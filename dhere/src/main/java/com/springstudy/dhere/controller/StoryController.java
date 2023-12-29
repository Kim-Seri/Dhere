package com.springstudy.dhere.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springstudy.dhere.domain.Image;
import com.springstudy.dhere.domain.Job;
import com.mysql.cj.Session;
import com.springstudy.dhere.domain.Member;
import com.springstudy.dhere.domain.Product;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;
import com.springstudy.dhere.service.ProductService;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private ProductService productService;
	
	// 데스크 셋업 리스트 출력 (메인)
	// 카테고리 별 제품 리스트 출력
	@RequestMapping(value= {"/", "/main"}, method=RequestMethod.GET)
	public String Main(Model model, @RequestParam(defaultValue="1") int storyNo,  @RequestParam(required=false, defaultValue="All") String productCategory) {
		
		List<Job> jList=storyService.getJobList();
		model.addAttribute("jList", jList);
		
		List<Story> sList = storyService.getStoryList();
		model.addAttribute("sList", sList);
		
		List<Product> pList = productService.productList(productCategory);
	    model.addAttribute("pList", pList);

		return "main";
	}
	
	// 게시물 디테일 
	@RequestMapping("/storyDetail")
	public String storyDetail(Model model, @RequestParam int storyNo) {
		
	    List<Story> story = storyService.getStoryDetail(storyNo);

	    model.addAttribute("story", story);
	    
	    System.out.println();

	    return "storyDetail";
	}
	
	//게시글 쓰기
	@RequestMapping(value="/postWrite",method=RequestMethod.POST)
	public String postWrite(HttpServletRequest request , HttpServletResponse response , Model model ,String title,String content1, String content2, String content3, String content4 ,
			@RequestParam(value="category",required=false)int categoryNo,HttpSession session,
			@RequestParam(value="additionalImages", required=false) List<MultipartFile> multipartFile) throws IOException{
		
		String nickname=(String) session.getAttribute("nickname");
		Member member=(Member) session.getAttribute("member");
		String email=member.getEmail();
		
		
		
		
		Story story=new Story();
		
		story.setTitle(title);
		story.setContent1(content1);
		story.setContent2(content2);
		story.setContent3(content3);
		story.setContent4(content4);
		story.setCategoryNo(categoryNo);
		story.setEmail(email);
		story.setNickname(nickname);
		System.out.println(nickname);
		
		
		storyService.postWrite(story);
		
		if(multipartFile != null &&! multipartFile.isEmpty()) {
			for (MultipartFile imageFile : multipartFile) {
                Image image = new Image();
                image.setFileName(imageFile.getOriginalFilename());
                image.setStoryNo(story.getStoryNo());
                storyService.insertImage(image);
            }
		}
		return "redirect:main";
	}
	
	@RequestMapping(value="/postWriteForm", method=RequestMethod.GET)
	public String postWriteForm(Model model) {
		
		List<Job> jList=storyService.getJobList();
		// System.out.println(jList.get(0).getCategoryName());
		model.addAttribute("jList",jList);
		
		
		return "postWriteForm";
	}

	// 제품 디테일
	@RequestMapping("/productDetail")
	public String productDetail(Model model, int productNo) {
		
		System.out.println(productNo);
		
		Product product = productService.getProduct(productNo);
		
		model.addAttribute("product", product);
		
		return "productDetail";
	}

}
