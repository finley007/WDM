package com.wdm.common.locale;

import java.util.Locale;
import java.util.ResourceBundle;

import com.wdm.common.utils.PropertyUtil;

public class WDMResource {
	static ResourceBundle resources = null;
	static{
		try {
			String locale = "zh_CN";
			String[] locales = locale.split("_");
			resources = ResourceBundle.getBundle("WDMResource", new Locale(locales[0],locales[1]));
		} catch (Exception e) {
			e.printStackTrace();
			resources = ResourceBundle.getBundle("WDMResource");
		}
	}

	public static String getString(String key){
		return resources.getString(key);
	}

	public static void main(String[] args) {
	}
}
