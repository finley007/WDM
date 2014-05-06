<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	WlanForm wlanInfo = (WlanForm)request.getAttribute("result");
	String flag = (String)request.getAttribute("flag");//ADD-�½���EDIT-�༭
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		$(document).ready(function(){
		  $("select[name=securityMode]").val('<%=wlanInfo.getSecurityMode()%>');
		  if($("select[name=securityMode]").val() == '2')
		  	$("select[name=securityPolicy]").prepend("<option value='DefaultSecurityPolicy'>DefaultSecurityPolicy</option>"); 
		  else
		  	$("select[name=securityPolicy] option:last").remove();
		  $("select[name=securityPolicy]").val('<%=wlanInfo.getSecurityPolicy()%>');
		  $("select[name=broadcastSsid]").val('<%=wlanInfo.getBroadcastSsid()%>');
		  $("select[name=qos]").val('<%=wlanInfo.getQos()%>');
		  $("select[name=macFilter]").val('<%=wlanInfo.getMacFilter()%>');
		  $("select[name=flowControlMode]").val('<%=wlanInfo.getFlowControlMode()%>');
		  $("select[name=securityMode]").change(function(){ 
		  	if($(this).val() == '2') 
		  		$("select[name=securityPolicy]").prepend("<option value='DefaultSecurityPolicy'>DefaultSecurityPolicy</option>"); 
		  	else
		  		$("select[name=securityPolicy] option:last").remove();
		  });  
		});
		
		function doSubmit(){	
			if(!testRegExp("apgroup",document.getElementById("wlanName").value)){
				alert("AP������������Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�");
				return false;
			}else if(trim(document.getElementById("ssid").value) === ""){
				alert("������SSID");
				return false;
			}else if(trim(document.getElementById("vlanId").value) === ""){
				alert("������VLAN ID");
				return false;
			}else if(!testRegExp("number",document.getElementById("maxUser").value)){
				alert("������Ϸ�������û���");
				return false;
			}else if(document.getElementById("flowControlMode").value == 1){
				if(trim(document.getElementById("downSsidFlow").value) === ""){
					alert("����������SSID��������");
					return false;
				}else if(trim(document.getElementById("downUserFlow").value) === ""){
					alert("�����������û���������");
					return false;
				}else if(trim(document.getElementById("upSsidFlow").value) === ""){
					alert("����������SSID��������");
					return false;
				}else if(trim(document.getElementById("upUserFlow").value) === ""){
					alert("�����������û���������");
					return false;
				}
			}
			return true;
		}	
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getAllWlans";
			this.location = url;
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
		<html:form action="/Wlan.do?method=addWlan" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">
									<%if(flag.equals("ADD")) out.println(WDMResourceConstants.ACTION_NEW);
										else out.println(WDMResourceConstants.ACTION_EDIT);%>WLAN</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">WLAN���</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" name="sn" 
								  		value="<%=wlanInfo.getSn()%>" width="200"> ϵͳ�Զ�����</td>
								</tr>   
								<tr>
								  <td class="item" width="200px">WLAN����</td>
								  <td class="value"><input class="value_text" type="text" name="wlanName" 
								  		value="<%=wlanInfo.getWlanName()%>" width="200"> Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�</td>
								</tr>
								<tr>
								  <td class="item" width="200px">��ȫģʽ</td>
								  <td class="value">
								  	<select name="securityMode" value="<%=wlanInfo.getSecurityMode()%>">
								  		<option value="0">OPEN</option>
								  		<option value="1">WEP</option>
								  		<option value="2">802.11i</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">��ȫ����</td>
								  <td class="value">
								  	<select name="securityPolicy" value="<%=wlanInfo.getSecurityPolicy()%>">
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">SSID</td>
								  <td class="value"><input class="value_text" type="text" name="ssid" 
								  		value="<%=wlanInfo.getSsid()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">�㲥SSID</td>
								  <td class="value">
								  	<select name="broadcastSsid" value="<%=wlanInfo.getBroadcastSsid()%>">
								  		<option value="1">�㲥</option>
								  		<option value="0">���㲥</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">VLAN ID</td>
								  <td class="value"><input class="value_text" type="text" name="vlanId" 
								  		value="<%=wlanInfo.getVlanId()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">QOS</td>
								  <td class="value">
								  	<select name="qos" value="<%=wlanInfo.getQos()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">����û���</td>
								  <td class="value"><input class="value_text" type="text" name="maxUser" 
								  		value="<%=wlanInfo.getMaxUser()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">MAC��ַ����</td>
								  <td class="value">
								  	<select name="macFilter" value="<%=wlanInfo.getMacFilter()%>">
								  		<option value="0">OPEN</option>
								  		<option value="1">������</option>
								  		<option value="2">������</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">�������Ʒ�ʽ</td>
								  <td class="value">
								  	<select name="flowControlMode" value="<%=wlanInfo.getFlowControlMode()%>">
								  		<option value="0">�ر�</option>
								  		<option value="1">�̶�����</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">����SSID��������</td>
								  <td class="value"><input class="value_text" type="text" name="downSsidFlow" 
								  		value="<%=wlanInfo.getDownSsidFlow()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">�����û���������</td>
								  <td class="value"><input class="value_text" type="text" name="downUserFlow" 
								  		value="<%=wlanInfo.getDownUserFlow()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">����SSID��������</td>
								  <td class="value"><input class="value_text" type="text" name="upSsidFlow" 
								  		value="<%=wlanInfo.getUpSsidFlow()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">�����û���������</td>
								  <td class="value"><input class="value_text" type="text" name="upUserFlow" 
								  		value="<%=wlanInfo.getUpUserFlow()%>" width="200"></td>
								</tr>
								<input type="hidden" name="action" value="<%=flag%>">
							</table>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="����"
								onclick="returnBack()"> </span></div>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="submit" class="formButton" name="submit" value="ȷ��"></span></div>
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