package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.form.SecurityForm;
import com.wdm.form.SystemForm;

public class SnmpVO {
	
	private final String COLOMN_SNMP_READ = "SNMP_READ";
	private final String COLOMN_SNMP_WRITE = "SNMP_WRITE";
	private final String COLOMN_SNMP_TRAP_IP = "SNMP_TRAP_IP";
	private final String COLOMN_SNMP_ENTERPRISENO = "SNMP_ENTERPRISENO";
	private final String COLOMN_SNMP_HEARTBEATINTERVAL = "SNMP_HEARTBEATINTERVAL";
	private final String COLOMN_SNMP_DISCOVERYINTERVAL = "SNMP_DISCOVERYINTERVAL";
	private final String COLOMN_SNMP_DEFAULTAPGROUP = "SNMP_DEFAULTAPGROUP";
	private final String COLOMN_SNMP_DEFAULTREFRESHTIME = "SNMP_DEFAULTREFRESHTIME";
	private final String COLOMN_SNMP_USBKEY = "SNMP_USBKEY";
	private final String COLOMN_SNMP_USBKEYFLAG = "SNMP_USBKEYFLAG";

	public SnmpVO(){
	}

	public SnmpVO(ResultSet rs) throws SQLException{
		this.setSnmpRead(rs.getString(this.COLOMN_SNMP_READ));
		this.setSnmpWrite(rs.getString(this.COLOMN_SNMP_WRITE));
		this.setSnmpTrapIP(rs.getString(this.COLOMN_SNMP_TRAP_IP));
		this.setSnmpEnterpriseNo(rs.getString(this.COLOMN_SNMP_ENTERPRISENO));
		this.setSnmpHeartBeatInterval(rs.getString(this.COLOMN_SNMP_HEARTBEATINTERVAL));
		this.setSnmpDiscoveryInterval(rs.getString(this.COLOMN_SNMP_DISCOVERYINTERVAL));
		this.setSnmpDefaultApGroup(rs.getString(this.COLOMN_SNMP_DEFAULTAPGROUP));
		this.setSnmpDefaultRefreshTime(rs.getString(this.COLOMN_SNMP_DEFAULTREFRESHTIME));
		this.setSnmpUsbKey(rs.getString(this.COLOMN_SNMP_USBKEY));
		this.setSnmpUsbKeyFlag(rs.getString(this.COLOMN_SNMP_USBKEYFLAG));
	}
	
	public SystemForm createForm(){
		SystemForm form = new SystemForm();
		form.setHeartBeatInterval(this.getSnmpHeartBeatInterval());
		form.setDiscoveryInterval(this.getSnmpDiscoveryInterval());
		form.setDefaultApGroup(this.getSnmpDefaultApGroup());
		form.setDefaultRefreshTime(this.getSnmpDefaultRefreshTime());
		return form;
	}
	
	private String snmpRead;
	private String snmpWrite;
	private String snmpTrapIP;
	private String snmpEnterpriseNo;
	private String snmpHeartBeatInterval;
	private String snmpDiscoveryInterval;
	private String snmpDefaultApGroup;
	private String snmpDefaultRefreshTime;
	private String snmpUsbKey;
	private String snmpUsbKeyFlag;

	public String getSnmpRead() {
		return snmpRead;
	}
	public void setSnmpRead(String snmpRead) {
		this.snmpRead = snmpRead;
	}
	public String getSnmpWrite() {
		return snmpWrite;
	}
	public void setSnmpWrite(String snmpWrite) {
		this.snmpWrite = snmpWrite;
	}
	public String getSnmpTrapIP() {
		return snmpTrapIP;
	}
	public void setSnmpTrapIP(String snmpTrapIP) {
		this.snmpTrapIP = snmpTrapIP;
	}
	public String getSnmpEnterpriseNo() {
		return snmpEnterpriseNo;
	}
	public void setSnmpEnterpriseNo(String snmpEnterpriseNo) {
		this.snmpEnterpriseNo = snmpEnterpriseNo;
	}
	public String getSnmpHeartBeatInterval() {
		return snmpHeartBeatInterval;
	}
	public void setSnmpHeartBeatInterval(String snmpHeartBeatInterval) {
		this.snmpHeartBeatInterval = snmpHeartBeatInterval;
	}
	public String getSnmpDiscoveryInterval() {
		return snmpDiscoveryInterval;
	}
	public void setSnmpDiscoveryInterval(String snmpDiscoveryInterval) {
		this.snmpDiscoveryInterval = snmpDiscoveryInterval;
	}
	public String getSnmpDefaultApGroup() {
		return snmpDefaultApGroup;
	}
	public void setSnmpDefaultApGroup(String snmpDefaultApGroup) {
		this.snmpDefaultApGroup = snmpDefaultApGroup;
	}
	public String getSnmpDefaultRefreshTime() {
		return snmpDefaultRefreshTime;
	}
	public void setSnmpDefaultRefreshTime(String snmpDefaultRefreshTime) {
		this.snmpDefaultRefreshTime = snmpDefaultRefreshTime;
	}
	public String getSnmpUsbKey() {
		return snmpUsbKey;
	}
	public void setSnmpUsbKey(String snmpUsbKey) {
		this.snmpUsbKey = snmpUsbKey;
	}
	public String getSnmpUsbKeyFlag() {
		return snmpUsbKeyFlag;
	}
	public void setSnmpUsbKeyFlag(String snmpUsbKeyFlag) {
		this.snmpUsbKeyFlag = snmpUsbKeyFlag;
	}

}
