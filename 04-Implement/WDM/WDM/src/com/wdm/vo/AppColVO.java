package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.common.WDMConstants;
import com.wdm.common.locale.WDMResource;
import com.wdm.common.locale.WDMResourceConstants;
import com.wdm.form.SystemForm;

public class AppColVO {
	
	private final String COLOMN_ID = "ID";
	private final String COLOMN_APP_ID = "APP_ID";
	private final String COLOMN_COL_ID = "COL_ID";
	private final String COLOMN_COL_NAME = "COL_NAME"; 
	private final String COLOMN_STATUS = "STATUS";
	
	public AppColVO(){
		
	}
	
	public AppColVO(ResultSet rs) throws SQLException{
		this.setId(rs.getString(this.COLOMN_ID));
		this.setAppId(rs.getString(this.COLOMN_APP_ID));
		this.setColId(rs.getString(this.COLOMN_COL_ID));
		this.setColName(WDMResource.getString(rs.getString(this.COLOMN_COL_NAME)));
		this.setStatus(rs.getString(this.COLOMN_STATUS));
	}
	
	private String id;
	private String appId;
	private String colId; 
	private String status;	
	private String colName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getColId() {
		return colId;
	}

	public void setColId(String colId) {
		this.colId = colId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}
	
}
