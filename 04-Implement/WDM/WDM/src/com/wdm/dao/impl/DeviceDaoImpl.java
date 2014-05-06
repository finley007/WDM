package com.wdm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.wdm.common.WDMConstants;
import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.dao.utils.DaoUtil;
import com.wdm.form.DashBoardForm;
import com.wdm.form.RadioAdvancedForm;
import com.wdm.form.RadioBasicForm;
import com.wdm.form.SecurityForm;
import com.wdm.form.WlanForm;
import com.wdm.vo.DeviceVO;
import com.wdm.vo.RadioAdvancedVO;
import com.wdm.vo.RadioBasicVO;
import com.wdm.vo.SecurityVO;
import com.wdm.vo.WlanVO;

public class DeviceDaoImpl extends BaseDaoImpl implements DeviceDao {
	
	private static final String GET_ALL_DEVICE_INFO_SQL = "select * from devinfo t order by t.dev_sn";
	private static final String GET_DEVICE_INFO_BY_CONDITION_SQL = "select * from devinfo t";
	private static final String GET_DEVICE_DETAIL_BY_SERIALNO = "select * from devinfo t where t.dev_sn = ?";
	private static final String DELETE_DEVICE_DETAIL_BY_SERIALNO = "delete t from devinfo t where t.dev_sn = ?";
	private static final String GET_ALL_DEVICE_ALERT_INFO_SQL = "select * from devlog t order by t.dev_trap_log_time desc";
	private static final String GET_DEVICE_ALERT_INFO_BY_DEVICE_SQL = "select * from devlog t where t.dev_trap_sn = ? order by t.dev_trap_log_time desc";
	private static final String GET_DEVICE_ALERT_INFO_BY_CONDITION_SQL = "select * from devlog t";
	private static final String DELETE_DEVICE_ALERT_BY_SERIALNO = "delete t from devlog t where t.dev_trap_sn = ?";
	private static final String GET_ALL_AP_GROUP = "select * from apgroupinfo t order by t.ApGroup_SN";
	private static final String DELETE_AP_GROUP_BY_SERIALNO = "delete t from apgroupinfo t where t.ApGroup_SN = ?";
	private static final String GET_AP_GROUP_NAME_LIST = "select t.ApGroup_Name from ApGroupInfo t ORDER BY t.ApGroup_SN";
	private static final String GET_WLAN_GROUP_NAME_LIST = "select t.WlanGroup_Name from WlanGroupInfo t ORDER BY t.WlanGroup_SN";
	private static final String GET_AP_GROUP_NEXT_SEQUENCE = "select max(t.ApGroup_SN) from apgroupinfo t";
	private static final String ADD_AP_GROUP = "insert into apgroupinfo values (?,?,?)";
	private static final String UPDATE_AP_WLAN_GROUP = "update apgroupinfo t set t.ApGroup_WlanGroupName = ? where t.ApGroup_SN = ?";
	private static final String GET_ALL_WLAN_GROUP = "select * from wlangroupinfo t order by t.WlanGroup_SN";
	private static final String GET_WLAN_GROUP_NEXT_SEQUENCE = "select max(t.WlanGroup_SN) from wlangroupinfo t";
	private static final String ADD_WLAN_GROUP = "insert into wlangroupinfo values (?,?,'-1','-1','-1','-1')";
	private static final String DELETE_WLAN_GROUP_BY_SERIALNO = "delete t from wlangroupinfo t where t.WlanGroup_SN = ?";
	private static final String GET_ALL_WLAN_INFO_SQL = "select * from wlaninfo t order by t.wlan_sn";
	private static final String GET_WLAN_NEXT_SEQUENCE = "select max(t.Wlan_SN) from wlaninfo t";
	private static final String ADD_WLAN = "insert into wlaninfo values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_WLAN_DETAIL_BY_SERIALNO = "select * from wlaninfo t where t.wlan_sn = ?";
	private static final String UPDATE_WLAN = "update wlaninfo t set t.Wlan_WlanName = ?," +
																	"t.Wlan_SecurityMode = ?," +
																	"t.Wlan_SecurityPolicy = ?," +
																	"t.Wlan_Ssid = ?," +
																	"t.Wlan_BroadcastSsid = ?," +
																	"t.Wlan_VlanId = ?," +
																	"t.Wlan_QOS = ?," +
																	"t.Wlan_MaxUser = ?," +
																	"t.Wlan_MacFilter = ?," +
																	"t.Wlan_FlowControlMode = ?," +
																	"t.Wlan_downSSIDflow = ?," +
																	"t.Wlan_downUserflow = ?," +
																	"t.Wlan_UpSSIDflow = ?," +
																	"t.Wlan_UpUserflow = ? where t.Wlan_SN = ?";
	private static final String DELETE_WLAN_BY_SERIALNO = "delete t from wlaninfo t where t.Wlan_SN = ?";
	private static final String GET_ALL_WLAN_SECURITY_INFO_SQL = "select * from securityinfo t order by t.security_sn";
	private static final String GET_SECURITY_DETAIL_BY_SERIALNO = "select * from securityinfo t where t.security_sn = ?";
	private static final String ADD_SECURITY = "insert into securityinfo values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_SECURITY = "update securityinfo t set t.Security_Name = ?," +
																			"t.Security_Mode = ?," +
																			"t.Security_AuthMode = ?," +
																			"t.Security_KeyType = ?," +
																			"t.Security_KeyLength = ?," +
																			"t.Security_Cipher = ?," +
																			"t.Security_key = ?," +
																			"t.Security_KeyIndex = ?," +
																			"t.Security_key0 = ?," +
																			"t.Security_key1 = ?," +
																			"t.Security_key2 = ?," +
																			"t.Security_key3 = ? where t.Security_SN = ?";
	private static final String DELETE_SECURITY_BY_SERIALNO = "delete t from securityinfo t where t.Security_SN = ?";
	private static final String GET_GROUPED_WLAN_BY_GROUP_SN = "select * from wlaninfo t where t.Wlan_WlanName in " +
																	"(select v.wlanSn from " +
																			"( select t.WlanGroup_WlanId0 as wlanSn,t.WlanGroup_SN as groupSn from wlangroupinfo t  " +
																			  	"union all select t1.WlanGroup_WlanId1 as wlanSn,t1.WlanGroup_SN as groupSn from wlangroupinfo t1 " +
																					"union all select t2.WlanGroup_WlanId2 as wlanSn,t2.WlanGroup_SN as groupSn from wlangroupinfo t2 " +
																						"union all select t3.WlanGroup_WlanId3 as wlanSn,t3.WlanGroup_SN as groupSn from wlangroupinfo t3) v where v.groupSn = ?)";
	
