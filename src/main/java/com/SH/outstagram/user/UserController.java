package com.SH.outstagram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SH.outstagram.user.bo.UserBO;
import com.SH.outstagram.user.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/signup_view")
	public String signupView() {
		
		return "user/signUp";
	}
	
	@GetMapping("/signin_view")
	public String signinView(){
		
		return "user/signIn";
		
	}
	
	@GetMapping("/sign_out")
	public String signout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		  
		// *** 바로 controller 의 url로 redirect이용하여 바로 !!!
		return "redirect:/user/signin_view";
		
	}

	@GetMapping("/search_view")
	public String searchUserView() {
		return "user/searchView";
	}
	
	@GetMapping("/search")
	public String seach(
			@RequestParam("userLoginIdInput") String userLoginId
			, Model model) {
		
		User searchUser = userBO.searchUser(userLoginId);
		
		model.addAttribute("searchUser", searchUser);
		return "user/searchView";
	}
	
	
	
}
