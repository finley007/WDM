package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.form.SecurityForm;
import com.wdm.form.WlanForm;

public class SecurityVO {
	
	private final String COLOMN_SECURITY_SN = "SECURITY_SN";
	private final String COLOMN_SECURITY_NAME = "SECURITY_NAME";
	private final String COLOMN_SECURITY_MODE = "SECURITY_MODE";
	private final String COLOMN_SECURITY_AUTHMODE = "SECURITY_AUTHMODE";
	private final String COLOMN_SECURITY_KEYTYPE = "SECURITY_KEYTYPE";
	private final String COLOMN_SECURITY_KEYLENGTH = "SECURITY_KEYLENGTH";
	private final String COLOMN_SECURITY_CIPHER = "SECURITY_CIPHER";
	private final String COLOMN_SECURITY_KEY = "SECURITY_KEY";
	private final String COLOMN_SECURITY_KEYINDEX = "SECURITY_KEYINDEX";
	private final String COLOMN_SECURITY_KEY0 = "SECURITY_KEY0";
	private final String COLOMN_SECURITY_KEY1 = "SECURITY_KEY1";
	private final String COLOMN_SECURITY_KEY2 = "SECURITY_KEY2";
	private final String COLOMN_SECURITY_KEY3 = "SECURITY_KEY3";
	
	public SecurityVO(){
	}
	
	public SecurityVO(ResultSet rs) throws SQLException{
		this.setSecuritySN(rs.getString(this.COLOMN_SECURITY_SN));
		this.setSecurityName(rs.getString(this.COLOMN_SECURITY_NAME));
		this.setSecurityMode(rs.getString(this.COLOMN_SECURITY_MODE));
		this.setSecurityAuthMode(rs.getString(this.COLOMN_SECURITY_AUTHMODE));
		this.setSecurityKeyType(rs.getString(this.COLOMN_SECURITY_KEYTYPE));
		this.setSecurityKeyLength(rs.getString(this.COLOMN_SECURITY_KEYLENGTH));
		this.setSecurityCipher(rs.getString(this.COLOMN_SECURITY_CIPHER));
		this.setSecurityKey(rs.getString(this.COLOMN_SECURITY_KEY));
		this.setSecurityKeyIndex(rs.getString(this.COLOMN_SECURITY_KEYINDEX));
		this.setSecurityKey0(rs.getString(this.COLOMN_SECURITY_KEY0));
		this.setSecurityKey1(rs.getString(this.COLOMN_SECURITY_KEY1));
		this.setSecurityKey2(rs.getString(this.COLOMN_SECURITY_KEY2));
		this.setSecurityKey3(rs.getString(this.COLOMN_SECURITY_KEY3));
	}
	
	public SecurityForm createForm(){
		SecurityForm form = new SecurityForm();
		form.setSn(this.getSecuritySN());
		form.setName(this.getSecurityName());
		form.setMode(this.getSecurityMode());
		form.setAuthMode(this.getSecurityAuthMode());
		form.setKeyType(this.getSecurityKeyType());
		form.setKeyLength(this.getSecurityKeyLength());
		form.setCipher(this.getSecurityCipher());
		form.setKey(this.getSecurityKey());
		form.setKeyIndex(this.getSecurityKeyIndex());
		form.setKey0(this.getSecurityKey0());
		form.setKey1(this.getSecurityKey1());
		form.setKey2(this.getSecurityKey2());
		form.setKey3(this.getSecurityKey3());
		return form;
	}
	
	private String securitySN;
	private String securityName;
	private String securityMode;
	private String securityAuthMode;
	private String securityKeyType;
	private String securityKeyLength;
	private String securityCipher;
	private String securityKey;
	private String securityKeyIndex;
	private String securityKey0;
	private String securityKey1;
	private String securityKey2;
	private String securityKey3;

	public String getSecuritySN() {
		return securitySN;
	}
	public void setSecuritySN(String securitySN) {
		this.securitySN = securitySN;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getSecurityMode() {
		return securityMode;
	}
	public void setSecurityMode(String securityMode) {
		this.securityMode = securityMode;
	}
	public String getSecurityAuthMode() {
		return securityAuthMode;
	}
	public void setSecurityAuthMode(String securityAuthMode) {
		this.securityAuthMode = securityAuthMode;
	}
	public String getSecurityKeyType() {
		return securityKeyType;
	}
	public void setSecurityKeyType(String securityKeyType) {
		this.securityKeyType = securityKeyType;
	}
	public String getSecurityKeyLength() {
		return securityKeyLength;
	}
	public void setSecurityKeyLength(String securityKeyLength) {
		this.securityKeyLength = securityKeyLength;
	}
	public String getSecurityCipher() {
		return securityCipher;
	}
	public void setSecurityCipher(String securityCipher) {
		this.securityCipher = securityCipher;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	public String getSecurityKeyIndex() {
		return securityKeyIndex;
	}
	public void setSecurityKeyIndex(String securityKeyIndex) {
		this.securityKeyIndex = securityKeyIndex;
	}
	public String getSecurityKey0() {
		return securityKey0;
	}
	public void setSecurityKey0(String securityKey0) {
		this.securityKey0 = securityKey0;
	}
	public String getSecurityKey1() {
		return securityKey1;
	}
	public void setSecurityKey1(String securityKey1) {
		this.securityKey1 = securityKey1;
	}
	public String getSecurityKey2() {
		return securityKey2;
	}
	public void setSecurityKey2(String securityKey2) {
		this.securityKey2 = securityKey2;
	}
	public String getSecurityKey3() {
		return securityKey3;
	}
	public void setSecurityKey3(String securityKey3) {
		this.securityKey3 = securityKey3;
	}

}
