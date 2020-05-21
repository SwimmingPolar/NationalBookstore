package com.ryan.service.main;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ryan.domain.book.BookGradeVO;
import com.ryan.domain.book.ReviewVO;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;
import com.ryan.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper mapper;

	@Override
	public Boolean insertReview(ReviewVO review) {
		int flag = 0;
		/*
		 * if(mapper.duplication(review)==1) return false; else {
		 * if(mapper.searchOrder(review)==1&&mapper.searchRead(review)==1) { return
		 * false; }else { mapper.insertReview(review);
		 * 
		 * BookGradeVO vo=new BookGradeVO(); vo.setBookNum(review.getBookNum());
		 * vo.setMemberEmail(review.getMemberEmail()); vo.setGradeScore(grade);
		 * mapper.insertGrade(vo);
		 * 
		 * return true; } }
		 */
		return mapper.insertReview(review) > 0 ? true : false;
	}

	@Override
	public Boolean delecteReview(int reviewNum) {
		/*
		 * if (mapper.duplication(review) > 0) return mapper.deleteReview(review) == 1 ?
		 * true : false; else return false;
		 */
		return mapper.deleteReview(reviewNum)==1?true:false;
	}

	@Override
	public Boolean updateReview(ReviewVO review) {
		if (mapper.duplication(review) > 0)
			return mapper.updateReview(review) == 1 ? true : false;
		else
			return false;
	}

	@Override
	public ArrayList<ReviewVO> myReviewList(String clickId) {
		return mapper.myReviewList(clickId);
	}

	@Override
	public Boolean insertGrade(BookGradeVO grade) {
		return mapper.insertGrade(grade) > 0 ? true : false;
	}

	@Override
	public int countMyPost(String memberEmail) {
		return mapper.countMyPost(memberEmail);
	}
}
