package com.wdm.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceVO {
	
	private final String COLOMN_DEV_SN = "DEV_SN";
	private final String COLOMN_DEV_GROUP = "DEV_GROUP";
	private final String COLOMN_DEV_NAME = "DEV_NAME";
	private final String COLOMN_DEV_TRAP_IPADDRESS = "DEV_TRAP_IPADDRESS";
	private final String COLOMN_DEV_IPASSIGN = "DEV_IPASSIGN";
	private final String COLOMN_DEV_IPADDRESS = "DEV_IPADDRESS";
	private final String COLOMN_DEV_SUBNET = "DEV_SUBNET";
	private final String COLOMN_DEV_GATEWAY = "DEV_GATEWAY";
	private final String COLOMN_DEV_DNS1 = "DEV_DNS1";
	private final String COLOMN_DEV_DNS2 = "DEV_DNS2";
	private final String COLOMN_DEV_MAC = "DEV_MAC";
	private final String COLOMN_DEV_ONLINETIME = "DEV_ONLINETIME";
	private final String COLOMN_DEV_ONLINE_STATUS = "DEV_ONLINE_STATUS";
	private final String COLOMN_DEV_STATUS_UPDATE_TIME = "DEV_STATUS_UPDATE_TIME";
	private final String COLOMN_DEV_SWNAME = "DEV_SWNAME";
	private final String COLOMN_DEV_SWVER = "DEV_SWVER";
	private final String COLOMN_DEV_MANUFACTURE = "DEV_MANUFACTURE";
	private final String COLOMN_DEV_MODEL_NAME = "DEV_MODEL_NAME";
	private final String COLOMN_DEV_UPDATEID = "DEV_UPDATEID";
	private final String COLOMN_DEV_MAX_POWER = "DEV_MAX_POWER";
	private final String COLOMN_DEV_SW = "DEV_SW";
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
	private final String COLOMN_RADIO_11NWORKMODE = "RADIO_11NRATE";
	private final String COLOMN_DEV_WLAN_CHANNEL = "DEV_WLAN_CHANNEL";
	private final String COLOMN_DEV_WLAN_BEACON_INERTVAL = "DEV_WLAN_BEACON_INERTVAL";
	private final String COLOMN_DEV_WLAN_RTS = "DEV_WLAN_RTS";
	private final String COLOMN_DEV_WLAN_CTS = "DEV_WLAN_CTS";
	private final String COLOMN_DEV_WLAN_STA_NUM = "DEV_WLAN_STA_NUM";
	
	
	public DeviceVO(){
		
	}
	
	public DeviceVO(ResultSet rs) throws SQLException{
		this.setDevSn(rs.getString(this.COLOMN_DEV_SN));
		this.setDevGroup(rs.getString(this.COLOMN_DEV_GROUP));
		this.setDevName(rs.getString(this.COLOMN_DEV_NAME));
		this.setDevTrapIpaddress(rs.getString(this.COLOMN_DEV_TRAP_IPADDRESS));
		this.setDevIpaddress(rs.getString(this.COLOMN_DEV_IPADDRESS));
		this.setDevIpassign(rs.getString(this.COLOMN_DEV_IPASSIGN));
		this.setDevSubnet(rs.getString(this.COLOMN_DEV_SUBNET));
		this.setDevGateway(rs.getString(this.COLOMN_DEV_GATEWAY));
		this.setDevDns1(rs.getString(this.COLOMN_DEV_DNS1));
		this.setDevDns2(rs.getString(this.COLOMN_DEV_DNS2));
		this.setDevMAC(rs.getString(this.COLOMN_DEV_MAC));
		this.setDevOnlineTime(rs.getString(this.COLOMN_DEV_ONLINETIME));
		this.setDevSwName(rs.getString(this.COLOMN_DEV_SWNAME));
		this.setDevSwVer(rs.getString(this.COLOMN_DEV_SWVER));
		this.setDevManufacture(rs.getString(this.COLOMN_DEV_MANUFACTURE));
		this.setDevModelName(rs.getString(this.COLOMN_DEV_MODEL_NAME));
	}
	
	private String devSn = "";
	private String devGroup = "";
	private String devName = "";
	private String devTrapIpaddress = "";
	private String devIpassign = "";
	private String devIpaddress = "";
	private String devSubnet = "";
	private String devGateway = "";
	private String devDns1 = "";
	private String devDns2 = "";
	private String devMAC = "";
	private String devOnlineTime = "";
	private String devOnlineStatus = "";
	private String devStatusUpdateTime = "";
	private String devSwName = "";
	private String devSwVer = "";
	private String devManufacture = "";
	private String devModelName = "";
	private String devUpdateId = "";
	private String devMaxPower = "";
	private String radioSw = "";
	private String radioPowerMode = "";
	private String radioPowerAuto = "";
	private String radioPowerPer = "";
	private String radioMode = "";
	private String radioRate = "";
	private String radio11nRate = "";
	private String radioRxTxFlow = "";
	private String radioBw = "";
	private String radioShortGI = "";
	private String radioAMPDU = "";
	private String radioAMSDU = "";
	private String radio11nWorkMode = "";
	private String devWlanChannel = "";
	private String devWlanBeaconInertval = "";
	private String devWlanRts = "";
	private String devWlanCts = "";
	private String devWlanStaNum = "";


	public String getDevSn() {
		return devSn;
	}

	public void setDevSn(String devSn) {
		this.devSn = devSn;
	}

	public String getDevGroup() {
		return devGroup;
	}

	public void setDevGroup(String devGroup) {
		this.devGroup = devGroup;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevTrapIpaddress() {
		return devTrapIpaddress;
	}

	public void setDevTrapIpaddress(String devTrapIpaddress) {
		this.devTrapIpaddress = devTrapIpaddress;
	}

	public String getDevIpassign() {
		return devIpassign;
	}

	public void setDevIpassign(String devIpassign) {
		this.devIpassign = devIpassign;
	}

	public String getDevIpaddress() {
		return devIpaddress;
	}

	public void setDevIpaddress(String devIpaddress) {
		this.devIpaddress = devIpaddress;
	}

	public String getDevSubnet() {
		return devSubnet;
	}

	public void setDevSubnet(String devSubnet) {
		this.devSubnet = devSubnet;
	}

	public String getDevGateway() {
		return devGateway;
	}

	public void setDevGateway(String devGateway) {
		this.devGateway = devGateway;
	}

	public String getDevDns1() {
		return devDns1;
	}

	public void setDevDns1(String devDns1) {
		this.devDns1 = devDns1;
	}

	public String getDevDns2() {
		return devDns2;
	}

	public void setDevDns2(String devDns2) {
		this.devDns2 = devDns2;
	}

	public String getDevMAC() {
		return devMAC;
	}

	public void setDevMAC(String devMAC) {
		this.devMAC = devMAC;
	}

	public String getDevOnlineTime() {
		return devOnlineTime;
	}

	public void setDevOnlineTime(String devOnlineTime) {
		this.devOnlineTime = devOnlineTime;
	}

	public String getDevOnlineStatus() {
		return devOnlineStatus;
	}

	public void setDevOnlineStatus(String devOnlineStatus) {
		this.devOnlineStatus = devOnlineStatus;
	}

	public String getDevStatusUpdateTime() {
		return devStatusUpdateTime;
	}

	public void setDevStatusUpdateTime(String devStatusUpdateTime) {
		this.devStatusUpdateTime = devStatusUpdateTime;
	}

	public String getDevSwName() {
		return devSwName;
	}

	public void setDevSwName(String devSwName) {
		this.devSwName = devSwName;
	}

	public String getDevSwVer() {
		return devSwVer;
	}

	public void setDevSwVer(String devSwVer) {
		this.devSwVer = devSwVer;
	}

	public String getDevManufacture() {
		return devManufacture;
	}

	public void setDevManufacture(String devManufacture) {
		this.devManufacture = devManufacture;
	}

	public String getDevModelName() {
		return devModelName;
	}

	public void setDevModelName(String devModelName) {
		this.devModelName = devModelName;
	}

	public String getDevUpdateId() {
		return devUpdateId;
	}

	public void setDevUpdateId(String devUpdateId) {
		this.devUpdateId = devUpdateId;
	}

	public String getDevMaxPower() {
		return devMaxPower;
	}

	public void setDevMaxPower(String devMaxPower) {
		this.devMaxPower = devMaxPower;
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

	public void setRadioPowerAuto(String radioPowerAuto) {
		this.radioPowerAuto = radioPowerAuto;
	}

	public String getRadioPowerPer() {
		return radioPowerPer;
	}

	public void setRadioPowerPer(String radioPowerPer) {
		this.radioPowerPer = radioPowerPer;
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

	public String getDevWlanChannel() {
		return devWlanChannel;
	}

	public void setDevWlanChannel(String devWlanChannel) {
		this.devWlanChannel = devWlanChannel;
	}

	public String getDevWlanBeaconInertval() {
		return devWlanBeaconInertval;
	}

	public void setDevWlanBeaconInertval(String devWlanBeaconInertval) {
		this.devWlanBeaconInertval = devWlanBeaconInertval;
	}

	public String getDevWlanRts() {
		return devWlanRts;
	}

	public void setDevWlanRts(String devWlanRts) {
		this.devWlanRts = devWlanRts;
	}

	public String getDevWlanCts() {
		return devWlanCts;
	}

	public void setDevWlanCts(String devWlanCts) {
		this.devWlanCts = devWlanCts;
	}

	public String getDevWlanStaNum() {
		return devWlanStaNum;
	}

	public void setDevWlanStaNum(String devWlanStaNum) {
		this.devWlanStaNum = devWlanStaNum;
	}

}
