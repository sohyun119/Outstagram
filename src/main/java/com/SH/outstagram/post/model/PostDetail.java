package com.SH.outstagram.post.model;

import java.util.List;

import com.SH.outstagram.post.comment.model.Comment;

// 각 포스트에 대한 댓글과 좋아요 정보 관리를 위한 class
public class PostDetail {
	// 하나의 post + 댓글 리스트 + 좋아요 갯수 (좋아요 중인지 판별)
	
	private Post post;
	private List<Comment> commentList;
	private int likeCount;
	private boolean isLike;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public boolean getIsLike() {
		return isLike;
	}
	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}

}
