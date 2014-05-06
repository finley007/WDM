<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%SystemForm form = (SystemForm)request.getAttribute("systemForm");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function checkboxOnclick(){
			if(document.getElementById("is_supervisor").checked == true)
				document.getElementById("is_supervisor").value = "1";
			else
				document.getElementById("is_supervisor").value = "0";
		}
		
		function doSubmit(){	
			if(document.getElementById("account").value == ""){
				alert("�û�������Ϊ��");
				return false;
			}else if(document.getElementById("password").value == ""){
				alert("���벻��Ϊ��");
				return false;
			}else if(document.getElementById("password").value != 
				document.getElementById("re_password").value){
				alert("�����������벻һ�£�����");
				return false;
			}else
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
		}
		.value_text{
			width : 400;
			font-size: 14px;
		}
	</style>
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/System.do?method=saveAccountInfo" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">ϵͳ�û���Ϣ����</td></tr></table>
							<table width="100%">
								<input type="hidden" name="isCreate" value="<%="".equals(form.getAccount())?WDMConstants.TRUE:WDMConstants.FALSE%>">
								<tr width="100%">
								  <td class="item" width="200px">�û���</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" type="text" id="account" name="account" 
								  		value="<%=form.getAccount()%>" width="200">
								  </td>
								</tr>   
								<tr>
								  <td class="item" width="200px">����</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" class="item" type="password" id="password" name="password" 
								  		value="<%=form.getPassword()%>" width="50%">
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">����ȷ��</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" class="item" type="password" id="re_password" 
								  		name="re_password" value="<%=form.getPassword()%>" width="50%"></td>
								</tr>
								<tr width="100%">
								  <td class="item" width="200px">״̬</td>
								  <td class="value">
								  	<select name="status" value="<%=form.getStatus()%>">
								  		<option value="1" <%if("1".equals(form.getStatus())){%>selected<%}%>>��Ч</option>
								  		<option value="0" <%if("0".equals(form.getStatus())){%>selected<%}%>>��Ч</option>
									</select>
								  </td>
								</tr> 
								<tr width="100%">
								  <td class="item" width="200px">�Ƿ����Ա</td>
								  <td class="value">
								  	<input id="is_supervisor" type="checkbox" name="isSupervisor"  
								  		<%if("1".equals(form.getIsSupervisor())){%>
								  			checked="true"
								  		<%}%>
								  		value="<%=form.getIsSupervisor()%>"
								  		onclick="checkboxOnclick()"/>
								  </td>								  
								</tr> 
							</table>
							<div>
								<div style="float: right; margin-top: 20px;" class="bottomButtons"><span class="formButtons">
									<input type="button" class="formButton" name="shut" value="ȡ��"
										onclick="javascript:history.back(-1);"> </span></div>
								<div style="float: right; margin-top: 20px;" class="bottomButtons"><span class="formButtons">
									<input type="submit" class="formButton" name="query" value="ȷ��"></span></div>
							</div>
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