	private static final String GET_NOT_GROUPED_WLAN_BY_GROUP_SN = "select * from wlaninfo t where t.Wlan_WlanName not in " +
																	"(select v.wlanSn from " +
																			"( select t.WlanGroup_WlanId0 as wlanSn,t.WlanGroup_SN as groupSn from wlangroupinfo t  " +
																			  	"union all select t1.WlanGroup_WlanId1 as wlanSn,t1.WlanGroup_SN as groupSn from wlangroupinfo t1 " +
																					"union all select t2.WlanGroup_WlanId2 as wlanSn,t2.WlanGroup_SN as groupSn from wlangroupinfo t2 " +
																						"union all select t3.WlanGroup_WlanId3 as wlanSn,t3.WlanGroup_SN as groupSn from wlangroupinfo t3) v where v.groupSn = ?)";
	private static final String GET_RADIO_BASIC_CONFIG_INFO = "select * from radiobasicparam t";
	private static final String GET_RADIO_ADVANCED_CONFIG_INFO = "select * from radioadvanceparam t";
	private static final String SET_RADIO_BASIC_CONFIG_INFO = "update radiobasicparam t set t.Radio_Sw = ?," +
																						   "t.Radio_PowerMode = ?," +
																						   "t.Radio_Power_Auto =?," +
																						   "t.Radio_Power_Per = ?," +
																						   "t.Radio_Mode = ?," +
																						   "t.Radio_Rate = ?," +
																						   "t.Radio_11nRate = ?," +
																						   "t.Radio_RxTxFlow = ?," +
																						   "t.Radio_Bw = ?," +
																						   "t.Radio_ShortGI = ?," +
																						   "t.Radio_AMPDU = ?," +
																						   "t.Radio_AMSDU = ?," +
																						   "t.Radio_11nWorkMode = ?," +
																						   "t.Radio_ChannelAutoAdjust = ?," +
																						   "t.Radio_ChannelAdjustMode = ?," +
																						   "t.Radio_ChannelAdjustInterval = ?," +
																						   "t.Radio_ChannelAdjustMixSignal = ? where t.Radio_SN = '0'";
	
