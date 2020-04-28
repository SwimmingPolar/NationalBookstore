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
@SessionAttributes("ryanMember")
@Log4j
public class MyBookServiceImpl implements MyBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;

	@Override
	public List<MyLibVO> libBook(@ModelAttribute("ryanMember") MyLibVO vo) {	//찜 책장 조회
		// TODO Auto-generated method stub		
		List<MyLibVO> list = mapper.libBook(vo.getMemberEmail());		
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
	public List<MyReadBookVO> readBook(@ModelAttribute("ryanMember") MyReadBookVO vo) {
		// TODO Auto-generated method stub
		List<MyReadBookVO> list = mapper.readBook(vo.getMemberEmail());
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
	public Boolean insertReadBook(int booknumber, @ModelAttribute("ryanMember") MyReadBookVO vo) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		vo.setBookNum(booknumber);
		vo.setReadDate(df.format(cal.getTime()));
		
		List<MyReadBookVO> list = mapper.readBook(vo.getMemberEmail());
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