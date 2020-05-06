package com.ryan.service.book;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryan.domain.book.MyLibVO;
import com.ryan.domain.book.MyReadBookVO;
import com.ryan.mapper.MyBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MyBookServiceImpl implements MyBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;

	@Override
	public List<MyLibVO> libBook(HttpServletRequest request) {	//찜 책장 조회
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession();
		List<MyLibVO> list = mapper.libBook(session.getAttribute("ryanMember").toString());		
		return list;
	}

	@Override	//찜 책장 삭제
	public List<MyLibVO> deleteLibBook(MyLibVO vo) {
		// TODO Auto-generated method stub
		int num=mapper.deleteLibBook(vo);
		List<MyLibVO> list = mapper.libBook(vo.getMemberEmail());		
		return list;
	}

	@Override 	//찜 책장 추가
	public Boolean insertLibBook(MyLibVO vo) {
		// TODO Auto-generated method stub
		int num = mapper.insertLibBook(vo);
		if(num==1) return true;
		return false;		
	}

	@Override		//읽은책 조회
	public List<MyReadBookVO> readBook(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<MyReadBookVO> list = mapper.readBook(session.getAttribute("ryanMember").toString());
		return list;
	}

	@Override		//읽은책 삭제
	public List<MyReadBookVO> deleteReadBook(MyReadBookVO vo) {
		// TODO Auto-generated method stub
		mapper.deleteReadBook(vo);
		List<MyReadBookVO> list = mapper.readBook(vo.getMemberEmail());
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
		List<MyReadBookVO> list = mapper.readBook(request.getAttribute("ryanMember").toString());
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
}