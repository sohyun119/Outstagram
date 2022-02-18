package com.SH.outstagram.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.outstagram.post.comment.dao.CommentDAO;
import com.SH.outstagram.post.comment.model.Comment;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public List<Comment> getCommentList(int postId){
		return commentDAO.selectCommentList(postId);
	}
	
	public int addComment(int postId, int userId, String userName, String comment) {
		return commentDAO.insertComment(postId, userId, userName, comment);
	}

	public int deleteComment(int commentId) {
		return commentDAO.deleteComment(commentId);
	}
	
	
}
