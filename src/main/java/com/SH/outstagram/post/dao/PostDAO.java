package com.SH.outstagram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SH.outstagram.post.model.Follow;
import com.SH.outstagram.post.model.Post;

@Repository
public interface PostDAO {

	public List<Follow> selectFollowing(@Param("thisId") int thisId);

	public List<Post> selectFeedPostList(@Param("thisId") int thisId);
	
}
