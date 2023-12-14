package com.springstudy.dhere.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.StoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private StoryService storyService;
	
	
	@RequestMapping(value= "/", method=RequestMethod.GET)
    public String storyList(Model model) {
	   
	  
        List<Story> sList = storyService.storyList();
        model.addAttribute("sList", sList);
        
        System.out.println(sList.get(0).getTitle());
        
        return "main";
    }
   
   
}
