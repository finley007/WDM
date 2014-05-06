package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.form.RadioBasicForm;

public class RadioBasicVO {
	
	private final String COLOMN_RADIO_SN = "RADIO_SN";
	private final String COLOMN_RADIO_SW = "RADIO_SW";
	private final String COLOMN_RADIO_POWERMODE = "RADIO_POWERMODE";
	private final String COLOMN_RADIO_POWER_AUTO = "RADIO_POWER_AUTO";
	private final String COLOMN_RADIO_POWER_PER = "RADIO_POWER_PER";
	private final String COLOMN_RADIO_MODE = "RADIO_MODE";
	private final String COLOMN_RADIO_RATE = "RADIO_RATE";
	private final String COLOMN_RADIO_11NRATE = "RADIO_11NRATE";
	private final String COLOMN_RADIO_RXTXFLOW = "RADIO_RXTXFLOW";
	private final String COLOMN_RADIO_BW = "RADIO_BW";
	private final String COLOMN_RADIO_SHORTGI = "RADIO_SHORTGI";
	private final String COLOMN_RADIO_AMPDU = "RADIO_AMPDU";
	private final String COLOMN_RADIO_AMSDU = "RADIO_AMSDU";
	private final String COLOMN_RADIO_11NWORKMODE = "RADIO_11NWORKMODE";
	private final String COLOMN_RADIO_CHANNELAUTOADJUST = "RADIO_CHANNELAUTOADJUST";
	private final String COLOMN_RADIO_CHANNELADJUSTMODE = "RADIO_CHANNELADJUSTMODE";
	private final String COLOMN_RADIO_CHANNELADJUSTINTERVAL = "RADIO_CHANNELADJUSTINTERVAL";
	private final String COLOMN_RADIO_CHANNELADJUSTMIXSIGNAL = "RADIO_CHANNELADJUSTMIXSIGNAL";
	
	public RadioBasicVO(){
	}
	
	public RadioBasicVO(ResultSet rs) throws SQLException{
		this.setRadioSN(rs.getString(this.COLOMN_RADIO_SN));
		this.setRadioSw(rs.getString(this.COLOMN_RADIO_SW));
		this.setRadioPowerMode(rs.getString(this.COLOMN_RADIO_POWERMODE));
		this.setRadioPowerAuto(rs.getString(this.COLOMN_RADIO_POWER_AUTO));
		this.setRadioPowerPer(rs.getString(this.COLOMN_RADIO_POWER_PER));
		this.setRadioMode(rs.getString(this.COLOMN_RADIO_MODE));
		this.setRadioRate(rs.getString(this.COLOMN_RADIO_RATE));
		this.setRadio11nRate(rs.getString(this.COLOMN_RADIO_11NRATE));
		this.setRadioRxTxFlow(rs.getString(this.COLOMN_RADIO_RXTXFLOW));
		this.setRadioBw(rs.getString(this.COLOMN_RADIO_BW));
		this.setRadioShortGI(rs.getString(this.COLOMN_RADIO_SHORTGI));
		this.setRadioAMPDU(rs.getString(this.COLOMN_RADIO_AMPDU));
		this.setRadioAMSDU(rs.getString(this.COLOMN_RADIO_AMSDU));
		this.setRadio11nWorkMode(rs.getString(this.COLOMN_RADIO_11NWORKMODE));
		this.setRadioChannelAutoAdjust(rs.getString(this.COLOMN_RADIO_CHANNELAUTOADJUST));
		this.setRadioChannelAdjustMode(rs.getString(this.COLOMN_RADIO_CHANNELADJUSTMODE));
		this.setRadioChannelAdjustInterval(rs.getString(this.COLOMN_RADIO_CHANNELADJUSTINTERVAL));
		this.setRadioChannelAdjustMixSignal(rs.getString(this.COLOMN_RADIO_CHANNELADJUSTMIXSIGNAL));
	}
	
	public RadioBasicForm createForm(){
		RadioBasicForm form = new RadioBasicForm();
		form.setSn(WDMCommonUtil.objToString(this.getRadioSN()));
		form.setSw(WDMCommonUtil.objToString(this.getRadioSw()));
		form.setPowerMode(WDMCommonUtil.objToString(this.getRadioPowerMode()));
		form.setPowerAuto(WDMCommonUtil.objToString(this.getRadioPowerAuto()));
		form.setPowerPer(WDMCommonUtil.objToString(this.getRadioPowerPer()));
		form.setMode(WDMCommonUtil.objToString(this.getRadioMode()));
		form.setRate(WDMCommonUtil.objToString(this.getRadioRate()));
		form.setRate11n(WDMCommonUtil.objToString(this.getRadio11nRate()));
		form.setRxTxFlow(WDMCommonUtil.objToString(this.getRadioRxTxFlow()));
		form.setBw(WDMCommonUtil.objToString(this.getRadioBw()));
		form.setShortGI(WDMCommonUtil.objToString(this.getRadioShortGI()));
		form.setAmpDU(WDMCommonUtil.objToString(this.getRadioAMPDU()));
		form.setAmsDU(WDMCommonUtil.objToString(this.getRadioAMSDU()));
		form.setWorkMode11n(WDMCommonUtil.objToString(this.getRadio11nWorkMode()));
		form.setChannelAutoAdjust(WDMCommonUtil.objToString(this.getRadioChannelAutoAdjust()));
		form.setChannelAdjustMode(WDMCommonUtil.objToString(this.getRadioChannelAdjustMode()));
		form.setChannelAdjustInterval(WDMCommonUtil.objToString(this.getRadioChannelAdjustInterval()));
		form.setChannelAdjustMixSignal(WDMCommonUtil.objToString(this.getRadioChannelAdjustMixSignal()));
		return form;
	}
	
