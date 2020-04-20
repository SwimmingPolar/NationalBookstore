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
import lombok.extern.log4j.Log4j;

@Service
@Log4j
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
	public void hashtagCookie(HashtagVO vo, HttpServletRequest request, HttpServletResponse response) {
		//bookNum + hashtag
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(vo.getBookNum() + "hashtag")) {
					flag = true;
					break;
				} 
			}
			if(!flag) {
				mapper.insertHashtag(vo);
				Cookie hashtagCookie = new Cookie(vo.getBookNum() + "hashtag", "insert");
				hashtagCookie.setMaxAge(60*60*24);
				hashtagCookie.setPath("/");
				response.addCookie(hashtagCookie);
			}
		} else {
			mapper.insertHashtag(vo);
			Cookie hashtagCookie = new Cookie(vo.getBookNum() + "hashtag", "insert");
			hashtagCookie.setMaxAge(60*60*24);
			hashtagCookie.setPath("/");
			response.addCookie(hashtagCookie);
		}
		
		
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
	
	
	
}
