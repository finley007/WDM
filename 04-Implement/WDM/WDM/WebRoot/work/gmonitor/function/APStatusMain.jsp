<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List colList = JSPAction.getAllColomnList("CATE_3_1");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		$(document).ready(function(){
		  $("input[status='STATUS设备下线']").each(function() { 
		  	$(this).attr('disabled','true'); 
		  });  
		});
	</script>
</head>
<body>
	<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
		<tr id="table_region">
			<td valign="top">
				<%List result=(List)request.getAttribute("result");	if(result!=null){ %>
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td class="tableContainer" width="40%" valign="top" class="tableRegion_bottom" height="500">
							<ec:table items="result" id="info"
								var="inss"
								action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDevices"
								imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
								title="AP设备信息" filterable="true" sortable="true">
								<ec:row highlightRow="true">
									<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>   
									<ec:column property="alert" title="设备日志" >
										<input type="button" class="formButton" value="设备日志" 
											onclick="getAlertInfo('${inss.Dev_Sn}')"/>
									</ec:column>
									<ec:column property="netInfo" title="网络信息" >
										<input type="button" class="formButton" value="网络信息" 
											onclick="showDeviceDetail('${inss.Dev_Sn}')"/>
									</ec:column>
									<ec:column property="userList" title="用户列表" >
										<input type="button" class="formButton" value="用户列表" 
											status="STATUS${inss.Dev_Online_Status}"
												onclick="showUserList('${inss.Dev_Sn}')"/>
									</ec:column>
									<ec:column property="flowStatistic" title="流量统计" >
										<input type="button" class="formButton" value="流量统计"
											status="STATUS${inss.Dev_Online_Status}"
												onclick="getFlowStatistic('${inss.Dev_Sn}')"/>
									</ec:column>
									<ec:column property="detailInfo" title="详细信息" >
										<input type="button" class="formButton" value="详细信息"
											status="STATUS${inss.Dev_Online_Status}"/>
									</ec:column>
								</ec:row>
							</ec:table>
						</td>
					</tr>
				</table>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script>
		var menuList = [];
		<%for(Object obj:colList){
			AppColVO vo = (AppColVO)obj;
			%>
				var item = new Object;
				item["menuName"] = <%="\" "+vo.getColName()+"\""%>;
				item["menuclass"] = <%="\""+vo.getColId()+"\""%>;
				menuList.push(item);
			<%
		  }
		%>
		var menu = {menuList:menuList};
		$("#table_region").RightMenu('myMenu','table_region','submit()',menu);
	 	$("#myMenu").css({"width":"100px"});
	 	getNameLength(menu["menuList"]);
	 	
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
				var length = getUnicodeLength(menuList[index]["menuName"]);
				if(maxLength < length)
					maxLength = length;
			}
			if(maxLength < 4){
				$("#myMenu").css({"width":"100px"});
			}else{
				var width = maxLength * 15 + 40;
				$("#myMenu").css({"width":width + "px"});
			}
		}
		
		function refreshColomn(selectCols){
			var url="<%=contextPath%>/DashBoard.do?method=getAllDevices&selectCols="+selectCols+"&appId=CATE_3_1";
 			this.location = url;
		}
		
		function getAlertInfo(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=getDeviceAlertsByDevice&devSn="+devSn;
			this.location = url;
		}
		
		function showDeviceDetail(devSn){
 			var url="<%=contextPath%>/DashBoard.do?method=getDeviceDetail&devSn="+devSn;
 			this.location = url;
		}
		
		function showUserList(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=getUserListByDevice&devSn="+devSn;
 			this.location = url;
		}
		
		function getFlowStatistic(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=getFlowStatisticByDevice&devSn="+devSn;
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>