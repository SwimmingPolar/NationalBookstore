package com.ryan.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.domain.BookGradeVO;
import com.ryan.domain.BookLikeVO;
import com.ryan.domain.EBookVO;
import com.ryan.domain.HashtagVO;
import com.ryan.domain.MemberVO;
import com.ryan.domain.MyReadBookVO;
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
	public ArrayList<ReviewVO> searchReview(int booknumber) {		//상세보기 리뷰 조회
		ArrayList<ReviewVO> list = mapper.searchReview(booknumber);
		return list;
	}

	@Override
	public List<EBookVO> interestbooks(int category) { 	//상세보기 관심책 불러오기
		List<EBookVO> list = mapper.interestbooks(category);		
		return list;
	}

	@Override
	public int bookLike(int booknumber) {	//좋아요 조회

		return mapper.bookLike(booknumber); 
	}

	@Override
	public double bookGrade(int booknumber) {		//평점조회
		// TODO Auto-generated method stub
		return mapper.bookGrade(booknumber);
	}

	@Override
	public List<HashtagVO> hashtag(int booknumber) {		//태그 조회
		List<HashtagVO> list = mapper.hashtag(booknumber);		
		return list;
	}

	@Override
	public ArrayList<MemberVO> likepeople(int booknumber) {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> list = mapper.likepeople(booknumber);
		return list;
	}

	
	@Override
	public boolean hashtagCookie(HashtagVO vo, HttpServletRequest request, HttpServletResponse response) {
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
				return true;
			}else {
				return false;
			}
		} else {
			mapper.insertHashtag(vo);
			Cookie hashtagCookie = new Cookie(vo.getBookNum() + "hashtag", "insert");
			hashtagCookie.setMaxAge(60*60*24);
			hashtagCookie.setPath("/");
			response.addCookie(hashtagCookie);
			return true;
		}
		
		
	}
/*
	@Override
	public double insertGrade(BookGradeVO vo) {
		int num = mapper.insertGrade(vo);
		if(num==1) {
			log.info("insert Grade 성공");
		}else {
			log.info("insert Grade 실패");
		}
		return mapper.bookGrade(vo.getBookNum());
	}
*/
	@Override
	public int insertLike(int booknumber, HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BookLikeVO> list = mapper.bookLikeList(booknumber);
		HttpSession session = request.getSession();	
		BookLikeVO vo = (BookLikeVO) session.getAttribute("ryanmember");
		vo.setBookNum(booknumber);
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getMemberEmail().equals(vo.getMemberEmail())) {
				mapper.deleteLike(vo);
			}else {
				mapper.insertLike(vo);
			}
		}
		return mapper.bookLike(booknumber);		
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

	@Override
	public boolean checkLike(int booknumber, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<BookLikeVO> list = mapper.bookLikeList(booknumber);
		
		MemberVO vo = (MemberVO) session.getAttribute("ryanMember");
		
		boolean flag = false;
		
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getMemberEmail().equals(vo.getMemberEmail())) {
				flag = true;
				return flag;
			}
		}		
		return flag;
	}

	@Override
	public boolean hashtagCookieCheck(int booknumber, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		
		boolean flag = false;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(booknumber+"hashtag")) {
					flag=true;
					break;
				}
			}
			if(!flag) { // 쿠키가 없음	
				return true;
			}else {
				return false;
			}
		} else {
			return true;
		}
	}

	
	
	
}
