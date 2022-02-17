package com.SH.outstagram.post.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SH.outstagram.post.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public List<Comment> selectCommentList(@Param("postId") int postId);

}
