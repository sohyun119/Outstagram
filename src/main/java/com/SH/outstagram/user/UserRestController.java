package com.SH.outstagram.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SH.outstagram.user.bo.UserBO;
import com.SH.outstagram.user.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;

	
	@PostMapping("/sign_up")
	public Map<String, String> signUp(
			@RequestParam("email") String email
			, @RequestParam("name") String name
			, @RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			){
		
		int count = userBO.addUser(email, name, loginId, password);
		
		Map<String, String> map = new HashMap<>();
		
		if(count==1) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	@GetMapping("/is_duplicate_id")
	public Map<String, String> isDuplicate(
			@RequestParam("loginId") String loginId
			){
		Map<String, String> map = new HashMap<>();
		
		if(userBO.isDuplicate(loginId) == true) { // 중복되는게 있을때
			map.put("is_duplicate", "true");
		}else {
			map.put("is_duplicate", "false");
		}
		
		return map;
		
	}
	
	
	@PostMapping("/sign_in")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request // session : 로그인 지속
			){
		
		User thisUser = userBO.loginUser(loginId, password);
		
		Map<String, String> map = new HashMap<>();
		
		if(thisUser != null) {
			map.put("result", "success");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", thisUser.getId());
			session.setAttribute("userLoginId", thisUser.getLoginId());
			session.setAttribute("userName", thisUser.getName());
			
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	
	
	
}
