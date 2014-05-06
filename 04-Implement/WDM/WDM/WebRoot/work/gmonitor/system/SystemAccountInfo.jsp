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
				alert("用户名不能为空");
				return false;
			}else if(document.getElementById("password").value == ""){
				alert("密码不能为空");
				return false;
			}else if(document.getElementById("password").value != 
				document.getElementById("re_password").value){
				alert("两次密码输入不一致，请检查");
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
							<table width="100%"><tr><td class="tableHeader">系统用户信息管理</td></tr></table>
							<table width="100%">
								<input type="hidden" name="isCreate" value="<%="".equals(form.getAccount())?WDMConstants.TRUE:WDMConstants.FALSE%>">
								<tr width="100%">
								  <td class="item" width="200px">用户名</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" type="text" id="account" name="account" 
								  		value="<%=form.getAccount()%>" width="200">
								  </td>
								</tr>   
								<tr>
								  <td class="item" width="200px">密码</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" class="item" type="password" id="password" name="password" 
								  		value="<%=form.getPassword()%>" width="50%">
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">密码确认</td>
								  <td class="value" colspan="3">
								  	<input class="value_text" class="item" type="password" id="re_password" 
								  		name="re_password" value="<%=form.getPassword()%>" width="50%"></td>
								</tr>
								<tr width="100%">
								  <td class="item" width="200px">状态</td>
								  <td class="value">
								  	<select name="status" value="<%=form.getStatus()%>">
								  		<option value="1" <%if("1".equals(form.getStatus())){%>selected<%}%>>有效</option>
								  		<option value="0" <%if("0".equals(form.getStatus())){%>selected<%}%>>无效</option>
									</select>
								  </td>
								</tr> 
								<tr width="100%">
								  <td class="item" width="200px">是否管理员</td>
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
									<input type="button" class="formButton" name="shut" value="取消"
										onclick="javascript:history.back(-1);"> </span></div>
								<div style="float: right; margin-top: 20px;" class="bottomButtons"><span class="formButtons">
									<input type="submit" class="formButton" name="query" value="确认"></span></div>
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