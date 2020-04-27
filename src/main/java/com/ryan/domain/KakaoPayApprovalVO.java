package com.ryan.domain;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayApprovalVO {
	
	//결제승인
	private String aid; //요청 고유번호
	private String tid; //결제 고육번호
	private String cid; //가맹점 코드
	private String sid; //정기결제용 ID, 정기결제 CID로 단건결제 요청 시 발급
	
	private String partner_order_id; //가맹점 주문번호
	private String partner_user_id; //가맹점 user Id
	private String payment_method_type; //결제 수단, CARD 또는 MONEY 중 하나
	
	private AmountVO amount;
	private CardVO card_info;
	
	private String item_name; //상품이름
	private String item_code; //상품 코드
	private Integer quantity, tax_free_amount, vat_amount;//수량
	private Date created_at, approved_at;
	
	
	
}
