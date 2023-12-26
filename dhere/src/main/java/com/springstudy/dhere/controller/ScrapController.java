package com.springstudy.dhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Scrap;
import com.springstudy.dhere.service.MemberService;
import com.springstudy.dhere.service.ScrapService;

@Controller
public class ScrapController {
	
	@Autowired
	private ScrapService scrapService;
	
	@Autowired
	private MemberService memberService;
	
//	@Autowired
//	private SessionInfo sessionInfo;
	
//	@RequestMapping(value= "/scrap" method=RequestMethod.GET)
//	public String viewMyPage(Model model) {
//		String email = SessionInfo.getEmail();
//		String job = SessionInfo.getJob();
//		
//		Member login = memberService.getMember(email);
//		
//		if(login != null) {
//			model.addAttribute(setMember, getMember);
//			return "scrap";
//		} else {
//			return "redirect:/login";
//		}
//	}
	
	
	// 회원정보 받기
	@RequestMapping(value="/scrap", method=RequestMethod.GET)
	public String email
	(Model model,HttpSession session ,
			@RequestParam (defaultValue="test") String email) {
		
		// 세션 객체 안에 있는 이메일 정보 저장
		Scrap scrap = scrapService.getScrap(email);
		// Member member = (Member) session.getAttribute("member");
		
//		if(member != null) {
//		String picture = member.getPicture();
//		String nickname = member.getNickname();
//		String Email = member.getEmail();
//		String job = member.getJob(); 
//		
//		} else {
//			
//		}
//		
		// 정보 저장 후 페이지 이동
		model.addAttribute("scrap", scrap);
		// model.addAttribute("member", member);
		
		return "scrap";
	}
	
	// 스크랩 리스트 출력하기
//	@RequestMapping(value= {"/scrap"}, method = RequestMethod.GET)
//	public String scrapList(Model model) {
//		
//		List<Scrap> list = scrapService.ScrapList();
//		model.addAllAttributes(scrapService.ScrapList());
//		
//		return "scrap";
//	}
}