package com.ryan.domain;

import lombok.Data;

@Data
public class CardVO {
	
	private String purchase_corp; //매입카드사 한글명
	private String purchase_corp_code; //매입 카드사 코드
	private String issuer_corp, issuer_corp_code; // 카드 발급사 한글명, 카드 발급사 코드
	private String kakaopay_purchase_corp, kakaopay_purchase_corp_code, kakaopay_issuer_corp ,kakaopay_issuer_corp_code;
	private String bin,cart_type,install_month,approved_id,card_mid; // 카드bin , 카드 타입, 할부 개월, 카드사 승인번호 , 카드사 가맹점 번호
	private String interest_free_install, card_item_code; // 무이자 여부 y/n , 카드 상품 코드
	
}
