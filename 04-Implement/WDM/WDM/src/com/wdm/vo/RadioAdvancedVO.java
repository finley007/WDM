package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.form.RadioAdvancedForm;

public class RadioAdvancedVO {
	
	private final String COLOMN_RADIO_SN = "RADIO_SN";
	private final String COLOMN_RADIO_L2ISOLATE = "RADIO_L2ISOLATE";
	private final String COLOMN_RADIO_IGMPSNOOPING = "RADIO_IGMPSNOOPING";
	private final String COLOMN_RADIO_PREAUTH = "RADIO_PREAUTH";
	private final String COLOMN_RADIO_ROAMING = "RADIO_ROAMING";
	private final String COLOMN_RADIO_ROAMINGHEART = "RADIO_ROAMINGHEART";
	private final String COLOMN_RADIO_SSIDROAMING = "RADIO_SSIDROAMING";
	private final String COLOMN_RADIO_EAPUSEROFFLINEDELAY = "RADIO_EAPUSEROFFLINEDELAY";
	private final String COLOMN_RADIO_UPLINKCHECK = "RADIO_UPLINKCHECK";
	private final String COLOMN_RADIO_UPLINKCHECKACTION = "RADIO_UPLINKCHECKACTION";
	private final String COLOMN_RADIO_NTPSERVER = "RADIO_NTPSERVER";
	private final String COLOMN_RADIO_NTPHEART = "RADIO_NTPHEART";
	
	public RadioAdvancedVO(ResultSet rs) throws SQLException{
		this.setRadioSN(rs.getString(this.COLOMN_RADIO_SN));
		this.setRadioL2Isolate(rs.getString(this.COLOMN_RADIO_L2ISOLATE));
		this.setRadioIgmpSnooping(rs.getString(this.COLOMN_RADIO_IGMPSNOOPING));
		this.setRadioPreAuth(rs.getString(this.COLOMN_RADIO_PREAUTH));
		this.setRadioRoaming(rs.getString(this.COLOMN_RADIO_ROAMING));
		this.setRadioRoamingHeart(rs.getString(this.COLOMN_RADIO_ROAMINGHEART));
		this.setRadioSSIDRoaming(rs.getString(this.COLOMN_RADIO_SSIDROAMING));
		this.setRadioEapUserOfflineDelay(rs.getString(this.COLOMN_RADIO_EAPUSEROFFLINEDELAY));
		this.setRadioUpLinkCheck(rs.getString(this.COLOMN_RADIO_UPLINKCHECK));
		this.setRadioUpLinkCheckAction(rs.getString(this.COLOMN_RADIO_UPLINKCHECKACTION));
		this.setRadioNTPServer(rs.getString(this.COLOMN_RADIO_NTPSERVER));
		this.setRadioNTPHeart(rs.getString(this.COLOMN_RADIO_NTPHEART));
	}
	
	public RadioAdvancedForm createForm(){
		RadioAdvancedForm form = new RadioAdvancedForm();
		form.setSn(WDMCommonUtil.objToString(this.getRadioSN()));
		form.setL2isolate(WDMCommonUtil.objToString(this.getRadioL2Isolate()));
		form.setIgmpSnooping(WDMCommonUtil.objToString(this.getRadioIgmpSnooping()));
		form.setPreAuth(WDMCommonUtil.objToString(this.getRadioPreAuth()));
		form.setRoaming(WDMCommonUtil.objToString(this.getRadioRoaming()));
		form.setRoamingHeart(WDMCommonUtil.objToString(this.getRadioRoamingHeart()));
		form.setSSidRoaming(WDMCommonUtil.objToString(this.getRadioSSIDRoaming()));
		form.setEapUserOfflineDelay(WDMCommonUtil.objToString(this.getRadioEapUserOfflineDelay()));
		form.setUpLinkCheck(WDMCommonUtil.objToString(this.getRadioUpLinkCheck()));
		form.setUpLinkCheckAction(WDMCommonUtil.objToString(this.getRadioUpLinkCheckAction()));
		form.setNtpServer(WDMCommonUtil.objToString(this.getRadioNTPServer()));
		form.setNtpHeart(WDMCommonUtil.objToString(this.getRadioNTPHeart()));
		return form;
	}
	
	private String radioSN;
	private String radioL2Isolate;
	private String radioIgmpSnooping;
	private String radioPreAuth;
	private String radioRoaming;
	private String radioRoamingHeart;
	private String radioSSIDRoaming;
	private String radioEapUserOfflineDelay;
	private String radioUpLinkCheck;
	private String radioUpLinkCheckAction;
	private String radioNTPServer;
	private String radioNTPHeart;
	
	public String getRadioSN() {
		return radioSN;
	}
	public void setRadioSN(String radioSN) {
		this.radioSN = radioSN;
	}
	public String getRadioL2Isolate() {
		return radioL2Isolate;
	}
	public void setRadioL2Isolate(String radioL2Isolate) {
		this.radioL2Isolate = radioL2Isolate;
	}
	public String getRadioIgmpSnooping() {
		return radioIgmpSnooping;
	}
	public void setRadioIgmpSnooping(String radioIgmpSnooping) {
		this.radioIgmpSnooping = radioIgmpSnooping;
	}
	public String getRadioPreAuth() {
		return radioPreAuth;
	}
	public void setRadioPreAuth(String radioPreAuth) {
		this.radioPreAuth = radioPreAuth;
	}
	public String getRadioRoaming() {
		return radioRoaming;
	}
	public void setRadioRoaming(String radioRoaming) {
		this.radioRoaming = radioRoaming;
	}
	public String getRadioRoamingHeart() {
		return radioRoamingHeart;
	}
	public void setRadioRoamingHeart(String radioRoamingHeart) {
		this.radioRoamingHeart = radioRoamingHeart;
	}
	public String getRadioSSIDRoaming() {
		return radioSSIDRoaming;
	}
	public void setRadioSSIDRoaming(String radioSSIDRoaming) {
		this.radioSSIDRoaming = radioSSIDRoaming;
	}
	public String getRadioEapUserOfflineDelay() {
		return radioEapUserOfflineDelay;
	}
	public void setRadioEapUserOfflineDelay(String radioEapUserOfflineDelay) {
		this.radioEapUserOfflineDelay = radioEapUserOfflineDelay;
	}
	public String getRadioUpLinkCheck() {
		return radioUpLinkCheck;
	}
	public void setRadioUpLinkCheck(String radioUpLinkCheck) {
		this.radioUpLinkCheck = radioUpLinkCheck;
	}
	public String getRadioUpLinkCheckAction() {
		return radioUpLinkCheckAction;
	}
	public void setRadioUpLinkCheckAction(String radioUpLinkCheckAction) {
		this.radioUpLinkCheckAction = radioUpLinkCheckAction;
	}
	public String getRadioNTPServer() {
		return radioNTPServer;
	}
	public void setRadioNTPServer(String radioNTPServer) {
		this.radioNTPServer = radioNTPServer;
	}
	public String getRadioNTPHeart() {
		return radioNTPHeart;
	}
	public void setRadioNTPHeart(String radioNTPHeart) {
		this.radioNTPHeart = radioNTPHeart;
	}



}
