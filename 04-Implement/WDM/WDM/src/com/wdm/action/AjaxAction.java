package com.wdm.action;

import com.wdm.common.locale.WDMResourceConstants;

public class AjaxAction extends BaseAction {
	
	public String test(String param){
		System.out.println("This is AjaxAction");
		return param;
	}
	
	public String loadBasicRadioRate(String param){
		if("2".equals(param)){
			return "<option value='0'>"+WDMResourceConstants.ACTION_AUTO_SELECT+"</option>" +
					"<option value='1'>1 Mbps</option>" +
					"<option value='2'>2 Mbps</option>" +
					"<option value='3'>5.5 Mbps</option>" +
					"<option value='4'>6 Mbps</option>" +
					"<option value='5'>9 Mbps</option>" +
					"<option value='6'>11 Mbps</option>";
		}else{
			return "<option value='0'>"+WDMResourceConstants.ACTION_AUTO_SELECT+"</option>" +
					"<option value='1'>1 Mbps</option>" +
					"<option value='2'>2 Mbps</option>" +
					"<option value='3'>5.5 Mbps</option>" +
					"<option value='4'>6 Mbps</option>" +
					"<option value='5'>9 Mbps</option>" +
					"<option value='6'>11 Mbps</option>" +
					"<option value='7'>12 Mbps</option>" +
					"<option value='8'>18 Mbps</option>" +
					"<option value='9'>24 Mbps</option>" +
					"<option value='10'>36 Mbps</option>" +
					"<option value='11'>48 Mbps</option>" +
					"<option value='12'>54 Mbps</option>";
		}
	}

}
