package com.SH.outstagram.post.like;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SH.outstagram.post.like.bo.LikeBO;

@RestController
@RequestMapping("/post")
public class LikeRestController {
	@Autowired
	private LikeBO likeBO;
	
	@GetMapping("/like")
	public Map<String, Boolean> like(
			@RequestParam("postId") int postId
			, HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", likeBO.like(postId, userId));
		
		return result;
		
	}
	
	

}
