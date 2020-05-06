package com.ryan.service.member;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.admin.mapper.RevenueMapper;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.member.PaymentVO;
import com.ryan.domain.payment.KakaoPayApprovalVO;
import com.ryan.domain.payment.KakaoPayResponseVO;
import com.ryan.mapper.PaymentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class RegularPaymentServiceImpl implements RegularPaymentService {
	
	//카카오페이 호스트 기본주소
	
	private static final String HOST = "https://kapi.kakao.com";
	
	//정기결제 준비 상태에서 response 값을 받을 클래스
	private KakaoPayResponseVO kakaoPayResponseVO;
	//결제 완료후 리턴값들을 받을 클래스
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	
	@Setter(onMethod_ = {@Autowired})
	private PaymentMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private RevenueMapper revenueMapper;
	
	
	@Override
	public String regularPaymentReady(MemberVO member) {
		/*
		 카카오페이 결제를 시작하기 위해 상세 정보를 카카오페이 서버에 전달하고 결제 고유 번호(TID)를 받는 단계입니다. 
		 어드민 키를 헤더에 담아 파라미터 값들과 함께 POST로 요청합니다.

		요청이 성공하면 응답 바디에 JSON 객체로 다음 단계 진행을 위한 값들을 받습니다. 
		서버(Server)는 tid를 저장하고, 클라이언트는 사용자 환경에 맞는 URL로 리다이렉트(redirect)합니다.
		 */
		
		log.info(member.getMemberEmail());
		log.info(member.getMemberEmail());
		RestTemplate restTemplate = new RestTemplate();
		
		//서버로 요청할 헤더값
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "3fdf415fd07c82f57f2cffbee8bfb871");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		MultiValueMap<String, String> paymentParams = new LinkedMultiValueMap<String, String>();
		paymentParams.add("cid", "TCSUBSCRIP"); // 테스트용 cid
		paymentParams.add("partner_order_id","80000"); // 회사 이 상품 구매시 주문번호
		paymentParams.add("partner_user_id", member.getMemberEmail());
		paymentParams.add("item_name", "RyanBookStore 정기 결제"); //  상품명
		paymentParams.add("quantity", "1"); //상품 수량
		paymentParams.add("total_amount", "9900"); //상품 총액
		paymentParams.add("tax_free_amount", "0"); // 비과세
		paymentParams.add("approval_url", "http://localhost:8181/member/paymentSuccess"); //성공
		paymentParams.add("cancel_url", "http://localhost:8181/kakaoCancel"); //취소
		paymentParams.add("fail_url", "http://localhost:8181/kakaoFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(paymentParams,headers);
		
		log.info(headers);
		log.info(body);
		try {
			kakaoPayResponseVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayResponseVO.class);
			log.info("" + kakaoPayResponseVO);
			return kakaoPayResponseVO.getNext_redirect_pc_url();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public KakaoPayApprovalVO paymentComplete(String pg_token, MemberVO member) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//서버로 요청 헤더
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "3fdf415fd07c82f57f2cffbee8bfb871");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		log.info("tid코드: " + kakaoPayResponseVO.getTid());
		
		MultiValueMap<String, String> paymentParame = new LinkedMultiValueMap<String, String>();
		paymentParame.add("cid", "TCSUBSCRIP");
		paymentParame.add("tid", kakaoPayResponseVO.getTid());
		paymentParame.add("partner_order_id", "80000");
		paymentParame.add("partner_user_id", member.getMemberEmail());
		paymentParame.add("pg_token", pg_token);
		paymentParame.add("total_amount", "9900");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(paymentParame,headers);
		
		try {
			kakaoPayApprovalVO = restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/approve"), body, KakaoPayApprovalVO.class);
			log.info("" + kakaoPayApprovalVO);
			
			//에러가 안날시 수익 증가.. 나중에 DB설계 다시할 예쩡
			revenueMapper.insertRevenue();
			
			return kakaoPayApprovalVO;
		} catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
		
		return kakaoPayApprovalVO;
	}

	@Override
	public boolean insertPaymentInfo(String memberEmail, String memberSid) {
		return mapper.insertPaymentInfo(memberEmail, memberSid) == 1 ? true : false;
	}
	
	

	@Scheduled(cron="0 0 02 * * *") 
	@Override
	public void autoRegularPaymentSystem() {
		
		log.info("스케쥴 실행");
		
		ArrayList<PaymentVO> paymentList = mapper.getTodayRegularPaymentList();
		
		RestTemplate restTemplate = new RestTemplate();
		
		//서버로 요청 헤더
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "3fdf415fd07c82f57f2cffbee8bfb871");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		for(PaymentVO pay : paymentList) {
			
			
			MultiValueMap<String, String> paymentParame = new LinkedMultiValueMap<String, String>();
			paymentParame.add("cid","TCSUBSCRIP");
			paymentParame.add("sid", pay.getMemberSid());
			paymentParame.add("partner_order_id", "8000");
			paymentParame.add("partner_user_id", pay.getMemberEmail());
			paymentParame.add("quantity", "1");
			paymentParame.add("total_amount", "9900");
			paymentParame.add("tax_free_amount", "0");
			
			HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(paymentParame,headers);
			
			try {
				kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/subscription"), body, KakaoPayApprovalVO.class);
				
				//정기 결제 1회 완료시마다 수익 입력
				revenueMapper.insertRevenue();
				
			} catch (RestClientException e) {
	            e.printStackTrace();
	        } catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
			
		}
		
		
	}
	
	

}
