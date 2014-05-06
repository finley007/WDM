package com.wdm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.dao.DeviceDao;
import com.wdm.form.DashBoardForm;
import com.wdm.vo.DeviceVO;
import com.wdm.vo.WlanVO;

public class DashBoardAction extends BaseAction {
	
	private DeviceDao devDao = (DeviceDao)getBean("devDao");
	private LogUtil logger = new LogUtil(DashBoardAction.class);
	
	public ActionForward getAllDevices(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String appId = request.getParameter("appId");
			if(request.getParameter("selectCols") != null)
				setColomnList(appId,request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList(appId));
			List result = devDao.getAllDeviceList();
			request.setAttribute("result", result);
			if(appId.equals("CATE_3_1"))
				return mapping.findForward("deviceList");
			else
				return mapping.findForward("deviceConfig");
		}catch(Exception e){
			logger.error("getAllDevices", e);
			throw e;
		}
	}
	
	public ActionForward getAllDevicesForUpdate(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_4_3",request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_4_3"));
			List result = devDao.getAllDeviceList();
			request.setAttribute("result", result);
			return mapping.findForward("deviceSoftUpdate"); 
		}catch(Exception e){
			logger.error("getAllDevicesForUpdate", e);
			throw e;
		}
	}
	
	public ActionForward getDeviceDetail(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = (String)request.getParameter("devSn");
			DeviceVO devInfo = devDao.getDeviceBySn(devSn);
			request.setAttribute("result", devInfo);
			return mapping.findForward("deviceDetail");
		}catch(Exception e){
			logger.error("getDeviceDetail", e);
			throw e;
		}
	}
	
	public ActionForward deleteDevice(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = (String)request.getParameter("devSn");
			devDao.deleteDeviceBySn(devSn);
			List result = devDao.getAllDeviceList();
			request.setAttribute("result", result);
			request.setAttribute("fieldInfo", getColomnList("CATE_4_1"));
			return mapping.findForward("deviceConfig");
		}catch(Exception e){
			logger.error("deleteDevice", e);
			throw e;
		}
	}
	
	public ActionForward getAllDeviceAlerts(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			List result = devDao.getAllDeviceAlertList();
			request.setAttribute("result", result);
			return mapping.findForward("deviceAlertList");
		}catch(Exception e){
			logger.error("getAllDeviceAlerts", e);
			throw e;
		}
	}
	
	public ActionForward getDeviceAlertsByDevice(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = request.getParameter("devSn");
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_1_2",(String)request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_1_2"));
			List result = devDao.getDeviceAlertListByDevice(devSn);
			request.setAttribute("result", result);
			request.setAttribute("flag", "1");
			request.setAttribute("devSn", devSn);
			return mapping.findForward("deviceAlertList");
		}catch(Exception e){
			logger.error("getDeviceAlertsByDevice", e);
			throw e;
		}
	}
	
	public ActionForward getUserListByDevice(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = request.getParameter("devSn");
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_3_1_1",(String)request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_3_1_1"));
			request.setAttribute("devSn", devSn);
			request.setAttribute("result", new ArrayList());
			return mapping.findForward("userList");
		}catch(Exception e){
			logger.error("getUserListByDevice", e);
			throw e;
		}
	}
	
	public ActionForward getFlowStatisticByDevice(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = request.getParameter("devSn");
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_3_1_2",(String)request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_3_1_2"));
			request.setAttribute("devSn", devSn);
			request.setAttribute("result", new ArrayList());
			return mapping.findForward("flowStatistic");
		}catch(Exception e){
			logger.error("getFlowStatisticByDevice", e);
			throw e;
		}
	}
	
	public ActionForward deleteDeviceAlert(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String alertSn = (String)request.getParameter("alertSn");
			devDao.deleteDeviceAlertBySn(alertSn);
			List result = devDao.getAllDeviceAlertList();
			request.setAttribute("result", result);
			return mapping.findForward("deviceAlertList");
		}catch(Exception e){
			logger.error("deleteDeviceAlert", e);
			throw e;
		}
	}
	
	public ActionForward initDeviceQuery(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			List channelList = new ArrayList();
			Map map = new HashMap();
			map.put("data", "channel1");
			map.put("label", "channel1");
			channelList.add(map);
			map = new HashMap();
			map.put("data", "channel2");
			map.put("label", "channel2");
			channelList.add(map);
			List statusList = new ArrayList();
			map = new HashMap();
			map.put("data", "1");
			map.put("label", "在线");
			statusList.add(map);
			map = new HashMap();
			map.put("data", "2");
			map.put("label", "离线");
			statusList.add(map);
			request.setAttribute("channelList", channelList);
			request.setAttribute("statusList", statusList);
			request.setAttribute("dashBoardForm", new DashBoardForm());
			return mapping.findForward("deviceQuery");
		}catch(Exception e){
			logger.error("initDeviceQuery", e);
			throw e;
		}
	}
	
	public ActionForward deviceQuery(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			List result = devDao.getDeviceListByCondition(form);
			request.setAttribute("result", result);
			request.setAttribute("flag", "1");
			return mapping.findForward("deviceList");
		}catch(Exception e){
			logger.error("deviceQuery", e);
			throw e;
		}
	}
	
	public ActionForward initAlertQuery(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setAttribute("dashBoardForm", new DashBoardForm());
			return mapping.findForward("alertQuery");
		}catch(Exception e){
			logger.error("initAlertQuery", e);
			throw e;
		}
	}
	
	public ActionForward alertQuery(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			List result = devDao.getDeviceAlertListByCondition(form);
			request.setAttribute("result", result);
			request.setAttribute("flag", "1");
			return mapping.findForward("deviceAlertList");
		}catch(Exception e){
			logger.error("alertQuery", e);
			throw e;
		}
	}
	
	public ActionForward initIPDetect(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setAttribute("dashBoardForm", new DashBoardForm());
			return mapping.findForward("ipDetect");
		}catch(Exception e){
			logger.error("initIPDetect", e);
			throw e;
		}
	}
	
	public ActionForward ipDetect(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			request.setAttribute("fieldInfo", getColomnList("CATE_3_1"));
			List result = devDao.getDeviceListByCondition(form);
			request.setAttribute("result", result);
			return mapping.findForward("deviceList");
		}catch(Exception e){
			logger.error("ipDetect", e);
			throw e;
		}
	}
	
	public ActionForward updateDeviceSoftware(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Object obj1 = request.getParameter("ids");
			List result = devDao.getAllDeviceList();
			request.setAttribute("result", result);
			return mapping.findForward("deviceSoftUpdate");
		}catch(Exception e){
			logger.error("updateDeviceSoftware", e);
			throw e;
		}
	}
	
	public ActionForward getAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			List result = devDao.getAllAPGroup();
			request.setAttribute("result", result);
			request.setAttribute("wlanGroupList", devDao.getWlanGroupNameList());
			return mapping.findForward("appGroupList");
		}catch(Exception e){
			logger.error("getAPGroup", e);
			throw e;
		}
	}
	
	public ActionForward deleteAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = (String)request.getParameter("sn");
			devDao.deleteAPGroupBySn(sn);
			List result = devDao.getAllAPGroup();
			request.setAttribute("result", result);
			request.setAttribute("wlanGroupList", devDao.getWlanGroupNameList());
			return mapping.findForward("appGroupList");
		}catch(Exception e){
			logger.error("deleteAPGroup", e);
			throw e;
		}
	}
	
	public ActionForward getAPGroupSeq(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String nextSeq = devDao.getNextAPGroupSeq();
			request.setAttribute("nextSeq", nextSeq);
			return mapping.findForward("addApGroup");
		}catch(Exception e){
			logger.error("getAPGroupSeq", e);
			throw e;
		}
	}
	
	public ActionForward addAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			devDao.addAPGroup(form);
			String nextSeq = devDao.getNextAPGroupSeq();
			request.setAttribute("nextSeq", nextSeq);
			return mapping.findForward("addApGroup");
		}catch(Exception e){
			logger.error("addAPGroup", e);
			throw e;
		}
	}
	
	public ActionForward updateAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = (String)request.getParameter("sn");
			String group = (String)request.getParameter("group");
			devDao.updateAPWlanGroup(sn,group);
			List result = devDao.getAllAPGroup();
			request.setAttribute("result", result);
			request.setAttribute("wlanGroupList", devDao.getWlanGroupNameList());
			return mapping.findForward("appGroupList");
		}catch(Exception e){
			logger.error("updateAPGroup", e);
			throw e;
		}
	}
	
	public ActionForward getWlanGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			List result = devDao.getAllWlanGroup();
			request.setAttribute("result", result);
			return mapping.findForward("wlanGroupList");
		}catch(Exception e){
			logger.error("getWlanGroup", e);
			throw e;
		}
	}
	
	public ActionForward getWlanGroupSeq(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String nextSeq = devDao.getNextWlanGroupSeq();
			request.setAttribute("nextSeq", nextSeq);
			return mapping.findForward("addWlanGroup");
		}catch(Exception e){
			logger.error("getWlanGroupSeq", e);
			throw e;
		}
	}
	
	public ActionForward addWlanGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			devDao.addWlanGroup(form);
			String nextSeq = devDao.getNextWlanGroupSeq();
			request.setAttribute("nextSeq", nextSeq);
			return mapping.findForward("addWlanGroup");
		}catch(Exception e){
			logger.error("addWlanGroup", e);
			throw e;
		}
	}
	
	public ActionForward deleteWlanGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String sn = (String)request.getParameter("sn");
			devDao.deleteWlanGroupBySn(sn);
			List result = devDao.getAllWlanGroup();
			request.setAttribute("result", result);
			return mapping.findForward("wlanGroupList");
		}catch(Exception e){
			logger.error("deleteWlanGroup", e);
			throw e;
		}
	}
	
	public ActionForward getAllWlans(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_5_2",request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_5_2"));
			List result = devDao.getAllWlanList();
			request.setAttribute("result", result);
			return mapping.findForward("wlanList");
		}catch(Exception e){
			logger.error("getAllWlans", e);
			throw e;
		}
	}
	
	public ActionForward getAllWlanSecurities(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			if(request.getParameter("selectCols") != null)
				setColomnList("CATE_6_1",request.getParameter("selectCols"));
			request.setAttribute("fieldInfo", getColomnList("CATE_6_1"));
			List result = devDao.getAllWlanSecurityList();
			request.setAttribute("result", result);
			return mapping.findForward("wlanSecurityList");
		}catch(Exception e){
			logger.error("getAllWlanSecurities", e);
			throw e;
		}
	}
	
	public ActionForward initChangeAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String devSn = (String)request.getParameter("devSn");
			DeviceVO vo = devDao.getDeviceBySn(devSn);
			request.setAttribute("sn", devSn);
			request.setAttribute("name", vo.getDevName());
			request.setAttribute("group", vo.getDevGroup());
			List apGroupList = devDao.getAPGroupNameList();
			request.setAttribute("apGroupList", apGroupList);
			return mapping.findForward("changeApGroup");
		}catch(Exception e){
			logger.error("getInitChangeAPGroup", e);
			throw e;
		}
	}
	
	public ActionForward changeAPGroup(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			DashBoardForm form = (DashBoardForm)actionForm;
			String sn = form.getSn();
			String apGroup = form.getApGroup();
			devDao.changeAPGroup(sn,apGroup);
			DeviceVO vo = devDao.getDeviceBySn(sn);
			request.setAttribute("sn", sn);
			request.setAttribute("name", vo.getDevName());
			request.setAttribute("group", vo.getDevGroup());
			List apGroupList = devDao.getAPGroupNameList();
			request.setAttribute("apGroupList", apGroupList);
			return mapping.findForward("changeApGroup");
		}catch(Exception e){
			logger.error("changeAPGroup", e);
			throw e;
		}
	}
	
}
