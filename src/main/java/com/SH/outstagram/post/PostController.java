package com.SH.outstagram.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SH.outstagram.post.bo.PostBO;
import com.SH.outstagram.post.model.Follow;
import com.SH.outstagram.post.model.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;

	@GetMapping("/timeline_view")
	public String timeline(
			HttpServletRequest request
			, Model model
			) {
		
		HttpSession session = request.getSession();
		int thisId = (Integer)session.getAttribute("userId");
		
		List<Follow> followList = postBO.followingList(thisId);
		model.addAttribute("followList", followList);
		
		return "post/timelineView";
	}
	
	@GetMapping("/other_feed_view")
	public String other_feed(
			@RequestParam("userId") int userId,
			@RequestParam("userName") String userName,
			HttpServletRequest request,
			Model model
			) {
		
		model.addAttribute("feedUserName", userName);
		model.addAttribute("feedUserId", userId);
		
		HttpSession session = request.getSession();
		int thisId = (Integer)session.getAttribute("userId");
		
		int count = postBO.isFollow(thisId, userId);
		model.addAttribute("followState",count);
		
		List<Post> feedPost = postBO.feedPostList(userId);
		model.addAttribute("feedPost", feedPost);
		
		return "post/feed";
	}
	
	@GetMapping("/feed_view")
	public String feed(
			HttpServletRequest request
			, Model model
			)
	{
			
		HttpSession session = request.getSession();
		int thisId = (Integer)session.getAttribute("userId");
		String thisName = (String)session.getAttribute("userName");
		String thisLoginId = (String)session.getAttribute("userLoginId");
		
		model.addAttribute("feedUserName", thisName);
		model.addAttribute("feedUserLoginId", thisLoginId);
		
		
		List<Post> feedPost = postBO.feedPostList(thisId);
		model.addAttribute("feedPost", feedPost);
		
		
		return "post/feed";
		
	}
	
	@GetMapping("/create_view")
	public String createView() {
		
		return "post/createView";
	}
	
	
}
