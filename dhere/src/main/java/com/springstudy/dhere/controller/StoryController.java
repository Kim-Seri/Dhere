package com.springstudy.dhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	private StoryService storyService;

	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String Main(Model model) {


		model.addAllAttributes(storyService.getStoryList());

		return "main";
	}
	
	
	
	
	
	

}
