<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List result=(List)request.getAttribute("result");
	List colList = JSPAction.getAllColomnList("CATE_4_3");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		$(document).ready(function(){
		  $("input[status='STATUS设备下线']").each(function() { 
		  	$(this).attr('disabled','true'); 
		  });  
		  $("#select_all").click(function(){
		  	$("input.checkbox").each(function() { 
		  		if($(this).attr('disabled') == undefined)
		  			this.checked = true;
			}); 
		  });
		  $("#select_reverse").click(function(){
		  	$("input.checkbox").each(function() { 
		  		if($(this).attr('disabled') == undefined)
		  			this.checked =! this.checked;
			}); 
		  });
		});
		function update(){
			var ids = "";
			<%for(Object obj:result){
				Map map = (Map)obj;
				String id = WDMCommonUtil.objToString(map.get("Dev_Sn"));
				if(!"".equals(id))%>
					var id = <%=id%>;
					if(document.getElementById(id) && document.getElementById(id).checked)
						ids += id + "|";
				<%
			  }
			%>
			alert(ids);
			if(ids == ""){
				alert("请选择需要升级的设备");
				return;
			}
			AjaxAction.test(callServiceArea,ids);
			//var url="<%=contextPath%>/DashBoard.do?method=updateDeviceSoftware&ids=" + ids;
			//this.location = url;
		}	
		function callServiceArea(data){	
			alert(data);
		}
	</script>	
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr id="table_region">
		<td valign="top">
			<%if(result != null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDevicesForUpdate"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="CPE设备信息" filterable="true" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>   
								<ec:column property="detail" title="是否选择" >
									<input type="checkbox" class="checkbox" name="${inss.Dev_Sn}" status="STATUS${inss.Dev_Online_Status}"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<div>
							<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="升级软件"
									onclick="update()"> </span></div>
							<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="恢复配置"
									onclick="update()"> </span></div>
							<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="重启设备"
									onclick="update()"> </span></div>
							<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input id="select_reverse" type="button" class="formButton" name="shut" value="反选"> </span></div>
							<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input id="select_all" type="button" class="formButton" name="shut" value="全选"> </span></div>
						</div>
					</td>
				</tr>
			</table>
			<%}%>
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
			var url="<%=contextPath%>/DashBoard.do?method=getAllDevicesForUpdate&selectCols="+selectCols;
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>