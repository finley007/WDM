<%@page contentType="text/html;charset=gb2312"%>
<%@include file="CommonImport.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<script>
<%UserInfoDO userInfoDO=(UserInfoDO)session.getAttribute("userDo");%>

function bind_map(value){
	<%if(userInfoDO.getCityId()!=null&&userInfoDO.getCityId().equals("*")){%>
	document.getElementById("selected_localNet").value=value;
	document.getElementById("selected_serviceArea").value="*";
	if (document.getElementById("selected_hall") != null){
		document.getElementById("selected_hall").value="*";
	}
	document.getElementById("submit_Qry").click();
	<%}%>
}
</script>
</head>


<body leftmargin="0" topmargin="0" rightmargin="0">
<img src="<%=path%>/images/map.jpg" width="252" height="425" border="0" usemap="#Map">
<map name="Map">	
  <area shape="circle" coords="154,366,31" href="#" style="cursor:hand" name="ankang" onClick="bind_map(915)" >
  <area shape="circle" coords="78,345,31" href="#" style="cursor:hand" name="hanzhong" onClick="bind_map(916)">
  <area shape="circle" coords="205,316,23" href="#" style="cursor:hand" name="shangluo" onClick="bind_map(914)">
  <area shape="circle" coords="151,295,17" href="#" style="cursor:hand" name="xian" onClick="bind_map(290)">
  <area shape="circle" coords="85,280,24" href="#" style="cursor:hand" name="baoji" onClick="bind_map(917)">
  <area shape="circle" coords="133,263,16" href="#" style="cursor:hand" name="xianyang" onClick="bind_map(910)">
  <area shape="circle" coords="193,253,17" href="#" style="cursor:hand" name="weinan" onClick="bind_map(913)">
  <area shape="circle" coords="159,237,10" href="#" style="cursor:hand" name="tongchuan" onClick="bind_map(919)">
  <area shape="circle" coords="180,177,33" href="#" style="cursor:hand" name="yanan" onClick="bind_map(911)">
  <area shape="circle" coords="192,80,28" href="#" style="cursor:hand" name="yulin" onClick="bind_map(912)">
</map>
</body>
</html>
