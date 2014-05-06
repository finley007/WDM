package com.wdm.form;

public class SystemForm extends BaseForm {
	
	private String account;
	private String password;
	private String isSupervisor; //1-yes,0-no
	private String status;	//1-valid,0-invalid
	private String remark;
	
	private String fileName;
	private String fileType;
	private String transProtocal;
	private String serverAddr;
	private String serverPort;
	private String serverUsername;
	private String serverPassword;
	
	private String heartBeatInterval;
	private String discoveryInterval;
	private String defaultApGroup;
	private String defaultRefreshTime; 
	
	private String sn;
	private String company;
	private String devType;
	private String hardwareVersion;
	private String updateFileId;
	private String updateFileDstId;
	
	public SystemForm(){
		this.account = "";
		this.password = "";
		this.isSupervisor = "0";
		this.status = "1";
		this.remark = "";
		
		this.fileName = "";
		this.fileType = "";
		this.transProtocal = "";
		this.serverAddr = "";
		this.serverPort = "";
		this.serverUsername = "";
		this.serverPassword = "";
		
		this.heartBeatInterval = "";
		this.discoveryInterval = "";
		this.defaultApGroup = "";
		this.defaultRefreshTime = "";
		
		this.sn = "";
		this.company = "";
		this.devType = "";
		this.hardwareVersion = "";
		this.updateFileId = "";
		this.updateFileDstId = "";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public String getHeartBeatInterval() {
		return heartBeatInterval;
	}

	public void setHeartBeatInterval(String heartBeatInterval) {
		this.heartBeatInterval = heartBeatInterval;
	}

	public String getDiscoveryInterval() {
		return discoveryInterval;
	}

	public void setDiscoveryInterval(String discoveryInterval) {
		this.discoveryInterval = discoveryInterval;
	}

	public String getDefaultApGroup() {
		return defaultApGroup;
	}

	public void setDefaultApGroup(String defaultApGroup) {
		this.defaultApGroup = defaultApGroup;
	}

	public String getDefaultRefreshTime() {
		return defaultRefreshTime;
	}

	public void setDefaultRefreshTime(String defaultRefreshTime) {
		this.defaultRefreshTime = defaultRefreshTime;
	}
	
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDevType() {
		return devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	public String getUpdateFileId() {
		return updateFileId;
	}

	public void setUpdateFileId(String updateFileId) {
		this.updateFileId = updateFileId;
	}

	public String getUpdateFileDstId() {
		return updateFileDstId;
	}

	public void setUpdateFileDstId(String updateFileDstId) {
		this.updateFileDstId = updateFileDstId;
	}
}
