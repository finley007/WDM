package com.wdm.action;

import java.util.ArrayList;
import java.util.List;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.FuncDao;

public class JSPAction extends BaseAction {
	
	private static LogUtil logger = new LogUtil(JSPAction.class);
	
	public static List getFunctionList(){
		try{
			FuncDao funDao = (FuncDao)getBean("funcDao");
			return funDao.getFunctionList();
		}catch(Exception e){
			logger.error("getFunctionList",e);
		}
		return new ArrayList();
	}
	
	public static List getAllColomnList(String appId){
		try{
			FuncDao funDao = (FuncDao)getBean("funcDao");
			return funDao.getAllColomnList(appId);
		}catch(Exception e){
			logger.error("getAllColomnList",e);
		}
		return new ArrayList();
	}

}
