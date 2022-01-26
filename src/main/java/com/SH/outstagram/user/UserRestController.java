package com.SH.outstagram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/sign_in")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			){
		
		User thisUser = userBO.loginUser(loginId, password);
		
		Map<String, String> map = new HashMap<>();
		
		if(thisUser != null) {
			map.put("result", "success");
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	
	
}
