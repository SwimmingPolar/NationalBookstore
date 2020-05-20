package com.ryan.service.payment;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ryan.domain.member.MemberVO;
import com.ryan.domain.payment.KakaoPayApprovalVO;
import com.ryan.domain.payment.KakaoPayResponseVO;
import com.ryan.domain.payment.OrderVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.mapper.OrderMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderServiceImpl implements OrderService {
	
	@Setter(onMethod_ = {@Autowired})
	private OrderMapper mapper;
	
	private static final String HOST = "https://kapi.kakao.com";
	
	private KakaoPayResponseVO kakaoPayResponseVO;
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	
	@Override
	public int insertOrder(OrderVO order) {
		return mapper.insertOrder(order);
	}
	

	@Override
	public ArrayList<OrderVO> getOrderList(Authentication auth) {
		
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		
		return mapper.getOrderList(member.getMemberEmail());
	}


	@Override
	public String kakaoPayTest() {
		
		/*
		 카카오페이 결제를 시작하기 위해 상세 정보를 카카오페이 서버에 전달하고 결제 고유 번호(TID)를 받는 단계입니다. 
		 어드민 키를 헤더에 담아 파라미터 값들과 함께 POST로 요청합니다.

		요청이 성공하면 응답 바디에 JSON 객체로 다음 단계 진행을 위한 값들을 받습니다. 
		서버(Server)는 tid를 저장하고, 클라이언트는 사용자 환경에 맞는 URL로 리다이렉트(redirect)합니다.
		 */
		
		RestTemplate restTemplate = new RestTemplate();
		
		//서버로 요청 헤더
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "3fdf415fd07c82f57f2cffbee8bfb871");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		//바디
		//https://developers.kakao.com/docs/latest/ko/kakaopay/single-payment 참고
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME"); // 테스트용 cid
		params.add("partner_order_id","8000"); // 회사 이 상품 구매시 주문번호
		params.add("partner_user_id", "apsdfk");
		params.add("item_name", "룬의아이들"); //  상품명
		params.add("quantity", "1"); //상품 수량
		params.add("total_amount", "1000"); //상품 총액
		params.add("tax_free_amount", "0"); // 비과세
		params.add("approval_url", "http://localhost:8181/member/paymentSuccess"); //성공
		params.add("cancel_url", "http://localhost:8181/kakaoCancel"); //취소
		params.add("fail_url", "http://localhost:8181/kakaoFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
		log.info(headers);
		log.info(body);
		try {
			kakaoPayResponseVO = restTemplate.postForObject(new URI(HOST) + "/v1/payment/ready", body, KakaoPayResponseVO.class);
			log.info("" + kakaoPayResponseVO);
			return kakaoPayResponseVO.getNext_redirect_pc_url();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}


	@Override
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//서버로 요청 헤더
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "3fdf415fd07c82f57f2cffbee8bfb871");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME"); //가맹점 코드
		params.add("tid", kakaoPayResponseVO.getTid()); //결제 고유번호, 결제 준비 API 응답에 포함
		params.add("partner_order_id", "8000"); //가맹점 주문번호, 결제 준비 API 요청과 일치해야 함
		params.add("partner_user_id", "apsdfk"); //가맹점 회원 id, 결제 준비 API 요청과 일치해야 함
		params.add("pg_token", pg_token); //결제승인 요청을 인증하는 토큰 사용자 결제 수단 선택 완료 시, approval_url로 redirection해줄 때 pg_token을 query string으로 전달
		params.add("total_amount", "1000");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params,headers);
		
		try {
			kakaoPayApprovalVO = restTemplate.postForObject(new URI("https://kapi.kakao.com/v1/payment/approve"), body, KakaoPayApprovalVO.class);
			log.info("" + kakaoPayApprovalVO);
			return kakaoPayApprovalVO;
		} catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return kakaoPayApprovalVO;
	}




	
	
}
