package com.wdm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class WDMCommonUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String objToString(Object obj,String defaultValue){
		String result = objToString(obj);
		if(result.equals(""))
			return defaultValue;
		else
			return result;
	}
	
	public static String objToString(Object obj){
		if(obj != null)
			return obj.toString();
		else 
			return "";
	}
	
	public static String getMapStringValue(Map map,String key){
		if(map != null && map.get(key) != null)
			return map.get(key).toString();
		else
			return "";
	}
	
	public static String getFormatDate(Date date){
		return sdf.format(date);
	}
	
	public static String changeCase(String str,int type){
		if(str != null && !"".equals(str)){
			if(type == 0)
				return str.toLowerCase();
			else
				return str.toUpperCase();
		}else
			return "";
	}
	
	public static String changeCase(String str){
		return changeCase(str,0);
	}

}
