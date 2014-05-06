<%@include file="Common/CommonImport.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312"/>
<title>无线AP管理平台</title>
<script type="text/javascript">	
	function doSubmit(){	
		var uid = document.getElementById("userid").value;
		if(uid === ""){
			$("div#error").text("请输入用户名");
			$("div#error").css("display","block");
			return false;
		}
		var pwd = document.getElementById("password").value;
		if(pwd === ""){
			$("div#error").text("请输入密码");
			$("div#error").css("display","block");
			return false;
		}
		return true;
	}
	
	function clearInput(){
		document.getElementById("userid").value = "";
		document.getElementById("password").value = "";
	}
	
	$(document).ready(function(){
		$("#userid").on('input propertychange',function(e){  
		   	$("div#error").css("display","none"); 
		}); 
		$("#password").on('input propertychange',function(e){  
		   	$("div#error").css("display","none"); 
		});  
	});
</script>
<style>
BODY {
    background : #6EA0DB url("<%=path%>/images/loginBackground.jpg");
    background-repeat : no-repeat;
    background-position : center;
    font-family : Arial,Tahoma;
    font-size : 75%;
}
BUTTON {
    font-family : "Arial,Tahoma";
    font-size : 9pt;
    border-width : 1px;
    padding-top : 0px;
    padding-bottom : 0px;
    width : 50px;
    margin-left : 0px;
    margin-bottom : 0px;
}
tr.alert {
	color:red; 
	font-size:10pt; 
	font-weight:700; 
}
</style>
</head>
<body onLoad="document.all.userid.focus();">
<form name="form" method="post" action="<%=contextPath%>/AuditAdmin.do?method=login&login=\"true\"" onsubmit="return doSubmit();">
    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td id="toptable">
            </td>
        </tr>
        <tr>
            <td align="center" valign="center" height="400">
                <table width="100%" height="400" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center">
                            <table width="700" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td colspan="2">
                                        <table height="20" width="100%" cellpadding="0" cellspacing="0">
                                            <tr>
                                                <td width="160" height="25"></td>
                                                <td height="25"></td>
                                            </tr>
                                            <tr>
                                                <td id="leftPadding" width="160"></td>
                                                <td height="30" align="left" valign="top">
                                                    <div style="font-family: Arial;font-size:16pt; font-weight: 700; color: rgb(235,225,166);">&nbsp;</div>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="160"></td>
                                </tr>
                                <tr>
                                    <td height="160" align="right" valign="top">
                                        <div style="font-family: Arial; font-size:10pt; color: rgb(117, 117, 117);"><b></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="45" align="center" width="100%" valign="bottom">
                                        <table cellpadding="0" cellspacing="0" align="center">
	                                        <tr class="alert">
                                                <td colspan="2" style="">
												 	<div id="error" align="center" style="display:none;">
														用户名密码错误
													</div>
												 </td>
                                            </tr>
                                            <tr class="alert">
                                                <td height="8"></td>
                                            </tr>
											<tr id="loginPanel">
                                                <td style="font-size:11pt; font-weight:700; font-family:SimHei; ">用户名&nbsp;</td>
                                                <td style="color:red;"><input id="userid" name="userid" type="text" style="padding-bottom:2px;"></td>
                                            </tr>
                                            <tr>
                                                <td height="2"></td>
                                            </tr>
                                            <tr>
                                                <td style="font-size:11pt; font-weight:700; font-family:SimHei;">密码&nbsp;</td>
                                                <td><input id="password" name="password" type="password"></td>
                                            </tr>
                                            <tr>
                                                <td height="8"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left">
                                                	<button type="submit">登录</button>
                                                	<button type="button" style="margin-left:15px" onclick="clearInput()">清空</button>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="45"></td>
                                </tr>
                                <tr>
                                    <td height="35" style="font-family: Arial; font-size:7pt; font-weight: 400;">&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="75">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
            <td id="bottomtable">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script type="text/javascript">	
	var loginFail = <%=request.getAttribute("loginFail")%>
	if(loginFail != null){
		$("div#error").text("用户名密码错误");
		$("div#error").css("display","block");
	}
</script>