<%@page contentType="text/html;charset=gb2312"%>
<%@include file="Common/CommonImport.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>无标题文档</title>
	</head>
	<body>
		<%
		    response.sendRedirect(contextPath + "/DashBoard.do?method=getAllDevices&appId=CATE_3_1");
		%>
	</body>
</html>