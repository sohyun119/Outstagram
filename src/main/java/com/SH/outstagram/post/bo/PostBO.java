package com.SH.outstagram.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SH.outstagram.common.FileManagerService;
import com.SH.outstagram.post.comment.bo.CommentBO;
import com.SH.outstagram.post.comment.model.Comment;
import com.SH.outstagram.post.dao.PostDAO;
import com.SH.outstagram.post.like.bo.LikeBO;
import com.SH.outstagram.post.model.Post;
import com.SH.outstagram.post.model.PostDetail;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private CommentBO commentBO;
	@Autowired
	private LikeBO likeBO;
	

	public List<Integer> timelineUserIdList(int thisId){
		return postDAO.selectTimelineUserIdList(thisId);
	}
	// 하나의 post에 대한 정보를 다 내포함 -> * 댓글과 좋아요를 게시물과 연관 짓기 위해서 (jsp에서 post를 불러온 뒤 불러오기가 힘듦)
	public List<PostDetail> postDetailList(List<Integer> followingList, int userId){
		
		List<PostDetail> postDetailList = new ArrayList<>();
		
		for(int followingUserId:followingList) {
			List<Post> posts = this.feedPostList(followingUserId);
			for(Post post:posts) {
				
				List<Comment> commentList = commentBO.getCommentList(post.getId());
				int likeCount = likeBO.getLikeCount(post.getId());
				boolean isLike = likeBO.getIsLike(post.getId(), userId);
				
				PostDetail postDetail = new PostDetail();
				
				postDetail.setPost(post);
				postDetail.setCommentList(commentList);
				postDetail.setLikeCount(likeCount);
				postDetail.setIsLike(isLike);
				
				postDetailList.add(postDetail);
			}
		}
		return postDetailList;
		
	}
	
	// feed 디테일 화면에서 사용할 리스트가 아닌 하나의 postDetail 에 관한 정보 불러오기
	public PostDetail selectPostDetail(int postId, int userId) {
		
		PostDetail postDetail = new PostDetail();
		
		List<Comment> commentList = commentBO.getCommentList(postId);
		int likeCount = likeBO.getLikeCount(postId);
		boolean isLike = likeBO.getIsLike(postId, userId);
		
		postDetail.setPost(this.selectPost(postId));
		postDetail.setCommentList(commentList);
		postDetail.setLikeCount(likeCount);
		postDetail.setIsLike(isLike);
		
		return postDetail;
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
	
	public int followCount(int feedUserId) {
		return postDAO.followCount(feedUserId);
	}
	public int followingCount(int feedUserId) {
		return postDAO.followingCount(feedUserId);
	}
	
	
}
