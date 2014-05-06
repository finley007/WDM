package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.common.locale.WDMResource;

public class FuncInfoVO {
	
	private final String COLOMN_FUNC_ID = "FUNC_ID";
	private final String COLOMN_PARENT_ID = "PARENT_ID";
	private final String COLOMN_URL = "URL";
	private final String COLOMN_FUNC_NAME = "FUNC_NAME";
	private final String COLOMN_FUNC_DESC = "FUNC_DESC";
	
	public FuncInfoVO(){
		
	}
	
	public FuncInfoVO(ResultSet rs) throws SQLException{
		this.setFuncID(rs.getString(COLOMN_FUNC_ID));
		this.setParentID(rs.getString(COLOMN_PARENT_ID));
		this.setFuncName(WDMResource.getString(rs.getString(COLOMN_FUNC_NAME)));
		this.setFuncDesc(rs.getString(COLOMN_FUNC_DESC));
		this.setUrl(rs.getString(COLOMN_URL));
	}
	
	private String parentID;
	private String funcID;
	private String url;
	private String funcName;
	private String funcDesc;
	
	public String getFuncDesc() {
		return funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}

	public String getFuncID() {
		return funcID;
	}

	public void setFuncID(String funcID) {
		this.funcID = funcID;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}