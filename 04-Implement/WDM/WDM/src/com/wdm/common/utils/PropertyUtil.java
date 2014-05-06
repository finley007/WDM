package com.wdm.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
	
	private static Map _propCache = new HashMap();

	public static Properties loadProperties(final String fileName) throws Exception{
		if(_propCache.get(fileName) != null)
			return (Properties)_propCache.get(fileName);
		Properties prop = null;
		InputStream inputStream = null;
		if (fileName.lastIndexOf("/") > 0){
			String file = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
			inputStream = PropertyUtil.class.getResourceAsStream(file);
			if (inputStream == null){
				inputStream = PropertyUtil.class.getResourceAsStream(fileName);
			}
		}else {
			if (fileName.contains("/")){
				inputStream = PropertyUtil.class.getResourceAsStream(fileName);
			}else {
				inputStream = PropertyUtil.class.getResourceAsStream("/"+fileName);
			}
		}
		if (inputStream != null){
			prop = new Properties();
			prop.load(inputStream);
			_propCache.put(fileName, prop);
			inputStream.close();
		}else{
			throw new Exception("[PropertyUtil]The file:" + fileName + " does not exist");
		}
		return prop;
	}
}
