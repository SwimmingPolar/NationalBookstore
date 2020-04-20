package com.ryan.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.domain.MemberVO;
import com.ryan.domain.ReviewVO;
import com.ryan.mapper.DetailBookMapper;

import lombok.Setter;

@Service
public class DetailBookServiceImpl implements DetailBookService{

	@Setter(onMethod_ = @Autowired)
	private DetailBookMapper mapper;
	
	@Override
	public EBookVO searchEBook(int booknumber) {		//상세보기 책 조회
		return mapper.searchEBook(booknumber);
	}

	@Override
	public ReviewVO searchReview(int booknumber) {		//상세보기 리뷰 조회
		return mapper.searchReview(booknumber);
	}

	@Override
	public List<EBookVO> interestbooks(String category) { 	//상세보기 관심책 불러오기
		return mapper.interestbooks(category);
	}

	@Override
	public BookLikeVO bookLike(int booknumber) {	//좋아요 조회
		// TODO Auto-generated method stub
		return mapper.bookLike(booknumber);
	}

	@Override
	public double bookGrade(int booknumber) {		//평점조회
		// TODO Auto-generated method stub
		return mapper.bookGrade(booknumber);
	}

	@Override
	public HashtagVO hashtag(int booknumber) {		//태그 조회
		// TODO Auto-generated method stub
		return mapper.hashtag(booknumber);
	}

	@Override
	public MemberVO likepeople(String id) {
		// TODO Auto-generated method stub
		return mapper.likepeople(id);
	}



	@Override
	public int insertHashtag(HashtagVO vo) {
		return mapper.insertHashtag(vo);		
	}

	@Override
	public int insertGrade(BookGradeVO vo) {
		return mapper.insertGrade(vo);
	}

	@Override
	public int insertLike(BookLikeVO vo) {
		return mapper.insertLike(vo);
	}

	@Override
	public int deleteLike(BookLikeVO vo) {
		return mapper.deleteLike(vo);
	}

	@Override
	public void updateBookLookUp(EBookVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		
		boolean flag = false;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(vo.getBookNum() + "lookUp")) {
					flag = true;
				} 
			}
			
			if(!flag) {
				mapper.updateBookLookUp(vo);
				Cookie bookLookUpCookie = new Cookie(vo.getBookNum()+ "lookUp", "update");
				bookLookUpCookie.setMaxAge(60*5); // 300초  5분
				bookLookUpCookie.setPath("/");
				response.addCookie(bookLookUpCookie);
			}
				
		} else {
			mapper.updateBookLookUp(vo);
			Cookie bookLookUpCookie = new Cookie(vo.getBookNum()+ "lookUp", "update");
			bookLookUpCookie.setMaxAge(60*5); // 300초  5분
			bookLookUpCookie.setPath("/");
			response.addCookie(bookLookUpCookie);
		}
		
	}

	
	
	
}
