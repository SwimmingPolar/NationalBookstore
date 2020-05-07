package com.admin.service.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.book.AdminBestListVO;
import com.admin.mapper.AdminEventMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminEventServiceImpl implements AdminEventService{

	@Setter(onMethod_ = {@Autowired})
	private AdminEventMapper mapper;
	
	@Override
	public Boolean pushBook(AdminBestListVO booknum) {
		// TODO Auto-generated method stub
		int count = mapper.countBook();
		List<AdminBestListVO> list = mapper.checkBook();
		boolean flag = false;
		
		if(count < 6) {
			if(!list.equals("") || list != null) {
				for(int i=0; i<list.size();i++) {
					if(booknum.getBookNum()==list.get(i).getBookNum()) {
						flag=true;
						break;
					}
				}
				if(flag) {
					log.info("같은책 존재");
				}else {
					mapper.pushBook(booknum);
				}
			}
		}else {
			log.info("count 확인");
			return false;
		}		
		return true;
	}

	@Override
	public Boolean deleteBook(int[] deletenum ) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int number : deletenum) {
			list.add(number);
		}
		
		Map map = new HashMap();
		map.put("deletenum", list);	
		
		int num=mapper.deleteBook(map);
		if(num==0) return false;
		return true;
	}
	
}
