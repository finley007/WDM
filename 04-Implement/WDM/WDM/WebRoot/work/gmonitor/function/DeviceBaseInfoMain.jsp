<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%String flag=(String)request.getAttribute("flag");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
 		function showDeviceDetail(devSn){
 			var url="<%=contextPath%>/DashBoard.do?method=getDeviceDetail&devSn="+devSn;
 			this.location = url;
		}	
		
		function deleteDevice(devSn){
			if(confirm("确认删除?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteDevice&devSn="+devSn;
 				this.location = url;
 			}
		}	
	</script>	
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<td valign="top">
			<%List result=(List)request.getAttribute("result");	if(result!=null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDevices"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="CPE设备信息" filterable="true" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:column property="Dev_MAC" title="设备MAC地址" />
								<ec:column property="Dev_Ipaddress" title="设备IP地址" />
								<ec:column property="Dev_Wlan1_Bssid" title="关联BSSID" />
								<ec:column property="Dev_Wlan1_Ssid" title="关联SSID"/>
								<ec:column property="channel" title="信道" 
									filterCell="org.extremecomponents.table.cell.FilterDroplistCell"/>
								<ec:column property="status" title="在线状态"  
									filterCell="org.extremecomponents.table.cell.FilterDroplistCell"/>
								<ec:column property="Dev_OnlineTime" title="运行时间" />
								<ec:column property="version" title="软件版本" />
								<ec:column property="detail" title="详细信息" >
									<input type="button" class="formButton" value="详细信息" 
										onclick="showDeviceDetail('${inss.Dev_Sn}')"/>
								</ec:column>
								<ec:column property="delete" title="删除设备" >
									<input type="button" class="formButton" value="删除设备" 
										onclick="deleteDevice('${inss.Dev_Sn}')"/>
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
</html>