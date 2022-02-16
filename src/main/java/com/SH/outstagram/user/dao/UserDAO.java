package com.SH.outstagram.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SH.outstagram.user.model.User;

@Repository
public interface UserDAO {


	public int insertUser(
			@Param("email") String email
			, @Param("name") String name
			, @Param("loginId") String loginId
			, @Param("password") String password
			);
	
	public User selectLoginUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			);
	
	public int selectDuplicate(
			@Param("loginId") String loginId
			);
	
	
	public User searchUser(@Param("userLoginId") String userLoginId);
	
}

