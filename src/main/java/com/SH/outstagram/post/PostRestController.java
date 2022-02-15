package com.SH.outstagram.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SH.outstagram.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	// restcontroller 에서는 modle을 쓰지 않는다!!!!!!!
	
	@Autowired
	private PostBO postBO;

	@PostMapping("/create")
	public Map<String, String> create(
			@RequestParam("content") String content
			, @RequestParam("file") MultipartFile file
			,HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		
		int count = postBO.addPost(userId, userName, content, file);
		
		Map<String, String> map = new HashMap<>();
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("/delete")
	public Map<String, String> delete(@RequestParam("postId") int postId){
		
		int count = postBO.deletePost(postId);
		
		Map<String, String> map = new HashMap<>();
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/follow")
	public Map<String, String> follow(
			@RequestParam("feedUserId") int userId
			, @RequestParam("feedUserName") String userName
			, HttpServletRequest request
			){
	// if문 써서 delete or insert
		HttpSession session = request.getSession();
		
		int thisId = (Integer)session.getAttribute("userId");
		String thisName = (String)session.getAttribute("userName");
		
		int count = postBO.addFollow(thisId,thisName,userId,userName);	
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@GetMapping("/unfollow")
	public Map<String, String> unfollow(
			@RequestParam("feedUserId") int userId
			, HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		
		int thisId = (Integer)session.getAttribute("userId");
		
		int count = postBO.deleteFollow(thisId, userId);
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
	@GetMapping("/followList")
	public List<String> followList(
			@RequestParam("feedUserId") int feedUserId
			){
		
		List<String> followList = new ArrayList<>();
		
		followList = postBO.followList(feedUserId);
		
		return followList;
	}
	
	@GetMapping("/followingList")
	public List<String> followingList(
			@RequestParam("feedUserId") int feedUserId){
		
		List<String> followingList = new ArrayList<>();
		
		followingList = postBO.followingList(feedUserId);
		
		return followingList;
		
	}
	
	
	
	
	
	
	
}
