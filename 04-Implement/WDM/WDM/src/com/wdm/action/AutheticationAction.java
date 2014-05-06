package com.wdm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wdm.common.utils.LogUtil;
import com.wdm.common.utils.WDMCommonUtil;
import com.wdm.dao.AuthenticationDao;
import com.wdm.vo.UserVO;

public class AutheticationAction extends BaseAction {
	
	private AuthenticationDao authDao = (AuthenticationDao)getBean("authDao");
	private LogUtil logger = new LogUtil(AutheticationAction.class);

	public ActionForward login(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String userId = (String)request.getParameter("userid");
			String password = (String)request.getParameter("password");
			if("".equals(WDMCommonUtil.objToString(userId)) || "".equals(WDMCommonUtil.objToString(password))){
				request.setAttribute("loginFail",false);
				return mapping.findForward("login");
			}
			boolean isValid = authDao.isValid(userId, password);
			if(isValid){
				UserVO userVO = authDao.createUserInfo(userId);
				request.getSession().setAttribute("userVO", userVO);
				return mapping.findForward("main");
			}else{
				request.setAttribute("loginFail",false);
				return mapping.findForward("login");
			}
		}catch(Exception e){
			logger.error("login", e);
			throw e;
		}
	}
	
	public ActionForward loginOut(ActionMapping mapping,
		ActionForm actionForm, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		try{
			request.getSession().removeAttribute("userVO");
			return mapping.findForward("login");
		}catch(Exception e){
			logger.error("loginOut", e);
			throw e;
		}
	}
}