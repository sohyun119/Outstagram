package com.SH.outstagram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SH.outstagram.common.FileManagerService;
import com.SH.outstagram.post.dao.PostDAO;
import com.SH.outstagram.post.model.Follow;
import com.SH.outstagram.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;

	public List<Follow> followingList(int thisId){
		return postDAO.selectFollowing(thisId);
	}
	
	public List<Post> feedPostList(int thisId){
		return postDAO.selectFeedPostList(thisId);
	}
	
	public int addPost(int userId, String userName, String content, MultipartFile file) {
		String filePath = FileManagerService.saveFile(userId, file);
		return postDAO.insertPost(userId, userName, content, filePath);
	}
	
	
}
