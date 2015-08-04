package com.tastecoordi.web.dao;


import java.util.List;

import com.tastecoordi.web.vo.Enterprise;

public interface EnterpriseDao {
	
	
	public List<Enterprise> getEnterprises(int page, String field, String query);
		
	public int addEnterprise(Enterprise m);
	
	public int removeEnterprise(String uid);

	public Enterprise getEnterprise(String uid);
	
}
