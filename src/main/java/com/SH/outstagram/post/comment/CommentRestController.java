package com.SH.outstagram.post.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SH.outstagram.post.comment.bo.CommentBO;

@RestController
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/post/add_comment")
	public Map<String, String> addComment(
			@RequestParam("postId") int postId,
			@RequestParam("comment") String comment,
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		
		int count = commentBO.addComment(postId, userId, userName, comment);
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@GetMapping("/post/delete_comment")
	public Map<String, String> deleteComment(@RequestParam("commentId") int commentId){
		
		int count = commentBO.deleteComment(commentId);
		
		Map<String, String> map = new HashMap<>();
		if(count == 1) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
	

}
