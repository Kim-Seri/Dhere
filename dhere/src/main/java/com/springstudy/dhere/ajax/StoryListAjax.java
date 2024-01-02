package com.springstudy.dhere.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.service.StoryService;

@Controller
public class StoryListAjax {
	
	@Autowired
	private StoryService storyService;
	
	@RequestMapping("/jobSelectedCategory")
	@ResponseBody
	public Map<String, List<Story>> categoryStoryList(String selectedJob) {
		System.out.println(selectedJob);

		Map<String, List<Story>> map = new HashMap<>();
		map.put("category", storyService.storyList(selectedJob));
		
		return map;
	}
}
