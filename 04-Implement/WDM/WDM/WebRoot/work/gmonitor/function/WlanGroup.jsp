<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function deleteGroup(sn){
			if(confirm("ȷ��ɾ��?")){
 				var url="<%=contextPath%>/DashBoard.do?method=deleteWlanGroup&sn="+sn;
 				this.location = url;
 			}
		}	
		
		function addGroup(){
			var url="<%=contextPath%>/DashBoard.do?method=getWlanGroupSeq";
 			this.location = url;
		}
		
		function editGroup(sn,name){
			var url="<%=contextPath%>/Wlan.do?method=initGroupedWlan&sn="+sn+"&name="+name;
 			this.location = url;
		}
		
		function setWlanGroup(sn){
			if(confirm("�������·�����������AP�����ã��Ƿ����?")){
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
							action="${pageContext.request.contextPath}/DashBoard.do?method=getWlanGroup"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="WLAN�豸��Ϣ" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:column property="WlanGroup_SN" title="���" />
								<ec:column property="WlanGroup_Name" title="WLAN��������" />
								<ec:column property="editGroup" title="�༭" >
									<input type="button" class="formButton" value="�༭����"
										onclick="editGroup('${inss.WlanGroup_SN}','${inss.WlanGroup_Name}')"/>
								</ec:column>
								<ec:column property="deleteGroup" title="ɾ��" >
									<input type="button" class="formButton" value="ɾ������"
										onclick="deleteGroup('${inss.WlanGroup_SN}')" id="DEL${inss.WlanGroup_SN}"/>
								</ec:column>
								<ec:column property="changeWlanGroup" title="����" >
									<input type="button" class="formButton" value="Ӧ��"
										onclick="setWlanGroup('${inss.WlanGroup_SN}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<div style="float: right;" class="bottomButtons"><span class="formButtons">
								<input type="button" class="formButton" name="shut" value="���ӷ���"
									onclick="addGroup()"> </span></div>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
<script type="text/javascript">
	//��ʼ��Wlan��������
	$(document).ready(function(){
	  $("input#DEL0").remove();
	});
	$("#main").height(document.body.clientHeight);
</script>
</html>