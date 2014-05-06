<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List colList = JSPAction.getAllColomnList("CATE_8_4");
	List result=(List)request.getAttribute("result");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr id="table_region">
		<td valign="top">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td class="tableContainer" width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result" id="info"
							var="inss"
							action="${pageContext.request.contextPath}/System.do?method=getUpdateVersions"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="AP版本文件列表" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>   
								<ec:column property="flowStatistic" title="删除版本" >
									<input type="button" class="formButton" value="删除版本"
											onclick="deleteVersion('${inss.UpdateFile_Sn}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<div style="float: right" class="bottomButtons"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="增加版本"
									onclick="addVerion()"> </span></div>
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
			var url="<%=contextPath%>/System.do?method=getUpdateVersions&selectCols="+selectCols;
 			this.location = url;
		}
		
		function deleteVersion(sn){
			var url="<%=contextPath%>/System.do?method=deleteUpdateVersion&sn="+sn;
			this.location = url;
		}
		
		function addVerion(){
			var url="<%=contextPath%>/System.do?method=getUpdateVersionSeq";
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>