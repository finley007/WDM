<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	String flag = (String)request.getAttribute("flag");
  	String devSn = (String)request.getAttribute("devSn");
  	List colList = JSPAction.getAllColomnList("CATE_1_2");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function deleteDeviceAlert(alertSn){
			if(confirm("ȷ��ɾ��?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteDeviceAlert&alertSn="+alertSn;
 				this.location = url;
 			}
		}	
		
		function getAlertInfo(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=getDeviceAlertsByDevice&devSn="+devSn;
			this.location = url;
		}
		
		function returnBack(){
			var url="<%=contextPath%>/DashBoard.do?method=getAllDevices&appId=CATE_3_1";
			this.location = url;
		}
	</script>	
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr id="table_region">
		<td valign="top">
			<%List result=(List)request.getAttribute("result");	if(result!=null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getDeviceAlertsByDevice"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="CPE�豸�澯��־" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>
								<ec:column property="delete" title="ɾ���澯" >
									<input type="button" class="formButton" value="ɾ���澯" 
										onclick="deleteDeviceAlert('${inss.Dev_Trap_Sn}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<%if(flag != null) {%>
							<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="return" value="����"
								onclick="returnBack()"> </span></div>
						<%}%>
						<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
							<input type="button" class="formButton" name="refresh" value="ˢ����Ϣ"
								onclick="getAlertInfo(<%=devSn%>)"> </span></div>
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
		 		alert("������ѡ��һ��!!");
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
			var url="<%=contextPath%>/DashBoard.do?method=getDeviceAlertsByDevice&selectCols="+selectCols+"&devSn="+<%=devSn%>;
 			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>