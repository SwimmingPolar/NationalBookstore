package com.admin.domain.revenue;

import lombok.Data;

@Data
public class RegularPaymentRevenueVO {
	
    // 고유번호 
    private int revenueNum;

    // 결제 날짜 
    private String paymentDate;
	
    //
	private int count;
    
}
