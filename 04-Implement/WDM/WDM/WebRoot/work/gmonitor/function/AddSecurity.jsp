<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	SecurityForm security = (SecurityForm)request.getAttribute("result");
	String flag = (String)request.getAttribute("flag");//ADD-�½���EDIT-�༭
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script type="text/javascript">
		$(document).ready(function(){
		  $("select[name = 'mode']").val('<%=security.getMode()%>');
		  if($("select[name = 'mode']").val() == '1'){
		  	$("tr.WEP").show(); 
		  	$("tr.802").hide(); 
		  	$("select[name = 'keyType']").val('<%=security.getKeyType()%>');
		  	$("select[name = 'keyLength']").val('<%=security.getKeyLength()%>');
		  	$("select[name = 'keyIndex']").val('<%=security.getKeyIndex()%>');
		  }else{
		  	$("tr.WEP").hide(); 
		  	$("tr.802").show();
		  	$("select[name = 'keyType']").val('<%=security.getKeyType()%>');
		  	$("select[name = 'authMode']").val('<%=security.getAuthMode()%>');
		  	$("select[name = 'cipher']").val('<%=security.getCipher()%>');
		  }
		  $("select[name = 'mode']").change(function(){ 
		  	if($(this).val() == '1'){ 
		  		$("tr.WEP").show(); 
		  		$("tr.802").hide();
		  	}else{
		  		$("tr.WEP").hide(); 
		  		$("tr.802").show();
		  	} 
		  });  
		});
		
		function doSubmit(){	
			if(!testRegExp("apgroup",document.getElementById("name").value)){
				alert("��ȫ�������Ʊ�����Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�");
				return false;
			}
			if(document.getElementById("mode").value == 1){
				if(!testRegExp("ascii5",document.getElementById("key0").value)){
					alert("��������ȷ��ʽ����Կ1");
					return false;
				}else if(!testRegExp("ascii5",document.getElementById("key1").value)){
					alert("��������ȷ��ʽ����Կ2");
					return false;
				}else if(!testRegExp("ascii5",document.getElementById("key2").value)){
					alert("��������ȷ��ʽ����Կ3");
					return false;
				}else if(!testRegExp("ascii5",document.getElementById("key3").value)){
					alert("��������ȷ��ʽ����Կ4");
					return false;
				}
			}else{
				if(!testRegExp("ascii8",document.getElementById("key").value)){
					alert("��������ȷ��ʽ����Կ");
					return false;
				}			
			}
			return true;
		}	
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getAllWlanSecurities";
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
		<html:form action="/Security.do?method=addSecurity" onsubmit="return doSubmit();">
			<td valign="top">
				<table width="100%" height="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr height="500">
						<td width="40%" valign="top" class="tableRegion_bottom" height="500">
							<table width="100%"><tr><td class="tableHeader">WLAN��ȫ��������</td></tr></table>
							<table width="100%">
								<tr width="100%">
								  <td class="item" width="200px">��ȫ����ID</td>
								  <td class="value"><input class="value_text" readonly="true" type="text" name="sn" 
								  		value="<%=security.getSn()%>" width="200"> ϵͳ�Զ�����</td>
								</tr>   
								<tr>
								  <td class="item" width="200px">��ȫ��������</td>
								  <td class="value"><input class="value_text" type="text" name="name" 
								  		value="<%=security.getName()%>" width="200"> Ӣ����ĸ�����ֺ��»�����ɣ�����С��255���ַ�</td>
								</tr>
								<tr>
								  <td class="item" width="200px">��ȫģʽ</td>
								  <td class="value">
								  	<select name="mode" value="<%=security.getMode()%>">
								  		<option value="1">WEP</option>
								  		<option value="2">802.11i</option>
									</select>
								  </td>
								</tr>
								<tr>
								  <td class="item" width="200px">��Կ����</td>
								  <td class="value">
								  	<select name="keyType" value="<%=security.getKeyType()%>">
								  		<option value="0">ASCii</option>
									</select>
								  </td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ����</td>
								  <td class="value">
								  	<select name="keyLength" value="<%=security.getKeyLength()%>">
								  		<option value="0">WEP 64 Bit</option>
								  		<option value="1">WEP 128 Bit</option>
									</select>
								  </td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ����</td>
								  <td class="value">
								  	<select name="keyIndex" value="<%=security.getKeyIndex()%>">
								  		<option value="0">��Կ1</option>
								  		<option value="1">��Կ2</option>
								  		<option value="2">��Կ3</option>
								  		<option value="3">��Կ4</option>
									</select>
								  </td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ1</td>
								  <td class="value"><input class="value_text" type="text" name="key0" 
								  		value="<%=security.getKey0()%>" width="200"> WPA��ԿΪ5��ASCii�ַ�</td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ2</td>
								  <td class="value"><input class="value_text" type="text" name="key1" 
								  		value="<%=security.getKey1()%>" width="200"> WPA��ԿΪ5��ASCii�ַ�</td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ3</td>
								  <td class="value"><input class="value_text" type="text" name="key2" 
								  		value="<%=security.getKey2()%>" width="200"> WPA��ԿΪ5��ASCii�ַ�</td>
								</tr>
								<tr class="WEP">
								  <td class="item" width="200px">��Կ4</td>
								  <td class="value"><input class="value_text" type="text" name="key3" 
								  		value="<%=security.getKey3()%>" width="200"> WPA��ԿΪ5��ASCii�ַ�</td>
								</tr>
								<tr class="802">
								  <td class="item" width="200px">��Ȩģʽ</td>
								  <td class="value">
								  	<select name="authMode" value="<%=security.getAuthMode()%>">
								  		<option value="0">WPA-PSK</option>
								  		<option value="1">WPA2-PSK</option>
									</select>
								  </td>
								</tr>
								<tr class="802">
								  <td class="item" width="200px">���ܷ�ʽ</td>
								  <td class="value">
								  	<select name="cipher" value="<%=security.getCipher()%>">
								  		<option value="0">TKIP</option>
								  		<option value="1">AES</option>
									</select>
								  </td>
								</tr>
								<tr class="802">
								  <td class="item" width="200px">��Կ</td>
								  <td class="value"><input class="value_text" type="text" name="key" 
								  		value="<%=security.getKey()%>" width="200"> WPA/WPA2��ԿΪ8~63��ASCii�ַ�</td>
								</tr>
								<input type="hidden" name="action" value="<%=flag%>">
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