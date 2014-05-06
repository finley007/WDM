package com.wdm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.wdm.dao.AuthenticationDao;
import com.wdm.vo.UserVO;

public class AuthenticationDaoImpl extends BaseDaoImpl implements AuthenticationDao {
	
	private static final String SQL_CHECK_IS_VALID = "select count(*) from user_info where account=? and password=?";
	private static final String GET_ACCOUNT_BY_ID_SQL = "select * from user_info t where t.account = ?";
	
	public boolean isValid(String userId, String password) throws Exception {
		int flag = getJdbcTemplate().queryForInt(SQL_CHECK_IS_VALID,
				new String[] { userId, password });
		return flag > 0;
	}
	
	public UserVO createUserInfo(String userId) throws Exception{
		List accountList = getJdbcTemplate().query(this.GET_ACCOUNT_BY_ID_SQL,new String[]{userId},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						UserVO account = new UserVO(rs);
						return account;
					}
				});
		if(accountList != null && accountList.size() > 0)
			return (UserVO)accountList.get(0);
		else
			return null;
	}

}
