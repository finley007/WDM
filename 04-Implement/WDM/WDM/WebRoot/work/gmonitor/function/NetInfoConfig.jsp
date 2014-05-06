<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%DeviceVO devInfo = (DeviceVO)request.getAttribute("result");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/DashBoard.do?method=getDeviceDetail">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">网络设置</td></tr></table>
							<table width="100%">
								<tr>
								  <td class="item" width="200px">设备IP地址类型</td>
								  <td class="value">
								  	<select name="channel" value="<%=devInfo.getDevIpassign()%>" disabled="disabled">
								  		<option value="0">静态设置</option>
								  		<option value="1">动态设置</option>
									</select>
								  </td>
								</tr>
								<tr width="100%">
								  <td class="item" width="200px">设备IP地址</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevIpaddress()%>" width="200"></td>
								</tr>   
								<tr>
								  <td class="item" width="200px">设备子网掩码</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevSubnet()%>" width="200"></td>
								</tr>
								<tr width="100%">
								  <td class="item" width="200px">设备网关地址</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevGateway()%>" width="200"></td>
								</tr> 
								<tr width="100%">
								  <td class="item" width="200px">设备DNS1</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevDns1()%>" width="200"></td>
								</tr> 
								<tr width="100%">
								  <td class="item" width="200px">设备DNS2</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevDns2()%>" width="200"></td>
								</tr> 
								<tr width="100%">
								  <td class="item" width="200px">AP管理IP地址</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=devInfo.getDevIpassign()%>" width="200">
								  	(XXX.XXX.XXX.XXX)</td>
								</tr> 
							</table>
							<div class="bottomButtons" style="margin-top:20px;" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="返回"
								onclick="javascript:history.back(-1);"> </span></div>
						</td>
					</tr>
				</table>
			</td>
		</html:form>
	</tr>
</table>
<script>
	$("#main").height(document.body.clientHeight);
</script>
</html>