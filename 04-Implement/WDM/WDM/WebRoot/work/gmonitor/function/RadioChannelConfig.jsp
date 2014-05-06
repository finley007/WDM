<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	RadioBasicForm form = (RadioBasicForm)request.getAttribute("result");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		$(document).ready(function(){
		  $("select[name = 'channelAutoAdjust']").val('<%=form.getChannelAutoAdjust()%>');
		  $("select[name = 'channelAdjustMode']").val('<%=form.getChannelAdjustMode()%>');
		});
		
		function doSubmit(){	
		    var channelAdjustInterval = parseInt(document.getElementById("channelAdjustInterval").value);
			if(isNaN(channelAdjustInterval)){
				alert("������Ϸ��ĵ������");
				return false;
			}
			var channelAdjustMixSignal = parseInt(document.getElementById("channelAdjustMixSignal").value);
			if(isNaN(channelAdjustMixSignal)){
				alert("������Ϸ�������źű�׼");
				return false;
			}
			if(channelAdjustMixSignal < -90 || channelAdjustMixSignal > 10){
				alert("����źű�׼������-90��10֮��");
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
		<html:form action="/BasicRadio.do?method=saveChannelConfig" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">�����ŵ�����</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">Radio ID</td>
								  <td class="value">
								  	<select>
								  		<option value="1">1</option>
									</select>
								  </td>
								</tr>   
								<tr>
								  <td class="item" width="200px">�ŵ��Զ�����</td>
								  <td class="value">
								  	<select name="channelAutoAdjust" value=<%=form.getChannelAutoAdjust()%>>
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">����ģʽ</td>
								  <td class="value">
								  	<select name="channelAdjustMode" value="<%=form.getChannelAdjustMode()%>">
								  		<option value="0">����ʱ����</option>
								  		<option value="1">�����Ե���</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">�������</td>
								  <td class="value"><input class="value_text" type="text" name="channelAdjustInterval" 
								  		value="<%=form.getChannelAdjustInterval()%>" width="200"> ����</td>
								</tr>
								<tr>
								  <td class="item" width="200px">����źű�׼</td>
								  <td class="value"><input class="value_text" type="text" name="channelAdjustMixSignal" 
								  		value="<%=form.getChannelAdjustMixSignal()%>" width="200"> dbm ��Χ��-90-10</td>
								</tr>
							</table>
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