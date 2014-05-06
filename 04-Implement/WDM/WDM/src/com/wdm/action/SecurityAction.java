package com.wdm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.form.SecurityForm;

public class SecurityAction extends BaseAction {
	
	private final String ACTION_ADD = "ADD";
	private final String ACTION_EDIT = "EDIT";
	
	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(SecurityAction.class);
	
	public ActionForward initSecurity(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = "";
			SecurityForm form = null;
			if(request.getParameter("sn") != null){
				sn = request.getParameter("sn");
				form = devDao.getSecurityBySn(sn);
				request.setAttribute("flag", ACTION_EDIT);
			}else{
				sn = devDao.getNextSecuritySeq();
				form = new SecurityForm();
				form.setSn(sn);
				request.setAttribute("flag", ACTION_ADD);
			}
			request.setAttribute("result", form);
			return mapping.findForward("addSecurity");
		}catch(Exception e){
			logger.error("initSecurity", e);
			throw e;
		}
	}

	public ActionForward addSecurity(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			SecurityForm form = (SecurityForm)actionForm;
			String action = form.getAction();
			SecurityForm newForm = null;
			if(ACTION_ADD.equals(action)){
				devDao.addSecurity(form);
				String sn = devDao.getNextWlanSeq();
				newForm = new SecurityForm();
				newForm.setSn(sn);
				request.setAttribute("flag", ACTION_ADD);
			}else{
				devDao.updateSecurity(form);
				newForm = devDao.getSecurityBySn(form.getSn());
				request.setAttribute("flag", ACTION_EDIT);
			}
			request.setAttribute("result", newForm);
			return mapping.findForward("addSecurity");
		}catch(Exception e){
			logger.error("addSecurity", e);
			throw e;
		}
	}
	
	public ActionForward deleteSecurity(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = request.getParameter("sn");
			devDao.deleteSecurityBySn(sn);
			request.setAttribute("fieldInfo", getColomnList("CATE_6_1"));
			List result = devDao.getAllWlanSecurityList();
			request.setAttribute("result", result);
			return mapping.findForward("wlanSecurityList");
		}catch(Exception e){
			logger.error("deleteSecurity", e);
			throw e;
		}
	}

}
