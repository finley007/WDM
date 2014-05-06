package com.wdm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wdm.dao.FuncDao;


public class BaseAction extends org.apache.struts.actions.DispatchAction {
	
	//ApplicationContext appContext;
	private static ApplicationContext appContext;
	protected final Log logger = LogFactory.getLog(getClass());
	
    public static Object getBean(String manager) {
    	if(null == appContext){
    		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	}
        return appContext.getBean(manager);
    }
    
    /**
     * Gets the dynaActionForward attribute of the PostCardBaseAction object
     * @param mapping     Description of the Parameter
     * @param forwardName Description of the Parameter
     * @param qry         Description of the Parameter
     * @return The dynaActionForward value
     */
    protected ActionForward getDynaActionForward(ActionMapping mapping, String forwardName, String qry) {
        ActionForward af = new ActionForward();
        StringBuffer path = new StringBuffer();
        path.append(mapping.findForward(forwardName).getPath());
        if ((mapping.findForward(forwardName).getPath().indexOf("?") < 0) && (qry.indexOf("?") < 0)) {
            path.append("?");
            path.append(qry + "&timeStamp=" + System.currentTimeMillis());
        }else if (mapping.findForward(forwardName).getPath().indexOf("?") > 0) {
            path.append("&" + qry + "&timeStamp=" + System.currentTimeMillis());
        }else {
            path.append(qry + "&timeStamp=" + System.currentTimeMillis());
        }
        af.setPath(path.toString());
        return af;
    }
    
    protected List getColomnList(String appId){
		try{
			FuncDao funDao = (FuncDao)getBean("funcDao");
			return funDao.getColomnList(appId);
		}catch(Exception e){
			logger.error("getColomnList",e);
		}
		return new ArrayList();
	}
    
    protected void setColomnList(String appId,String colList){
    	try{
			FuncDao funDao = (FuncDao)getBean("funcDao");
			funDao.setColomnList(appId,colList);
		}catch(Exception e){
			logger.error("getColomnList",e);
		}
    }
  
}
