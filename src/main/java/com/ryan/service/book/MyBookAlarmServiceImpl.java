package com.ryan.service.book;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.BookAlarmVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
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
	public Boolean requestAlarm(int booknumber, String memberEmail) {
		Boolean flag=false;
		BookAlarmVO vo = new BookAlarmVO();
		ArrayList<BookAlarmVO> list = mapper.checkAlarm(memberEmail);
		if(!list.isEmpty()) {
			vo.setFkBookAlarm(booknumber);
			vo.setFkMemberAlarm(memberEmail);
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getFkMemberAlarm().equals(memberEmail) && list.get(i).getFkBookAlarm()==booknumber) { //북 넘버가 같고 이메일이 같을 때 삭제
					mapper.deleteAlarm(list.get(i).getAlarmNo());	//false 리턴
					break;
				}else {	//북 넘버가 같지 않거나 이메일이 다를때 
					return mapper.requestAlarm(vo)==1 ? true : false;
				}
			}	
		}else {
			vo.setFkBookAlarm(booknumber);
			vo.setFkMemberAlarm(memberEmail);
			return mapper.requestAlarm(vo)==1 ? true : false;
		}
		return flag;
	}

	@Override
	public ArrayList<BookAlarmVO> showAlarm(Authentication auth) {
		RyanMember ryanmember = (RyanMember) auth.getPrincipal();
		MemberVO member = (MemberVO) ryanmember.getMember();
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
			}
		}
	}
	
	
}
