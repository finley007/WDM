<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%SystemForm form = (SystemForm)request.getAttribute("result");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		$(document).ready(function(){
		  $("select[name = 'defaultApGroup']").val('<%=form.getDefaultApGroup()%>');
		});
		
		function doSubmit(){	
			var heartBeatInterval = parseInt(document.getElementById("heartBeatInterval").value);
			if(isNaN(heartBeatInterval)){
				alert("������Ϸ���SNMP�������ʱ��");
				return false;
			}
			if(heartBeatInterval < 30 || heartBeatInterval > 540){
				alert("SNMP�������ʱ�������30��540��֮��");
				return false;
			}
			var discoveryInterval = parseInt(document.getElementById("discoveryInterval").value);
			if(isNaN(discoveryInterval)){
				alert("������Ϸ���AP Discovery�����");
				return false;
			}
			if(discoveryInterval < 5 || discoveryInterval > 9){
				alert("AP Discovery�����������5��9����֮��");
				return false;
			}
			var defaultRefreshTime = parseInt(document.getElementById("defaultRefreshTime").value);
			if(isNaN(defaultRefreshTime)){
				alert("������Ϸ���APҳ����ʾˢ�¼��");
				return false;
			}
			if(defaultRefreshTime < 1 || defaultRefreshTime > 3600){
				alert("APҳ����ʾˢ�¼��������1��3600��֮��");
				return false;
			}
			return true;
		}	
	</script>
	<style>	
		table{
			border-collapse:collapse;
		}
		td{
			border:solid 1px #C0C0C0;
			height:22px;
		}
		.item{
			font-size: 12px;
			text-align: right;
			padding-right: 5px;
		}
		.value{
			font-size: 12px;
			padding-left: 5px;
		}
		.value_text{
			width : 400;
			font-size: 14px;
		}
	</style>
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/System.do?method=saveSNMPConfig">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">SNMP������������</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">SNMP�������ʱ��</td>
								  <td class="value"><input class="value_text" type="text" name="heartBeatInterval" 
								  	value="<%=form.getHeartBeatInterval()%>" width="200">
								  	�� ��Χ��30-540</td>
								</tr>   
								<tr>
								  <td class="item" width="200px">AP Discovery�����</td>
								  <td class="value"><input class="value_text" type="text" name="discoveryInterval" 
								  	value="<%=form.getDiscoveryInterval()%>" width="200">
								  	���� ��Χ��5-9</td>
								</tr>
								<tr>
								  <td class="item" width="200px">AP�Զ�����Ĭ�Ϸ���</td>
								  <td class="value">
								  	<select name="defaultApGroup" value=<%=form.getDefaultApGroup()%>>
								  		<%List apGroupList = (List)request.getAttribute("apGroupList");	
								  		  if(apGroupList!=null){
								  		  		for(int i = 0;i < apGroupList.size();i++) {
								  		  			String grp = (String)apGroupList.get(i); %>
													<option value="<%=grp%>"><%=grp%></option>
										<%}}%>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">APҳ����ʾˢ�¼��</td>
								  <td class="value"><input class="value_text" type="text" name="defaultRefreshTime" 
								  	value="<%=form.getDefaultRefreshTime()%>" width="200">
								  	�� ��Χ��1-3600</td>
								</tr>
							</table>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="submit" class="formButton" name="comfirm" value="ȷ��"></span></div>
						</td>
					</tr>
				</table>
			</td>
		</html:form>
	</tr>
</table>
<script type="text/javascript">
	$("#main").height(document.body.clientHeight);
</script>
</html>