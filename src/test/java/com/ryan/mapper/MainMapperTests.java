package com.ryan.mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryan.domain.book.EBookVO;
import com.ryan.domain.book.HashtagVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MainMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private MainMapper mapper;
	
//	@Test
//	public void mainMapperTest() {
//		
//		String[] arr = {"룬의","아이들"};
//		String type = "book_title";
//		
//		
//	}
	
	@Test
	public void getHashTagTests() {
		
		ArrayList<HashtagVO> hashTagList = mapper.getRandomHashTag();
		
		ArrayList<EBookVO> bookList = mapper.getHashTagBook(hashTagList);
		
		while(bookList.size() <= 2) {
			log.info("while 문 실행!");
			ArrayList<EBookVO> tempList = mapper.getHashTagBook(mapper.getRandomHashTag());
			
			for(EBookVO e : bookList) {
				for(EBookVO t : tempList) {
					
					if(e.getBookNum() != t.getBookNum()) {
						log.info("같지않음");
						log.info(t);
						bookList.add(t);
						if(bookList.size() <= 2) {
							log.info("break 실행전");
						}
					}
					
				}
			}
			
			log.info(bookList.size());
			
		} // while end
		log.info("while 종료");
		log.info("bookList size: " + bookList.size()); 
		bookList.forEach(book -> log.info(book));
		
	}
	
}
