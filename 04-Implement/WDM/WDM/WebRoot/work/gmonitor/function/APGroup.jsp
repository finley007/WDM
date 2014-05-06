<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function deleteGroup(sn){
			if(confirm("确认删除?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteAPGroup&sn="+sn;
 				this.location = url;
 			}
		}	
		
		function addGroup(){
			var url="<%=contextPath%>/DashBoard.do?method=getAPGroupSeq";
 			this.location = url;
		}
		
		function setWlanGroup(sn){
			if(confirm("将重新下发分组内所有AP的配置，是否继续?")){
				var wlanGroup = document.getElementById("SN"+sn).value;
				var url="<%=contextPath%>/DashBoard.do?method=updateAPGroup&sn="+sn+"&group="+wlanGroup;
 				this.location = url;
 			}
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
					<td class="tableContainer" width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result" id="info"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAPGroup"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="AP设备信息" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:column property="ApGroup_SN" title="序号" />
								<ec:column property="ApGroup_Name" title="AP分组名称" />
								<ec:column property="ApGroup_WlanGroupName" title="WLAN分组名称">
									<select name="wlanGroup" id="SN${inss.ApGroup_SN}">
								  		<%List wlanGroupList = (List)request.getAttribute("wlanGroupList");	
								  		  if(wlanGroupList!=null){
								  		  		for(int i = 0;i < wlanGroupList.size();i++) {
								  		  			String group = (String)wlanGroupList.get(i); %>
													<option id="${inss.ApGroup_SN}_${inss.ApGroup_WlanGroupName}_<%=group%>" value="<%=group%>"><%=group%></option>
										<%}}%>
									</select>
								</ec:column>
								<ec:column property="deleteGroup" title="删除" >
									<input type="button" class="formButton" value="删除分组"
										onclick="deleteGroup('${inss.ApGroup_SN}')" id="DEL${inss.ApGroup_SN}"/>
								</ec:column>
								<ec:column property="changeWlanGroup" title="操作" >
									<input type="button" class="formButton" value="应用"
										onclick="setWlanGroup('${inss.ApGroup_SN}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<div style="float: right;" class="bottomButtons" align="right"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="增加分组"
									onclick="addGroup()"> </span></div>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
<script type="text/javascript">
	//初始化Wlan组下拉框
	$(document).ready(function(){
		  $("input#DEL0").remove();
		  $("select#SN0 option[value!='DefaultGroup']").remove();
		  $("option").each(function() {
		  		var id = this.id;
		  		if(id != "" && id != null){
		  			var arr = id.split("_");
		  			if(arr[1] == arr[2])
		  				this.selected = true;
		  		} 
			}); 
		});
	$("#main").height(document.body.clientHeight);
</script>
</html>