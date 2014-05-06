<%@include file="Common/CommonImport.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<script type="text/javascript" src="javascript/prototype.js" ></script>
		<script type="text/javascript" src="javascript/rico.js" ></script>
		<script type='text/javascript' src='<%=contextPath%>/dwr/interface/AjaxAction.js'></script>
		<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
		<script src="javascript/global.js"></script>
	</head>
	<body leftmargin="0" rightmargin="0" topmargin="0" class="leftNav">
		<div style="border-top-width:1px; border-top-style:solid; cursor:hand" id="accordionDiv">
			<%
				List userLists = JSPAction.getFunctionList();
				for(int i = 0;i < userLists.size();i++){
					FuncInfoVO temp = (FuncInfoVO)userLists.get(i);
					if(temp.getParentID().equals("")){
						%>
							<div id="overviewPanel">
								<div id="overviewHeader" class="accordionTabTitleBar">
									<%=temp.getFuncName()%>
								</div>
								<div id="panel1Content" class="accordionTabContentBox">
								 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
									<%
									for(int j = 0;j < userLists.size();j++){
										FuncInfoVO tp = (FuncInfoVO)userLists.get(j);
										if(tp.getParentID().equals(temp.getFuncID())){
									%>
									<tr/>
										<td height="5"/>
									<tr>
										<td align="left"><img src="./images/selectF.gif">
										<a href="#" onClick="clickLink('<%out.print(contextPath+tp.getUrl());%>')" class="menuLink"><%=tp.getFuncName()%></a></td>
									</tr>
									<%
										}
									}
									%>
								  </table>
								</div>
							</div>
						<% 
					}
				}
			%>
		</div>
		<script>
			var height = document.body.clientHeight - 150;
			new Rico.Accordion( $('accordionDiv'), {panelHeight:height} );
		</script>
	</body>
</html>