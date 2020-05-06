package com.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.AdminBestListVO;
import com.admin.mapper.AdminEventMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminEventServiceImpl implements AdminEventService{

	@Setter(onMethod_ = {@Autowired})
	private AdminEventMapper mapper;
	
	@Override
	public Boolean pushBook(ArrayList<AdminBestListVO> booknum) {
		// TODO Auto-generated method stub
		int count = mapper.countBook();
		List<AdminBestListVO> list = mapper.checkBook();
		
		if(count < 6) {
			for(AdminBestListVO number : booknum) {
				for(AdminBestListVO ad : list) {
					if(ad.getBookNum()==number.getBookNum()) {
						log.info("같은 책 존재함");
					}else {
						mapper.pushBook(number);
					}
				}		
			}
		}else {
			return false;
		}		
		return true;
	}

	@Override
	public Boolean deleteBook(int[] deletenum ) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int number : list) {
			list.add(number);
		}
		
		Map map = new HashMap();
		map.put("deletenum", list);	
		
		int num=mapper.deleteBook(map);
		if(num==0) return false;
		return true;
	}

	
}
