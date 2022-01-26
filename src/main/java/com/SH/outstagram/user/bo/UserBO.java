package com.SH.outstagram.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.outstagram.common.EncryptUtils;
import com.SH.outstagram.user.dao.UserDAO;
import com.SH.outstagram.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	

	public int addUser(String email, String name, String loginId, String password) {
		
		return userDAO.insertUser(email, name, loginId, EncryptUtils.md5(password));
		
	}
	
	public User loginUser(String loginId, String password) {
		return userDAO.selectLoginUser(loginId, EncryptUtils.md5(password));
	}
	
	
}
