<%@page contentType="text/html;charset=gb2312"%>
<%@include file="./../Common/CommonImport.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<script>
		function deleteAccount(id){
			if(confirm("ȷ��ɾ��?")){
 				var url="<%=contextPath%>/System.do?method=deleteAccount&account="+id;
 				this.location = url;
 			}
		}	
		function editAccount(account){
			var url="<%=contextPath%>/System.do?method=editAccountInfo&account="+account;
			this.location = url;
		}
	</script>	
</head>
<table id="main" width="100%" border="0" cellspacing="0" cellpadding="0" class="tableRegion">
	<tr>
		<td valign="top">
			<%List result=(List)request.getAttribute("result");	if(result!=null){ %>
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr height="500">
					<td width="40%" valign="top" class="tableRegion_bottom" height="500">
						<ec:table items="result"
							var="inss"
							action="${pageContext.request.contextPath}/DashBoard.do?method=getAllDeviceAlerts"
							imagePath="${pageContext.request.contextPath}/work/gmonitor/images/*.gif"
							title="�˺��б�" filterable="true" sortable="true">
							<ec:row highlightRow="true">
								<ec:column property="account" title="�˺�" />
								<ec:column property="isSupervisorLabel" title="�Ƿ����Ա" />
								<ec:column property="statusLabel" title="״̬" />
								<ec:column property="createTime" title="����ʱ��" />
								<ec:column property="updateTime" title="����ʱ��" />
								<ec:column property="edit" title="�༭" style="width : 100px">
									<input type="button" class="formButton" value="�༭" 
										onclick="editAccount('${inss.account}')"/>
								</ec:column>
								<ec:column property="delete" title="ɾ��" style="width : 100px">
									<input type="button" class="formButton" value="ɾ��" 
										onclick="deleteAccount('${inss.account}')"/>
								</ec:column>
							</ec:row>
						</ec:table>
						<div class="bottomButtons" align="right"><span class="formButtons">
						<input type="button" class="formButton" name="shut" value="�½�"
							onclick="editAccount('')"> </span></div>
					</td>
				</tr>
			</table>
			<%}%>
		</td>
	</tr>
</table>
<script type="text/javascript">
	$("#main").height(document.body.clientHeight);
</script>
</html>