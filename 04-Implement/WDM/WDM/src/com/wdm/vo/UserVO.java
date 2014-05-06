package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.common.WDMConstants;
import com.wdm.common.locale.WDMResourceConstants;
import com.wdm.form.SystemForm;

public class UserVO {
	
	private final String COLOMN_USER_ACCOUNT = "ACCOUNT";
	private final String COLOMN_USER_PASSWORD = "PASSWORD";
	private final String COLOMN_USER_IS_SUPERVISOR = "IS_SUPERVISOR";
	private final String COLOMN_USER_STATUS = "STATUS"; 
	private final String COLOMN_USER_REMARK = "REMARK";
	private final String COLOMN_USER_CREATE_TIME = "CREATE_TIME"; 
	private final String COLOMN_USER_UPDATE_TIME = "UPDATE_TIME";
	
	public UserVO(){
		
	}
	
	public UserVO(ResultSet rs) throws SQLException{
		this.setAccount(rs.getString(this.COLOMN_USER_ACCOUNT));
		this.setPassword(rs.getString(this.COLOMN_USER_PASSWORD));
		this.setIsSupervisor(rs.getString(this.COLOMN_USER_IS_SUPERVISOR));
		this.setStatus(rs.getString(this.COLOMN_USER_STATUS));
		this.setRemark(rs.getString(this.COLOMN_USER_REMARK));
		this.setCreateTime(rs.getString(this.COLOMN_USER_CREATE_TIME));
		this.setUpdateTime(rs.getString(this.COLOMN_USER_UPDATE_TIME));
		if(WDMConstants.ACCOUNT_STATUS_VALID.equals(this.status))
			this.statusLabel = WDMResourceConstants.ACCOUNT_STATUS_VALID;
		else
			this.statusLabel = WDMResourceConstants.ACCOUNT_STATUS_INVALID;
		if(WDMConstants.ACCOUNT_IS_SUPERVISOR_TRUE.equals(this.isSupervisor))
			this.isSupervisorLabel = WDMResourceConstants.COMMON_YES;
		else
			this.isSupervisorLabel = WDMResourceConstants.COMMON_NO;
	}
	
	public SystemForm createForm(){
		SystemForm form = new SystemForm();
		form.setAccount(this.getAccount());
		form.setPassword(this.getPassword());
		form.setIsSupervisor(this.getIsSupervisor());
		form.setStatus(this.getStatus());
		form.setRemark(this.getRemark());
		return form;
	}
	
	private String account;
	private String password;
	private String isSupervisor; 
	private String status;	
	private String remark;
	private String createTime;
	private String updateTime;
	private String isSupervisorLabel;
	private String statusLabel;
	
	public String getIsSupervisorLabel() {
		return isSupervisorLabel;
	}

	public void setIsSupervisorLabel(String isSupervisorLabel) {
		this.isSupervisorLabel = isSupervisorLabel;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsSupervisor() {
		return isSupervisor;
	}
	public void setIsSupervisor(String isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
