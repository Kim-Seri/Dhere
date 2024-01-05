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
import com.springstudy.dhere.domain.Reply;
import com.springstudy.dhere.domain.Story;
import com.springstudy.dhere.domain.Tag;
import com.springstudy.dhere.service.ProductService;
import com.springstudy.dhere.service.ReplyService;
import com.springstudy.dhere.service.StoryService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	//	댓글 쓰기(syj)
	@RequestMapping(value="/replyWrite", method=RequestMethod.POST)
	public String replyWrite(HttpServletRequest request, HttpServletResponse response, Model model,
	                         @RequestParam("storyNo") int storyNo,
	                         @RequestParam(value = "replyNo", required = false) Integer replyNo,
	                         @RequestParam("replyContent") String replyContent,
	                         HttpSession session) {
	    // 세션에서 이메일을 가져오기
	    String email = (session.getAttribute("member") != null) ? ((Member)session.getAttribute("member")).getEmail() : null;

	    // 이메일이 null이면 사용자가 로그인하지 않은 것으로 간주하고 처리
	    if(email == null) {
	        // 로그인 페이지로 리다이렉트하거나 에러 메시지
	        return "redirect:login";
	    }

	    Reply reply = new Reply();
	    
	    reply.setStoryNo(storyNo);
	    reply.setReplyNo(replyNo != null ? replyNo : 0); // replyNo가 null이면 기본값으로 설정
	    reply.setReplyContent(replyContent);
	    reply.setEmail(email);
	    
	    replyService.replyWrite(reply);
	    
	    return "redirect:storyDetail?storyNo=" + storyNo; // 댓글을 단 스토리로 리다이렉트
	}
	
	
	
//	//	댓글 리스트에 담아 가져오기(syj)
//    @RequestMapping("/getReply")
//    public String getReply(@RequestParam("storyNo") int storyNo, Model model) {
//        List<Reply> reply = replyService.getReply(storyNo);
//        model.addAttribute("reply", reply);
//        model.addAttribute("storyNo", storyNo);
//        return "storyDetail";
//    }
}
