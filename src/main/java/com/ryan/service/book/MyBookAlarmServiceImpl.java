package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.BookAlarmVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.MyBookAlarmMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MyBookAlarmServiceImpl implements MyBookAlarmService {

	@Setter(onMethod_ = {@Autowired})
	private MyBookAlarmMapper mapper;
	
	//알람요청
	@Override
	public Boolean requestAlarm(BookAlarmVO vo, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		vo.setFkMemberAlarm(member.getMemberEmail());
		return mapper.requestAlarm(vo)==1 ? true : false;
	}

	@Override
	public ArrayList<BookAlarmVO> showAlarm(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		return mapper.showAlarm(member.getMemberEmail());
	}

	
	//매일 당일 날짜 출판 예정인 책 알람구분 변경
	@Scheduled(cron = "0 0 * * * *")
	@Override
	public void checkDay() {
		// TODO Auto-generated method stub
		ArrayList<BookAlarmVO> list = mapper.checkList();
		for(BookAlarmVO vo : list) {
			if(vo.getBookPbDate() == 0) {
				mapper.changeNO(vo.getAlarmNo());
			}else if(vo.getBookPbDate() >= 2) {
				mapper.deleteAlarm(vo.getAlarmNo());
			}else {
				log.info("모름");
			}
		}
	}
	
	
}
