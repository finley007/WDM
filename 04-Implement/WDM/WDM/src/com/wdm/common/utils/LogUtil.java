package com.wdm.common.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
	
	private Logger logger = null;
	
	public LogUtil(Class clz){
		try{
			PropertyConfigurator.configure(PropertyUtil.loadProperties("log4j.properties"));
			logger = Logger.getLogger(clz);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void info(String str){
		if(logger != null)
			logger.info(str);
	}
	
	public void debug(String str){
		if(logger != null)
			logger.debug(str);
	}
	
	public void error(String str,Throwable e){
		if(logger != null)
			logger.error(str, e);
	}
	
	public static void main(String[] args){
		LogUtil log = new LogUtil(LogUtil.class);
		log.info("aaa");
	}

}
