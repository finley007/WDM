<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	SystemForm form = (SystemForm)request.getAttribute("result");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function returnBack(){
			var url="<%=contextPath%>/System.do?method=getUpdateVersions";
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
		<html:form action="/System.do?method=addUpdateVersion">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">����AP�汾�ļ�</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">�ļ����</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" name="sn" 
								  		value="<%=form.getSn()%>" width="200"> ϵͳ�Զ�����</td>
								</tr>   
								<tr>
								  <td class="item" width="200px">�����ļ���</td>
								  <td class="value"><input class="value_text" type="text" name="fileName" 
								  		value="<%=form.getFileName()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">��������</td>
								  <td class="value"><input class="value_text" type="text" name="company" 
								  		value="<%=form.getCompany()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">�豸����</td>
								  <td class="value"><input class="value_text" type="text" name="devType" 
								  		value="<%=form.getDevType()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">Ӳ���汾</td>
								  <td class="value"><input class="value_text" type="text" name="hardwareVersion" 
								  		value="<%=form.getHardwareVersion()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">����������</td>
								  <td class="value"><input class="value_text" type="text" name="updateFileId" 
								  		value="<%=form.getUpdateFileId()%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">Ŀ������������</td>
								  <td class="value"><input class="value_text" type="text" name="updateFileDstId" 
								  		value="<%=form.getUpdateFileDstId()%>" width="200"></td>
								</tr>
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