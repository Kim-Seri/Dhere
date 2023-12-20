package com.springstudy.dhere.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import com.springstudy.dhere.domain.Image;
import com.mysql.cj.Session;
import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	// 데스크 셋업 리스트 출력 (메인)
	@RequestMapping(value= {"/", "/main"}, method=RequestMethod.GET)
	public String Main(Model model, @RequestParam(defaultValue="1") int storyNo) {
		
		List<Story> sList = storyService.getStoryList();
		model.addAttribute("sList", sList);

		return "main";
	}
	
	// 게시물 쓰기 
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

	// 제품 리스트 출력 (메인)
	@RequestMapping("/productDetail")
	public String productDetail(Model model, int productNo) {
		
		System.out.println(productNo);
		
		Product product = productService.getProduct(productNo);
		
		model.addAttribute("product", product);
		
		return "productDetail";
	}
	
	
	
	

}
