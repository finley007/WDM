package com.wdm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.form.RadioAdvancedForm;

public class RadioAdvancedAction extends BaseAction {

	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(RadioAdvancedAction.class);

	public ActionForward initConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setAttribute("result", devDao.getRadioAdvancedConfig());
			return mapping.findForward("advancedInfo");
		}catch(Exception e){
			logger.error("initConfig", e);
			throw e;
		}
	}
	
	public ActionForward saveConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			RadioAdvancedForm form = (RadioAdvancedForm)actionForm;
			devDao.setRadioAdvancedConfig(form);
			request.setAttribute("result", devDao.getRadioAdvancedConfig());
			return mapping.findForward("advancedInfo");
		}catch(Exception e){
			logger.error("saveConfig", e);
			throw e;
		}
	}
	
}
