package com.admin.mapper;

import java.util.ArrayList;

import com.admin.domain.revenue.BookRevenueVO;
import com.admin.domain.revenue.RegularPaymentRevenueVO;
import com.admin.domain.revenue.SearchDateVO;

public interface RevenueMapper {
	
	//구독
	
	//결제 완료시 결제날짜 입력
	public int insertRevenue();
	
	//데이터가 있는 월 목록 가져오기
	public ArrayList<String> getRegularPaymentRevenueDate();
	
	//구독수익 가져오기
	public ArrayList<RegularPaymentRevenueVO> getRegularPaymentRevenue(SearchDateVO searchDate);
	
	
	//종이책
	
	//데이터가 있는 월 목록 가져오기
	public ArrayList<String> getBookPaymentRevenueDate();
	
	//종이책 수익
	public ArrayList<BookRevenueVO> getBookPaymentRevenue(SearchDateVO searchDate);
	
	
}