	private static final String SET_RADIO_ADVANCED_CONFIG_INFO = "update radioadvanceparam t set t.Radio_L2Isolate = ?," +
																								"t.Radio_IgmpSnooping = ?," +
																								"t.Radio_PreAuth = ?," +
																								"t.Radio_Roaming = ?," +
																								"t.Radio_RoamingHeart = ?," +
																								"t.Radio_SSIDRoaming = ?," +
																								"t.Radio_EapUserOfflineDelay = ?," +
																								"t.Radio_UpLinkCheck = ?," +
																								"t.Radio_UpLinkCheckAction = ?," +
																								"t.Radio_NTPServer = ?," +
																								"t.Radio_NTPHeart = ? where t.Radio_SN = '0'";
	
	private static final String CHANGE_AP_GROUP = "update devinfo t set t.Dev_Group = ? where t.Dev_Sn = ?";
	private static final String GET_SECURITY_NEXT_SEQUENCE = "select max(t.Security_SN) from securityinfo t";
	
	public List getAllDeviceList() throws Exception{
		return DaoUtil.doFieldMapping(DaoUtil.TABLE_DEVICEINFO, getJdbcTemplate().queryForList(GET_ALL_DEVICE_INFO_SQL));
	}
	
	private String addCondition(String sql,Boolean isFirst,String colomn,String value){
		if(isFirst)
			sql += "  where t." + colomn + " = '" + value.trim() + "' ";
		else
			sql += "  and t." + colomn + " = '" + value.trim() + "' ";
		return sql;
	}
	
