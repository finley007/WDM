package com.wdm.dao;

import java.util.List;
import java.util.Map;

import com.wdm.form.DashBoardForm;
import com.wdm.form.RadioAdvancedForm;
import com.wdm.form.RadioBasicForm;
import com.wdm.form.SecurityForm;
import com.wdm.form.WlanForm;
import com.wdm.vo.DeviceVO;

public interface DeviceDao {
	
	public List getAllDeviceList() throws Exception;
	public List getDeviceListByCondition(DashBoardForm form) throws Exception;
	public DeviceVO getDeviceBySn(String devSn) throws Exception;
	public void deleteDeviceBySn(String devSn) throws Exception;
	public List getAllDeviceAlertList() throws Exception;
	public List getDeviceAlertListByDevice(String devSn) throws Exception;
	public List getDeviceAlertListByCondition(DashBoardForm form) throws Exception;
	public void deleteDeviceAlertBySn(String alertSn) throws Exception;
	public List getAllAPGroup() throws Exception;
	public List getAPGroupNameList() throws Exception;
	public void deleteAPGroupBySn(String sn) throws Exception;
	public String getNextAPGroupSeq() throws Exception;
	public void addAPGroup(DashBoardForm form) throws Exception;
	public void updateAPWlanGroup(String sn,String group) throws Exception;
	public List getAllWlanGroup() throws Exception;
	public List getWlanGroupNameList() throws Exception;
	public String getNextWlanGroupSeq() throws Exception;
	public void addWlanGroup(DashBoardForm form) throws Exception;
	public void deleteWlanGroupBySn(String sn) throws Exception;
	public List getAllWlanList() throws Exception;
	public String getNextWlanSeq() throws Exception;
	public void addWlan(WlanForm form) throws Exception;
	public WlanForm getWlanBySn(String sn) throws Exception;
	public void updateWlan(WlanForm form) throws Exception;
	public void deleteWlanBySn(String sn) throws Exception;
	public List getAllWlanSecurityList() throws Exception;
	public SecurityForm getSecurityBySn(String sn) throws Exception;
	public void addSecurity(SecurityForm form) throws Exception;
	public void updateSecurity(SecurityForm form) throws Exception;
	public void deleteSecurityBySn(String sn) throws Exception;
	public Map getGroupedWlan(String groupSn) throws Exception;
	public void changeGroupedWlan(String sn,String wlans) throws Exception;
	public RadioBasicForm getRadioBasicConfig() throws Exception;
	public RadioAdvancedForm getRadioAdvancedConfig() throws Exception;
	public void setRadioBasicConfig(RadioBasicForm form) throws Exception;
	public void setRadioAdvancedConfig(RadioAdvancedForm form) throws Exception;
	public void changeAPGroup(String sn,String group) throws Exception;
	public String getNextSecuritySeq() throws Exception;
}
