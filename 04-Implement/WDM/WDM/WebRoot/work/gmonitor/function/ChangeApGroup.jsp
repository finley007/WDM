<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	String sn = (String)request.getAttribute("sn");
	String name = (String)request.getAttribute("name");
	String group = (String)request.getAttribute("group");
%>
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
		<html:form action="/DashBoard.do?method=changeAPGroup">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">AP分组设置</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">AP序列号</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" name="sn" 
								  		value="<%=sn%>" width="200"></td>
								</tr>   
								<tr>
								  <td class="item" width="200px">AP名称</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" 
								  		value="<%=name%>" width="200"></td>
								</tr>
								<tr>
								  <td class="item" width="200px">AP分组</td>
								  <td class="value">
								  	<select name="apGroup">
								  		<%List apGroupList = (List)request.getAttribute("apGroupList");	
								  		  if(apGroupList!=null){
								  		  		for(int i = 0;i < apGroupList.size();i++) {
								  		  			String grp = (String)apGroupList.get(i); %>
													<option value="<%=grp%>"><%=grp%></option>
										<%}}%>
									</select>
								  </td>
								</tr>
							</table>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="返回"
								onclick="returnBack()"> </span></div>
							<div class="bottomButtons" style="float: right; margin-top: 20px;"><span class="formButtons">
							<input type="submit" class="formButton" name="submit" value="确定"></span></div>
						</td>
					</tr>
				</table>
			</td>
		</html:form>
	</tr>
</table>
<script type="text/javascript">
	$(document).ready(function(){
	  $("select").val('<%=group%>');
	});
	
	function returnBack(){
		var url="<%=contextPath%>/DashBoard.do?method=getAllDevices&appId=CATE_4_1";
		this.location = url;
	}
	$("#main").height(document.body.clientHeight);
</script>
</html>