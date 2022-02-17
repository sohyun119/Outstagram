package com.SH.outstagram.post.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.outstagram.post.like.dao.LikeDAO;

@Service
public class LikeBO {
	
	@Autowired
	private LikeDAO likeDAO;
	
	public boolean like(int postId, int userId) {
		
		if(this.getIsLike(postId, userId)) { // 좋아요 중 -> 좋아요 취소
			likeDAO.deleteLike(postId, userId);
			return false;
		}
		else {
			likeDAO.insertLike(postId, userId);
			return true;
		}
		
	}
	
	public int getLikeCount(int postId) {
		return likeDAO.selectLikeCount(postId);
	}
	
	public boolean getIsLike(int postId, int userId) {
		int count = likeDAO.selectIsLike(postId, userId);
		
		if(count==1) { // 좋아요 중
			return true;
		}else {
			return false;
		}
	}
	

}
