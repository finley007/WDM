<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	RadioAdvancedForm form = (RadioAdvancedForm)request.getAttribute("result");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		$(document).ready(function(){
		  $("select[name = 'l2isolate']").val('<%=form.getL2isolate()%>');
		  $("select[name = 'igmpSnooping']").val('<%=form.getIgmpSnooping()%>');
		  $("select[name = 'preAuth']").val('<%=form.getPreAuth()%>');
		  $("select[name = 'roaming']").val('<%=form.getRoaming()%>');
		  if($("select[name = 'roaming']").val() == '0'){ 
	  		$("tr.roaming").attr('disabled',true);
	  		$("tr.roaming").value = "";
  		  }else{
	  		$("tr.roaming").removeAttr('disabled');
	  		$("select[name = 'sSidRoaming']").val('<%=form.getSSidRoaming()%>');
	  	  } 
	  	  $("select[name = 'eapUserOfflineDelay']").val('<%=form.getEapUserOfflineDelay()%>');
	  	  $("select[name = 'upLinkCheck']").val('<%=form.getUpLinkCheck()%>');
	  	  if($("select[name = 'upLinkCheck']").val() == '0'){ 
	  		$("select[name = 'upLinkCheckAction']").attr('disabled',true);
  			$("select[name = 'upLinkCheckAction']").value = "";
  		  }else{
	  		$("select[name = 'upLinkCheckAction']").removeAttr('disabled');
	  		$("select[name = 'upLinkCheckAction']").val('<%=form.getUpLinkCheckAction()%>');
	  	  }
		  $("select[name = 'roaming']").change(function(){ 
		  	if($(this).val() == '0'){ 
		  		$("tr.roaming").attr('disabled',true);
		  		$("tr.roaming").value = "";
		  	}else{
		  		$("tr.roaming").removeAttr('disabled');
		  	} 
		  }); 
		  $("select[name = 'upLinkCheck']").change(function(){ 
		  	if($(this).val() == '0'){ 
		  		$("select[name = 'upLinkCheckAction']").attr('disabled',true);
		  		$("select[name = 'upLinkCheckAction']").value = "";
		  	}else{
		  		$("select[name = 'upLinkCheckAction']").removeAttr('disabled');
		  	} 
		  });
		});
		
		function doSubmit(){	
		    if($("select[name = 'roaming']").val() == '1'){
				var roamingHeart = parseInt(document.getElementById("roamingHeart").value);
				if(isNaN(roamingHeart)){
					alert("������Ϸ�������̽��ʱ��");
					return false;
				}
				if(roamingHeart <= 0 || roamingHeart >= 120){
					alert("����̽��ʱ�䷶Χ������1��120��֮��");
					return false;
				}
			}
			var ntpHeart = parseInt(document.getElementById("ntpHeart").value);
			if(isNaN(ntpHeart)){
				alert("������Ϸ���NTPͬ�����");
				return false;
			}
			if(ntpHeart < 0 || ntpHeart > 1092){
				alert("NTPͬ�����������1��1092����֮��");
				return false;
			}
			if(document.getElementById("ntpServer").value == ""){
				alert("������NTP��������ַ");
				return false;
			}else if(!testRegExp("ip",document.getElementById("ntpServer").value)){
				alert("������Ϸ���NTP��������ַ");
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
		<html:form action="/AdvancedRadio.do?method=saveConfig" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">���߲����߼�����</td></tr></table>
							<table width="100%">  
								<tr>
								  <td class="item" width="200px">�������</td>
								  <td class="value">
								  	<select name="l2isolate" value=<%=form.getL2isolate()%>>
								  		<option value="0">�رն������</option>
								  		<option value="1">���뵥��</option>
								  		<option value="2">�����鲥</option>
								  		<option value="3">����㲥</option>
								  		<option value="4">��������</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">IGMP SNOOPING</td>
								  <td class="value">
								  	<select name="igmpSnooping" value="<%=form.getIgmpSnooping()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">Ԥ��֤</td>
								  <td class="value">
								  	<select name="preAuth" value="<%=form.getPreAuth()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">���ι���</td>
								  <td class="value">
								  	<select name="roaming" value="<%=form.getRoaming()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr class="roaming">
								  <td class="item" width="200px">����̽��ʱ��</td>
								  <td class="value"><input class="value_text" type="text" name="roamingHeart" 
								  		value="<%=form.getRoamingHeart()%>" width="200"> �� ��Χ��1-120</td>
								</tr>
								<tr class="roaming">
								  <td class="item" width="200px">SSID�����л���ֹ</td>
								  <td class="value">
								  	<select name="sSidRoaming" value="<%=form.getSSidRoaming()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">EAP��֤�û�������ʱ����</td>
								  <td class="value">
								  	<select name="eapUserOfflineDelay" value="<%=form.getEapUserOfflineDelay()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">������·�����Լ��</td>
								  <td class="value">
								  	<select name="upLinkCheck" value="<%=form.getUpLinkCheck()%>">
								  		<option value="1">����</option>
								  		<option value="0">�ر�</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">����</td>
								  <td class="value">
								  	<select name="upLinkCheckAction" value="<%=form.getUpLinkCheckAction()%>">
								  		<option value="0">�ر���Ƶ</option>
								  		<option value="1">����</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">NTP��������ַ</td>
								  <td class="value"><input class="value_text" type="text" name="ntpServer" 
								  		value="<%=form.getNtpServer()%>" width="200"> (XXX.XXX.XXX.XXX)</td> 
								</tr>
								<tr>
								  <td class="item" width="200px">NTPͬ�����</td>
								  <td class="value"><input class="value_text" type="text" name="ntpHeart" 
								  		value="<%=form.getNtpHeart()%>" width="200"> ���� ��Χ��1-1092</td>
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