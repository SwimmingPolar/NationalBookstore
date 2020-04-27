package com.ryan.domain;

import lombok.Data;

@Data
public class AmountVO {
	
	private Integer total; //전체 결제금액
	private Integer tax_free; //비과세금액
	private Integer vat; //부과세
	private Integer point;//사용한 포인트 금액
	private Integer discount; // 할인
	
}
