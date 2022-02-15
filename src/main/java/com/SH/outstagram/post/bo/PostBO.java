package com.SH.outstagram.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SH.outstagram.common.FileManagerService;
import com.SH.outstagram.post.dao.PostDAO;
import com.SH.outstagram.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;

	public List<Integer> timelineUserIdList(int thisId){
		return postDAO.selectTimelineUserIdList(thisId);
	}
	
	public List<Post> selectTimelinePost(int followingUserId){

		return postDAO.selectTimelinePost(followingUserId);
	}
	
	public List<Post> feedPostList(int thisId){
		return postDAO.selectFeedPostList(thisId);
	}
	
	public Post selectPost(int postId) {
		return postDAO.selectPost(postId);
	}
	
	public int addPost(int userId, String userName, String content, MultipartFile file) {
		// 파일경로로 DAO에 넘기기
		String filePath = FileManagerService.saveFile(userId, file);
		return postDAO.insertPost(userId, userName, content, filePath);
	}
	
	public int deletePost(int postId) {
		return postDAO.deletePost(postId);
	}
	
	// 팔로우 여부 확인
	public int isFollow(int thisId, int userId) {
		return postDAO.selectIsFollow(thisId, userId);
	}
	
	public int addFollow(int thisId, String thisName, int userId, String userName) {
		return postDAO.insertFollow(thisId, thisName, userId, userName);
	}
	
	public int deleteFollow(int thisId, int userId) {
		return postDAO.deleteFollow(thisId, userId);
	}
	
	// feed 주인의 팔로우 팔로잉 리스트 확인
	public List<String> followList(int feedUserId){
		return postDAO.followUserNameList(feedUserId);
	}
	public List<String> followingList(int feedUserId){
		return postDAO.followingUserNameList(feedUserId);
	}
	
}
