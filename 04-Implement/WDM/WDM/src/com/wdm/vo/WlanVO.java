package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.form.WlanForm;

public class WlanVO {
	
	private final String COLOMN_WLAN_SN = "WLAN_SN";
	private final String COLOMN_WLAN_WLANNAME = "WLAN_WLANNAME";
	private final String COLOMN_WLAN_SECURITYMODE = "WLAN_SECURITYMODE";
	private final String COLOMN_WLAN_SECURITYPOLICY = "WLAN_SECURITYPOLICY";
	private final String COLOMN_WLAN_SSID = "WLAN_SSID";
	private final String COLOMN_WLAN_BROADCASTSSID = "WLAN_BROADCASTSSID";
	private final String COLOMN_WLAN_VLANID = "WLAN_VLANID";
	private final String COLOMN_WLAN_QOS = "WLAN_QOS";
	private final String COLOMN_WLAN_MAXUSER = "WLAN_MAXUSER";
	private final String COLOMN_WLAN_MACFILTER = "WLAN_MACFILTER";
	private final String COLOMN_WLAN_FLOWCONTROLMODE = "WLAN_FLOWCONTROLMODE";
	private final String COLOMN_WLAN_DOWNSSIDFLOW = "WLAN_DOWNSSIDFLOW";
	private final String COLOMN_WLAN_DOWNUSERFLOW = "WLAN_DOWNUSERFLOW";
	private final String COLOMN_WLAN_UPSSIDFLOW = "WLAN_UPSSIDFLOW";
	private final String COLOMN_WLAN_UPUSERFLOW = "WLAN_UPUSERFLOW";

	public WlanVO(){
		
	}
	
	public WlanVO(ResultSet rs) throws SQLException{
		this.setWlanSn(rs.getString(this.COLOMN_WLAN_SN));
		this.setWlanWlanname(rs.getString(this.COLOMN_WLAN_WLANNAME));
		this.setWlanSecuritymode(rs.getString(this.COLOMN_WLAN_SECURITYMODE));
		this.setWlanSecuritypolicy(rs.getString(this.COLOMN_WLAN_SECURITYPOLICY));
		this.setWlanSsid(rs.getString(this.COLOMN_WLAN_SSID));
		this.setWlanBroadcastssid(rs.getString(this.COLOMN_WLAN_BROADCASTSSID));
		this.setWlanVlanid(rs.getString(this.COLOMN_WLAN_VLANID));
		this.setWlanQos(rs.getString(this.COLOMN_WLAN_QOS));
		this.setWlanMaxuser(rs.getString(this.COLOMN_WLAN_MAXUSER));
		this.setWlanMacfilter(rs.getString(this.COLOMN_WLAN_MACFILTER));
		this.setWlanFlowcontrolmode(rs.getString(this.COLOMN_WLAN_FLOWCONTROLMODE));
		this.setWlanDownssidflow(rs.getString(this.COLOMN_WLAN_DOWNSSIDFLOW));
		this.setWlanDownuserflow(rs.getString(this.COLOMN_WLAN_DOWNUSERFLOW));
		this.setWlanUpssidflow(rs.getString(this.COLOMN_WLAN_UPSSIDFLOW));
		this.setWlanUpuserflow(rs.getString(this.COLOMN_WLAN_UPUSERFLOW));
	}
	
	public WlanForm createForm(){
		WlanForm form = new WlanForm();
		form.setSn(this.getWlanSn());
		form.setWlanName(this.getWlanWlanname());
		form.setSecurityMode(this.getWlanSecuritymode());
		form.setSecurityPolicy(this.getWlanSecuritypolicy());
		form.setSsid(this.getWlanSsid());
		form.setBroadcastSsid(this.getWlanBroadcastssid());
		form.setVlanId(this.getWlanVlanid());
		form.setQos(this.getWlanQos());
		form.setMaxUser(this.getWlanMaxuser());
		form.setMacFilter(this.getWlanMacfilter());
		form.setFlowControlMode(this.getWlanFlowcontrolmode());
		form.setDownSsidFlow(this.getWlanDownssidflow());
		form.setDownUserFlow(this.getWlanDownuserflow());
		form.setUpSsidFlow(this.getWlanUpssidflow());
		form.setUpUserFlow(this.getWlanUpuserflow());
		return form;
	}
	
