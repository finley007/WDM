<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%String flag=(String)request.getAttribute("flag");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr id="table_region">
		<td valign="top">
			<%List result=(List)request.getAttribute("result");	if(result!=null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td class="tableContainer" width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result" id="AA"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDeviceAlerts"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="CPE设备告警日志" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>   
								<ec:column property="delete" title="删除告警" >
									<input type="button" class="formButton" value="删除告警" 
										onclick="deleteDeviceAlert('${inss.Dev_Trap_Sn}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<%if(flag != null) {%>
							<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="返回"
								onclick="javascript:history.back(-1);"> </span></div>
						<%}%>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
<script>
		var menuList = {menuList:
					[{menuName:"告警时间",menuclass:"Dev_Trap_Log_Time"},
					 {menuName:"设备IP地址",menuclass:"Dev_Trap_IP_Addr"}]};
					 
		$("#table_region").RightMenu('myMenu','table_region','submit()',menuList);
 		
	 	$("#myMenu").css({"width":"100px"});
	 	
	 	getNameLength(menuList["menuList"]);
 
		function submit(){
			var selectCol = "";
			$("#myMenu ul li input.checkbox").each(function() { 
				  if(this.checked)
					selectCol += this.name+"|";
			}); 
		 	if(selectCol != ""){
		 		refreshColomn(selectCol);
		 		$("#myMenu").hide();
		 	}else{
		 		alert("请至少选择一列!!");
		 	}
		}
		
		function getNameLength(menuList){
			var maxLength = 0;
			for(var index in menuList){
				if(maxLength < menuList[index]["menuName"].length)
					maxLength = menuList[index]["menuName"].length;
			}
			if(maxLength < 4){
				$("#myMenu").css({"width":"100px"});
			}else{
				var width = maxLength * 15 + 40;
				$("#myMenu").css({"width":width + "px"});
			}
		}
		
		function refreshColomn(selectCol){
			var url="<%=contextPath%>/DashBoard.do?method=getAllDeviceAlerts&selectCol="+selectCol;
 			this.location = url;
		}
		
		function deleteDeviceAlert(alertSn){
			if(confirm("确认删除?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteDeviceAlert&alertSn="+alertSn;
 				this.location = url;
 			}
		}	
		
		function deleteDeviceAlert(alertSn){
			alert("aa");
			//if(confirm("确认删除?")){
 			//	var url="<%=contextPath%>/DashBoard.do?method=deleteDeviceAlert&alertSn="+alertSn;
 			//	this.location = url;
 			//}
		}
	</script>	
</html>