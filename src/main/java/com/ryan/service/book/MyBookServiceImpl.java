package com.ryan.service.book;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.mapper.MemberMapper;
import com.ryan.mapper.MyBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MyBookServiceImpl implements MyBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper memberMapper;

	@Override
	public ArrayList<EBookVO> libBook(String clickId,Authentication auth) {	//찜 책장 조회
		// TODO Auto-generated method stub		
		ArrayList<EBookVO> list = new ArrayList<EBookVO>();

		if(clickId != null && clickId != "") {
			list = mapper.libBook(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO vo = (MemberVO) ryanmember.getMember();
			list = mapper.libBook(vo.getMemberEmail());
		}
		return list;
	}

	@Override	//찜 책장 삭제
	public ArrayList<EBookVO> deleteLibBook(int[] booknum, HttpServletRequest request, String memberEmail) {
		// TODO Auto-generated method stub
		ArrayList<MyLibVO> number = new ArrayList<MyLibVO>();
		for(int i : booknum) {
			MyLibVO mylib = new MyLibVO();
			mylib.setBookNum(i);
			mylib.setMemberEmail(memberEmail);
			number.add(mylib);
		}
			
		Map list = new HashMap();
		list.put("numberlist", number);
		mapper.deleteLibBook(list);
		ArrayList<EBookVO> libBookList = mapper.libBook(memberEmail);		
		return libBookList;
	}

	@Override 	//찜 책장 추가
	public Boolean insertLibBook(int booknumber, String memberEmail) {
		// TODO Auto-generated method stub
		try {
			MyLibVO vo = new MyLibVO();
			vo.setBookNum(booknumber);
			vo.setMemberEmail(memberEmail);
			mapper.insertLibBook(vo);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			return false;
		}		
	}

	@Override		//읽은책 조회
	public ArrayList<EBookVO> readBook(String clickId,Authentication auth) {
		// TODO Auto-generated method stub
		ArrayList<EBookVO> list = new ArrayList<EBookVO>();
		if(clickId != null && clickId != "") {
			list = mapper.readBook(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO member = (MemberVO) ryanmember.getMember();
			list = mapper.readBook(member.getMemberEmail());
		}
		return list;
	}

	@Override		//읽은책 삭제
	public ArrayList<EBookVO> deleteReadBook(MyReadBookVO vo) {
		// TODO Auto-generated method stub
		mapper.deleteReadBook(vo);
		ArrayList<EBookVO> list = mapper.readBook(vo.getMemberEmail());
		return list;
	}

	@Override		//읽은책 추가
	public Boolean insertReadBook(int booknumber, String memberEmail) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		MyReadBookVO vo = new MyReadBookVO();
		vo.setBookNum(booknumber);
		vo.setReadDate(df.format(cal.getTime()));
//		vo.setMemberEmail("abc1234@naver.com"); 
	
		ArrayList<EBookVO> list = mapper.readBook(memberEmail);
		vo.setMemberEmail(memberEmail);
		boolean flag= false;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getBookNum()==vo.getBookNum()) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			mapper.insertReadBook(vo);
			return false;
		}else {
			mapper.updateReadBook(vo);	//읽은시간 업데이트 해주고 끝
			return true;
		}
	}

	@Override
	public int countLibBook(String clickId,Authentication auth) {
		if(clickId != null && clickId != "") {
			return mapper.countLibBook(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO member = (MemberVO) ryanmember.getMember();
			return mapper.countLibBook(member.getMemberEmail());
		}
	}

	@Override
	public int countReadBook(String clickId,Authentication auth) {
		if(clickId != null && clickId != "") {
			return mapper.countReadBook(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO member = (MemberVO) ryanmember.getMember();
			return mapper.countReadBook(member.getMemberEmail());
		}
	}

	@Override
	public int countLikeBook(String clickId,Authentication auth) {
		if(clickId != null && clickId != "") {
			return mapper.countLikeBook(clickId);
		}else {
			RyanMember ryanmember = (RyanMember) auth.getPrincipal();
			MemberVO member = (MemberVO) ryanmember.getMember();
			return mapper.countLikeBook(member.getMemberEmail());
		}
	}

	@Override
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo,String memberEmail) {
		ArrayList<BookGradeVO> gradeList = mapper.checkEmail(memberEmail);
		boolean flag=false;
		for(BookGradeVO grade : gradeList) {
			if(grade.getMemberEmail().equals(memberEmail)) {
				if(grade.getBookNum()==vo.getBookNum()) {
					flag = true;
					break;
				}				
			}else {
				mapper.insertGrade(vo);
			}
		}
		if(!flag) {
			mapper.insertGrade(vo);
		}
		return mapper.checkEmail(memberEmail);
	}

	@Override
	public MemberVO readClickId(String clickId) {
		log.info("결과 " + memberMapper.readClickId(clickId));
		return memberMapper.readClickId(clickId);
	}


	
	
}