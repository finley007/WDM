package com.wdm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.wdm.common.WDMConstants;
import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.dao.SystemDao;
import com.wdm.form.DashBoardForm;
import com.wdm.form.SystemForm;
import com.wdm.vo.SnmpVO;
import com.wdm.vo.SoftUpdateParamsVO;
import com.wdm.vo.UserVO;

public class SystemDaoImpl extends BaseDaoImpl implements SystemDao {

	private static final String GET_ALL_ACCOUNT_SQL = "select * from user_info t order by t.account";
	private static final String GET_ACCOUNT_BY_ID_SQL = "select * from user_info t where t.account = ?";
	private static final String INSERT_INTO_USER_INFO = "insert into user_info values(?,?,?,?,?,?,?)";
	private static final String UPDATE_USER_INFO = "update user_info t set t.`password` = ? ," +
																		  "t.is_supervisor = ?," +
																		  "t.`status` = ?," +
																		  "t.remark = ?," +
																		  "t.update_time = ? where t.account = ?";
	private static final String DELETE_ACCOUNT_BY_ID_SQL = "delete t from user_info t where t.account = ?";
	private static final String GET_UPDATE_PARAMETERS = "select * from updateinfo";
	private static final String UPDATE_UPDATE_PARAMETERS = "update updateinfo t set t.filetype = ?," +
																  "t.transprotocol = ?," +
																  "t.serveraddr = ?," +
																  "t.serverport = ?," +
																  "t.serverusername = ?," +
																  "t.serverpasswd = ?";
	private static final String GET_SNMP_PARAMETERS = "select * from snmpinfo";
	private static final String UPDATE_SNMP_PARAMETERS = "update snmpinfo t set t.Snmp_HeartBeatInterval = ? ," +
																  "t.Snmp_DiscoveryInterval = ?," +
																  "t.Snmp_DefaultApGroup = ?," +
																  "t.Snmp_DefaultRefreshTime = ? where t.Snmp_EnterpriseNo = '37260'";
	private static final String GET_ALL_UPDATE_VERSION = "select * from updatefileinfo t order by t.UpdateFile_SN";
	private static final String GET_UPDATE_VERSION_NEXT_SEQUENCE = "select max(t.UpdateFile_SN) from updatefileinfo t";
	private static final String ADD_UPDATE_VERSION = "insert into updatefileinfo values(?,?,?,?,?,?,?)";
	private static final String DELETE_UPDATE_VERSION = "delete t from updatefileinfo t where t.UpdateFile_SN = ?";
	
	public List getAccountList() throws Exception {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query(this.GET_ALL_ACCOUNT_SQL,new String[]{},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						UserVO account = new UserVO(rs);
						return account;
					}
				});
	}
	
	public SystemForm getAccountInfoById(String id) throws Exception {
		List accountList = getJdbcTemplate().query(this.GET_ACCOUNT_BY_ID_SQL,new String[]{id},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						UserVO account = new UserVO(rs);
						return account;
					}
				});
		if(accountList != null && accountList.size() > 0)
			return ((UserVO)accountList.get(0)).createForm();
		else
			return null;
	}
	
	public void saveAccount(SystemForm form) throws Exception {
		// TODO Auto-generated method stub
		Object[] params = new Object[]{
				form.getAccount(),
				form.getPassword(),
				form.getIsSupervisor(),
				form.getStatus(),
				form.getRemark(),
				WDMCommonUtil.getFormatDate(new Date()),
				WDMCommonUtil.getFormatDate(new Date()),
	    };
		this.getJdbcTemplate().update(INSERT_INTO_USER_INFO, params);
	}
	
	public void updateAccount(SystemForm form) throws Exception {
		// TODO Auto-generated method stub
		Object[] params = new Object[]{
				form.getPassword(),
				form.getIsSupervisor(),
				form.getStatus(),
				form.getRemark(),
				WDMCommonUtil.getFormatDate(new Date()),
				form.getAccount(),
	    };
		this.getJdbcTemplate().update(UPDATE_USER_INFO, params);
	}
	
	public void deleteAccountById(String id) throws Exception {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(DELETE_ACCOUNT_BY_ID_SQL,new Object[]{id});
	}
	
	public SystemForm getSoftUpdateParams() throws Exception {
		// TODO Auto-generated method stub
		List paramsList = getJdbcTemplate().query(this.GET_UPDATE_PARAMETERS,new String[]{},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						SoftUpdateParamsVO param = new SoftUpdateParamsVO(rs);
						return param;
					}
				});
		if(paramsList != null && paramsList.size() > 0)
			return ((SoftUpdateParamsVO)paramsList.get(0)).createForm();
		else
			return null;
	}
	
	public void saveSoftUpdateParamsConfig(SystemForm form) throws Exception {
		// TODO Auto-generated method stub
		Object[] params = new Object[]{
				form.getFileType(),
				form.getTransProtocal(),
				form.getServerAddr(),
				form.getServerPort(),
				form.getServerUsername(),
				form.getServerPassword()
	    };
		this.getJdbcTemplate().update(UPDATE_UPDATE_PARAMETERS, params);
	}
	
	public SystemForm getSMNPParams() throws Exception {
		// TODO Auto-generated method stub
		List paramsList = getJdbcTemplate().query(this.GET_SNMP_PARAMETERS,new String[]{},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						SnmpVO param = new SnmpVO(rs);
						return param;
					}
				});
		if(paramsList != null && paramsList.size() > 0)
			return ((SnmpVO)paramsList.get(0)).createForm();
		else
			return null;
	}
	
	public void saveSMNPParams(SystemForm form) throws Exception {
		// TODO Auto-generated method stub
		Object[] params = new Object[]{
				form.getHeartBeatInterval(),
				form.getDiscoveryInterval(),
				form.getDefaultApGroup(),
				form.getDefaultRefreshTime()
	    	};
		this.getJdbcTemplate().update(UPDATE_SNMP_PARAMETERS, params);
	}

	public List getUpdateVersions() throws Exception {
		// TODO Auto-generated method stub
		return getJdbcTemplate().queryForList(this.GET_ALL_UPDATE_VERSION);
	}
	
	public String getNextUpdateVersionSeq() throws Exception{
		Long result = getJdbcTemplate().queryForLong(GET_UPDATE_VERSION_NEXT_SEQUENCE);
		if(result != null)
			return (++result).toString();
		else
			return "0";
	}
	
	public void addUpdateVersion(SystemForm form) throws Exception{
		getJdbcTemplate().update(ADD_UPDATE_VERSION,
				new Object[]{Integer.valueOf(form.getSn()),
							 form.getFileName(),
							 form.getCompany(),
							 form.getDevType(),
							 form.getHardwareVersion(),
							 form.getUpdateFileId(),
							 form.getUpdateFileDstId()});
	}
	
	public void deleteUpdateVersion(String sn) throws Exception{
		getJdbcTemplate().update(DELETE_UPDATE_VERSION,new Object[]{sn});
	}
}
