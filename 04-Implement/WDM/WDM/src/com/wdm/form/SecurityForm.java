package com.wdm.form;

public class SecurityForm extends BaseForm {
	
	private String sn;
	private String name;
	private String mode;
	private String authMode;
	private String keyType;
	private String keyLength;
	private String cipher;
	private String key;
	private String keyIndex;
	private String key0;
	private String key1;
	private String key2;
	private String key3;
	
	private String action;
	
	public SecurityForm(){
		this.sn = "";
		this.name = "";
		this.mode = "1";
		this.authMode = "";
		this.keyType = "";
		this.keyLength = "";
		this.cipher = "";
		this.key = "";
		this.keyIndex = "";
		this.key0 = "";
		this.key1 = "";
		this.key2 = "";
		this.key3 = "";
	}
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getAuthMode() {
		return authMode;
	}
	public void setAuthMode(String authMode) {
		this.authMode = authMode;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getKeyLength() {
		return keyLength;
	}
	public void setKeyLength(String keyLength) {
		this.keyLength = keyLength;
	}
	public String getCipher() {
		return cipher;
	}
	public void setCipher(String cipher) {
		this.cipher = cipher;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKeyIndex() {
		return keyIndex;
	}
	public void setKeyIndex(String keyIndex) {
		this.keyIndex = keyIndex;
	}
	public String getKey0() {
		return key0;
	}
	public void setKey0(String key0) {
		this.key0 = key0;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getKey3() {
		return key3;
	}
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

}
