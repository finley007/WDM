<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<%
	List colList = JSPAction.getAllColomnList("CATE_4_1");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		$(document).ready(function(){
		  $("input[status='STATUS�豸����']").each(function() { 
		  	$(this).attr('disabled','true'); 
		  });  
		});
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
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDevices"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="AP�豸��Ϣ" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:columns autoGenerateColumns="com.wdm.extremecomponents.impl.AutoGenerateColumnsImpl"/>   
								<ec:column property="changeGroup" title="���ķ���" >
									<input type="button" class="formButton" value="���ķ���"
										status="STATUS${inss.Dev_Online_Status}"
											onclick="changeGroup('${inss.Dev_Sn}')"/>
								</ec:column>
								<ec:column property="netConfig" title="��������" >
									<input type="button" class="formButton" value="��������" disabled="true"/>
								</ec:column>
								<ec:column property="advancedConfig" title="�߼�����" >
									<input type="button" class="formButton" value="�߼�����"
										status="STATUS${inss.Dev_Online_Status}"/>
								</ec:column>
								<ec:column property="deleteDevice" title="ɾ���豸" >
									<input type="button" class="formButton" value="ɾ���豸"
										onclick="deleteDevice('${inss.Dev_Sn}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
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
			var url="<%=contextPath%>/DashBoard.do?method=getAllDevices&selectCols="+selectCols+"&appId=CATE_4_1";
 			this.location = url;
		}
		
		function deleteDevice(devSn){
			if(confirm("ɾ���豸��ͬʱҲ��ɾ���豸��־��ȷ��ɾ��?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteDevice&devSn="+devSn;
 				this.location = url;
 			}
		}
		
		function changeGroup(devSn){
			var url="<%=contextPath%>/DashBoard.do?method=initChangeAPGroup&devSn="+devSn;
			this.location = url;
		}
		$("#main").height(document.body.clientHeight);
	</script>	
</html>