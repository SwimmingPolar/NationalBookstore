package com.ryan.service.book;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ArrayList<MyLibVO> readingBook(MyLibVO vo, HttpServletRequest request) {		//찜 책장 
		HttpSession session = request.getSession();
		MyLibVO myvo = (MyLibVO) session.getAttribute("ryanmember");
		
		if(myvo.getMemberEmail().equals(vo.getMemberEmail()) && myvo.getBookNum()==vo.getBookNum()) {
			
		}
		
		return mvo;
	}

	@Override
	public ArrayList<MyLibVO> deleteList(MyLibVO vo) {
		int num = mapper.deleteList(vo);
		if(num==1) {
			log.info("mybook list delete 실행 ");
		}else {
			log.info(" mybook list delete 오류");
		}
		return mapper.readingBook(vo);
	}

	@Override
	public boolean insertList(MyLibVO vo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0; i<mapper.readingBook(vo).size(); i++) {
			if(mapper.readingBook(vo).get(i).getBookNum()!=vo.getBookNum()) {
				/*
				 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time =
				 * df.format(cal.getTime());
				 */
				flag=true;
				mapper.insertList(vo);
				return flag;
			}
		}
		return flag;

	}

	@Override
	public int insertReadBook(MyReadBookVO vo) {
		// TODO Auto-generated method stub
		ArrayList<MyReadBookVO> list = mapper.readBookList(vo);
		int num=0;
		for(MyReadBookVO read : list) {
			if(read.getBookNum()==vo.getBookNum() && read.getMemberEmail().equals(vo.getMemberEmail())) {
				return mapper.updateReadBook(vo);				
			}else {
				return mapper.insertReadBook(vo);
			}
		}
		return num;
	}

	@Override
	public ArrayList<MyReadBookVO> readBookList(MyReadBookVO vo) {
		// TODO Auto-generated method stub
		return mapper.readBookList(vo);
	}

	@Override
	public ArrayList<MyReadBookVO> deleteReadBook(MyReadBookVO vo) {
		// TODO Auto-generated method stub
		mapper.deleteReadBook(vo);
		return mapper.readBookList(vo);
	}		
}
