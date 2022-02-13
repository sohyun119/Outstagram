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
		
		// 특정유저의 post들을 가져와서... 합친다? -> 여러 사람의 게시물을 섞어서 가져오지 못하겠음 ㅜ 
		//										ㄴ 따라서 일단은 각 유저의 post를 최신순으로 20개씩까지만 가져와서 유저별로 배치 예정
		
		List<Post> timelinePosts = new ArrayList<>();
		
		for(int followingUserId:followingList) {
			List<Post> userPost = postBO.selectTimelinePost(followingUserId);
			for(int i=0; i<userPost.size(); i++) {
				timelinePosts.add(userPost.get(i));
			}
		}
		
		model.addAttribute("timelinePosts", timelinePosts);
		
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
