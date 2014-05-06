package com.wdm.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoImpl {
	
	private JdbcTemplate jdbcTemplate = null;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
