package com.wdm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.WDMConstants;
import com.wdm.common.utils.LogUtil;
import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.dao.SystemDao;
import com.wdm.form.DashBoardForm;
import com.wdm.form.SystemForm;
import com.wdm.vo.DeviceVO;

public class SystemAction extends BaseAction {
	
	private SystemDao sysDao = (SystemDao)getBean("sysDao");
	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(SystemAction.class);
	
	public ActionForward getAllAccounts(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			List result = sysDao.getAccountList();
			request.setAttribute("result", result);
			return mapping.findForward("accountList"); 
		}catch(Exception e){
			logger.error("getAllAccounts", e);
			throw e;
		}
	}
	
	public ActionForward editAccountInfo(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String account = WDMCommonUtil.objToString(request.getParameter("account"));
			SystemForm form = null;
			if("".equals(account))
				form = new SystemForm();
			else
				form = sysDao.getAccountInfoById(account);
			request.setAttribute("systemForm", form);
			return mapping.findForward("accountInfo"); 
		}catch(Exception e){
			logger.error("editAccountInfo", e);
			throw e;
		}
	}
	
	public ActionForward saveAccountInfo(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String isCreate = request.getParameter("isCreate");
			SystemForm form = (SystemForm)actionForm;
			if(WDMConstants.TRUE.equals(isCreate)){
				sysDao.saveAccount(form);
			}else{
				sysDao.updateAccount(form);
			}
			List result = sysDao.getAccountList();
			request.setAttribute("result", result);
			return mapping.findForward("accountList");
		}catch(Exception e){
			logger.error("saveAccountInfo", e);
			throw e;
		}
	}
	
	public ActionForward deleteAccount(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String accountId = request.getParameter("account");
			sysDao.deleteAccountById(accountId);
			List result = sysDao.getAccountList();
			request.setAttribute("result", result);
			return mapping.findForward("accountList"); 
		}catch(Exception e){
			logger.error("deleteAccount", e);
			throw e;
		}
	}
	
	public ActionForward initSNMPConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SystemForm form = sysDao.getSMNPParams();
		List apGroupList = devDao.getAPGroupNameList(); 
		request.setAttribute("result", form);
		request.setAttribute("apGroupList", apGroupList);
		return mapping.findForward("snmpConfig");
	}
	
	public ActionForward saveSNMPConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SystemForm form = (SystemForm)actionForm;
		sysDao.saveSMNPParams(form);
		SystemForm newForm = sysDao.getSMNPParams();
		List apGroupList = devDao.getAPGroupNameList(); 
		request.setAttribute("result", newForm);
		request.setAttribute("apGroupList", apGroupList);
		return mapping.findForward("snmpConfig");
	}
	
	public ActionForward initSoftUpdateParamsConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			SystemForm form = sysDao.getSoftUpdateParams();
			if(form == null)
				form = new SystemForm();
			request.setAttribute("systemForm", form);
			return mapping.findForward("softUpdateConfig");
		}catch(Exception e){
			logger.error("initSoftUpdateParamsConfig", e);
			throw e;
		}
	} 
	
	public ActionForward saveSoftUpdateParamsConfig(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			SystemForm form = (SystemForm)actionForm;
			sysDao.saveSoftUpdateParamsConfig(form);
			SystemForm newForm = sysDao.getSoftUpdateParams();
			request.setAttribute("systemForm", newForm);
			return mapping.findForward("softUpdateConfig"); 
		}catch(Exception e){
			logger.error("saveSoftUpdateParamsConfig", e);
			throw e;
		}
	}
	
	public ActionForward getUpdateVersions(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_8_4",request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_8_4"));
			List result = sysDao.getUpdateVersions();
			request.setAttribute("result", result);
			return mapping.findForward("updateVersion");
		}catch(Exception e){
			logger.error("getUpdateVersions", e);
			throw e;
		}
	}
	
	public ActionForward getUpdateVersionSeq(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String nextSeq = sysDao.getNextUpdateVersionSeq();
			SystemForm form = new SystemForm();
			form.setSn(nextSeq);
			request.setAttribute("result", form);
			return mapping.findForward("addUpdateVersion");
		}catch(Exception e){
			logger.error("getUpdateVersionSeq", e);
			throw e;
		}
	}
	
	public ActionForward addUpdateVersion(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			SystemForm form = (SystemForm)actionForm;
			sysDao.addUpdateVersion(form);
			String nextSeq = sysDao.getNextUpdateVersionSeq();
			SystemForm newForm = new SystemForm();
			newForm.setSn(nextSeq);
			request.setAttribute("result", newForm);
			return mapping.findForward("addUpdateVersion");
		}catch(Exception e){
			logger.error("addUpdateVersion", e);
			throw e;
		}
	}
	
	public ActionForward deleteUpdateVersion(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = request.getParameter("sn");
			sysDao.deleteUpdateVersion(sn);
			List result = sysDao.getUpdateVersions();
			request.setAttribute("result", result);
			request.setAttribute("fieldInfo", getColomnList("CATE_8_4"));
			return mapping.findForward("updateVersion");
		}catch(Exception e){
			logger.error("deleteUpdateVersion", e);
			throw e;
		}
	}

}