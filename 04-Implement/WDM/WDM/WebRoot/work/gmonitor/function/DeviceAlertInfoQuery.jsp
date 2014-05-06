<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%DashBoardForm form = (DashBoardForm)request.getAttribute("dashBoardForm");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function doSubmit(){	
			document.getElementById("startDate").value=dojo.widget.byId("dojo_startDate").inputNode.value;
			document.getElementById("endDate").value=dojo.widget.byId("dojo_endDate").inputNode.value;
			var conditionSelected = false;
			if(document.getElementById("isDate").checked){
				conditionSelected = true;
				if(document.getElementById("startDate").value == "" 
					&& document.getElementById("endDate").value == ""){
					alert("请至少选择起始时间或者结束时间");
					return false;
				}
			}else if(document.getElementById("isIp").checked){
				conditionSelected = true;
				if(document.getElementById("ip").value == ""){
					alert("请输入设备IP地址");
					return false;
				}else if(!testRegExp("ip",document.getElementById("ip").value)){
					alert("请输入合法的IP地址");
					return false;
				}
			}
			if(conditionSelected)
				return true;
			else{
				alert("请至少选择一个查询条件");
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
		<html:form action="/DashBoard.do?method=alertQuery" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">设备告警日志查询</td></tr></table>
							<table width="100%">
								<tr>
								  <td class="item" width="200px">选择按照日期范围查询<input type="checkbox" name="isDate"/></td>
								  <td class="value" width="160px" style="border-right : 0px">
								  	<div><input name="startDate" type="hidden" value="">
										<div dojoType="dropdowndatepicker" widgetId="dojo_startDate"
											value="<%=form.getStartDate()%>" displayFormat="yyyy-MM-dd HH:mm:ss"/></div>
									  	&nbsp;-
								  </td>
								  <td class="value" width="780px" style="border-left : 0px ; padding-left : 0px">
								  	<div><input name="endDate" type="hidden" value="">
										<div dojoType="dropdowndatepicker" widgetId="dojo_endDate"
											value="<%=form.getEndDate()%>" displayFormat="yyyy-MM-dd HH:mm:ss"/></div>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">选择按照设备IP地址查询<input type="checkbox" name="isIp"/></td>
								  <td colspan="2" class="value"><input class="value_text" class="item" type="text" name="ip">
								  	(0.0.0.0-255.255.255.255)</td>
								</tr>
							</table>
							<div class="bottomButtons" align="right"><span class="formButtons">
							<input type="submit" class="formButton" name="query" value="查询"></span></div>
						</td>
					</tr>
				</table>
			</td>
		</html:form>
	</tr>
</table>
</html>