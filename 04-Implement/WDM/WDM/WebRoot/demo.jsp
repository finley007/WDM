<%@include file="./work/gmonitor/Common/CommonImport.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
*{ font-size:12px; margin:0; padding:0;}

.div_RightMenu{ position:absolute; list-style:none;font:verdana;}
.div_RightMenu div{background:#bbb;position:relative;}
.div_RightMenu ul{position:relative;background:#fff; border:1px solid #999;left:-2px;top:-2px; margin:0; padding:1px 0;}
.div_RightMenu ul li{list-style:none; margin:0 1px;padding:0 5px 0 5px;line-height:25px;height:25px; background-repeat:no-repeat;border-width:1px;border-style:solid;border-color:#fff;}
.div_RightMenu ul li input{vertical-align:middle;cursor:pointer;}
.div_RightMenu input.submit{width:30px;height:20px;float:right;}
.div_RightMenu ul li.RM_mouseover{ background-color:#B6BDD2; border-color:#0A246A;}
tr.selected{ background:#B6BDD2;}
</style>
</head>

<body>
<table class="slist" id="slist" width="100%" border="1" cellpadding="0" cellspacing="0">
<tr id="T_1"><td>1</td></tr>
<tr id="T_2"><td>2</td></tr>
<tr id="T_3"><td>3</td></tr>
<tr id="T_4"><td>4</td></tr>
</table>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<table class="slist" width="100%" border="1" cellpadding="0" cellspacing="0">
<tr id="S_1"><td>1</td></tr>
<tr id="S_2"><td>2</td></tr>
<tr id="S_3"><td>3</td></tr>
<tr id="S_4"><td>4</td></tr>
</table><br />
<br />
<br />
<br />
<br />
<br />
<div id="divTest">右键菜单显示区域</div>

<script type="text/javascript">

$("#divTest,.slist tr").RightMenu('myMenu2','slist','submit()',{
   menuList:[{menuName:"菜单1",menuclass:"1",clickEvent:"divClick(1)"},
			{menuName:"菜单2",menuclass:"2",clickEvent:"divClick(2)"},
            {menuName:"菜单3",menuclass:"3",clickEvent: "divClick(3)"},
            {menuName:"菜单4",menuclass:"4",clickEvent: "divClick(4)"},
            {menuName:"菜单5",menuclass:"5",clickEvent: "divClick(5)"},
            {menuName:"菜单6",menuclass:"6",clickEvent: "divClick(6)"},
            {menuName:"菜单7",menuclass:"7",clickEvent: "divClick(7)"},
            {menuName:"菜单8",menuclass:"8",clickEvent: "divClick(8)"},
            {menuName:"菜单9",menuclass:"9",clickEvent: "divClick(9)"},
            {menuName:"菜单10",menuclass:"10",clickEvent: "divClick(10)"},
            {menuName:"菜单11",menuclass:"11",clickEvent: "divClick(11)"},
            {menuName:"菜单12",menuclass:"12",clickEvent: "divClick(12)"},
            {menuName:"菜单13",menuclass:"13",clickEvent: "divClick(13)"},
            {menuName:"菜单14",menuclass:"14",clickEvent: "divClick(14)"},
            {menuName:"菜单15",menuclass:"15",clickEvent: "divClick(15)"},
            {menuName:"菜单16",menuclass:"16",clickEvent: "divClick(16)"},
            {menuName:"菜单17",menuclass:"17",clickEvent: "divClick(17)"}]
 });
 $("#myMenu2").css({"width":"100px"});
 
 function submit(){
	var selectCol="";
	$("#myMenu2 ul li input.checkbox").each(function() { 
		  if(this.checked)
			selectCol += this.name+"|";
	}); 
	alert(selectCol);
 	$("#myMenu2").hide();
 }


</script>

</body>
</html>
