<html>

<%@ page import="java.util.Hashtable"%>
<%@ page contentType="text/html;charset=GBK" language="java" %>

<body bgcolor="" onload="fload()" scroll="no" >
<script src="calendar.script"></script>
<script>
function fload()
{
	fPopCalendar(document.tmp.txt1, document.tmp.txt1);
}

function fkeydown()
{
	if(event.keyCode==27){
		event.returnValue = null;
		window.returnValue = null;
		window.close();
	}
}

document.onkeydown=fkeydown;
</script>
<form name="tmp">
<input type=text id="txt1" style="display:none">
</form>
</body>
