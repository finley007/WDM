package com.wdm.dao;

import java.util.List;

import com.wdm.form.SystemForm;
import com.wdm.form.WlanForm;

public interface SystemDao {
	
	public List getAccountList() throws Exception;
	public SystemForm getAccountInfoById(String id) throws Exception; 
	public void saveAccount(SystemForm form) throws Exception;
	public void updateAccount(SystemForm form) throws Exception;
	public void deleteAccountById(String id) throws Exception;
	public SystemForm getSoftUpdateParams() throws Exception;
	public void saveSoftUpdateParamsConfig(SystemForm form) throws Exception;
	public SystemForm getSMNPParams() throws Exception;
	public void saveSMNPParams(SystemForm form) throws Exception;
	public List getUpdateVersions() throws Exception;
	public String getNextUpdateVersionSeq() throws Exception;
	public void addUpdateVersion(SystemForm form) throws Exception;
	public void deleteUpdateVersion(String sn) throws Exception;
}
