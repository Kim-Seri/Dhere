package com.springstudy.dhere.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.dhere.domain.Image;
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
	
	
	

	@RequestMapping("storyDetail")
	public String storyDetail(Model model, @RequestParam int storyNo) {
	    List<Story> story = storyService.getStoryDetail(storyNo);
	    model.addAttribute("story", story);

	    return "storyDetail";
	}
   
}
