package com.wdm.form;

public class WlanForm extends BaseForm {
	
	private String sn;
	private String wlanName;
	private String securityMode;
	private String securityPolicy;
	private String ssid;
	private String broadcastSsid;
	private String vlanId;
	private String qos;
	private String maxUser;
	private String macFilter;
	private String flowControlMode;
	private String downSsidFlow;
	private String downUserFlow;
	private String upSsidFlow;
	private String upUserFlow;
	
	private String action;
	
	public WlanForm(){
		this.sn = "";
		this.wlanName = "";
		this.securityMode = "";
		this.securityPolicy = "";
		this.ssid = "";
		this.broadcastSsid = "";
		this.vlanId = "";
		this.qos = "channel1";
		this.maxUser = "";
		this.macFilter = "1";
		this.flowControlMode = "";
		this.downSsidFlow = "";
		this.downUserFlow = "";
		this.upSsidFlow = "";
		this.upUserFlow = "";
	}
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getWlanName() {
		return wlanName;
	}
	public void setWlanName(String wlanName) {
		this.wlanName = wlanName;
	}
	public String getSecurityMode() {
		return securityMode;
	}
	public void setSecurityMode(String securityMode) {
		this.securityMode = securityMode;
	}
	public String getSecurityPolicy() {
		return securityPolicy;
	}
	public void setSecurityPolicy(String securityPolicy) {
		this.securityPolicy = securityPolicy;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getBroadcastSsid() {
		return broadcastSsid;
	}
	public void setBroadcastSsid(String broadcastSsid) {
		this.broadcastSsid = broadcastSsid;
	}
	public String getVlanId() {
		return vlanId;
	}
	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}
	public String getQos() {
		return qos;
	}
	public void setQos(String qos) {
		this.qos = qos;
	}
	public String getMaxUser() {
		return maxUser;
	}
	public void setMaxUser(String maxUser) {
		this.maxUser = maxUser;
	}
	public String getMacFilter() {
		return macFilter;
	}
	public void setMacFilter(String macFilter) {
		this.macFilter = macFilter;
	}
	public String getFlowControlMode() {
		return flowControlMode;
	}
	public void setFlowControlMode(String flowControlMode) {
		this.flowControlMode = flowControlMode;
	}
	public String getDownSsidFlow() {
		return downSsidFlow;
	}
	public void setDownSsidFlow(String downSsidFlow) {
		this.downSsidFlow = downSsidFlow;
	}
	public String getDownUserFlow() {
		return downUserFlow;
	}
	public void setDownUserFlow(String downUserFlow) {
		this.downUserFlow = downUserFlow;
	}
	public String getUpSsidFlow() {
		return upSsidFlow;
	}
	public void setUpSsidFlow(String upSsidFlow) {
		this.upSsidFlow = upSsidFlow;
	}
	public String getUpUserFlow() {
		return upUserFlow;
	}
	public void setUpUserFlow(String upUserFlow) {
		this.upUserFlow = upUserFlow;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
