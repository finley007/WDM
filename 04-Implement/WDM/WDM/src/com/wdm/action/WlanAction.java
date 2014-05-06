package com.wdm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.form.WlanForm;

public class WlanAction extends BaseAction {
	
	private final String ACTION_ADD = "ADD";
	private final String ACTION_EDIT = "EDIT";
	
	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(WlanAction.class);
	
	public ActionForward initWlan(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = "";
			WlanForm form = null;
			if(request.getParameter("sn") != null){
				sn = request.getParameter("sn");
				form = devDao.getWlanBySn(sn);
				request.setAttribute("flag", ACTION_EDIT);
			}else{
				sn = devDao.getNextWlanSeq();
				form = new WlanForm();
				form.setSn(sn);
				request.setAttribute("flag", ACTION_ADD);
			}
			request.setAttribute("result", form);
			return mapping.findForward("addWlan");
		}catch(Exception e){
			logger.error("initWlan", e);
			throw e;
		}
	}

	public ActionForward addWlan(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			WlanForm form = (WlanForm)actionForm;
			String action = form.getAction();
			WlanForm newForm = null;
			if(ACTION_ADD.equals(action)){
				devDao.addWlan(form);
				String sn = devDao.getNextWlanSeq();
				newForm = new WlanForm();
				newForm.setSn(sn);
				request.setAttribute("flag", ACTION_ADD);
			}else{
				devDao.updateWlan(form);
				newForm = devDao.getWlanBySn(form.getSn());
				request.setAttribute("flag", ACTION_EDIT);
			}
			request.setAttribute("result", newForm);
			return mapping.findForward("addWlan");
		}catch(Exception e){
			logger.error("addWlan", e);
			throw e;
		}
	}
	
	public ActionForward deleteWlan(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = request.getParameter("sn");
			devDao.deleteWlanBySn(sn);
			request.setAttribute("fieldInfo", getColomnList("CATE_5_2"));
			List result = devDao.getAllWlanList();
			request.setAttribute("result", result);
			return mapping.findForward("wlanList");
		}catch(Exception e){
			logger.error("deleteWlan", e);
			throw e;
		}
	}
	
	public ActionForward initGroupedWlan(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = request.getParameter("sn");
			String name = request.getParameter("name");
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_5_2",request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_5_2"));
			Map result = devDao.getGroupedWlan(sn);
			request.setAttribute("grouped", (List)result.get("grouped"));
			request.setAttribute("ungrouped", (List)result.get("ungrouped"));
			request.setAttribute("sn", sn);
			request.setAttribute("name", name);
			return mapping.findForward("groupedWlan");
		}catch(Exception e){
			logger.error("initGroupedWlan", e);
			throw e;
		}
	} 
	
	public ActionForward changeGroupedWlan(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = request.getParameter("sn");
			String name = request.getParameter("name");
			String wlans = request.getParameter("wlans");
			request.setAttribute("fieldInfo", getColomnList("CATE_5_2"));
			devDao.changeGroupedWlan(sn,wlans);
			Map result = devDao.getGroupedWlan(sn);
			request.setAttribute("grouped", (List)result.get("grouped"));
			request.setAttribute("ungrouped", (List)result.get("ungrouped"));
			request.setAttribute("sn", sn);
			request.setAttribute("name", name);
			return mapping.findForward("groupedWlan");
		}catch(Exception e){
			logger.error("initGroupedWlan", e);
			throw e;
		}
	} 
	
	
}
