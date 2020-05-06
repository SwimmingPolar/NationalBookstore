package com.admin.service.revenue;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.revenue.BookRevenueVO;
import com.admin.domain.revenue.RegularPaymentRevenueVO;
import com.admin.domain.revenue.SearchDateVO;
import com.admin.mapper.RevenueMapper;

import lombok.Setter;

@Service
public class RevenueServiceImpl implements RevenueService {
	
	@Setter(onMethod_ = {@Autowired})
	private RevenueMapper mapper;
	
	@Override
	public boolean insertRevenue() {
		return mapper.insertRevenue() == 1 ? true : false;
	}

	@Override
	public ArrayList<String> getRegularPaymentRevenueDate() {
		return mapper.getRegularPaymentRevenueDate();
	}

	@Override
	public ArrayList<RegularPaymentRevenueVO> getRegularPaymentRevenue(SearchDateVO searchDate) {
		return mapper.getRegularPaymentRevenue(searchDate);
	}

	@Override
	public ArrayList<String> getBookPaymentRevenueDate() {
		return mapper.getBookPaymentRevenueDate();
	}

	@Override
	public ArrayList<BookRevenueVO> getBookPaymentRevenue(SearchDateVO searchDate) {
		return mapper.getBookPaymentRevenue(searchDate);
	}
	
	
	
}
