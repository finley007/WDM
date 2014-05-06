<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List grouped = (List)request.getAttribute("grouped");
	List ungrouped = (List)request.getAttribute("ungrouped");
	List colList = JSPAction.getAllColomnList("CATE_5_2");
	String name = (String)request.getAttribute("name");
	String sn = (String)request.getAttribute("sn");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function addWlan(wlanName){
			var names = "";
			<%for(Object obj:grouped){
				Map map = (Map)obj;
				String wname = WDMCommonUtil.objToString(map.get("Wlan_WlanName"));
				if(!"".equals(wname))%>
					var name = "<%=wname%>";
					names += name + "|";
				<%
			  }
			%>
			names += wlanName;
			var url="<%=contextPath%>/Wlan.do?method=changeGroupedWlan&sn="+<%=sn%>+"&wlans="+names+"&name="+"<%=name%>";
			this.location = url;
		}
		
		function removeWlan(wlanName){
			var names = "";
			<%for(Object obj:grouped){
				Map map = (Map)obj;
				String wname = WDMCommonUtil.objToString(map.get("Wlan_WlanName"));
				if(!"".equals(wname))%>
					var name = "<%=wname%>";
					if(wlanName != name)
						names += name + "|";
				<%
			  }
			%>
			var url="<%=contextPath%>/Wlan.do?method=changeGroupedWlan&sn="+<%=sn%>+"&wlans="+names+"&name="+"<%=name%>";
			this.location = url;
		}
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getWlanGroup";
			this.location = url;
		}
	</script>
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr id="table_region">
		<td valign="top">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr align="left" height="50">
					<th class="title"><%=name%>分组</th>
				</tr>
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom">
						<ec:table items="grouped"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=initGroupedWlan"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="分组内WLAN列表" filterable="false" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:column property="remove" title="移出分组" >
									<input type="button" class="formButton" value="移出分组" 
										onclick="removeWlan('${inss.Wlan_WlanName}')"/>
								</ec:column>
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>
							</ec:row>
						</ec:table>
						<ec:table items="ungrouped"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=initGroupedWlan"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="其它WLAN列表" filterable="false" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:column property="add" title="加入分组" >
									<input type="button" class="formButton" value="加入分组" 
										onclick="addWlan('${inss.Wlan_WlanName}')"/>
								</ec:column>
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>
							</ec:row>
						</ec:table>
						<div class="bottomButtons" style="float: right;"><span class="formButtons">
							<input type="button" class="formButton" name="shut" value="返回"
								onclick="returnBack()"> </span></div>
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
			var url="<%=contextPath%>/Wlan.do?method=initGroupedWlan&selectCols="+selectCols+"&sn="+<%=sn%>+"&name="+"<%=name%>";
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>