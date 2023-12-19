package com.springstudy.dhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.dhere.domain.Product;
import com.springstudy.dhere.service.ProductService;

@Controller
public class StoryController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value= {"/", "/main"}, method=RequestMethod.GET)
    public String productList(Model model) { 
        List<Product> pList = productService.productList();
        model.addAttribute("pList", pList);
        return "main";
    }
	
	@RequestMapping("/productDetail")
	public String productDetail(Model model, int productNo) {
		
		System.out.println(productNo);
		
		Product product = productService.getProduct(productNo);
		
		model.addAttribute("product", product);
		
		return "productDetail";
	}

}
