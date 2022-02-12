package com.SH.outstagram.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SH.outstagram.post.model.Follow;
import com.SH.outstagram.post.model.Post;

@Repository
public interface PostDAO {

	public List<Integer> selectTimelineUserIdList(@Param("thisId") int thisId);
	
	public List<Post> selectTimelinePost(@Param("followingUserId") int followingUserId);

	public List<Post> selectFeedPostList(@Param("thisId") int thisId);
	
	public int insertPost(
			@Param("userId") int userId
			, @Param("userName") String userName
			, @Param("content") String content
			, @Param("imagePath") String filePath
			);
	
	public int selectIsFollow(
			@Param("thisId") int thisId
			, @Param("userId") int userId
			);
	
	public int insertFollow(
			@Param("thisId") int thisId
			, @Param("thisName") String thisName
			, @Param("userId") int userId
			, @Param("userName") String userName
			);
	
	public int deleteFollow(
			@Param("thisId") int thisId
			, @Param("userId") int userId
			);
	
	
	public List<String> followUserNameList(
			@Param("feedUserId") int feedUserId
			);
	
	public List<String> followingUserNameList(
			@Param("feedUserId") int feedUserId
			);
	
	
	
	
}