	public List getDeviceListByCondition(DashBoardForm form) throws Exception{
		String sql = GET_DEVICE_INFO_BY_CONDITION_SQL;
		Boolean isFirst = true;
		if(WDMCommonUtil.objToString(form.getIsSn()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_Sn",form.getSn());
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIsIp()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_Ipaddress",form.getIp());
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIsMac()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_MAC",form.getMac());
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIsChannel()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_Wlan_Channel",form.getChannel());
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIsStatus()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_Online_Status",form.getStatus());
			isFirst = false;
		}
		if(form.getStartIp() != null && !"".equals(form.getStartIp())){
			if(isFirst)
				sql += "  where t.Dev_Ipaddress >= '" + form.getStartIp() + "' ";
			else
				sql += "  and t.Dev_Ipaddress >= '" + form.getStartIp() + "' ";
			isFirst = false;
		}
		if(form.getEndIp() != null && !"".equals(form.getEndIp())){
			if(isFirst)
				sql += "  where t.Dev_Ipaddress <= '" + form.getEndIp() + "' ";
			else
				sql += "  and t.Dev_Ipaddress <= '" + form.getEndIp() + "' ";
			isFirst = false;
		}
		sql += " order by t.dev_sn";
		return getJdbcTemplate().queryForList(sql);
	}
	
	public DeviceVO getDeviceBySn(String devSn) throws Exception{
		List devList = getJdbcTemplate().query(this.GET_DEVICE_DETAIL_BY_SERIALNO,new String[]{devSn},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						DeviceVO dev = new DeviceVO(rs);
						return dev;
					}
				});
		if(devList != null && devList.size() > 0)
			return (DeviceVO)devList.get(0);
		else
			return null;
	}
	
	public void deleteDeviceBySn(String devSn) throws Exception{
		getJdbcTemplate().update(DELETE_DEVICE_DETAIL_BY_SERIALNO, new Object[]{devSn});
	}
	
	public List getAllDeviceAlertList() throws Exception{
		return getJdbcTemplate().queryForList(GET_ALL_DEVICE_ALERT_INFO_SQL);
	}
	
	public List getDeviceAlertListByDevice(String devSn) throws Exception{
		return getJdbcTemplate().queryForList(GET_DEVICE_ALERT_INFO_BY_DEVICE_SQL,new String[]{devSn});
	}
	
	public List getDeviceAlertListByCondition(DashBoardForm form) throws Exception{
		String sql = GET_DEVICE_ALERT_INFO_BY_CONDITION_SQL;
		Boolean isFirst = true;
		if(WDMCommonUtil.objToString(form.getIsDate()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)
				&& !"".equals(WDMCommonUtil.objToString(form.getStartDate()))){
			if(isFirst)
				sql += " where t.Dev_Trap_Log_Time > '" + form.getStartDate() + "'";
			else
				sql += " and t.Dev_Trap_Log_Time > '" + form.getStartDate() + "'";
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIsDate()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)
				&& !"".equals(WDMCommonUtil.objToString(form.getEndDate()))){
			if(isFirst)
				sql += " where t.Dev_Trap_Log_Time < '" + form.getEndDate() + "'";
			else
				sql += " and t.Dev_Trap_Log_Time < '" + form.getEndDate() + "'";
			isFirst = false;
		}
		if(WDMCommonUtil.objToString(form.getIp()).equals(WDMConstants.FORM_COMP_CHECK_BOX_SELECT)){
			sql = addCondition(sql,isFirst,"Dev_Ipaddress",form.getIp());
			isFirst = false;
		}
		sql += " order by t.dev_trap_log_time desc";
		return getJdbcTemplate().queryForList(sql);
	}
	
	public void deleteDeviceAlertBySn(String alertSn) throws Exception{
		getJdbcTemplate().update(DELETE_DEVICE_ALERT_BY_SERIALNO, new Object[]{alertSn});
	}

	public List getAllAPGroup() throws Exception{
		return getJdbcTemplate().queryForList(GET_ALL_AP_GROUP);
	}
	
	public void deleteAPGroupBySn(String sn) throws Exception{
		getJdbcTemplate().update(DELETE_AP_GROUP_BY_SERIALNO, new Object[]{sn});
	}
	
	public List getWlanGroupNameList() throws Exception{
		List<String> result = new ArrayList<String>();
		List list = getJdbcTemplate().queryForList(GET_WLAN_GROUP_NAME_LIST);
		if(list != null  && list.size() > 0){
			for(Object obj : list){
				Map map = (Map)obj;
				result.add((String)map.get("WlanGroup_Name"));
			}
		}
		return result;
	}
	
	public List getAPGroupNameList() throws Exception{
		List<String> result = new ArrayList<String>();
		List list = getJdbcTemplate().queryForList(GET_AP_GROUP_NAME_LIST);
		if(list != null  && list.size() > 0){
			for(Object obj : list){
				Map map = (Map)obj;
				result.add((String)map.get("ApGroup_Name"));
			}
		}
		return result;
	}
	
	public String getNextAPGroupSeq() throws Exception{
		Long result = getJdbcTemplate().queryForLong(GET_AP_GROUP_NEXT_SEQUENCE);
		if(result != null)
			return (++result).toString();
		else
			return "0";
	}
	
	public void addAPGroup(DashBoardForm form) throws Exception{
		String sn = form.getSn();
		String groupName = form.getApGroup();
		getJdbcTemplate().update(ADD_AP_GROUP,new Object[]{Integer.valueOf(sn),groupName,WDMConstants.DEFAULT_WLAN_GROUP_NAME});
	}
	
	public void updateAPWlanGroup(String sn,String group) throws Exception{
		getJdbcTemplate().update(UPDATE_AP_WLAN_GROUP,new Object[]{group,sn});
	}
	
	public List getAllWlanGroup() throws Exception{
		return getJdbcTemplate().queryForList(GET_ALL_WLAN_GROUP);
	}
	
	public String getNextWlanGroupSeq() throws Exception{
		Long result = getJdbcTemplate().queryForLong(GET_WLAN_GROUP_NEXT_SEQUENCE);
		if(result != null)
			return (++result).toString();
		else
			return "0";
	}
	
	public void addWlanGroup(DashBoardForm form) throws Exception{
		String sn = form.getSn();
		String groupName = form.getWlanGroup();
		getJdbcTemplate().update(ADD_WLAN_GROUP,new Object[]{Integer.valueOf(sn),groupName});
	}
	
	public void deleteWlanGroupBySn(String sn) throws Exception{
		getJdbcTemplate().update(DELETE_WLAN_GROUP_BY_SERIALNO, new Object[]{sn});
	}
	
	public List getAllWlanList() throws Exception{
		return DaoUtil.doFieldMapping(DaoUtil.TABLE_WLANINFO,getJdbcTemplate().queryForList(GET_ALL_WLAN_INFO_SQL));
	}
	
	public String getNextWlanSeq() throws Exception{
		Long result = getJdbcTemplate().queryForLong(GET_WLAN_NEXT_SEQUENCE);
		if(result != null)
			return (++result).toString();
		else
			return "0";
	}
	
	public void addWlan(WlanForm form) throws Exception{
		getJdbcTemplate().update(ADD_WLAN,
				new Object[]{Integer.valueOf(form.getSn()),
							 form.getWlanName(),
							 form.getSecurityMode(),
							 form.getSecurityPolicy(),
							 form.getSsid(),
							 form.getBroadcastSsid(),
							 form.getVlanId(),
							 form.getQos(),
							 form.getMaxUser(),
							 form.getMacFilter(),
							 form.getFlowControlMode(),
							 form.getDownSsidFlow(),
							 form.getDownUserFlow(),
							 form.getUpSsidFlow(),
							 form.getUpUserFlow()});
	}
	
	public WlanForm getWlanBySn(String sn) throws Exception{
		List wlanList = getJdbcTemplate().query(this.GET_WLAN_DETAIL_BY_SERIALNO,new String[]{sn},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						WlanVO wlan = new WlanVO(rs);
						return wlan;
					}
				});
		if(wlanList != null && wlanList.size() > 0)
			return ((WlanVO)wlanList.get(0)).createForm();
		else
			return null;
	}
	
	public void updateWlan(WlanForm form) throws Exception{
		getJdbcTemplate().update(UPDATE_WLAN,
				new Object[]{form.getWlanName(),
							 form.getSecurityMode(),
							 form.getSecurityPolicy(),
							 form.getSsid(),
							 form.getBroadcastSsid(),
							 form.getVlanId(),
							 form.getQos(),
							 form.getMaxUser(),
							 form.getMacFilter(),
							 form.getFlowControlMode(),
							 form.getDownSsidFlow(),
							 form.getDownUserFlow(),
							 form.getUpSsidFlow(),
							 form.getUpUserFlow(),
							 Integer.valueOf(form.getSn())});
	}
	
	public void deleteWlanBySn(String sn) throws Exception{
		getJdbcTemplate().update(DELETE_WLAN_BY_SERIALNO, new Object[]{sn});
	}
	
	public List getAllWlanSecurityList() throws Exception{
		return DaoUtil.doFieldMapping(DaoUtil.TABLE_SECURITYINFO,getJdbcTemplate().queryForList(GET_ALL_WLAN_SECURITY_INFO_SQL));
	}
	
	public SecurityForm getSecurityBySn(String sn) throws Exception{
		List securityList = getJdbcTemplate().query(this.GET_SECURITY_DETAIL_BY_SERIALNO,new String[]{sn},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						SecurityVO security = new SecurityVO(rs);
						return security;
					}
				});
		if(securityList != null && securityList.size() > 0)
			return ((SecurityVO)securityList.get(0)).createForm();
		else
			return null;
	}
	
	public void addSecurity(SecurityForm form) throws Exception{
		getJdbcTemplate().update(ADD_SECURITY,
				new Object[]{Integer.valueOf(form.getSn()),
							 form.getName(),
							 form.getMode(),
							 form.getAuthMode(),
							 form.getKeyType(),
							 form.getKeyLength(),
							 form.getCipher(),
							 form.getKey(),
							 form.getKeyIndex(),
							 form.getKey0(),
							 form.getKey1(),
							 form.getKey2(),
							 form.getKey3()});
	}
	
	public void updateSecurity(SecurityForm form) throws Exception{
		getJdbcTemplate().update(UPDATE_SECURITY,
				new Object[]{form.getName(),
							 form.getMode(),
							 form.getAuthMode(),
							 form.getKeyType(),
							 form.getKeyLength(),
							 form.getCipher(),
							 form.getKey(),
							 form.getKeyIndex(),
							 form.getKey0(),
							 form.getKey1(),
							 form.getKey2(),
							 form.getKey3(),
							 Integer.valueOf(form.getSn())});
	}
	
	public void deleteSecurityBySn(String sn) throws Exception{
		getJdbcTemplate().update(DELETE_SECURITY_BY_SERIALNO, new Object[]{sn});
	}
	
	public Map getGroupedWlan(String groupSn) throws Exception{
		Map result = new HashMap();
		List wlanGrouped = DaoUtil.doFieldMapping(DaoUtil.TABLE_WLANINFO,getJdbcTemplate().queryForList(GET_GROUPED_WLAN_BY_GROUP_SN,new Object[]{groupSn}));
		List wlanUngrouped = DaoUtil.doFieldMapping(DaoUtil.TABLE_WLANINFO,getJdbcTemplate().queryForList(GET_NOT_GROUPED_WLAN_BY_GROUP_SN,new Object[]{groupSn}));
		result.put("grouped", wlanGrouped);
		result.put("ungrouped", wlanUngrouped);
		return result;
	}
	
	public void changeGroupedWlan(String sn,String wlans) throws Exception{
		String[] wlanArray = wlans.split("\\|");
		String sql = "update wlangroupinfo t ";
		for(int i = 0;i < 4;i++){
			if(i == 0){
				sql += " set t.WlanGroup_WlanId" + i + " = ?,";
			}else{
				sql += " t.WlanGroup_WlanId" + i + " = ?,";
			}
		}
		sql = sql.substring(0,sql.length() - 1);
		sql += " where t.WlanGroup_SN = ?";
		Object[] params = new Object[5];
		for(int i = 0;i < 4;i++){
			if(i < wlanArray.length)
				params[i] = wlanArray[i];
			else
				params[i] = "-1";
		}
		params[params.length - 1] = sn;
		getJdbcTemplate().update(sql, params);
	}
	
	public RadioBasicForm getRadioBasicConfig() throws Exception{
		List result = getJdbcTemplate().query(this.GET_RADIO_BASIC_CONFIG_INFO,new String[]{},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						RadioBasicVO vo = new RadioBasicVO(rs);
						return vo;
					}
				});
		if(result != null && result.size() > 0)
			return ((RadioBasicVO)result.get(0)).createForm();
		else
			return null;
	}
	public RadioAdvancedForm getRadioAdvancedConfig() throws Exception{
		List result = getJdbcTemplate().query(this.GET_RADIO_ADVANCED_CONFIG_INFO,new String[]{},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						RadioAdvancedVO vo = new RadioAdvancedVO(rs);
						return vo;
					}
				});
		if(result != null && result.size() > 0)
			return ((RadioAdvancedVO)result.get(0)).createForm();
		else
			return null;
	}
	
	public void setRadioBasicConfig(RadioBasicForm form) throws Exception{
		getJdbcTemplate().update(SET_RADIO_BASIC_CONFIG_INFO,
				new Object[]{form.getSw(),
							 form.getPowerMode(),
							 form.getPowerAuto(),
							 form.getPowerPer(),
							 form.getMode(),
							 form.getRate(),
							 form.getRate11n(),
							 form.getRxTxFlow(),
							 form.getBw(),
							 form.getShortGI(),
							 form.getAmpDU(),
							 form.getAmsDU(),
							 form.getWorkMode11n(),
							 form.getChannelAutoAdjust(),
							 form.getChannelAdjustMode(),
							 form.getChannelAdjustInterval(),
							 form.getChannelAdjustMixSignal()});
	}
	
	public void setRadioAdvancedConfig(RadioAdvancedForm form) throws Exception{
		getJdbcTemplate().update(SET_RADIO_ADVANCED_CONFIG_INFO,
				new Object[]{form.getL2isolate(),
							 form.getIgmpSnooping(),
							 form.getPreAuth(),
							 form.getRoaming(),
							 form.getRoamingHeart(),
							 form.getSSidRoaming(),
							 form.getEapUserOfflineDelay(),
							 form.getUpLinkCheck(),
							 form.getUpLinkCheckAction(),
							 form.getNtpServer(),
							 form.getNtpHeart()});
	}
	
	public void changeAPGroup(String sn,String group) throws Exception{
		getJdbcTemplate().update(CHANGE_AP_GROUP, new Object[]{group,sn});
	}
	
	public String getNextSecuritySeq() throws Exception{
		Long result = getJdbcTemplate().queryForLong(GET_SECURITY_NEXT_SEQUENCE);
		if(result != null)
			return (++result).toString();
		else
			return "0";
	}
}
