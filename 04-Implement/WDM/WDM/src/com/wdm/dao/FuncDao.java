package com.wdm.dao;

import java.util.List;

public interface FuncDao {
	
	public List getFunctionList() throws Exception;
	public List getColomnList(String appId) throws Exception;
	public List getAllColomnList(String appId) throws Exception;
	public void setColomnList(String appId,String colList) throws Exception;
}
