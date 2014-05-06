package com.wdm.extremecomponents.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.AutoGenerateColumns;
import org.extremecomponents.table.core.TableModel;

import com.wdm.vo.AppColVO;

public class AutoGenerateColumnsImpl implements AutoGenerateColumns {

	public void addColumns(TableModel model) {
		// TODO Auto-generated method stub
		 List fieldInfoList = (List)model.getContext().getRequestAttribute("fieldInfo");    
		 Iterator iterator = fieldInfoList.iterator();    
		 while (iterator.hasNext()) {    
			 AppColVO vo = (AppColVO)iterator.next();    
		     Column column = model.getColumnInstance(); 
		     String fieldName = (String)vo.getColName();
		     String fieldProp = (String)vo.getColId();
		     column.setProperty(fieldProp);  
		     column.setTitle(fieldName);
		     model.getColumnHandler().addAutoGenerateColumn(column);    
		 }    
	}

}
