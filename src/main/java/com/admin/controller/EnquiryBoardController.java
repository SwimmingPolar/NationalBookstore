package com.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.ReplyVO;
import com.admin.service.board.EnquiryBoardService;
import com.ryan.domain.member.MemberVO;

@Controller
@RequestMapping("/board/enquiry/*")
public class EnquiryBoardController {
	
	@Autowired
	private EnquiryBoardService service;
	
	@RequestMapping("/writeForm")
	public String enquiryWriteForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String enquiryWrite(EnquiryBoardVO enquiry) {
		//성공하면 리스트로
		return "";
	}
	
	@RequestMapping("/delete")
	public String enquiryDelete(EnquiryBoardVO enquiry,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			
			return service.eqDelete(enquiry)?"":"";
		}else
			return "";
	}
	
	@RequestMapping("/updateForm")
	public String enquiryUpdateForm() {
		return "입력jsp";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String enquiryUpdate(EnquiryBoardVO enquiry) {
		return "";
	}
	
	//문의사항 리스트가 보임
	@RequestMapping("/showList")
	public String enquiryList(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		String memberEmail=member.getMemberEmail();
		model.addAttribute("enquiryList", service.selectList(memberEmail));
		return "";
	}
	
	//리스트중 특정 문의사항 클릭시
	@RequestMapping("/select")
	//클릭한 문의사항관련 객체를 EnquiryBoardVO enquiry로 넘겨야 합니다
	public String enquirySelect(Model model,EnquiryBoardVO enquiry,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		if(enquiry!=null&&enquiry.getMemberEmail()!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			//선택한 문의사항 객체 
			model.addAttribute("enquiryVO", service.select(enquiry));
			//선택한 문의사항 replyList
			model.addAttribute("replyList", service.selectReplyList(enquiry.getBoardNum()));
			//선택한 문의사항 fileList
			model.addAttribute("fileList", service.selectEqFileList(enquiry.getBoardNum()));
			return "문의사항 선택jsp";
		}else
			return "";
	}
	
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	public String replyWrite(ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			service.replyWrite(reply);
			return "";
		}else
			return "";
	}
	
	@RequestMapping("/replyDelete")
	public String replyDelete(ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			service.replyDelete(reply);
			return "";
		}else
			return "";
	}
	
	@RequestMapping(value="/replyUpdate", method=RequestMethod.POST)
	public String replyUpdate(ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			service.replyUpdate(reply);
			return "";
		}else
			return "";
	}
}
