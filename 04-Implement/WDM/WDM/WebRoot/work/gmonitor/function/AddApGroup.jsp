<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%String nextSeq = (String)request.getAttribute("nextSeq");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		function doSubmit(){	
			if(!testRegExp("apgroup",document.getElementById("apGroup").value)){
				alert("AP������������Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�");
				return false;
			}
			return true;
		}	
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getAPGroup";
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
		<html:form action="/DashBoard.do?method=addAPGroup" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">��������</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">AP����ID</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" name="sn" 
								  		value="<%=nextSeq%>" width="200"> ϵͳ�Զ�����</td>
								</tr>   
								<tr>
								  <td class="item" width="200px">AP������</td>
								  <td class="value"><input class="value_text" type="text" name="apGroup" 
								  		width="200"> Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�</td>
								</tr>
							</table>
							<div class="bottomButtons" align="right" style="float: right;margin-top: 20px;"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="����"
								onclick="returnBack()"> </span></div>
							<div class="bottomButtons" align="right" style="float: right;margin-top: 20px;"><span class="formButtons">
							<input type="submit" class="formButton" name="submit" value="ȷ��"></span></div>
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