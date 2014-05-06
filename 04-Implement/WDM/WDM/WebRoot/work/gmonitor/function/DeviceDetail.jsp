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
						<table width="100%"><tr><td class="tableHeader">�豸������Ϣ</td></tr></table>
						<table width="100%">
							<tr width="100%">
							  <td class="title" width="20%">�豸���к�</td><td class="z" width="30%"><%=result.getDevSn()%></td>
							  <td class="title" width="20%">�豸�ͺ�</td><td class="z" width="30%">Row</td>
							</tr>   
							<tr>
							  <td class="title" width="20%">SNMP����IP��ַ</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">ϵͳ����</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">�������</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">����汾</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">����ʱ��</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">��ϵ�绰</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">�豸λ��1</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">�豸λ��2</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">�豸λ��3</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">�豸λ��4</td><td class="z" width="30%">Row</td>
							</tr>
						</table>
						<table width="100%"><tr><td class="tableHeader">�豸����������Ϣ</td></tr></table>
						<table width="100%">
							<tr width="100%">
							  <td class="title" width="20%">����״̬</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">����MAC��ַ</td><td class="z" width="30%">Row</td>
							</tr>   
							<tr>
							  <td class="title" width="20%">����IP��ַ</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">������������BSSID</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">������������SSID</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">����MAC��ַ</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">����IP��ַ</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">����BSSID</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">����SSID</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">����Ƶ��ģʽ</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">�����ŵ�</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">���߹���ģʽ</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">���Ͱ���</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">�����ֽ���</td><td class="z" width="30%">Row</td>
							</tr>
							<tr>
							  <td class="title" width="20%">���հ���</td><td class="z" width="30%">Row</td>
							  <td class="title" width="20%">�����ֽ���</td><td class="z" width="30%">Row</td>
							</tr>
						</table>
						<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="refresh" value="ˢ����Ϣ"
								onclick="refresh()">
							<input type="button" class="formButton" name="shut" value="����"
								onclick="javascript:history.back(-1);"> </span></div>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
</html>