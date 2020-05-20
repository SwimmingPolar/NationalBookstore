package com.admin.controller;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.board.EnquiryBoardVO;
import com.admin.domain.board.ReplyVO;
import com.admin.service.board.EnquiryBoardService;
import com.ryan.domain.member.MemberVO;
import com.ryan.domain.security.RyanMember;

@Controller
@RequestMapping("/board/enquiry/*")
public class EnquiryBoardController {
	
	@Autowired
	private EnquiryBoardService service;
	
	@RequestMapping("/writeForm")
	public String enquiryWriteForm() {
		return "redirect:/board/enquiry/write";
	}
	
	//문의사항을 등록할때는 문의사항 객체와 파일 어레이객체(이건 안넘어왇도됨) 넘김
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String enquiryWrite(Model model,EnquiryBoardVO enquiry,Authentication auth,ArrayList<MultipartFile> files,HttpServletRequest request) {
		/*
		 * HttpSession session = request.getSession(); MemberVO member = (MemberVO)
		 * session.getAttribute("ryanMember");
		 */
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			boolean flag=service.eqWrite(enquiry);
			//문의사항 등록이 완료되면 등록할 파일이 있는지 확인후 있으면 등록
			if(flag&&files!=null&&files.isEmpty()&&files.size()>0) {
				String path = request.getSession().getServletContext().getRealPath("\\")+"\\resources\\enquiryFile";
				boolean flag2=false;
				try {
					//파일등록
					flag2=service.insertFiles(enquiry,files, path);
				} catch (IOException e) {
					flag2=false;
					e.printStackTrace();
				}
				if(flag2)
					model.addAttribute("filemessage", "파일등록실패");
			}
			if(flag) 
				model.addAttribute("message", "문의사항 입력 성공");
			else 
				model.addAttribute("message", "문의사항 입력 실패");
			return "redirect:/board/enquiry/showList";
		}else {
			model.addAttribute("message", "입력한 내용이 없습니다.");
			return "redirect:/board/enquiry/showList";
		}
	}
	
	@RequestMapping("/delete")
	public String enquiryDelete(Model model,EnquiryBoardVO enquiry,Authentication auth) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();	
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			
			
			if(service.eqDelete(enquiry))
				model.addAttribute("message", "문의사항 삭제 성공");
			else
				model.addAttribute("message", "문의사항 삭제 실패");
			return "redirect:/board/enquiry/showList";
		}else {
			model.addAttribute("message", "선택된 내용이 없습니다.");
			return "redirect:/board/enquiry/showList";
		}
	}
	
	@RequestMapping("/updateForm")
	public String enquiryUpdateForm(Model model,Authentication auth) {
		
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		
		return "입력view";
	}
	
	//문의사항 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String enquiryUpdate(Model model,EnquiryBoardVO enquiry,ArrayList<MultipartFile> files,Authentication auth,HttpServletRequest request) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();	
		if(enquiry!=null&&enquiry.getMemberEmail().equals(member.getMemberEmail())) {
			service.eqUpdate(enquiry,files,request);
			return "";
		}else {
			model.addAttribute("message", "수정할 내용이 없습니다.");
			return "redirect:/board/enquiry/showList";
		}
	}
	
	//문의사항 리스트가 보임
	@RequestMapping("/showList")
	public String enquiryList(Model model,Authentication auth) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
		String memberEmail=member.getMemberEmail();
		model.addAttribute("enquiryList", service.selectList(memberEmail));
		return "본인 문의사항 보이는 view";
	}
	
	//리스트중 특정 문의사항 클릭시
	@RequestMapping("/select")
	//클릭한 문의사항관련 객체를 EnquiryBoardVO enquiry로 넘겨야 합니다
	public String enquirySelect(Model model,@RequestParam(value="boardNum", defaultValue="1")int boardNum,Authentication auth) {
		RyanMember ryanMember = (RyanMember) auth.getPrincipal();
		MemberVO member = ryanMember.getMember();
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
