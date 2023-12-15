package com.springstudy.dhere.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getMember(String email, @RequestParam("pass1") String pass, HttpServletResponse response,
			HttpSession session, PrintWriter out) {

		int result = memberService.login(email, pass);

		if (result == -1) { // 회원이 존재하지 않는 경우
			response.setContentType("text/html; charset=utf-8");
			out.print("<script>");
			out.print("alert('회원 아이디가 존재하지 않습니다');");
			out.print("location.href='loginForm'");
			out.print("</script>");
			return null;
		} else if (result == 0) { // 비밀번호가 틀린 경우
			response.setContentType("text/html; charset=utf-8");
			out.print("<script>");
			out.print("alert('비밀번호가 틀립니다.');");
			out.print("history.back();");
			out.print("</script>");
		}

		Member member = memberService.getMember(email);

		session.setAttribute("isLogin", true);
		session.setAttribute("member", member);
		session.setAttribute("name", member.getNickname());

		System.out.println(email);
		System.out.println(pass);
		System.out.println(result);

		return "redirect:main";

	}
}
