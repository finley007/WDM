<%@page pageEncoding="gb2312"%>
<% request.setCharacterEncoding("gb2312"); %>
<%@ page import="java.util.*,
                java.io.*,
			    com.wdm.dao.*,
				com.wdm.dao.impl.*,
				com.wdm.action.*,
				com.wdm.vo.*,
				com.wdm.common.*,
				com.wdm.common.utils.*,
				com.wdm.form.*,
				com.wdm.common.locale.*,
				java.sql.Timestamp"
				
%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/extremecomponents.tld" prefix="ec" %>
<%@ taglib uri="/WEB-INF/cewolf.tld" prefix="cewolf" %>
<%	String contextPath=request.getContextPath();
	String path=request.getContextPath();
	path+="/work/gmonitor";%>
<link rel="stylesheet" href="<%=path%>/Common/main.css">
<link rel="stylesheet" href="<%=path%>/Common/extremecomponents.css">
<link rel="stylesheet" href="<%=path%>/Common/rico.css">
<link rel="stylesheet" href="<%=path%>/Common/colomn.css">
<script type="text/javascript" src="<%=path%>/javascript/common.js"></script>
<script type="text/javascript" src="<%=path%>/javascript/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/javascript/dojo/dojo.js"></script>
<script type="text/javascript" src="<%=path%>/javascript/ContextMenu.js"></script>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/AjaxAction.js"></script>
<script type="text/javascript" src="<%=contextPath%>/dwr/engine.js"></script>
<!-- May conflict with jquery -->
<!--script type="text/javascript" src="<%=contextPath%>/dwr/util.js"></script>-->
<script type="text/javascript">
        dojo.require("dojo.widget.*");
		dojo.require("dojo.widget.Dialog");
		<%if(request.getSession().getAttribute("userVO") == null){%>
			var url = top.location.toString();
			if(url.indexOf("Login.jsp") < 0 && url.indexOf("login") < 0)
				top.location = "<%=contextPath%>/index.jsp";
		<%}%>
</script>