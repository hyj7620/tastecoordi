package com.tastecoordi.web.dao;

import java.sql.SQLException;

import com.tastecoordi.web.vo.Follow;

public interface FollowDao {


	public int removeFollow(Follow f) throws ClassNotFoundException,
			SQLException;;

	/*
	 * public Fallow getfallow(String Mid) throws ClassNotFoundException,
	 * SQLException;
	 */

	public int getfollow(Follow f) throws ClassNotFoundException, SQLException;

	public int removeFollow(String Mid) throws ClassNotFoundException,
			SQLException;
	
	public int addFollow(Follow f);

}
