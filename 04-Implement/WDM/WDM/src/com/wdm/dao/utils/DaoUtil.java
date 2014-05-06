package com.wdm.dao.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wdm.common.locale.WDMResource;
import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.dao.cache.DBFieldMappingCache;

public class DaoUtil {

	public static final String TABLE_DEVICEINFO = "devinfo";
	public static final String TABLE_WLANINFO = "wlaninfo";
	public static final String TABLE_SECURITYINFO = "securityinfo";
	
	private static DBFieldMappingCache mappingCache = new DBFieldMappingCache();
	
	public static List doFieldMapping(String table,List list){
		List<String> mappingFields = new ArrayList<String>();
		if(list != null && list.size() > 0){
			Map template = (Map)list.get(0);
			for(Iterator itor = template.keySet().iterator();itor.hasNext();){
				String field = (String)itor.next();
				if(mappingCache.checkFieldExist(WDMCommonUtil.changeCase(table), WDMCommonUtil.changeCase(field)))
					mappingFields.add(field);
			}
			if(mappingFields.size() > 0){
				for(Object obj : list){
					Map map = (Map)obj;
					for(String field : mappingFields){
						String newValue = "";
						try{
							newValue = WDMResource.getString(mappingCache.getFieldLabel(WDMCommonUtil.changeCase(table), 
								WDMCommonUtil.changeCase(field), (String)map.get(field)));
						}catch(Exception e){
							newValue = mappingCache.getFieldLabel(WDMCommonUtil.changeCase(table), 
									WDMCommonUtil.changeCase(field), (String)map.get(field));
						}
						map.put(field, newValue);
					}
				}
			}
		}
		return list;
	}
}