	private String radioSN;
	private String radioSw;
	private String radioPowerMode;
	private String radioPowerAuto;
	private String radioPowerPer;
	private String radioMode;
	private String radioRate;
	private String radio11nRate;
	private String radioRxTxFlow;
	private String radioBw;
	private String radioShortGI;
	private String radioAMPDU;
	private String radioAMSDU;
	private String radio11nWorkMode;
	private String radioChannelAutoAdjust;
	private String radioChannelAdjustMode;
	private String radioChannelAdjustInterval;
	private String radioChannelAdjustMixSignal;
	
	public String getRadioSN() {
		return radioSN;
	}
	public void setRadioSN(String radioSN) {
		this.radioSN = radioSN;
	}
	public String getRadioSw() {
		return radioSw;
	}
	public void setRadioSw(String radioSw) {
		this.radioSw = radioSw;
	}
	public String getRadioPowerMode() {
		return radioPowerMode;
	}
	public void setRadioPowerMode(String radioPowerMode) {
		this.radioPowerMode = radioPowerMode;
	}
	public String getRadioPowerAuto() {
		return radioPowerAuto;
	}
	public void setRadioPowerAuto(String radioPower_Auto) {
		this.radioPowerAuto = radioPower_Auto;
	}
	public String getRadioPowerPer() {
		return radioPowerPer;
	}
	public void setRadioPowerPer(String radioPower_Per) {
		this.radioPowerPer = radioPower_Per;
	}
	public String getRadioMode() {
		return radioMode;
	}
	public void setRadioMode(String radioMode) {
		this.radioMode = radioMode;
	}
	public String getRadioRate() {
		return radioRate;
	}
	public void setRadioRate(String radioRate) {
		this.radioRate = radioRate;
	}
	public String getRadio11nRate() {
		return radio11nRate;
	}
	public void setRadio11nRate(String radio11nRate) {
		this.radio11nRate = radio11nRate;
	}
	public String getRadioRxTxFlow() {
		return radioRxTxFlow;
	}
	public void setRadioRxTxFlow(String radioRxTxFlow) {
		this.radioRxTxFlow = radioRxTxFlow;
	}
	public String getRadioBw() {
		return radioBw;
	}
	public void setRadioBw(String radioBw) {
		this.radioBw = radioBw;
	}
	public String getRadioShortGI() {
		return radioShortGI;
	}
	public void setRadioShortGI(String radioShortGI) {
		this.radioShortGI = radioShortGI;
	}
	public String getRadioAMPDU() {
		return radioAMPDU;
	}
	public void setRadioAMPDU(String radioAMPDU) {
		this.radioAMPDU = radioAMPDU;
	}
	public String getRadioAMSDU() {
		return radioAMSDU;
	}
	public void setRadioAMSDU(String radioAMSDU) {
		this.radioAMSDU = radioAMSDU;
	}
	public String getRadio11nWorkMode() {
		return radio11nWorkMode;
	}
	public void setRadio11nWorkMode(String radio11nWorkMode) {
		this.radio11nWorkMode = radio11nWorkMode;
	}
	public String getRadioChannelAutoAdjust() {
		return radioChannelAutoAdjust;
	}
	public void setRadioChannelAutoAdjust(String radioChannelAutoAdjust) {
		this.radioChannelAutoAdjust = radioChannelAutoAdjust;
	}
	public String getRadioChannelAdjustMode() {
		return radioChannelAdjustMode;
	}
	public void setRadioChannelAdjustMode(String radioChannelAdjustMode) {
		this.radioChannelAdjustMode = radioChannelAdjustMode;
	}
	public String getRadioChannelAdjustInterval() {
		return radioChannelAdjustInterval;
	}
	public void setRadioChannelAdjustInterval(String radioChannelAdjustInterval) {
		this.radioChannelAdjustInterval = radioChannelAdjustInterval;
	}
	public String getRadioChannelAdjustMixSignal() {
		return radioChannelAdjustMixSignal;
	}
	public void setRadioChannelAdjustMixSignal(String radioChannelAdjustMixSignal) {
		this.radioChannelAdjustMixSignal = radioChannelAdjustMixSignal;
	}




}
