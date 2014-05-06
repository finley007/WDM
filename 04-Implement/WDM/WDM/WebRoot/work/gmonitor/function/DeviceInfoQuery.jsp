<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%DashBoardForm form = (DashBoardForm)request.getAttribute("dashBoardForm");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function doSubmit(){	
			var conditionSelected = false;
			if(document.getElementById("isSn").checked){
				conditionSelected = true;
				if(document.getElementById("sn").value == ""){
					alert("�������豸���к�");
					return false;
				}
			}else if(document.getElementById("isMac").checked){
				conditionSelected = true;
				if(document.getElementById("mac").value == ""){
					alert("�������豸MAC��ַ");
					return false;
				}else if(!testRegExp("mac",document.getElementById("mac").value)){
					alert("������Ϸ���MAC��ַ");
					return false;
				}
			}else if(document.getElementById("isIp").checked){
				conditionSelected = true;
				if(document.getElementById("ip").value == ""){
					alert("�������豸IP��ַ");
					return false;
				}else if(!testRegExp("ip",document.getElementById("ip").value)){
					alert("������Ϸ���IP��ַ");
					return false;
				}
			}else if(document.getElementById("isChannel").checked)
				conditionSelected = true;
			else if(document.getElementById("isStatus").checked)
				conditionSelected = true;
			else
				conditionSelected = false;
			if(conditionSelected)
				return true;
			else{
				alert("������ѡ��һ����ѯ����");
				return false;
			}
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
			font-size: 14px;
			padding-left: 5px;
		}
		.value_text{
			width : 400;
			font-size: 14px;
		}
	</style>
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/DashBoard.do?method=deviceQuery" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">�豸��Ϣ��ѯ</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">ѡ�����豸���кŲ�ѯ<input type="checkbox" name="isSn"/></td>
								  <td class="value"><input class="value_text" type="text" name="sn" width="200"></td>
								</tr>   
								<tr>
								  <td class="item" width="200px">ѡ�����豸MAC��ַ��ѯ<input type="checkbox" name="isMac"/></td>
								  <td class="value"><input class="value_text" class="item" type="text" name="mac" width="50%">
								  	(XX.XX.XX.XX.XX.XX)</td>
								</tr>
								<tr>
								  <td class="item" width="200px">ѡ�����豸IP��ַ��ѯ<input type="checkbox" name="isIp"/></td>
								  <td class="value"><input class="value_text" class="item" type="text" name="ip" width="50%">
								  	(0.0.0.0-255.255.255.255)</td>
								</tr>
								<tr>
								  <td class="item" width="200px">ѡ�����豸�����ŵ���ѯ<input type="checkbox" name="isChannel"/></td>
								  <td class="value">
								  	<select name="channel" value="<%=form.getChannel()%>">
								  		<%List channelList=(List)request.getAttribute("channelList");	
								  		  if(channelList!=null){
								  		  		for(int i=0;i<channelList.size();i++) {
								  		  			Map map=(Map)channelList.get(i); %>
													<option value="<%=WDMCommonUtil.getMapStringValue(map,"name")%>">
														<%=WDMCommonUtil.getMapStringValue(map,"label")%></option>
										<%}}%>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">ѡ�����豸����״̬��ѯ<input type="checkbox" name="isStatus"/></td>
								  <td class="value">
								  	<select name="status" value="<%=form.getStatus()%>">
								  		<%List statusList=(List)request.getAttribute("statusList");	
								  		  if(statusList!=null){
								  		  		for(int i=0;i<statusList.size();i++) {
								  		  			Map map=(Map)statusList.get(i); %>
													<option value="<%=WDMCommonUtil.getMapStringValue(map,"name")%>">
														<%=WDMCommonUtil.getMapStringValue(map,"label")%></option>
										<%}}%>
									</select>
								  </td>
								</tr>
							</table>
							<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="submit" class="formButton" name="query" value="��ѯ"></span></div>
						</td>
					</tr>
				</table>
			</td>
		</html:form>
	</tr>
</table>
</html>