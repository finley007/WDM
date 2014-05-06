package com.wdm.form;

import com.wdm.common.WDMConstants;

public class DashBoardForm extends BaseForm {
	
	private String isSn;
	private String sn;
	private String isMac;
	private String mac;
	private String isIp;
	private String ip;
	private String isChannel;
	private String channel;
	private String isStatus;
	private String status;
	private String isDate;
	private String startDate;
	private String endDate;
	private String startIp;
	private String endIp;
	private String apGroup;
	private String wlanGroup;
	
	public DashBoardForm(){
		this.isSn = "";
		this.sn = "";
		this.isMac = "";
		this.mac = "";
		this.isIp = "";
		this.ip = "";
		this.isChannel = "";
		this.channel = "channel1";
		this.isStatus = "";
		this.status = "1";
		this.isDate = "";
		this.startDate = "";
		this.endDate = "";
		this.startIp = "";
		this.endIp = "";
		this.apGroup = "";
	}
	
	public String getIsDate() {
		return isDate;
	}

	public void setIsDate(String isDate) {
		this.isDate = isDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getIsSn() {
		return isSn;
	}
	public void setIsSn(String isSn) {
		this.isSn = isSn;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getIsMac() {
		return isMac;
	}
	public void setIsMac(String isMac) {
		this.isMac = isMac;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIsChannel() {
		return isChannel;
	}
	public void setIsChannel(String isChannel) {
		this.isChannel = isChannel;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getIsStatus() {
		return isStatus;
	}
	public void setIsStatus(String isStatus) {
		this.isStatus = isStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsIp() {
		return isIp;
	}

	public void setIsIp(String isIp) {
		this.isIp = isIp;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public String getApGroup() {
		return apGroup;
	}

	public void setApGroup(String apGroup) {
		this.apGroup = apGroup;
	}
	
	public String getWlanGroup() {
		return wlanGroup;
	}

	public void setWlanGroup(String wlanGroup) {
		this.wlanGroup = wlanGroup;
	}
}