	private String wlanSn;
	private String wlanWlanname;
	private String wlanSecuritymode;
	private String wlanSecuritypolicy;
	private String wlanSsid;
	private String wlanBroadcastssid;
	private String wlanVlanid;
	private String wlanQos;
	private String wlanMaxuser;
	private String wlanMacfilter;
	private String wlanFlowcontrolmode;
	private String wlanDownssidflow;
	private String wlanDownuserflow;
	private String wlanUpssidflow;
	private String wlanUpuserflow;

	public String getWlanSn() {
		return wlanSn;
	}
	public void setWlanSn(String wlanSn) {
		this.wlanSn = wlanSn;
	}
	public String getWlanWlanname() {
		return wlanWlanname;
	}
	public void setWlanWlanname(String wlanWlanname) {
		this.wlanWlanname = wlanWlanname;
	}
	public String getWlanSecuritymode() {
		return wlanSecuritymode;
	}
	public void setWlanSecuritymode(String wlanSecuritymode) {
		this.wlanSecuritymode = wlanSecuritymode;
	}
	public String getWlanSecuritypolicy() {
		return wlanSecuritypolicy;
	}
	public void setWlanSecuritypolicy(String wlanSecuritypolicy) {
		this.wlanSecuritypolicy = wlanSecuritypolicy;
	}
	public String getWlanSsid() {
		return wlanSsid;
	}
	public void setWlanSsid(String wlanSsid) {
		this.wlanSsid = wlanSsid;
	}
	public String getWlanBroadcastssid() {
		return wlanBroadcastssid;
	}
	public void setWlanBroadcastssid(String wlanBroadcastssid) {
		this.wlanBroadcastssid = wlanBroadcastssid;
	}
	public String getWlanVlanid() {
		return wlanVlanid;
	}
	public void setWlanVlanid(String wlanVlanid) {
		this.wlanVlanid = wlanVlanid;
	}
	public String getWlanQos() {
		return wlanQos;
	}
	public void setWlanQos(String wlanQos) {
		this.wlanQos = wlanQos;
	}
	public String getWlanMaxuser() {
		return wlanMaxuser;
	}
	public void setWlanMaxuser(String wlanMaxuser) {
		this.wlanMaxuser = wlanMaxuser;
	}
	public String getWlanMacfilter() {
		return wlanMacfilter;
	}
	public void setWlanMacfilter(String wlanMacfilter) {
		this.wlanMacfilter = wlanMacfilter;
	}
	public String getWlanFlowcontrolmode() {
		return wlanFlowcontrolmode;
	}
	public void setWlanFlowcontrolmode(String wlanFlowcontrolmode) {
		this.wlanFlowcontrolmode = wlanFlowcontrolmode;
	}
	public String getWlanDownssidflow() {
		return wlanDownssidflow;
	}
	public void setWlanDownssidflow(String wlanDownssidflow) {
		this.wlanDownssidflow = wlanDownssidflow;
	}
	public String getWlanDownuserflow() {
		return wlanDownuserflow;
	}
	public void setWlanDownuserflow(String wlanDownuserflow) {
		this.wlanDownuserflow = wlanDownuserflow;
	}
	public String getWlanUpssidflow() {
		return wlanUpssidflow;
	}
	public void setWlanUpssidflow(String wlanUpssidflow) {
		this.wlanUpssidflow = wlanUpssidflow;
	}
	public String getWlanUpuserflow() {
		return wlanUpuserflow;
	}
	public void setWlanUpuserflow(String wlanUpuserflow) {
		this.wlanUpuserflow = wlanUpuserflow;
	}

}
