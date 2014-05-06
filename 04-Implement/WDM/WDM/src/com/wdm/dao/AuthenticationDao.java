package com.wdm.dao;

import com.wdm.vo.UserVO;

public interface AuthenticationDao {

	public boolean isValid(String userId, String password) throws Exception;
	public UserVO createUserInfo(String userId) throws Exception;
}
