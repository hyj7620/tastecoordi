package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.Comments;

public interface CommentsDao {
	public List<Comments> getComments();

	public List<Comments> getComments(int page);

	public List<Comments> getComments(int page, String field, String query);

	public int addComments(Comments c);

	public int removeComments(String code);
}
