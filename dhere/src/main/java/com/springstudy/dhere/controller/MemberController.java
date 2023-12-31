package com.springstudy.dhere.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private static final String DEFAULT_PATH = "/resources/images/profile";

	// 로그인
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
			return null;
		}

		Member member = memberService.getMember(email);

		session.setAttribute("isLogin", true);
		session.setAttribute("member", member);
		session.setAttribute("nickname", member.getNickname());

		System.out.println(email);
		System.out.println(pass);
		System.out.println(result);

		return "redirect:main";

	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	// 회원가입
	@RequestMapping(value = "/joinResult", method = RequestMethod.POST)
    public String joinResult(Member m, HttpServletRequest request, @RequestParam(value="picture1", required=false) MultipartFile multipartFile) throws IOException {
        System.out.println("email : " + m.getEmail());
        System.out.println("pass : " + m.getPass());
        System.out.println("name : " + m.getName());
        System.out.println("nickname : " + m.getNickname());
        System.out.println("zipcod : " + m.getZipcode());
        System.out.println("a1 : " + m.getAddress1());
        System.out.println("a2 : " + m.getAddress2());
        System.out.println("job : " + m.getJob());
        System.out.println("phone : " + m.getPhone());
        System.out.println("role : " + m.getRole());
        
        if (multipartFile != null && !multipartFile.isEmpty()) {
            
            // Request 객체를 이용해 파일이 저장될 실제 경로를 구한다.
            String filePath = request.getServletContext().getRealPath(DEFAULT_PATH);
            
            UUID uid = UUID.randomUUID();
            String saveName = uid.toString() + "_" + multipartFile.getOriginalFilename();
            
            File file = new File(filePath, saveName);         
            
            // 업로드 되는 파일을 upload 폴더로 저장한다.
            multipartFile.transferTo(file);
            m.setPicture(saveName);
            
            System.out.println("picture : " + m.getPicture());
        } else {
            // Handle the case when no file is uploaded
            System.out.println("No file uploaded");
        }
        memberService.addMember(m);
        return "redirect:main";
    }
	
	
	// 회원 정보 수정 폼 요청을 처리하는 메서드
	@RequestMapping(value="/mypageUpdateProcess")
	public String updateForm(String email, HttpSession session) {
		
		return "member/mypageUpdateProcess";
	}
	

	// 회원 수정폼에서 들어오는 요청을 처리하는 메서드
//	@RequestMapping("/mypageUpdateResult")
//	public String mypageUpdateInfo(Model model, Member member, 
//			String pass1, String phone) {
//		member.setPass(pass1);
//		member.setPhone(phone);
//		
//		memberService.updateMember(member);
//		model.addAttribute("member", member);
//		
//		return "redirect:scrap";
//	}

}
