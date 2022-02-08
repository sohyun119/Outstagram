package com.SH.outstagram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.outstagram.post.dao.PostDAO;
import com.SH.outstagram.post.model.Follow;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;

	public List<Follow> followingList(int thisId){
		return postDAO.selectFollowing(thisId);
	}
	
	
}
