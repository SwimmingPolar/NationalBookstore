package com.ryan.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.payment.CartVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/security-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class CartMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private CartMapper mapper;
	
//	@Test
//	public void removeAllTest() {
//		
//		log.info(mapper.removeAll("abc1234@naver.com"));
//		
//	}
	
//	@Test
//	public void getCartList() {
//		
//		mapper.getCartList("abc1234@naver.com").forEach(cart -> log.info(cart));
//		
//	}
	
//	@Test
//	public void cartBuyList() {
//		
//		int[] cartNumList = {2,3,4,5};
//		
//		log.info("실행");
//		mapper.cartBuyList(cartNumList).forEach(cart -> log.info(cart));
//	}
	
	@Test
	public void cartInsert() {
		
		CartVO[] cartArr = new CartVO[4];
		
		for(int i=0; i<cartArr.length; i++) {
			CartVO cart = new CartVO();
			cart.setBookNum(197);
			cart.setBookCount(i+1);
			cart.setMemberEmail("abc1234@naver.com");
			cartArr[i] = cart;
			log.info(cartArr[i]);
		}
		
		mapper.insertCart(cartArr);
		
	}
	
//	@Test
//	public void removeBuyCart() {
//		
//		String memberEmail = "abc1234@naver.com";
//		
//		ArrayList<CartVO> cartBuyList = new ArrayList<CartVO>();
//		
//		CartVO vo = new CartVO();
//		vo.setCartNum(2);
//		
//		CartVO vo1 = new CartVO();
//		vo1.setCartNum(4);
//		
//		cartBuyList.add(vo1);
//		cartBuyList.add(vo);
//		
//		mapper.removeBuyCartList(cartBuyList, memberEmail);
//		
//	}
	
//	//수량수정
//	@Test
//	public void modifyCartCountTest() {
//		
//		int result = mapper.modifyCartCount(1, 41);
//		
//		log.info("결과: " +  result);
//		
//	}
	
}
