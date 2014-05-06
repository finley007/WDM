package com.wdm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.wdm.dao.FuncDao;
import com.wdm.vo.AppColVO;
import com.wdm.vo.FuncInfoVO;

public class FuncDaoImpl extends BaseDaoImpl implements FuncDao {
	
	private static final String FIND_FUNC_INFO_SQL = "select * from func_info t order by t.func_id";
	private static final String FIND_COL_INFO_BY_APP_SQL = "select * from app_col t where t.app_id = ? and t.status = '1' " +
																"order by t.seq,t.col_id";
	private static final String FIND_ALL_COL_INFO_BY_APP_SQL = "select * from app_col t where t.app_id = ? order by t.seq,t.col_id";
	private static final String SET_COL_INFO_BY_APP_SQL = "update app_col t set t.status = ? where t.app_id = ?";
	
	public List getFunctionList() throws Exception {
		// TODO Auto-generated method stub
		List funcList = getJdbcTemplate().query(this.FIND_FUNC_INFO_SQL,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						FuncInfoVO func = new FuncInfoVO(rs);
						return func;
					}
				});
		return funcList;
	}
	
	public List getColomnList(String appId) throws Exception {
		// TODO Auto-generated method stub
		List funcList = getJdbcTemplate().query(this.FIND_COL_INFO_BY_APP_SQL,new String[]{appId},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						AppColVO vo = new AppColVO(rs);
						return vo;
					}
				});
		return funcList;
	}
	
	public List getAllColomnList(String appId) throws Exception {
		// TODO Auto-generated method stub
		List funcList = getJdbcTemplate().query(this.FIND_ALL_COL_INFO_BY_APP_SQL,new String[]{appId},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						AppColVO vo = new AppColVO(rs);
						return vo;
					}
				});
		return funcList;
	}
	
	public void setColomnList(String appId,String colList) throws Exception {
		// TODO Auto-generated method stub
		String[] cols = colList.split("\\|");
		String condition = "('',";
		if(cols != null && cols.length > 0){
			for(int i = 0;i < cols.length;i++){
				condition += "'" + cols[i] + "',";
			}
		}
		condition = condition.substring(0,condition.length() - 1) + ")";
		getJdbcTemplate().update(SET_COL_INFO_BY_APP_SQL + " and t.col_id in " + condition, new Object[]{"1",appId});
		getJdbcTemplate().update(SET_COL_INFO_BY_APP_SQL + " and t.col_id not in " + condition, new Object[]{"0",appId});
	}
	
	public static void main(String[] args){
		try{
			ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			FuncDao dao = (FuncDao)appContext.getBean("funcDao");
			List list = dao.getFunctionList();
			System.out.println(list);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
