package com.springstudy.dhere.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.service.MemberService;

@Controller
public class MemberController {
	
	private static final String DEFAULT_PATH = "/resources/upload/";
	
	@Autowired
	private MemberService memberService;
	
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
}