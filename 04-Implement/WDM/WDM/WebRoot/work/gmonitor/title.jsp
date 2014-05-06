<%@include file="Common/CommonImport.jsp"%>
<script>
<!--
function handleLoginFailure(gotoPage) {
    var inDialog = (window.dialogTop != undefined);
    if (inDialog) {
        //alert("login failure in dialog (in prolog), " + window.name);
        window.returnValue = "$$%%afLoginFailure%%$$" + gotoPage; // Causes openDialog() to redirect to login.jsp
        window.close();
    } else {
        //alert("login failure not in dialog (in prolog), on window " + window.name);
        window.top.location=gotoPage;
    }
}
// -->
</script>

<html>

<head>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <link rel="stylesheet" href="style.css">
    <script src="javascript/global.js"></script>
</head>

<script>
<!--
var oBigTab, oActiveTab, tabLeft=130, tabTop=29;

function init() {
    var oTabTable=document.all.tabTable, i;

    oActiveTab = oTabTable.cells[0];
    for (i=0; i<oTabTable.cells.length; i++) {
        if (oTabTable.cells[i].className=="mainTabActive") {
            oActiveTab = oTabTable.cells[i];
            break;
        }
    }
    oBigTab = document.createElement("TABLE");
    oBigTab.style.position = "absolute";
    oBigTab.cellPadding = "0";
    oBigTab.cellSpacing = "0";
    oBigTab.insertRow();
    oBigTab.rows[0].insertCell();
    oBigTab.rows[0].insertCell();
    oBigTab.cells[0].className="mainTabActive";
    oBigTab.cells[1].className="mainTabActiveRight";
    oBigTab.cells[0].style.padding = "2px 5px 3px 9px";
    oBigTab.cells[0].style.fontWeight = "bold";
    oBigTab.cells[0].innerHTML = oActiveTab.innerHTML;
    oBigTab.title = oActiveTab.title;
    oBigTab.cells[1].innerHTML = '<img src="images/spacer.gif" height="1" width="4">';
    oBigTab.style.left = tabLeft-2; //getClientLeft(oTabTable.cells[1])-2;
    oBigTab.style.top = tabTop-3;   //getClientTop(oTabTable.cells[1])-2;
    oBigTab.style.height = oActiveTab.offsetHeight+3;
    oBigTab.style.zIndex = "999";
    oTabTable.insertAdjacentElement("beforeBegin", oBigTab);
    oBigTab.style.filter = "progid:DXImageTransform.Microsoft.Shadow(color='#999999', Direction=100, Strength=1)";
    resize();
}

function resize() {

    var oTabTable=document.all.tabTable, newLeft=tabLeft;
    var widthDiff = Math.floor((oBigTab.offsetWidth-oActiveTab.offsetWidth-4)/2+.5);

    if (oTabTable.offsetWidth+tabLeft > document.body.clientWidth) {
        newLeft = document.body.clientWidth - oTabTable.offsetWidth;
        if (newLeft<0) newLeft = 0;
    }
    oTabTable.style.left = newLeft;
    oBigTab.style.left = newLeft + oActiveTab.offsetLeft - widthDiff;
}
// -->
</script>

<body class="titleBar"  onresize="resize()">

<table width="100%" height="100%" cellpadding="0" cellspacing="0">
<tr>
    <td width="128">&nbsp;
    </td>
    <td valign=bottom>&nbsp;
    </td>
    <td align=right valign="middle">
        <div class="globalToolbar">
        <nobr>
        <a class="titleLink" href="operation.pdf" target="_blank" style="font-size:12; font-weight:bold;">°ïÖú</a>
        &nbsp;|&nbsp;
        <a class="titleLink" href="<%=contextPath%>/AuditAdmin.do?method=loginOut" target='_top' style="font-size:12; font-weight:bold;">ÍË³ö</a>
        </nobr>
        </div>
    </td>
</tr>
<tr>
    <td colspan="3" height="1" class="titleBarBottomTopBorder"><img src="images/spacer.gif" height="1" width="1"></td>
</tr>
</table>
</body>
<head>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
</html>