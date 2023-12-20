package com.springstudy.dhere.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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
import com.springstudy.dhere.domain.Product;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.ProductService;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private ProductService productService;
	
	// 데스크 셋업 리스트 출력 (메인)
	@RequestMapping(value= {"/", "/main"}, method=RequestMethod.GET)
	public String Main(Model model, @RequestParam(defaultValue="1") int storyNo) {
		
		List<Story> sList = storyService.getStoryList();
		model.addAttribute("sList", sList);
		
		List<Product> pList = productService.productList();
	    model.addAttribute("pList", pList);

		return "main";
	}
	
	// 게시물 디테일 
	@RequestMapping("storyDetail")
	public String storyDetail(Model model, @RequestParam int storyNo) {
	    List<Story> story = storyService.getStoryDetail(storyNo);
	    model.addAttribute("story", story);

	    return "storyDetail";
	}

}
