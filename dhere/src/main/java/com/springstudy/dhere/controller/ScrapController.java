package com.springstudy.dhere.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
	
	public void setScrapService(ScrapService scrapService) {
		this.scrapService = scrapService;
	}
	
	@Autowired
	private MemberService memberService;	
	
	// 회원정보 받기
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String email
	(Model model,HttpSession session ,
			@RequestParam (defaultValue="test") String email) {
		
		// 세션 객체 안에 있는 이메일 정보 저장
		Scrap scrap = scrapService.getScrap(email);

		// 정보 저장 후 페이지 이동
		model.addAttribute("scrap", scrap);
		
		return "scrap";
	}

	
	@RequestMapping(value="/mypageupdateProcess", method=RequestMethod.POST)
	public String updateMember(HttpServletResponse response, PrintWriter out, Member member) {
		boolean result = memberService.memberPassCheck(member.getEmail(), member.getPass());
		
		if(! result) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("alert('비밀번호가 맞지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
			return null;
		}
		memberService.updateMember(member);
		return "redirect:scrap";
	}

}