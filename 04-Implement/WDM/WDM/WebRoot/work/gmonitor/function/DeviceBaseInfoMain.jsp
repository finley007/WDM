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
			if(confirm("ȷ��ɾ��?")){
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
							title="CPE�豸��Ϣ" filterable="true" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:column property="Dev_MAC" title="�豸MAC��ַ" />
								<ec:column property="Dev_Ipaddress" title="�豸IP��ַ" />
								<ec:column property="Dev_Wlan1_Bssid" title="����BSSID" />
								<ec:column property="Dev_Wlan1_Ssid" title="����SSID"/>
								<ec:column property="channel" title="�ŵ�" 
									filterCell="org.extremecomponents.table.cell.FilterDroplistCell"/>
								<ec:column property="status" title="����״̬"  
									filterCell="org.extremecomponents.table.cell.FilterDroplistCell"/>
								<ec:column property="Dev_OnlineTime" title="����ʱ��" />
								<ec:column property="version" title="����汾" />
								<ec:column property="detail" title="��ϸ��Ϣ" >
									<input type="button" class="formButton" value="��ϸ��Ϣ" 
										onclick="showDeviceDetail('${inss.Dev_Sn}')"/>
								</ec:column>
								<ec:column property="delete" title="ɾ���豸" >
									<input type="button" class="formButton" value="ɾ���豸" 
										onclick="deleteDevice('${inss.Dev_Sn}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<%if(flag != null) {%>
							<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="����"
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