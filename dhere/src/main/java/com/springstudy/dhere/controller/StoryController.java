package com.springstudy.dhere.controller;

import java.io.IOException;
import java.util.List;

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

import com.mysql.cj.Session;
import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@RequestMapping(value="/postWrite",method=RequestMethod.POST)
	public String postWrite(HttpServletRequest request , HttpServletResponse response , Model model ,String title,String content ,@RequestParam(value="category",required=false)int categoryNo,HttpSession session,
			@RequestParam(value="fileName", required=false) MultipartFile multipartFile) throws IOException{
		
		String nickname=(String) session.getAttribute("nickname");
		Member member=(Member) session.getAttribute("member");
		String email=member.getEmail();
		
		System.out.println("originName : " + multipartFile.getOriginalFilename());
		System.out.println("name : " + multipartFile.getName());
		
		Story story=new Story();
		
		story.setTitle(title);
		story.setContent(content);
		story.setCategoryNo(categoryNo);
		story.setEmail(email);
		story.setNickname(nickname);
		
		
		storyService.postWrite(story);
		
		if(! multipartFile.isEmpty()) {
			Image image=new Image();
			image.setFileName(multipartFile.getOriginalFilename());
			image.setStoryNo(story.getStoryNo());
			
		}
		
		
		
		
		return "redirect:main";
	}

	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String Main(Model model) {

		model.addAllAttributes(storyService.getStoryList());

		return "main";
	}

}
