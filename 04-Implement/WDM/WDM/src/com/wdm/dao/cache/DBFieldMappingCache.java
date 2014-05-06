package com.wdm.dao.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wdm.common.utils.LogUtil;
import com.wdm.common.utils.WDMCommonUtil;

public class DBFieldMappingCache {
	
	private LogUtil logger = new LogUtil(DBFieldMappingCache.class);
	
	private Map mappingCache_;
	
	private Map getMappingCache(){
		if(this.mappingCache_ == null){
			this.init();
		}
		return this.mappingCache_;
	}
	
	private void init(){
		try{
			mappingCache_ = new HashMap();
			SAXReader sax = new SAXReader();  
	        Document root = sax.read(DBFieldMappingCache.class.getClassLoader().getResourceAsStream("dbFieldMapping.xml")); 
	        List tableList = (List) root.selectNodes("//field_mapping/table");
	        for (Object table : tableList) {  
	        	Element elem = (Element) table;  
	        	Map fieldMap = new HashMap();
	            List fieldList = elem.elements();
	            for (Object field : fieldList) {
	            	Element ele = (Element) field;  
	            	Map valueMap = new HashMap();
	                List valueList = ele.elements();
	                for (Object value : valueList) {
	                	Element e = (Element) value;  
	                	valueMap.put(e.attributeValue("code"), e.getText());
	                }
	                fieldMap.put(WDMCommonUtil.changeCase(ele.attributeValue("name")), valueMap);
	            }
	            mappingCache_.put(WDMCommonUtil.changeCase(elem.attributeValue("name")), fieldMap);
	        } 
	        logger.debug("[DBFieldMappingCache]Mapping cache:" + mappingCache_.toString());
		}catch(Exception e){
			logger.error("[DBFieldMappingCache]Init error", e);
		}
	}

	public String getFieldLabel(String table,String field,String code){
		if(getMappingCache().get(table) != null 
				&& ((Map)getMappingCache().get(table)).get(field) != null
					&& ((Map)((Map)getMappingCache().get(table)).get(field)).get(code) != null){
			return ((Map)((Map)getMappingCache().get(table)).get(field)).get(code).toString();
		}else
			return code;
	}
	
	public boolean checkFieldExist(String table,String field){
		if(getMappingCache().get(table) != null 
				&& ((Map)getMappingCache().get(table)).get(field) != null)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {  
        try {  
            SAXReader sax = new SAXReader();  
            Document root = sax.read(DBFieldMappingCache.class.getClassLoader().getResourceAsStream("dbFieldMapping.xml")); 
            List tableList = (List) root.selectNodes("//field_mapping/table");
            for (Object table : tableList) {  
            	Element elem = (Element) table;  
                System.out.println(elem.getName() + ": " + elem.attributeValue("name"));  
                List fieldList = elem.elements();
                for (Object field : fieldList) {
                	Element ele = (Element) field;  
                    System.out.println(ele.getName() + ": " + ele.attributeValue("name")); 
                    List valueList = ele.elements();
                    for (Object value : valueList) {
                    	Element e = (Element) value;  
                        System.out.println(e.attributeValue("code") + ": " + e.getText()); 
                    }
                }
            } 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
