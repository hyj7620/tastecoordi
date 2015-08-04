package com.tastecoordi.web.dao;


import com.tastecoordi.web.vo.Like;

public interface LikeDao {
	
	public int addLike(Like m);
	
	public int removeLike(String uid);

	public Like getLike(String uid);

	

}
