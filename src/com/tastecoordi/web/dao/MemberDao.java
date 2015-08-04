package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.Member;

public interface MemberDao {
	
	public int addMember(Member m);
	
/*	public List<Member> getMembers(
			String field, 
			String query
			);*/
	
	public List<Member> getMembers(
			int page, 
			String field, 
			String query,
			String startDate,
			String endDate);
	
	
	public List<Member> getMembers();
	public Member getMember(String id);
	
	public int removeMember(String id);

}
