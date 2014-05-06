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
		  $("select[name = 'sw']").val('<%=form.getSw()%>');
		  $("select[name = 'powerMode']").val('<%=form.getPowerMode()%>');
		  if($("select[name = 'powerMode']").val() == '1'){ 
		  	$("select[name = 'powerPer']").attr('disabled',true);
		  	$("select[name = 'powerPer']").value = "";
		  }else{
		  	$("select[name = 'powerPer']").removeAttr('disabled');
		  	$("select[name = 'powerPer']").val('<%=form.getPowerPer()%>');
		  } 
		  $("select[name = 'mode']").val('<%=form.getMode()%>');
		  if($("select[name = 'mode']").val() == '2' || $("select[name = 'mode']").val() == '4'){ 
	  		$("tr.11n").attr('disabled',true);
	  		$("tr.11n").value = "";
	  		$("select[name = 'rate']").removeAttr('disabled');
	  		AjaxAction.loadBasicRadioRate(addRateList,$("select[name = 'mode']").val());
	  	  }else{
	  		$("tr.11n").removeAttr('disabled');
	  		$("select[name = 'rate']").attr('disabled',true);
	  		$("select[name = 'rate']").value = "";
	  	  } 
	  	  $("select[name = 'rate11n']").val('<%=form.getRate11n()%>');
	  	  $("select[name = 'rxTxFlow']").val('<%=form.getRxTxFlow()%>');
	  	  $("select[name = 'bw']").val('<%=form.getBw()%>');
	  	  $("select[name = 'shortGI']").val('<%=form.getShortGI()%>');
	  	  $("select[name = 'ampDU']").val('<%=form.getAmpDU()%>');
	  	  $("select[name = 'amsDU']").val('<%=form.getAmsDU()%>');
	  	  $("select[name = 'workMode11n']").val('<%=form.getWorkMode11n()%>');
		  $("select[name = 'powerMode']").change(function(){ 
		  	if($(this).val() == '1'){ 
		  		$("select[name = 'powerPer']").attr('disabled',true);
		  		$("select[name = 'powerPer']").value = "";
		  	}else{
		  		$("select[name = 'powerPer']").removeAttr('disabled');
		  	} 
		  });  
		  $("select[name = 'mode']").change(function(){ 
		  	if($(this).val() == '2' || $(this).val() == '4'){ 
		  		$("tr.11n").attr('disabled',true);
		  		$("tr.11n").value = "";
		  		$("select[name = 'rate']").removeAttr('disabled');
		  		AjaxAction.loadBasicRadioRate(addRateList,$(this).val());
		  	}else{
		  		$("tr.11n").removeAttr('disabled');
		  		$("select[name = 'rate']").attr('disabled',true);
		  		$("select[name = 'rate']").value = "";
		  	} 
		  }); 
		});
		
		function addRateList(data){	
			$("select[name = 'rate'] option").each(function() {
			    $(this).remove();
			});
			$("select[name = 'rate']").prepend(data);
			$("select[name = 'rate']").val('<%=form.getRate()%>');
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
		<html:form action="/BasicRadio.do?method=saveInfoConfig">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">无线参数基本配置</td></tr></table>
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
								  <td class="item" width="200px">射频开关</td>
								  <td class="value">
								  	<select name="sw" value=<%=form.getSw()%>>
								  		<option value="1">开启</option>
								  		<option value="0">关闭</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">功率配置模式</td>
								  <td class="value">
								  	<select name="powerMode" value="<%=form.getPowerMode()%>">
								  		<option value="1">开启自动功率调节</option>
								  		<option value="2">按百分比配置</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">自动功率调整间隔</td>
								  <td class="value"><input class="value_text" type="text" name="powerAuto" 
								  		value="<%=form.getPowerAuto()%>" width="200"> 分钟</td>
								</tr>
								<tr>
								  <td class="item" width="200px">功率</td>
								  <td class="value">
								  	<select name="powerPer" value="<%=form.getPowerPer()%>">
								  		<option value="0">100%</option>
								  		<option value="1">50%</option>
								  		<option value="2">25%</option>
								  		<option value="3">12.5%</option>
								  		<option value="4">6%</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">无线模式</td>
								  <td class="value">
								  	<select name="mode" value="<%=form.getMode()%>">
								  		<option value="2">802.11b only(2.4G)</option>
								  		<option value="4">802.11g only(2.4G)</option>
								  		<option value="16">802.11n only(2.4G)</option>
								  		<option value="6">802.11b and 802.11g(2.4G)</option>
								  		<option value="20">802.11n and 802.11g(2.4G)</option>
								  		<option value="22">802.11n and 802.11b and 802.11g(2.4G)</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">工作速率</td>
								  <td class="value">
								  	<select name="rate" value="<%=form.getRate()%>">
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">11N工作速率</td>
								  <td class="value">
								  	<select name="rate11n" value="<%=form.getRate11n()%>">
								  		<option value="0">Auto</option>
								  		<option value="1">MSC 0</option>
								  		<option value="2">MSC 1</option>
								  		<option value="3">MSC 2</option>
								  		<option value="4">MSC 3</option>
								  		<option value="5">MSC 4</option>
								  		<option value="6">MSC 5</option>
								  		<option value="7">MSC 6</option>
								  		<option value="8">MSC 7</option>
								  		<option value="9">MSC 8</option>
								  		<option value="10">MSC 9</option>
								  		<option value="11">MSC 10</option>
								  		<option value="12">MSC 11</option>
								  		<option value="13">MSC 12</option>
								  		<option value="14">MSC 13</option>
								  		<option value="15">MSC 14</option>
								  		<option value="16">MSC 15</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">空间流(11N)</td>
								  <td class="value">
								  	<select name="rxTxFlow" value="<%=form.getRxTxFlow()%>">
								  		<option value="0">1 X 1</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">信道宽带(11N)</td>
								  <td class="value">
								  	<select name="bw" value="<%=form.getBw()%>">
								  		<option value="0">20 MHZ</option>
								  		<option value="1">Auto 20/40MHZ</option>
								  		<option value="2">40- MHZ</option>
								  		<option value="3">40+ MHZ</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">Guard Interval(11N)</td>
								  <td class="value">
								  	<select name="shortGI" value="<%=form.getShortGI()%>">
								  		<option value="0">Long(800ns)</option>
								  		<option value="1">Short(400ns)</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">A-MPDU(11N)</td>
								  <td class="value">
								  	<select name="ampDU" value="<%=form.getAmpDU()%>">
								  		<option value="1">开启</option>
								  		<option value="0">关闭</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">A-MSDU(11N)</td>
								  <td class="value">
								  	<select name="amsDU" value="<%=form.getAmsDU()%>">
								  		<option value="1">开启</option>
								  		<option value="0">关闭</option>
									</select>
								  </td>
								</tr>
								<tr class="11n">
								  <td class="item" width="200px">11N工作模式</td>
								  <td class="value">
								  	<select name="workMode11n" value="<%=form.getWorkMode11n()%>">
								  		<option value="1">HT-Mixed</option>
								  		<option value="0">HT-Greenfield</option>
									</select>
								  </td>
								</tr>
							</table>
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
	$("#main").height(document.body.clientHeight);
</script>
</html>