package com.admin.service;

import java.util.List;

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
	public Boolean pushBook(AdminBestListVO vo) {
		// TODO Auto-generated method stub
		int count = mapper.countBook();
		List<AdminBestListVO> list = mapper.checkBook();
		
		if(count < 6) {
			for(AdminBestListVO ad : list) {
				if(ad.getBookNum()==vo.getBookNum()) {
					log.info("같은 책 존재함");
				}else {
					mapper.pushBook(vo);
				}
			}		
		}else {
			return false;
		}		
		return true;
	}

	
}
