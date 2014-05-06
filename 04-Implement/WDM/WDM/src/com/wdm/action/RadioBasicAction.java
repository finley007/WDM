package com.wdm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.form.RadioBasicForm;


public class RadioBasicAction extends BaseAction {
	
	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(RadioBasicAction.class);

	public ActionForward initInfoConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setAttribute("result", devDao.getRadioBasicConfig());
			return mapping.findForward("basicInfo");
		}catch(Exception e){
			logger.error("initConfig", e);
			throw e;
		}
	}
	
	public ActionForward initChannelConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setAttribute("result", devDao.getRadioBasicConfig());
			return mapping.findForward("channelInfo");
		}catch(Exception e){
			logger.error("initConfig", e);
			throw e;
		}
	}
	
	public ActionForward saveInfoConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			RadioBasicForm form = (RadioBasicForm)actionForm;
			devDao.setRadioBasicConfig(form);
			request.setAttribute("result", devDao.getRadioBasicConfig());
			return mapping.findForward("basicInfo");
		}catch(Exception e){
			logger.error("saveInfoConfig", e);
			throw e;
		}
	}
	
	public ActionForward saveChannelConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			RadioBasicForm form = (RadioBasicForm)actionForm;
			devDao.setRadioBasicConfig(form);
			request.setAttribute("result", devDao.getRadioBasicConfig());
			return mapping.findForward("channelInfo");
		}catch(Exception e){
			logger.error("saveChannelConfig", e);
			throw e;
		}
	}
	
}
