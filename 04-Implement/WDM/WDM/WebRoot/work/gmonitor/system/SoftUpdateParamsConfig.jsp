<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%SystemForm form = (SystemForm)request.getAttribute("systemForm");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		$(document).ready(function(){
			$("select[name = 'fileType']").val('<%=form.getFileType()%>');
			$("select[name = 'transProtocal']").val('<%=form.getTransProtocal()%>');
		});
		
		function doSubmit(){	
			var heartBeatInterval = parseInt(document.getElementById("heartBeatInterval").value);
			if(isNaN(heartBeatInterval)){
				alert("请输入合法的SNMP心跳间隔时间");
				return false;
			}
			if(heartBeatInterval < 30 || heartBeatInterval > 540){
				alert("SNMP心跳间隔时间必须在30到540秒之间");
				return false;
			}
			var discoveryInterval = parseInt(document.getElementById("discoveryInterval").value);
			if(isNaN(discoveryInterval)){
				alert("请输入合法的AP Discovery包间隔");
				return false;
			}
			if(discoveryInterval < 5 || discoveryInterval > 9){
				alert("AP Discovery包间隔必须在5到9分钟之间");
				return false;
			}
			var defaultRefreshTime = parseInt(document.getElementById("defaultRefreshTime").value);
			if(isNaN(defaultRefreshTime)){
				alert("请输入合法的AP页面显示刷新间隔");
				return false;
			}
			if(defaultRefreshTime < 1 || defaultRefreshTime > 3600){
				alert("AP页面显示刷新间隔必须在1到3600秒之间");
				return false;
			}
			if(document.getElementById("serverAddr").value == ""){
				alert("请输入NTP服务器地址");
				return false;
			}else if(!testRegExp("ip",document.getElementById("serverAddr").value)){
				alert("请输入合法的NTP服务器地址");
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
			padding-left: 5px;
			font-size: 12px;
		}
		.value_text{
			width : 400;
			font-size: 14px;
		}
	</style>
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/System.do?method=saveSoftUpdateParamsConfig">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">软件升级参数设置</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">升级文件类型</td>
								  <td class="value">
								  	<select name="fileType" value="<%=form.getFileType()%>">
								  		<option value="1">Software</option>
									</select>
								  </td>
								</tr>   
								<tr>
								  <td class="item" width="200px">传输协议</td>
								   <td class="value">
								  	<select name="transProtocal" value="<%=form.getTransProtocal()%>">
								  		<option value="0">FTP</option>
								  		<option value="1">TFTP</option>
								  		<option value="2">HTTP</option>
								  		<option value="3">HTTPS</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">服务器IP地址</td>
								  <td class="value"><input class="value_text" type="text" name="serverAddr" 
								  	value="<%=form.getServerAddr()%>"width="50%">  (XXX.XXX.XXX.XXX)</td>
								</tr>
								<tr>
								  <td class="item" width="200px">服务器端口</td>
								  <td class="value"><input class="value_text" type="text" name="serverPort" 
								  	value="<%=form.getServerPort()%>" width="50%"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">服务器用户名</td>
								  <td class="value"><input class="value_text" type="text" name="serverUsername" 
								  	value="<%=form.getServerUsername()%>" width="50%"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">服务器密码</td>
								  <td class="value"><input class="value_text" type="password" name="serverPassword" 
								  	value="<%=form.getServerPassword()%>" width="50%"></td>
								</tr>
							</table>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="submit" class="formButton" name="confirm" value="确定"></span></div>
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