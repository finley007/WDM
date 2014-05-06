<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List result=(List)request.getAttribute("result");
	List colList = JSPAction.getAllColomnList("CATE_6_1");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		//单选
		$(document).ready(function(){
		  $("input.checkbox[single='true']").click(function(){
		  	if(this.checked){
			  	$("input.checkbox"[single='true']).each(function() { 
			  		this.checked = false;
				});
				this.checked = true;
			}
		  });
		});
		
		function addSecurity(){
			var url="<%=contextPath%>/Security.do?method=initSecurity";
 			this.location = url;
		}
		
		function editSecurity(){
			var selectedId = getSelectedId();
			if(selectedId === ""){
				alert("请选择需要修改的安全策略");
				return;
			}
			var url="<%=contextPath%>/Security.do?method=initSecurity&sn="+selectedId;
 			this.location = url;
		}
		
		function deleteSecurity(){
			var selectedId = getSelectedId();
			if(selectedId === ""){
				alert("请选择需要删除的安全策略");
				return;
			}else if(confirm("确认删除?")){
				var url="<%=contextPath%>/Security.do?method=deleteSecurity&sn="+selectedId;
 				this.location = url;
			}
		}
		
		function getSelectedId(){
			var selectedId = "";
			<%for(Object obj:result){
				Map map = (Map)obj;
				String id = WDMCommonUtil.objToString(map.get("Security_SN"));
				if(!"".equals(id))%>
					var id = <%=id%>;
					if(document.getElementById(id) && document.getElementById(id).checked)
						selectedId = id;
				<%
			  }
			%>
			//alert(selectedId);
			return selectedId;
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
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllWlanSecurities"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="无线安全配置" filterable="true" sortable="true" rowsDisplayed="5">
							<ec:row highlightRow="true">
								<ec:column property="detail" title="操作" >
									<input type="checkbox" class="checkbox" id="${inss.Security_SN}" single="true"/>
								</ec:column>
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>
							</ec:row>
						</ec:table>
						<div>
							<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="删除"
									onclick="deleteSecurity()"> </span></div>
							<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="修改"
									onclick="editSecurity()"> </span></div>
							<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="新增"
									onclick="addSecurity()"> </span></div>
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
			var url="<%=contextPath%>/DashBoard.do?method=getAllWlanSecurities&selectCols="+selectCols;
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>