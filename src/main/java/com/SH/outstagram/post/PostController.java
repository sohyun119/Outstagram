package com.SH.outstagram.post;

import java.util.ArrayList;
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
import com.SH.outstagram.post.model.Post;
import com.SH.outstagram.post.model.PostDetail;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;

	@GetMapping("/timeline_view")
	public String timeline( // 로그인한 사람이 팔로잉한 사람들의 게시물들 나열
			HttpServletRequest request
			, Model model
			) {
		
		HttpSession session = request.getSession();
		int thisId = (Integer)session.getAttribute("userId");
		
		List<Integer> followingList = postBO.timelineUserIdList(thisId);
		followingList.add(thisId);
		
		List<PostDetail> postDetailList = postBO.postDetail(followingList, thisId); // BO에서 다 처리
	
		model.addAttribute("postDetailList", postDetailList);
		model.addAttribute("thisId", thisId);
		
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
		
		// 해당 메소드를 통해 내 feed를 들어갈때 my feed인 것을 알려주는 변수 필요
		boolean my_feed = false;
		if(thisId == userId) {
			my_feed = true;
		}
		model.addAttribute("my_feed", my_feed);
		
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
		
		model.addAttribute("feedUserId", thisId);
		model.addAttribute("feedUserName", thisName);
		model.addAttribute("feedUserLoginId", thisLoginId);
		model.addAttribute("my_feed",true);
		
		
		List<Post> feedPost = postBO.feedPostList(thisId);
		model.addAttribute("feedPost", feedPost);
		
		
		return "post/feed";
		
	}
	
	@GetMapping("/create_view")
	public String createView() {
		
		return "post/createView";
	}
	
	@GetMapping("/detail_view")
	public String detailView(
			@RequestParam("postId") int postId
			, HttpServletRequest request
			, Model model
			) {
		
		HttpSession session = request.getSession();
		int thisId = (Integer)session.getAttribute("userId");
		
		Post post = postBO.selectPost(postId);
		model.addAttribute("post", post);
		model.addAttribute("thisId", thisId);
		
		return "post/detailView";
	}
	
	
}
