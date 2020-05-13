package com.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "입력view";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String enquiryWrite(Model model,EnquiryBoardVO enquiry) {
		//성공하면 리스트로
		return "";
	}
	
	@RequestMapping("/delete")
	public String enquiryDelete(Model model,EnquiryBoardVO enquiry,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			if(service.eqDelete(enquiry))
				model.addAttribute("message", "문의사항 삭제 성공");
			return "";
		}else {
			model.addAttribute("message", "선택된 내용이 없습니다.");
			return "";
		}
	}
	
	@RequestMapping("/updateForm")
	public String enquiryUpdateForm() {
		return "입력view";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String enquiryUpdate(Model model,EnquiryBoardVO enquiry) {
		return "";
	}
	
	//문의사항 리스트가 보임
	@RequestMapping("/showList")
	public String enquiryList(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");	
		String memberEmail=member.getMemberEmail();
		model.addAttribute("enquiryList", service.selectList(memberEmail));
		return "본인 문의사항 보이는 view";
	}
	
	//리스트중 특정 문의사항 클릭시
	@RequestMapping("/select")
	//클릭한 문의사항관련 객체를 EnquiryBoardVO enquiry로 넘겨야 합니다
	public String enquirySelect(Model model,@RequestParam(value="boardNum")int boardNum,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("ryanMember");
		EnquiryBoardVO enquiry=service.selectEq(boardNum);
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			//선택한 문의사항 객체 
			model.addAttribute("enquiryVO", enquiry);
			//선택한 문의사항 replyList
			model.addAttribute("replyList", service.selectReplyList(boardNum));
			//선택한 문의사항 fileList
			model.addAttribute("fileList", service.selectEqFileList(boardNum));
			return "선택한 문의사항view";
		}else {
			model.addAttribute("message", "본인 문의사항이 아닙니다");
			return "redirect:/board/enquiry/showList";
		}
			
	}
	
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	public String replyWrite(Model model,ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			if(service.replyWrite(reply))
				model.addAttribute("message", "리플등록 성공");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}else {
			model.addAttribute("message", "내용이 없습니다.");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}
	}
	
	@RequestMapping("/replyDelete")
	public String replyDelete(Model model,ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			if(service.replyDelete(reply))
				model.addAttribute("message", "리플삭제 성공");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}else {
			model.addAttribute("message", "내용이 없습니다.");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}
	}
	
	@RequestMapping(value="/replyUpdate", method=RequestMethod.POST)
	public String replyUpdate(Model model,ReplyVO reply) {
		if(!(reply==null||reply.getBoardNum()<1)) {
			if(service.replyUpdate(reply))
				model.addAttribute("message", "리플수정 성공");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}else {
			model.addAttribute("message", "내용이 없습니다.");
			return "redirect:/board/enquiry/select?boardNum="+reply.getBoardNum();
		}
	}
}
