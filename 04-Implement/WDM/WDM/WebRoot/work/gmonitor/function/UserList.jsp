<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
  	String devSn=(String)request.getAttribute("devSn");
  	List colList = JSPAction.getAllColomnList("CATE_3_1_1");
  	List result=(List)request.getAttribute("result");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function refresh(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=getUserListByDevice&devSn="+devSn;
			this.location = url;
		}
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getAllDevices&appId=CATE_3_1";
			this.location = url;
		}
	</script>	
</head>
	<tr id="table_region">
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
		<td valign="top">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getUserListByDevice"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="用户列表" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>
							</ec:row>
						</ec:table>
						<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="return" value="返回"
								onclick="returnBack()"> </span></div>
						<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="refresh" value="刷新信息"
								onclick="refresh(<%=devSn%>)"> </span></div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script>
		var menuList = [];
		<%for(Object obj:colList){
			AppColVO vo = (AppColVO)obj;
			%>
				var item = new Object;
				item["menuName"] = <%="\" "+vo.getColName()+"\""%>;
				item["menuclass"] = <%="\""+vo.getColId()+"\""%>;
				menuList.push(item);
			<%
		  }
		%>
		var menu = {menuList:menuList};
		$("#table_region").RightMenu('myMenu','table_region','submit()',menu);
	 	$("#myMenu").css({"width":"100px"});
	 	getNameLength(menu["menuList"]);
	 	
		function submit(){
			var selectCol = "";
			$("#myMenu ul li input.checkbox").each(function() { 
				  if(this.checked)
					selectCol += this.name+"|";
			}); 
		 	if(selectCol != ""){
		 		refreshColomn(selectCol);
		 		$("#myMenu").hide();
		 	}else{
		 		alert("请至少选择一列!!");
		 	}
		}
		
		function getNameLength(menuList){
			var maxLength = 0;
			for(var index in menuList){
				var length = getUnicodeLength(menuList[index]["menuName"]);
				if(maxLength < length)
					maxLength = length;
			}
			if(maxLength < 4){
				$("#myMenu").css({"width":"100px"});
			}else{
				var width = maxLength * 15 + 40;
				$("#myMenu").css({"width":width + "px"});
			}
		}
		
		function refreshColomn(selectCols){
			var url="<%=contextPath%>/DashBoard.do?method=getUserListByDevice&selectCols="+selectCols+"&devSn="+<%=devSn%>;
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>