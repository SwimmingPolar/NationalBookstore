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
import org.springframework.stereotype.Service;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.mapper.MyBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MyBookServiceImpl implements MyBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;

	@Override
	public ArrayList<EBookVO> libBook(HttpSession session) {	//찜 책장 조회
		// TODO Auto-generated method stub		
		MemberVO vo = (MemberVO) session.getAttribute("ryanMember");
		ArrayList<EBookVO> list = new ArrayList<EBookVO>();
		if(vo != null) {
			list = mapper.libBook(vo.getMemberEmail());
			return list;
		}		
		return list;
	}

	@Override	//찜 책장 삭제
	public ArrayList<EBookVO> deleteLibBook(int[] booknum, HttpSession session) {
		// TODO Auto-generated method stub
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		ArrayList<MyLibVO> number = new ArrayList<MyLibVO>();
		for(int i : booknum) {
			MyLibVO mylib = new MyLibVO();
			mylib.setBookNum(i);
			mylib.setMemberEmail(member.getMemberEmail());
			number.add(mylib);
		}
			
		Map list = new HashMap();
		list.put("numberlist", number);
		mapper.deleteLibBook(list);
		ArrayList<EBookVO> libBookList = mapper.libBook(member.getMemberEmail());		
		return libBookList;
	}

	@Override 	//찜 책장 추가
	public Boolean insertLibBook(MyLibVO vo) {
		// TODO Auto-generated method stub
		int num = mapper.insertLibBook(vo);
		if(num==1) return true;
		return false;		
	}

	@Override		//읽은책 조회
	public ArrayList<EBookVO> readBook(HttpSession session) {
		// TODO Auto-generated method stub
		MemberVO member = (MemberVO)session.getAttribute("ryanMember");
		ArrayList<EBookVO> list = mapper.readBook(member.getMemberEmail());
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
	public Boolean insertReadBook(MyReadBookVO vo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		HttpSession session = request.getSession();
		
		//vo.setBookNum(booknumber);
		vo.setReadDate(df.format(cal.getTime()));
	//	vo.setMemberEmail("abc1234@naver.com"); 
		ArrayList<EBookVO> list = mapper.readBook(request.getAttribute("ryanMember").toString());
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
	public int countLibBook(HttpSession session) {
		MemberVO member =(MemberVO) session.getAttribute("ryanMember");
		return mapper.countLibBook(member.getMemberEmail());
	}

	@Override
	public int countReadBook(HttpSession session) {
		MemberVO member =(MemberVO) session.getAttribute("ryanMember");
		return mapper.countReadBook(member.getMemberEmail());
		}

	@Override
	public int countLikeBook(HttpSession session) {
		MemberVO member =(MemberVO) session.getAttribute("ryanMember");
		return mapper.countLikeBook(member.getMemberEmail());
	}

	@Override
	public ArrayList<BookGradeVO> insertGrade(BookGradeVO vo, HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		ArrayList<BookGradeVO> gradeList = mapper.checkEmail(member.getMemberEmail());
		boolean flag=false;
		for(BookGradeVO grade : gradeList) {
			if(grade.getMemberEmail().equals(member.getMemberEmail())) {
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
		return mapper.checkEmail(member.getMemberEmail());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}