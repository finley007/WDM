package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.form.SystemForm;

public class SoftUpdateParamsVO {
	
	private final String COLOMN_FILE_TYPE = "FILETYPE";
	private final String COLOMN_TRANS_PROTOCAL = "TRANSPROTOCOL";
	private final String COLOMN_SERVER_ADDRESS = "SERVERADDR"; 
	private final String COLOMN_SERVER_PORT = "SERVERPORT";
	private final String COLOMN_SERVER_USERNAME = "SERVERUSERNAME";
	private final String COLOMN_SERVER_PASSWORD = "SERVERPASSWD";
	
	public SoftUpdateParamsVO(){
		
	}
	
	public SoftUpdateParamsVO(ResultSet rs) throws SQLException{
		this.setFileType(rs.getString(this.COLOMN_FILE_TYPE));
		this.setTransProtocal(rs.getString(this.COLOMN_TRANS_PROTOCAL));
		this.setServerAddr(rs.getString(this.COLOMN_SERVER_ADDRESS));
		this.setServerPort(rs.getString(this.COLOMN_SERVER_PORT));
		this.setServerUsername(rs.getString(this.COLOMN_SERVER_USERNAME));
		this.setServerPassword(rs.getString(this.COLOMN_SERVER_PASSWORD));
	}
	
	public SystemForm createForm(){
		SystemForm form = new SystemForm();
		form.setFileType(this.getFileType());
		form.setTransProtocal(this.getTransProtocal());
		form.setServerAddr(this.getServerAddr());
		form.setServerPort(this.getServerPort());
		form.setServerUsername(this.getServerUsername());
		form.setServerPassword(this.getServerPassword());
		return form;
	}
	
	private String fileType;
	private String transProtocal;
	private String serverAddr;
	private String serverPort;
	private String serverUsername;
	private String serverPassword;
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getTransProtocal() {
		return transProtocal;
	}
	public void setTransProtocal(String transProtocal) {
		this.transProtocal = transProtocal;
	}
	public String getServerAddr() {
		return serverAddr;
	}
	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getServerUsername() {
		return serverUsername;
	}
	public void setServerUsername(String serverUsername) {
		this.serverUsername = serverUsername;
	}
	public String getServerPassword() {
		return serverPassword;
	}
	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

}
