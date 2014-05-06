<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%DashBoardForm form = (DashBoardForm)request.getAttribute("dashBoardForm");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function doSubmit(){	
			var a1 = document.getElementById("a1").value;
			var a2 = document.getElementById("a2").value;
			var a3 = document.getElementById("a3").value;
			var a4 = document.getElementById("a4").value;
			var b1 = document.getElementById("b1").value;
			var b2 = document.getElementById("b2").value;
			var b3 = document.getElementById("b3").value;
			var b4 = document.getElementById("b4").value;
			var ip1 = trim(a1) + "." + trim(a2) + "." + trim(a3) + "." + trim(a4);
			var ip2 = trim(b1) + "." + trim(b2) + "." + trim(b3) + "." + trim(b4);
			if(!testRegExp("ip",ip1) || !testRegExp("ip",ip2)){
				alert("请输入合法的IP地址范围");
				return false;
			}else{
				document.getElementById("startIp").value = ip1;
				document.getElementById("endIp").value = ip2;
				return true;
			}
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
			width : 40px;
			font-size: 14px;
		}
	</style>
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<html:form action="/DashBoard.do?method=ipDetect" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">AP设备探测</td></tr></table>
							<table width="100%">
								<tr>
								  <td class="item" width="200px">探测AP设备IP地址范围</td>
								  <input name="startIp" type="hidden" value="">
								  <input name="endIp" type="hidden" value="">
								  <td class="value">
								  	<input id="a1" class="value_text" type="text">&nbsp;.
								  	<input id="a2" class="value_text" type="text">&nbsp;.
								  	<input id="a3" class="value_text" type="text">&nbsp;.
								  	<input id="a4" class="value_text" type="text">&nbsp;-
								  	<input id="b1" class="value_text" type="text">&nbsp;.
								  	<input id="b2" class="value_text" type="text">&nbsp;.
								  	<input id="b3" class="value_text" type="text">&nbsp;.
								  	<input id="b4" class="value_text" type="text">&nbsp;
								  </td>
								</tr>
							</table>
							<div class="bottomButtons" style="margin-top:20px;" align="right"><span class="formButtons">
								<input type="submit" class="formButton" name="query" value="探测设备"></span></div>
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