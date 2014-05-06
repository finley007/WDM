<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%DeviceVO result=(DeviceVO)request.getAttribute("result");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
 		function refresh(){
 			var url="<%=contextPath%>/DashBoard.do?method=getDeviceDetail&devSn=<%=result.getDevSn()%>";
 			this.location = url;
		}		
	</script>	
	<style>
		 .title {
			color: #444444;
			font-weight: bold;
			font-family: verdana, arial, helvetica, sans-serif;
			font-size: 12px;
			vertical-align: middle;
		}
		
		table{
			border-collapse:collapse;
		}
		
		td{
			border:solid 1px #C0C0C0;
			height:22px;
		}
	</style>
</head>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<td valign="top">
			<%if(result!=null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<table width="100%"><tr><td class="tableHeader">设备基本信息</td></tr></table>
						<table width="100%">
							<tr width="100%">
							  <td class="title" width="20%">设备序列号</td><td class="z" width="30%"><%=result.getDevSn()%></td>
							  <td class="title" width="20%">设备型号</td><td class="z" width="30%">Row</td>
							</tr>   
							<tr>
							  <td class="title" width="20%">SNMP管理IP地址</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">系统描述</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">软件名称</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">软件版本</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">运行时间</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">联系电话</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">设备位置1</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">设备位置2</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">设备位置3</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">设备位置4</td><td class="z" width="30%">Row</td>
							</tr>
						</table>
						<table width="100%"><tr><td class="tableHeader">设备无线配置信息</td></tr></table>
						<table width="100%">
							<tr width="100%">
							  <td class="title" width="20%">连接状态</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">关联MAC地址</td><td class="z" width="30%">Row</td>
							</tr>   
							<tr>
							  <td class="title" width="20%">关联IP地址</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">连接无线网络BSSID</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">连接无线网络SSID</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">管理MAC地址</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">管理IP地址</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">管理BSSID</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">管理SSID</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">无线频半模式</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">无线信道</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">无线工作模式</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">发送包数</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">发送字节数</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">接收包数</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">接收字节数</td><td class="z" width="30%">Row</td>
							</tr>
						</table>
						<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="refresh" value="刷新信息"
								onclick="refresh()">
							<input type="button" class="formButton" name="shut" value="返回"
								onclick="javascript:history.back(-1);"> </span></div>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
</html>