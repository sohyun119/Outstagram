package com.SH.outstagram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

	@GetMapping("/timeline_view")
	public String timeline() {
		
		
		return "post/timelineView";
	}
	
	
	
}
