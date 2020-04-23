package com.ryan.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.MyLibVO;
import com.ryan.domain.MyReadBookVO;
import com.ryan.mapper.MyBookMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MyBookServiceImpl implements MyBookService{
	
	@Setter(onMethod_ = {@Autowired})
	private MyBookMapper mapper;

	@Override
	public ArrayList<MyLibVO> readingBook(MyLibVO vo) {	
		ArrayList<MyLibVO> mvo = mapper.readingBook(vo);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cal.getTime());
		String votime = null;
		
		for(int i=0; i<mvo.size(); i++) {
			if(vo.getMemberEmail().equals(mvo.get(i).getMemberEmail()) && vo.getBookNum()==mvo.get(i).getBookNum()) {
				votime = df.format(mvo.get(i).getSubDate());
			}				
			int check = time.compareTo(votime);
			if(check > 0) {
				//만료
			}else {
				// 대여중..
			}
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
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE,3);
				/*
				 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time =
				 * df.format(cal.getTime());
				 */
				flag=true;
				vo.setSubDate(cal.getTime());
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
