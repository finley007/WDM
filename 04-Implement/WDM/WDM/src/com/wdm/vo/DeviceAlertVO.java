package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceAlertVO {
	
	private final String COLOMN_DEV_TRAP_SN = "DEV_TRAP_SN";
	private final String COLOMN_DEV_TRAP_LOG_TIME = "DEV_TRAP_LOG_TIME";
	private final String COLOMN_DEV_TRAP_MAC_ADDR = "DEV_TRAP_MAC_ADDR";
	private final String COLOMN_DEV_TRAP_IP_ADDR = "DEV_TRAP_IP_ADDR"; 
	private final String COLOMN_DEV_TRAP_MSG_TYPE = "DEV_TRAP_MSG_TYPE";
	private final String COLOMN_DEV_TRAP_MSG = "DEV_TRAP_MSG";
	private final String COLOMN_DEV_TRAP_OID = "DEV_TRAP_OID";
	private final String COLOMN_DEV_TRAP_LOG_UPDATETIME = "DEV_TRAP_LOG_UPDATETIME";
	
	
	private String devTrapSn;
	private String devTrapLogTime;
	private String devTrapMacAddr;
	private String devTrapIPAddr;
	private String devTrapMsgType;
	private String devTrapMsg;
	private String devTrapOID;
	private String devTrapLogUpdateTime;
	
	public DeviceAlertVO(){
		
	}
	
	public DeviceAlertVO(ResultSet rs) throws SQLException{
		this.setDevTrapIPAddr(rs.getString(this.COLOMN_DEV_TRAP_IP_ADDR));
		this.setDevTrapLogTime(rs.getString(this.COLOMN_DEV_TRAP_LOG_TIME));
		this.setDevTrapLogUpdateTime(rs.getString(this.COLOMN_DEV_TRAP_LOG_UPDATETIME));
		this.setDevTrapMacAddr(rs.getString(this.COLOMN_DEV_TRAP_MAC_ADDR));
		this.setDevTrapMsg(rs.getString(this.COLOMN_DEV_TRAP_MSG));
		this.setDevTrapMsgType(rs.getString(this.COLOMN_DEV_TRAP_MSG_TYPE));
		this.setDevTrapOID(rs.getString(this.COLOMN_DEV_TRAP_OID));
		this.setDevTrapSn(rs.getString(this.COLOMN_DEV_TRAP_SN));
	}
	
	public String getDevTrapSn() {
		return devTrapSn;
	}
	public void setDevTrapSn(String devTrapSn) {
		this.devTrapSn = devTrapSn;
	}
	public String getDevTrapLogTime() {
		return devTrapLogTime;
	}
	public void setDevTrapLogTime(String devTrapLogTime) {
		this.devTrapLogTime = devTrapLogTime;
	}
	public String getDevTrapMacAddr() {
		return devTrapMacAddr;
	}
	public void setDevTrapMacAddr(String devTrapMacAddr) {
		this.devTrapMacAddr = devTrapMacAddr;
	}
	public String getDevTrapIPAddr() {
		return devTrapIPAddr;
	}
	public void setDevTrapIPAddr(String devTrapIPAddr) {
		this.devTrapIPAddr = devTrapIPAddr;
	}
	public String getDevTrapMsgType() {
		return devTrapMsgType;
	}
	public void setDevTrapMsgType(String devTrapMsgType) {
		this.devTrapMsgType = devTrapMsgType;
	}
	public String getDevTrapMsg() {
		return devTrapMsg;
	}
	public void setDevTrapMsg(String devTrapMsg) {
		this.devTrapMsg = devTrapMsg;
	}
	public String getDevTrapOID() {
		return devTrapOID;
	}
	public void setDevTrapOID(String devTrapOID) {
		this.devTrapOID = devTrapOID;
	}
	public String getDevTrapLogUpdateTime() {
		return devTrapLogUpdateTime;
	}
	public void setDevTrapLogUpdateTime(String devTrapLogUpdateTime) {
		this.devTrapLogUpdateTime = devTrapLogUpdateTime;
	}
	public String getCOLOMN_DEV_TRAP_SN() {
		return COLOMN_DEV_TRAP_SN;
	}
	public String getCOLOMN_DEV_TRAP_LOG_TIME() {
		return COLOMN_DEV_TRAP_LOG_TIME;
	}
	public String getCOLOMN_DEV_TRAP_MAC_ADDR() {
		return COLOMN_DEV_TRAP_MAC_ADDR;
	}
	public String getCOLOMN_DEV_TRAP_IP_ADDR() {
		return COLOMN_DEV_TRAP_IP_ADDR;
	}
	public String getCOLOMN_DEV_TRAP_MSG_TYPE() {
		return COLOMN_DEV_TRAP_MSG_TYPE;
	}
	public String getCOLOMN_DEV_TRAP_MSG() {
		return COLOMN_DEV_TRAP_MSG;
	}
	public String getCOLOMN_DEV_TRAP_OID() {
		return COLOMN_DEV_TRAP_OID;
	}
	public String getCOLOMN_DEV_TRAP_LOG_UPDATETIME() {
		return COLOMN_DEV_TRAP_LOG_UPDATETIME;
	}



}
