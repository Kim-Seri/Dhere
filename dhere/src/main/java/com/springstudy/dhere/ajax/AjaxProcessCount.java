package com.springstudy.dhere.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springstudy.dhere.domain.Product;
import com.springstudy.dhere.service.MemberService;
import com.springstudy.dhere.service.ProductService;

@Controller
public class AjaxProcessCount {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/ConfirmId")
	@ResponseBody
	public Map<String, Boolean> overIdCheck(String id){
		
		boolean result=memberService.overEmailCheck(id);
		Map<String,Boolean> map=new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	// 카테고리 별 제품 리스트 출력
	@RequestMapping("/categoryList")
	@ResponseBody
	public Map<String, List<Product>> productList(String productCategory) {
		Map<String, List<Product>> map= new HashMap<>();
		map.put("category", productService.productList(productCategory));
		
		return map;
	}
	
	// 회원 정보 수정하는 ajax 요청을 처리하는 컨트롤러
	@RequestMapping("/passCheck.ajax")
	@ResponseBody
	public Map<String, Boolean> memberPassCheck(String email, String pass) {
		boolean result = memberService.memberPassCheck(email, pass);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", result);
		
		return map;
	}
	
}

