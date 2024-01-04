package com.springstudy.dhere.controller;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	private static final String DEFAULT_PATH = "/resources/images/desk/";
	
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
///////////////////////////////////////////////////////////////////		
	// 게시물 디테일(syj)
	@RequestMapping("/storyDetail")
	public String storyDetail(Model model, @RequestParam int storyNo, HttpSession session) {
		
		// 조회수 증가 로직 추가
		storyService.increaseReadCount(storyNo);
	    
	    Story storyDetail = storyService.getStoryDetail(storyNo);
	    model.addAttribute("storyDetail", storyDetail);
	    
	    List<Image> iList = storyService.getStoryDetailImage(storyNo);
		model.addAttribute("iList", iList);
	    
		List<Tag> tList = storyService.getStoryDetailTag(storyNo);
		model.addAttribute("tList", tList);
	    
		
	    return "storyDetail";
	}
///////////////////////////////////////////////////////////////////		
	@RequestMapping(value = "/increaseThank", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> increaseThank(@RequestParam("storyNo") int storyNo) {
	
	    // 여기서 storyService.increaseThank(storyNo) 메서드는 데이터베이스에서 storyNo에 해당하는 게시물의 좋아요 수를 증가시키는 로직을 수행합니다.
	    int newLikes = storyService.increaseThank(storyNo);
	    Map<String, Object> response = new HashMap<>();
	    response.put("likes", newLikes);
	    
	    return response;
	}
///////////////////////////////////////////////////////////////////		
	// 게시물 삭제(syj)
	@RequestMapping("/deleteStory")
	public String deleteStory(HttpServletResponse response, int storyNo) {
		
		storyService.deleteStory(storyNo);
		
		return "redirect:main";
	}
///////////////////////////////////////////////////////////////////	
	// 게시물 수정하기 읽어오기(syj)
	@RequestMapping("/updateStory")
	public String updateStory(Model model, HttpServletResponse response, int storyNo) {

		Story story = storyService.getStoryDetail(storyNo);

		model.addAttribute("story", story);

		return "updateStory";
	}
///////////////////////////////////////////////////////////////////
	// 게시물 수정하기(syj)
	@RequestMapping(value="updateStoryProcess", method=RequestMethod.POST)
	public String updateStoryProcess(HttpServletResponse response, PrintWriter out, @ModelAttribute Story story) {
	
		// storyService 클래스를 이용해 게시물을 수정한다.
		storyService.updateStoryProcess(story);
		
		return "redirect:main";
	}
///////////////////////////////////////////////////////////////////		
	
	
	
	
	
	
	
	
	
	
	
	
	//게시글 쓰기
		@RequestMapping(value="/postWrite",method=RequestMethod.POST)
		public String postWrite(HttpServletRequest request , HttpServletResponse response , Model model ,String title,String content1, String content2, String content3, String content4 ,
				@RequestParam(value="category",required=false)int categoryNo,HttpSession session,
				@RequestParam(value="hashtag",required=false) List<String> tagList,
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
			
			System.out.println(tagList);
			
			
			//태그 리스트 추가
			if(tagList != null &&! tagList.isEmpty()) {
				for(String hashtag:tagList) {
					Tag tag=new Tag();
					tag.setTagName(hashtag);
					tag.setStoryNo(story.getStoryNo());
					storyService.insertTag(tag);
					storyService.insertTagPost(tag);
				}
			}
			
			// 이미지 리스트 추가
			if (multipartFile != null && !multipartFile.isEmpty()) {
				 
				for (MultipartFile imageFile : multipartFile) {
					Image image = new Image();
					 // Request 객체를 이용해 파일이 저장될 실제 경로를 구한다.
		            String filePath = request.getServletContext().getRealPath(DEFAULT_PATH);
		          
		            UUID uid = UUID.randomUUID();
		            
		            String saveName = uid.toString() + "_" + imageFile.getOriginalFilename();
		            String encodedFileName = URLEncoder.encode(saveName, "UTF-8");
		            File file = new File(filePath, encodedFileName);         
		            
		            // 업로드 되는 파일을 upload 폴더로 저장한다.
		            imageFile.transferTo(file);
		            image.setFileName(encodedFileName);
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
