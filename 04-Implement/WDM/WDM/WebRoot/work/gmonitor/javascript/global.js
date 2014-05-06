/*-----------------------------------------------------------------------------
-  Copyright (c) 2003 by Vitria Technology, Inc.
-  All Rights Reserved.
-
-  This SOURCE CODE FILE, which has been provided by Vitria as part
-  of a Vitria product for use ONLY by licensed users of the product,
-  includes information that is CONFIDENTIAL and PROPRIETARY to Vitria.
-
-  SOME API's contained herein are for INTERNAL USE ONLY and are NOT to
-  be used by ANY licensee of the product.  Vitria reserves the right
-  to change such API's at any time and is not required to support
-  them in current or future releases.
-
-  USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS
-  OF THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
-  THE PRODUCT.
-
-  IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD VITRIA HARMLESS FROM
-  AND AGAINST ANY CLAIMS OR LIABILITIES ARISING OUT OF THE USE,
-  REPRODUCTION, OR DISTRIBUTION OF YOUR PROGRAMS, INCLUDING ANY
-  CLAIMS OR LIABILITIES ARISING OUT OF OR RESULTING FROM THE
-  USE, MODIFICATION, OR DISTRIBUTION OF PROGRAMS OR FILES CREATED
-  FROM, BASED ON, AND/OR DERIVED FROM THIS SOURCE CODE FILE.
------------------------------------------------------------------------------*/

/*
 * Displays a message box that sizes to the contents of message.
 * message - the message to display
 * title -   title of message box
 * buttons - can be any combination of yes no ok cancel (i.e. "okCancel", "yesNoCancel", "yesNo", "yesAllNoCancel (Yes, Yes To All, No, Cancel)")
 * defaultButtonIndex - the index of the default button; default is "Cancel" if present, otherwise "No" if present
 * icon -    path to an image, default is exclamation icon
 * relativeUrl - A context JSP is located two levels down from msgBox.jsp, so they would pass in "../../"
 * returns either "cancel" (default), "ok", "yes", "yesall", or "no", depending on which button is clicked
 */
function msgBox(message, title, buttons, defaultButtonIndex, icon, relativeUrl) {
    var sArgs = new Array;
    sArgs[0] = (message==undefined)? "" : message;
    sArgs[1] = (title==undefined)? "" : title;
    sArgs[2] = (buttons==undefined)? "" : buttons;
    sArgs[3] = (defaultButtonIndex==undefined)? "" : defaultButtonIndex;
    sArgs[4] = (icon==undefined)? "" : icon;
    var relUrl = (relativeUrl==undefined)? "" : relativeUrl;
    return window.showModalDialog(relUrl + "msgBox.jsp", sArgs, 'dialogHeight=550px;dialogWidth=300px;status=no;help=no;resizable=no;scroll=no');
}

/*
 * Highlights tab on mouse over
 */
function tabOver() {
    var tab = window.event.srcElement;
    if (tab.className != "mainTab") return;

    tab.className = "mainTabHover";
    cells = document.all.tags("TD");
    for (i=0; i<cells.length; i++) {
        if (cells[i].className=="mainTabHover") {
            cells[i+1].className = "mainTabHoverRight";
            break;
        }
    }
}

/*
 * Returns tab to normal color on mouse out
 */
function tabOut() {
	var tab = window.event.srcElement;
    if (tab.className != "mainTabHover") return;

    cells = document.all.tags("TD");
    for (i=0; i<cells.length; i++) {
        if (cells[i].className=="mainTabHover") {
            cells[i+1].className = "mainTabRight";
            break;
        }
    }
    tab.className = "mainTab";
}


/*
 * Highlights left nav on mouse over
 */
function leftNavOver() {
    var oSource = window.event.srcElement;
    while (oSource.tagName != "DIV") {
        if (oSource.tagName == "BODY") return;
        oSource = oSource.parentElement;
    }
    if (oSource.className=="leftNavItem") oSource.className = "leftNavHover";
}

function leftNavOut() {
    var oSource = window.event.srcElement;
    while (oSource.tagName != "DIV") {
        if (oSource.tagName == "BODY") return;
        oSource = oSource.parentElement;
    }
    if (oSource.className=="leftNavHover") oSource.className = "leftNavItem";
}

/*
 * Highlights the specified left navigation tab. Called when page is loaded to
 *   highlight correct tab when browser navigation is used.
 */
function selectLeftNav(id) {
    if (top.leftFrame.document.getElementById(id).className!="leftNavActive") {
        cells = top.leftFrame.document.all.tags("DIV");
        for (i=0; i<cells.length; i++) {
            if (cells[i].className=="leftNavActive")
                cells[i].className="leftNavItem";
        }
        top.leftFrame.document.getElementById(id).className="leftNavActive";
    }
}

/*
 * Opens a modal dialog box and returns the returnValue paramater set by the dialog window
 * If returnValue is not set, undefined is returned
 */
function openDialog(url, width, height) {
    return openDialog(url,width, height, window);
}

/*
 * Opens a modal dialog box and returns the returnValue paramater set by the dialog window
 * If returnValue is not set, undefined is returned
 */
function openDialog(url, width, height, param) {
    var dlgTop = "";

    // Tile dialogs such that parent dialog titles are not obscured
    try {

        if (parent.dialogTop != undefined) {

            t = parent.screenTop;
            if (t + parseInt(height) <= screen.height)
                dlgTop = "dialogTop=" + t + ";";
        }
    }catch(e) {}
    var v = window.showModalDialog(url, param, dlgTop+'dialogHeight='+height+'px;dialogWidth='+width+'px;status=no;help=no;resizable=no;scroll=no');
    if (v && v.indexOf("$$%%afLoginFailure%%$$") == 0) {
        // login failure
        //alert("got login failure in " + window.name);
        var inDialog = (window.dialogTop != undefined);
        if (inDialog) {
            //alert("closing dialog (from openDialog()), " + window.name);
            window.returnValue = v; // Causes openDialog() to redirect to login.jsp
            window.close();
        } else {
            //alert("going to login page in window (from openDialog()), " + window.name);
            var gotoPageStart = v.indexOf("%%$$") + 4;
            var gotoPage = v.substring(gotoPageStart, v.length);
            window.top.location=gotoPage;
        }
    }
    return v;
}

function setCookie(sName, sValue, days) {
    var date = new Date();
    if (days==undefined) days = 30;
    var m = date.getTime() + days * 24 * 60 * 60 * 1000;
    date = new Date(m);
    document.cookie = sName + "=" + escape(sValue) + "; expires=" + date.toGMTString();
}

function getCookie(sName) {
    var aCookie = document.cookie.split("; "); // cookies are separated by semicolons
    for (var i=0; i<aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");    // a name/value pair (a crumb) is separated by an equal sign
        if (sName == aCrumb[0])
            return unescape(aCrumb[1]);
    }
    return null;
}

function resizeMainPage(listNavName, listFrameName) {
    var w = document.body.clientWidth - 20;
    var h = document.body.clientHeight - 90;
    if (w<200) w = 200;
    if (h<50) h = 50;

    if (listNavName.length > 0) {
        document.getElementById(listNavName).style.width = w;
    }
    document.getElementById(listFrameName).style.width = w;
    document.getElementById(listFrameName).style.height = h;
}

/*
 * Resize a dialog to fit contents. Assumes that all dialog contents appear in a table.
 * This function adds an additional 6 pixels to the right hand border to compensate for label paddings.
 */
function resizeFormDlg() {
try {
    //first 2 vars compensate for window borders in different operating systems
    var winBorderY = parseInt(window.dialogHeight)-document.body.clientHeight;
    var winBorderX = parseInt(window.dialogWidth)-document.body.clientWidth;
    var oTable = document.all.tags("TABLE")[0];
    var l = getClientLeft(oTable);
    var t = getClientTop(oTable);
    var w = oTable.offsetWidth + l*2 + winBorderX + 6; //6 is added for forms to compensate for left-hand label padding
    var h = oTable.offsetHeight + t + winBorderY + 10; //10 is the bottom margin
}catch(e) {return;}

    window.dialogWidth = w + "px";
    window.dialogHeight = h + "px";
    window.dialogLeft = (screen.width - w)/2;
}

function resizeDlg() {
try {
    //first 2 vars compensate for window borders in different operating systems
    var winBorderY = parseInt(window.dialogHeight)-document.body.clientHeight;
    var winBorderX = parseInt(window.dialogWidth)-document.body.clientWidth;
    //filterBtnHt compensates for the fact that filter HTC is not rendered until after the
    //..page is resized, increasing the height of the page filterBtnHt number of pixels
    var coll = document.all.tags("DIV"), filterBtnHt=0;
    for (var i=0; i<coll.length; i++) {
        if (coll[i].className=="filterHTC") {
            filterBtnHt = coll[i].offsetHeight;
            break;
        }
    }
    var oTable = document.all.tags("TABLE")[0];
    var l = getClientLeft(oTable);
    var t = getClientTop(oTable);
    var w = oTable.offsetWidth + l*2 + winBorderX;
    var h = oTable.offsetHeight + filterBtnHt + t + winBorderY + 10; //10 is the bottom margin
}catch(e) {return;}

    window.dialogWidth = w + "px";
    window.dialogHeight = h + "px";
    window.dialogLeft = (screen.width - w)/2;
}

function getClientLeft(oElement) {
    var left = 0;
    while (oElement.tagName != "BODY") {
        left += oElement.offsetLeft;
        oElement = oElement.offsetParent;
    }
    return left;
}

function getClientTop(oElement) {
    var top = 0;
    while (oElement.tagName != "BODY") {
        top += oElement.offsetTop;
        oElement = oElement.offsetParent;
    }
    return top;
}

/*
 * Used by trees to set the curosr style of node images to a hand if the node contains a link
 */
function setCursor() {
    var oElement = window.event.srcElement;
    if (oElement.tagName!="IMG") return;
    var coll = oElement.parentElement.children;

    for (i=0; i<coll.length; i++) {
        if (coll[i].tagName == "A") {
            if (oElement.style.cursor=="") oElement.style.cursor = "hand";
            break;
        }
    }
}


/*
 * Returns a hexadecimal color value from r g b values
 */
function DecToHex(red,green,blue) {
   a = GetHex(Math.floor(red / 16));
   b = GetHex(red % 16);
   c = GetHex(Math.floor(green / 16));
   d = GetHex(green % 16);
   e = GetHex(Math.floor(blue / 16));
   f = GetHex(blue % 16);



   return a + b + c + d + e + f;
}
function GetHex(dec) { // called by DecToHex
   if(dec == 10) value = "A";
   else if(dec == 11) value = "B";
   else if(dec == 12) value = "C";
   else if(dec == 13) value = "D";
   else if(dec == 14) value = "E";
   else if(dec == 15) value = "F";
   else value = "" + dec;

   return value ;
}

/*
 * Removes leading and trailing spaces
 */
function trim(string) {
    while (string.indexOf(" ")==0 && string.length > 0) {
        string = string.substr(1, string.length-1);
    }
    while (string.lastIndexOf(" ")==string.length-1 && string.length > 0) {
        string = string.substr(0, string.length-1);
    }
    return string;
}

/*
 * Removes trailing spaces
 */
function rTrim(string) {
    while (string.lastIndexOf(" ")==string.length-1 && string.length > 0) {
        string = string.substr(0, string.length-1);
    }
    return string;
}

/*
 * Traps Enter and Escape keys for dialog boxes that set the following:
 * <BODY onKeyDown=dlgKeyDown(1,1)>
 */
function dlgKeyDown(trapOk, trapCancel) {
try{
    if (event.keyCode==13 && trapOk) { //enter
        event.returnValue = false;
        try {
            document.all.btnOk.click();
        }catch(e) {}
    }else if (event.keyCode==27 && trapCancel) { //escape
        event.returnValue = false;
        try {
            document.all.btnCancel.click();
        }catch(e) {}
    }
}catch(e) {}
}

function openDetailDialog(href, fromList) {
    var r = openDialog(href, '800', '490');
    if (r && r.substring(0,9) == "okClicked") {
        fromList.all.operation.value = "noop";
        fromList.forms[0].submit();
    }
}

function arrayToString(arr) {
    var resultStr = "";
    var first = true;
    for (i=0; i<arr.length; i++) {
        if (first) {
            first = false;
            resultStr = escape(arr[i]);
        } else {
            resultStr = resultStr + "|" + escape(arr[i]);
        }
    }
    return resultStr;
}

function getListTextSelection(list) {
    var n = 0;
    var arr = new Array();
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
                try{
                    var td = rows[i].all.tags("TD");
                    var t = trim(td[0].innerText);
                    if (t.length==0) t = trim(td[1].innerText);
                    if (t.length==0) t = trim(td[2].innerText);
                    arr[n] = t;
                    n++;
                }catch(e) {}
            }
        }
    }
    return arr;
}

function getListIdSelection(list) {
    var n = 0;
    var arr = new Array();
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
                try{
                    td = rows[i].all.tags("TD");
                    t = trim(td[0].getAttribute("ID"));
                    if (t == null || t.length==0) t = trim(td[1].getAttribute("ID"));
                    if (t == null || t.length==0) t = trim(td[2].getAttribute("ID"));
                    arr[n] = t;
                    n++;
                }catch(e) {}
            }
        }
    }
    return arr;
}

function getListMainColSelection(list) {
    var sText = "";
    var mainCol = 0;
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
                for (j=0; j<rows[i].cells.length; j++) {
                    var links = rows[i].cells[j].all.tags("A");
                    if (links.length > 0) {
                        for (k=0; k<links.length; k++) {
                            if (links[k].getAttribute("fireOnDblClick", 0)!=null) mainCol = j;
                        }
                    }
                }
                sText = rows[i].cells[mainCol].innerText;
                break;
            }
        }
    }
    return sText;
}

function getListSelectionIndex(list) {
    var n = 0;
    var arr = new Array();
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
                return i;
            }
        }
    }
    return -1;
}

function bogus_getListIdSelection(list) {
    var n = 0;
    var arr = new Array();
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
                try{
                    arr[n] = trim(rows[i].getAttribute("ID", false));
                    n++;
                }catch(e) {}
            }
        }
    }
    return arr;
}

function delFromList(name, fromList) {
    return delFromList(name, fromList, "");
}

function delFromList(name, fromList, relUrl) {
    var arr = getListTextSelection(fromList);
    var arr2 = getListIdSelection(fromList);

    var okToDelete = false;
    var msg;
    if (arr.length==0) {
        // NoSelection
        var m2 = formatMessage(getMessage("js_no_selection_error"), name, name);
        alert(m2);
        return;
    }else if(arr.length==1) {
        msg = formatMessage(getMessage("js_delete_confirm_prompt"), name);
    }else {
        msg = formatMessage(getMessage("js_delete_multiple_confirm_prompt"), arr.length, name);
    }
    var okToDelete = msgBox(msg, getMessage("js_delete_confirm_title"), "okCancel", 2, "images/deleteIcon.gif", relUrl);
    if (okToDelete == "ok") {
        fromList.listForm.operation.value = "delete";
        fromList.listForm.rowsToOperateOn.value = arrayToString(arr2);
        fromList.listForm.submit();
    }
}

function removeFromList(listFrame, keyName) {
    var fromList = listFrame.document;
    var name = getMessage(keyName);
    var properName = name.charAt(0).toUpperCase() + name.substring(1, name.length);
    var arr = getListTextSelection(fromList);
    var arr2 = getListIdSelection(fromList);

    var msg;
    var title;
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return;
    } else if (arr.length == 1) {
        msg = formatMessage(getMessage("js_remove_question_prompt"), name);
        title = formatMessage(getMessage("js_remove_title"), properName);
    }else {
        msg = formatMessage(getMessage("js_remove_multiple_confirm_prompt"), arr.length, name);
        title = formatMessage(getMessage("js_remove_multiple_title"), properName);
    }
    var okToDelete = msgBox(msg, title);
    if (okToDelete == "ok") {
        fromList.listForm.operation.value = "remove";
        fromList.listForm.rowsToOperateOn.value = arrayToString(arr2);
        fromList.listForm.submit();
    }
}

function deleteFromList(objectType, name, fromList) {
    var arr = getListTextSelection(fromList);
    var arr2 = getListIdSelection(fromList);

    var msg;
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return;
    }else if(arr.length==1) {
        msg = formatMessage(getMessage("js_delete_confirm_prompt"), name);
    }else {
        msg = formatMessage(getMessage("js_delete_multiple_confirm_prompt"), arr.length, name);
    }
    var okToRemove = msgBox(msg, getMessage("js_delete_confirm_title"), "okCancel", 2, "images/deleteIcon.gif");
    if (okToRemove == "ok") {
        fromList.listForm.operation.value = "delete";
        fromList.listForm.rowsToOperateOn.value = arrayToString(arr2);
        fromList.listForm.containedInType.value = objectType;
        if (objectType == "partner") {
            fromList.listForm.containedInId.value = document.all.idField.value;
        } else if (objectType == "division") {
            fromList.listForm.containedInId.value = document.all.divisionId.value;
        }
        //alert("Deleting " + arrayToString(arr2) + " from partner with ID " + document.all.idField.value);
        fromList.listForm.submit();
    }
}

function deleteItemsFromList(name, fromList) {
    var arr = getListTextSelection(fromList);
    var arr2 = getListIdSelection(fromList);

    var okToRemove = false;
    var msg;
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return;
    }else if(arr.length==1) {
        msg = formatMessage(getMessage("js_delete_confirm_prompt"), name);
    }else {
        msg = formatMessage(getMessage("js_delete_multiple_confirm_prompt"), arr.length, name);
    }
    var okToRemove = msgBox(msg, getMessage("js_delete_confirm_title"), "okCancel", 2, "images/deleteIcon.gif");
    if (okToRemove == "ok") {
        fromList.listForm.operation.value = "delete";
        fromList.listForm.rowsToOperateOn.value = arrayToString(arr2);
        fromList.listForm.submit();
    }
}

function doDeleteFromList(itemsToDelete, fromList) {
    fromList.listForm.operation.value = "delete";
    fromList.listForm.rowsToOperateOn.value = itemsToDelete;
    fromList.listForm.submit();
}

function testValues(fromList) {
    alert("operation="+fromList.listForm.operation.value+", rows="+fromList.listForm.rowsToOperateOn.value);
}

function editBtnClick(name, fromList) {
    var rows = fromList.all.tags("TR");
    var moreThanOne = false;
    var linkToFire;
    var foundOne = false;
    for (i=0; i<rows.length; i++) {
        if (rows[i].runtimeStyle.backgroundColor != "") {
            links = rows[i].all.tags("A");
            for (j=0; j<links.length; j++) {
                if (links[j].getAttribute("fireOnDblClick")!=null) {
                    if (foundOne) {
                        moreThanOne = true;
                        break;
                    }
                    foundOne = true;
                    linkToFire = links[j];
                }
            }
        }
    }
    if (moreThanOne) {
        alert(formatMessage(getMessage("SEAIE_AF:js_select_only_one"), name));
    } else if (!foundOne) {
        alert(formatMessage(getMessage("SEAIE_AF:js_no_selection_error"), name, name));
    } else {
        linkToFire.setActive();
        linkToFire.click();
    }
}

function editListItem(name, fromList) {
    var rows = fromList.all.tags("TR");
    var moreThanOne = false;
    var linkToFire;
    var foundOne = false;
    for (i=0; i<rows.length; i++) {
        if (rows[i].runtimeStyle.backgroundColor != "") {
            for (j=0; j<rows[i].cells.length; j++) {
                //if (rows[i].cells[j].getAttribute("fireOnDblClick")!=null) {
                    var links = rows[i].cells[j].all.tags("A");
                    if (links.length > 0) {
                        if (foundOne) {
                            moreThanOne = true;
                            break;
                        }
                        foundOne = true;
                        linkToFire = links[0];
                        break;
                    }
                //}
            }
        }
    }
    if (moreThanOne) {
        alert(formatMessage(getMessage("js_select_only_one"), name));
    } else if (!foundOne) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
    } else {
        linkToFire.click();
    }
}

function sortList(list, localsearch) {
    var c = 0;                                        //sort column index
    var scrollPos = document.body.scrollLeft;
    var theDoc = "";                                  //the entire list document
    var docHead = "";                                 //list document header
    var docFoot = "";                                 //list document footer
    var ascending = true;                             //sort order
    var rowArray = new Array;                         //the entire HTML TABLE structure in an array of rows
    var oSource = window.event.srcElement;            //the TD that was clicked
    while (oSource.tagName!="TD") {
        if (oSource.tagName == "TABLE") return;
        oSource = oSource.parentElement;
    }
    if (oSource.runtimeStyle.cursor!="default") return;
    if (trim(oSource.innerText)=="") return;
    var rows = list.all.tags("TR");                   //a *reference* to the rows collection; not the same as rowArray
    var numRows = rows.length;                        //number of rows in the list
    if (numRows<2) return; else numRows--;
    var numCols = rows[0].cells.length;               //number of columns in the list
    var colHeader = oSource.parentElement;            //table object that defines column header
    while (colHeader.tagName != "TR") {
        colHeader = colHeader.parentElement;
    }
    try {list.all.tags("TABLE")[0].untruncateAll()}catch(e) {}

    // determine which column header was clicked
    var sortColumnName = "";
//alert("oSource="+oSource.innerHTML);
//alert("oSource.filtername="+oSource.filtername);
    oSource.runtimeStyle.backgroundColor = "blue";
    for (c=0; c<colHeader.cells.length; c++) {
        if (colHeader.cells[c].runtimeStyle.backgroundColor != "") break;
    }
    oSource.runtimeStyle.backgroundColor = "";
    sortColumnName = colHeader.cells[c].filtername;

    //determine sort order
    pic = oSource.all.tags("IMG");
    if (pic.length==0) {
        ascending = true;
    }else {
        ascending = (pic[0].src.indexOf("Ascending")==-1);
    }
    //alert("doing " + (ascending ? "ascending" : "descending") + " sort on " + sortColumnName + " with localsearch=" + localsearch);
    if (localsearch) {
        //grab everything between the <HTML> and </HTML> tags
        for (i=0; i<list.all.length; i++) {
            if (list.all[i].tagName == "HTML") {
                theDoc = list.all[i].innerHTML;
                break;
            }
        }
        //carve up the list document into header, footer, and row structure array
        i = theDoc.indexOf("<TR", theDoc.indexOf("<TR")+3);
        j = theDoc.lastIndexOf("</TR>");
        docHead = "<HTML>"+theDoc.substring(0, i-1);
        docFoot = theDoc.substring(j+5, theDoc.length)+"</HTML>";
        theDoc = theDoc.substring(i, j);
        rowArray = theDoc.split("</TR>");

        // load table structure into array for sorting
        var temp = new Array(2);                   // temp variable for performing bubble sort
        var r = new Array(numRows);
        var flag = (trim(rows[1].cells[c].innerText).length > 0); //determine whether to sort innerText or innerHTML
        for (i=0; i<numRows; i++) {
            r[i] = new Array(2);
            r[i][0] = (flag)? rows[i+1].cells[c].innerText:rows[i+1].cells[c].innerHTML; // load the value by which the array will be sorted
            r[i][1] = rowArray[i];                  // load the row HTML that will be used to reconstruct the table
        }

        // if performing sort on numeric column, then evaluate the values first
        sortVal = r[0][0].replace(",", ""); //value used to determine whether this is a numerical sort or not
        sortVal = sortVal.replace("$", "");
        sortVal = sortVal.replace("%", "");
        if (!isNaN(sortVal)) {
            for (i=0; i<numRows; i++) {
                sortVal = r[i][0].replace(",", "");
                sortVal = sortVal.replace("$", "");
                sortVal = sortVal.replace("%", "");
                r[i][0] = parseFloat(sortVal);
            }
        }

        // sort the array using bubble sort
        if (ascending) {
            for (i=0; i<numRows; i++) {
                flag = false;
                for (j=numRows-1; j>i; j--) {
                    if (r[j-1][0] > r[j][0]) {
                        temp = r[j-1];
                        r[j-1] = r[j];
                        r[j] = temp;
                        // Swap the actual rows in the table
                        rows[j].swapNode(rows[j+1]);
                        flag = true;
                    }
                }
                if (!flag) break;
            }
        }else {
            for (i=0; i<numRows; i++) {
                flag = false;
                for (j=numRows-1; j>i; j--) {
                    if (r[j-1][0] < r[j][0]) {
                        temp = r[j-1];
                        r[j-1] = r[j];
                        r[j] = temp;
                        // Swap the actual rows in the table
                        rows[j].swapNode(rows[j+1]);
                        flag = true;
                    }
                }
                if (!flag) break;
            }
        }

        list.all.list.init();
        colHeader.scrollIntoView();
    }

    var listRelUrl = list.all.list.relativeUrl;
    if (listRelUrl == undefined) {
        listRelUrl = "";
    }

    // clear sort indicator from all column headers
    for (i=0; i<colHeader.cells.length; i++) {
        img = colHeader.cells[i].all.tags("IMG");
        if (img.length>0) {
            if (img[0].src.indexOf("sort")>-1) img[0].src = listRelUrl + "images/sortBlank.gif";
        }
    }
    // set sort indicator for the current column
    img = oSource.all.tags("IMG");
    if (img.length==0) {
        oSource.innerHTML = "<nobr>"+oSource.innerText+" <img src=" + listRelUrl + "images/spacer.gif></nobr>";
        img = oSource.all.tags("IMG");
    }
    img[0].src = (ascending)? listRelUrl + "images/sortAscending.gif" : listRelUrl + "images/sortDescending.gif";
    colHeader.style.top = 0;
    document.body.scrollLeft = scrollPos;

    if (!localsearch) {
        document.all.sortInfo.value = sortColumnName + "/" + (ascending ? "ascend" : "descend");
        document.all.listForm.submit();
    }
}

function gotoURL(url) {
    parent.titleFrame.location.href=url;
}

function updateNav() {
    parent.leftFrame.location.reload(true);
}

function loadMainURL(url) {
    parent.mainFrame.location.href=url;
}

function loadActiveLink(id) {
//alert("loading " + id);
    var link;
    if (id != undefined && id != "") {
        link = top.leftFrame.document.getElementById(id);
        if (link) {
            link.click();
        }
    }
//alert("link="+link);
    if (link == undefined) {
        // Get the first link
        var div = top.leftFrame.document.all.tags("DIV")[0];
        div.click();
    }
}

function nav(url) {
    selectLeftNav(window.event.srcElement.id);
    setContentToLink(url);
}

function setContentToLink(url) {
    if (parent.mainFrame && parent.mainFrame.location) {
        parent.mainFrame.location.href=url;
    } else {
        window.setTimeout("setContentToLink('"+url+"')", 100);
    }
}

function resizePage(treeFrameName,listFrameName,listNavName) {
    var w = document.body.clientWidth - 330;
    var h = document.body.clientHeight - 100;
/*
    alert(document.getElementById(listNavName).width);
*/
    if (w > 200) {
        document.getElementById(listFrameName).style.width = w;
        document.getElementById(listNavName).style.width = w;
    }
    if (h > 100) {
        document.getElementById(listFrameName).style.height = h;
        document.getElementById(treeFrameName).style.height = h;
    }
}

function hasChildren(obj) {
    var oParent = obj.parentElement;
    while (oParent.tagName != "DIV") oParent = oParent.parentElement;
    var childNodes = oParent.children.tags("DIV");
    return (childNodes.length>0);
}

// VITR00110481 - Fixing problem that same named groups, even in different
// hierarchies, prevent listing divisions in those groups.
function getGroupsId(obj) {
    var oParent = obj.parentElement;
    while (oParent.tagName != "DIV") oParent = oParent.parentElement;
    var groupId = oParent.getAttribute("ID");
    return groupId;
}

/*
 * Used by trees to fire a link associated with a node when the node image is clicked
 */
function fireLink() {
    var oElement = window.event.srcElement.parentElement;
    var coll = oElement.children;

    for (i=0; i<coll.length; i++) {
        if (coll[i].tagName == "A") {
            coll[i].click();
            break;
        }
    }
}

function selectIt() {
    var i = 1; // Do nothing
}

function contactDetail() {
    openDialog('contact detail.html', '630', '290');
}

function showRelationshipDetail(p) {
    if (p=="x12") {
        openDialog('x12 par relation detail.html', '800', '440');
    }else {
        openDialog('as2Relationship detail.html', '800', '440');
    }
}

function wizardCheckAndEnable() {
    var nextStep = steps[step];
    if (document.getElementById("back"+nextStep)) {
        wizardInitialEnableButtons();
    } else {
        window.setTimeout("wizardCheckAndEnable()", 100);
    }
}

function wizardInitialEnableButtons() {
    // steps and step are global to the page
    var nextStep = steps[step];
    document.getElementById("back"+nextStep).disabled = true;
    document.getElementById("next"+nextStep).disabled = (nextStep == (numSteps - 1));
    document.getElementById("finish"+nextStep).disabled = (!readyForFinish && nextStep < (numSteps - 1));
}

function wizardNextStep() {
    // This function requires that step and numSteps have been defined correctly.
    // Also note that the names of the pages must be "page0" through "pageX"
    // where "X" is numSteps - 1 .
    // The step progression is actually implemented using the steps array.  If
    // you need to skip steps, change the steps array.  Be sure to update the
    // numSteps.
    // NOTE: You can't skip steps after the last step.

    step++;
    var nextStep = steps[step];
    document.getElementById("stepNumber"+nextStep).innerText = step+1;
    document.getElementById("back"+nextStep).disabled = false;
    document.getElementById("next"+nextStep).disabled = (nextStep == (numSteps - 1));
    document.getElementById("finish"+nextStep).disabled = (!readyForFinish && nextStep < (numSteps - 1));

    var coll = document.all.tags("DIV");
    for (i=0; i<coll.length; i++) {
        if (coll[i].className=="wizPage") coll[i].style.display = "none";
    }

    document.getElementById("page"+nextStep).style.display="block";
}

function wizardBackStep() {
    // This function requires that step and numSteps have been defined correctly
    // Also note that the names of the pages must be "page0" through "pageX"
    // where "X" is numSteps - 1 .

    step--;
    var prevStep = steps[step];
    document.getElementById("back"+prevStep).disabled = (prevStep == 0);
    document.getElementById("finish"+prevStep).disabled = (!readyForFinish && prevStep < numSteps);
    document.getElementById("next"+prevStep).disabled = false;

    var coll = document.all.tags("DIV");
    for (i=0; i<coll.length; i++) {
        if (coll[i].className=="wizPage") coll[i].style.display = "none";
    }

    document.getElementById("page"+prevStep).style.display="block";
}

function wizardFinishStep(formObject) {
    formObject.submit();
}

function selectEnables(form, labelToEnable, fieldToEnable, valueToTest) {
    document.getElementById(labelToEnable).disabled = (form.qualifier.value != valueToTest);
    document.getElementById(fieldToEnable).disabled = (form.qualifier.value != valueToTest);
}

function doContextChoice() {
    if (form.context.value=="") {
        alert("You must select a context before you can continue.");
        form.context.focus();
    }else {
        returnValue = form.context.value;
        window.close();
    }
}

function showParms(chooserclass) {
alert("chooserclass=" + chooserclass);
    var url = openDialog('contextChooser.jsp?classname=' + chooserclass, '500', '200');
alert("url=" + url);
    if (url==undefined) //clicked Cancel
        return;
}

/*
 * If there is only one protocol installed, we can jump straight into the wizard for
 * that context. Otherwise, allow the user to select the context in a seperate page, then display
 * the appropriate wizard for the selected context.
 */
function launchContextWizard(contextListDoc, chooserclass) {
    var url = openDialog('contextChooser.jsp?classname=' + chooserclass + "&parms=" + document.all.idField.value, '500', '200');
    if (url==undefined) //clicked Cancel
        return;
    else {
        url = "wizard.jsp?classname=" + url + "&parms=" + document.all.idField.value;
    }

    if (url!="") {
        var r = openDialog(url, '680', '500');
        if (r && r.substring(0,9) == "okClicked") {
            contextListDoc.all.operation.value = "noop";
            contextListDoc.forms[0].submit();
        }
    } else {
        launchContextWizard(contextListDoc, chooserclass);
    }
}

function launchContextImporter(contextListDoc, chooserclass) {
    var url = openDialog('contextChooser.jsp?classname=' + chooserclass, '500', '200');
    if (url==undefined) //clicked Cancel
        return;
    else {
        url = "import.jsp?classname=" + url;
    }

    if (url!="") {
        var r = openDialog(url, '747', '330');
    } else {
        launchContextImporter(contextListDoc, chooserclass);
    }
}

/*
 * There is no idField when creating a new relationship, since a relationship isn't
 * created inside anything, like a partner context is created inside a partner.
 */
function launchRelationshipContextWizard(contextListDoc, chooserclass) {
    var url;
    var newContextClass = openDialog('contextChooser.jsp?classname=' + chooserclass, '500', '200');
    if (newContextClass==undefined) //clicked Cancel
        return;
    else {
        url = "wizard.jsp?classname=" + newContextClass;
    }

    if (url != "") {
        var r = openDialog(url, '680', '500');
        if (r && r.substring(0,9) == "okClicked") {
            contextListDoc.all.operation.value = "noop";
            contextListDoc.forms[0].submit();
        }
    } else {
        launchRelationshipContextWizard(contextListDoc, chooserclass);
    }
}

function trimText(theField) {
    if (theField.value.length == 0) return "";
    var theValue = theField.value;
    return trim(theValue);
}

function listLabels(formName) {
    var theForm = document.getElementById(formName);
    var fields = theForm.all.tags("LABEL");
    var fieldList = "";
    for (i=0; i<fields.length; i++) {
        fieldList = fieldList + ", " + fields[i].id;
    }
    alert(fieldList);
}

/*
 * Checks if the required fields have values.  If so, sets the page variable
 * readyForFinish to true so the Finish button will become enabled and
 * returns true so we can go to the next page.  If the required are not
 * filled, sets readyForFinish to false and returns false.
 */
function finishOKIfRequiredFilled(formName) {
    if (checkRequiredFilled(formName)) {
        readyForFinish = true;
        return true;
    } else {
        readyForFinish = false;
        document.getElementById("finish"+step).disabled = true;
        return false;
    }
}

function checkRequiredFilledInForm(theForm) {
//alert("Working on " + formName);
    var msg = "";
    var fieldName = "";
    var end = 0;
    var theField;
    var fields = theForm.all.tags("LABEL");
    for (i=0; i<fields.length; i++) {
        if (fields[i].className=="requiredErrLabel")
            fields[i].className="requiredLabel";
    }
    for (i=0; i<fields.length; i++) {
        if (fields[i].className=="requiredLabel") {
            end = fields[i].id.length - 5; // Length minus length of "Label"
            fieldName = fields[i].id.substring(0, end);
            theField = document.getElementById(fieldName);
            //alert("found required field " + fieldName + " with value " + theField.value);
            var trimmedValue = trimText(theField);
            if (theField.value.length == 0 || trimmedValue.length == 0) {
                fields[i].className = "requiredErrLabel";
                if (msg == "") {
                    // Message about the first one
                    //alert("visibility="+theField.style.visibility);
                    try {
                        theField.focus();
                    } catch (e) {
                        //alert("Error (" + e.number + "): " + e.description);
                        makeFieldsTabVisible(theField);
                        theField.focus();
                    }
                    msg = formatMessage(getMessage("js_required_field_error"), fields[i].innerText);
                }
            }
        }
    }
    if (msg != "") {
        alert(msg);
        return false;
    } else {
        return true;
    }
}

function checkRequiredFilled(formName) {
    var theForm = document.getElementById(formName);
    return checkRequiredFilledInForm(theForm);
}

function checkTabsRequiredFilled() {
    return checkRequiredFilledInForm(document.forms[0]);
}

function makeFieldsTabVisible(theField) {
    var theDiv = theField.parentElement;
    while (theDiv.tagName != "DIV" && theDiv.className != "tab") {
        if (theDiv.tagName=="BODY") return;
        theDiv = theDiv.parentElement;
    }
    var tabId = theDiv.getAttribute("ID");
    // Find the associated tab and click it
    var coll = document.all.tags("TD");
    for (var i=0; i < coll.length; i++) {
        if (coll[i].getAttribute("CHILD")) {
            if (coll[i].getAttribute("CHILD") == tabId) {
//alert("clicking on tab " + tabId);
                coll[i].click();
                return;
            }
        }
    }
}

function launchEditDialog(name, fromList, classname, height, width) {
    arr = getListTextSelection(fromList);
    arr2 = getListIdSelection(fromList);
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
    }else if(arr.length==1) {
        var r = openDialog("editDialog.jsp?classname=" + classname + "&parms=" + escape(arr2[0]), height, width);
        if (r && r.substring(0,9) == "okClicked") {
            fromList.all.operation.value = "noop";
            fromList.forms[0].submit();
        }
    }else {
        alert(formatMessage(getMessage("js_select_only_one"), name));
    }
}

/**  SHOULD DEPRECATE THIS, IF POSSIBLE...NOT USED BY MY STUFF **/
function launchDetailDialog(name, fromList, classname, height, width) {
    arr = getListTextSelection(fromList);
    arr2 = getListIdSelection(fromList);
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
    }else if(arr.length==1) {
        var r = openDialog("detailDialog.jsp?classname=" + classname + "&parms=" + escape(arr2[0]), height, width);
        if (r && r.substring(0,9) == "okClicked") {
            fromList.all.operation.value = "noop";
            fromList.forms[0].submit();
        }
    }else {
        alert(formatMessage(getMessage("js_select_only_one"), name));
    }
}

function handleDetailDialog(fromList, classname, id, height, width) {
    var r = openDialog("tabbedDialog.jsp?classname=" + classname + "&parms=" + escape(id), height, width);
    if (r && r.substring(0,9) == "okClicked") {
        fromList.all.operation.value = "noop";
        fromList.forms[0].submit();
    }
}

function getSelectedLinkToFire(fromList) {
    var rows = fromList.all.tags("TR");
    for (i=0; i<rows.length; i++) {
        if (rows[i].runtimeStyle.backgroundColor != "") {
            for (j=0; j<rows[0].cells.length; j++) {
                if (rows[0].cells[j].getAttribute("fireOnDblClick")!=null) {
                    var links = rows[i].cells[j].all.tags("A");
                    if (links.length > 0) return links[0].href;
                    break;
                }
            }
            return "";
        }
    }
    return "";
}

function redirectToURL(url) {
    var id = document.uniqueID;
    var name = window.name;
    if (name=="") {
        name = "thisWindow";
        window.name = name;
    }
    var link = "<a href='"+url+"' target='"+name+"' id='"+id+"' style='display:none'></a>";
    document.body.insertAdjacentHTML("afterBegin", link);
    document.getElementById(id).click();
}

function tabbedDialogForThisContext(name, fromList, id, classname, height, width) {
    var href = "dialogTypeSelector.jsp?classname=" + classname + "&parms=" + id;
    var r = openDialog(href, 800, 490);
    if (r && r.substring(0,9) == "okClicked") {
        fromList.all.operation.value = "noop";
        fromList.forms[0].submit();
    }
}

function editDialogForThisContext(name, fromList, id, classname, height, width) {
    var href = "dialogTypeSelector.jsp?classname=" + classname + "&parms=" + id;
    var r = openDialog(href, 385, 215);
    if (r && r.substring(0,9) == "okClicked") {
        fromList.all.operation.value = "noop";
        fromList.forms[0].submit();
    }
}

/**  SHOULD DEPRECATE THIS, IF POSSIBLE...NOT USED BY MY STUFF **/
function launchEditContextDialog(name, fromList, height, width) {
    var arr = getListTextSelection(fromList);
    var arr2 = getListIdSelection(fromList);
    if (arr.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
    }else if(arr.length==1) {
        var href = getSelectedLinkToFire(fromList);
        var r = openDialog(href, height, width);
        if (r && r.substring(0,9) == "okClicked") {
            fromList.all.operation.value = "noop";
            fromList.forms[0].submit();
        }
    }else {
        alert(formatMessage(getMessage("js_select_only_one"), name));
    }
}

function newPartner(partnerListDoc) {
    var v = openDialog('wizard.jsp?classname=com.vitria.af.admin.NewPartnerUI', '680', '505');
    if (v && v.substring(0,9) == "okClicked") {
        partnerListDoc.all.operation.value = "noop";
        partnerListDoc.forms[0].submit();
    }
}

function newDivision(divisionListDoc) {
    var partnerId = document.all.idField.value;
    var v = openDialog('wizard.jsp?classname=com.vitria.af.admin.NewDivisionUI&parms=' + escape(partnerId), '680', '500');
    if (v && v.substring(0,9) == "okClicked") {
        divisionListDoc.all.operation.value = "noop";
        divisionListDoc.forms[0].submit();
    }
}

function addToField(field, valueToAdd) {
    var currentValue = field.value;
    if (currentValue.length > 0) currentValue = currentValue + ",";
    currentValue = currentValue + valueToAdd;
    field.value = currentValue;
}

function newPartnerContact(listFrameDoc) {
    var partnerId = document.all.idField.value;
    var r = openDialog('newDialog.jsp?classname=com.vitria.af.admin.NewContactHandler&parms=' + escape('partner/' + partnerId), '685', '338');
    if (r && r.substring(0,9) == "okClicked") {
        listFrameDoc.all.operation.value = "noop";
        listFrameDoc.forms[0].submit();
    }
}

function newDivisionContact(listFrameDoc) {
    var divisionId = document.all.divisionId.value;
    var r = openDialog('newDialog.jsp?classname=com.vitria.af.admin.NewContactHandler&parms=' + escape('division/' + divisionId), '685', '338');
    if (r && r.substring(0,9) == "okClicked") {
        listFrameDoc.all.operation.value = "noop";
        listFrameDoc.forms[0].submit();
    }
}

function getPickedIds(name, pickListDoc, op, onlyOne) {
    var rows = pickListDoc.all.tags("TR");
    var selectedRows = new Array();
    var j = 0;
    for (i=1; i<rows.length; i++) {
        if (rows[i].runtimeStyle.backgroundColor != "") {
            td = rows[i].all.tags("TD");
            t = trim(td[0].getAttribute("ID"));
            selectedRows[j] = t;
            j++;
        }
    }
    if (selectedRows.length == 0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return false;
    } else if (onlyOne && selectedRows.length > 1) {
        alert(formatMessage(getMessage("js_picklist_select_only_one"), name));
        return false;
    } else {
        document.all.operation.value = op;
        document.all.idsToOperateOn.value = arrayToString(selectedRows);
        return true;
    }
}

/**
 * Handles when only one set of filter widgets
 **/
function doPicklistFilter(filterDoc, classname) {
    var filterInfo = document.forms[0].filterObjName.value + "/" +
                     document.forms[0].filterType.value + "/" +
                     document.forms[0].filterValue.value;
    //alert("filtering on " + filterInfo);
    if (document.forms[0].filterValue.value == "") {
        filterDoc.all.filterInfo.value = "";
        filterDoc.all.listForm.submit();
        //filterDoc.location = "list.jsp?classname=" + classname + "&listtype=picklist";
    } else {
        filterDoc.all.filterInfo.value = filterInfo;
        filterDoc.all.listForm.submit();
        //filterDoc.location = "list.jsp?classname=" + classname + "&listtype=picklist&parms=" + escape(filterInfo);
    }
}

function doFilterWithGroup(filterDoc, classname, turnOff) {
    var groupName = document.all.filterExtras.value;
    handleFiltering(filterDoc, classname, groupName, turnOff);
}

function doFilter(filterDoc, classname, turnOff, relUrl, filterHtcWidget) {
    var extraParms;
    if (filterHtcWidget != undefined) {
        extraParms = filterHtcWidget.getFilterExtras();
    } else if (document.all.filterExtras) {
        extraParms = document.all.filterExtras.value;
    } else {
        extraParms = "";
    }
    handleFiltering(filterDoc, classname, extraParms, turnOff, relUrl, filterHtcWidget);
}

/**
 * Handles two sets of filter widgets with an AND and OR between.
 **/
function handleFiltering(filterDoc, classname, extraParms, turnOff, relUrl, filterHtcWidget) {
    var relativeUrl = ((relUrl != undefined) ? relUrl : "");
    var parmStr = "";
/*
    if (extraParms == "$$XX$$") {
        if (filterHtcWidget != undefined) {
            extraParms = filterHtcWidget.getFilterExtras();
        } else {
            extraParms = "";
        }
    }
*/
    if (extraParms != "") parmStr = "&parms=" + extraParms;
    if (turnOff) {
        filterDoc.location = relativeUrl + "list.jsp?classname=" + classname + parmStr;
        return;
    }
    var filterInfo;
    if (filterHtcWidget != undefined) {
        filterInfo = filterHtcWidget.getValues();
    } else {
        var replacedValue = document.all.filterValue.value;
        var slashLoc = replacedValue.indexOf("/");
        while (slashLoc >= 0) {
            replacedValue = replacedValue.replace("/", "%%slash%%");
            slashLoc = replacedValue.indexOf("/");
        }
        var replacedValue2 = document.all.filterValue2.value;
        slashLoc = replacedValue2.indexOf("/");
        while (slashLoc >= 0) {
            replacedValue2 = replacedValue2.replace("/", "%%slash%%");
            slashLoc = replacedValue2.indexOf("/");
        }
//alert("value="+replacedValue);
        filterInfo = document.all.filterObjName.value + "/" +
                     document.all.filterType.value + "/" +
                     replacedValue + "/" +
                     document.all.filterBoolean.value + "/" +
                     document.all.filterObjName2.value + "/" +
                     document.all.filterType2.value + "/" +
                     replacedValue2;
    }
    //alert("filtering on " + filterInfo);
/*
    if (document.all.filterValue.value == "") {
        filterDoc.all.filterInfo.value = filterInfo;
        filterDoc.all.listForm.submit();
    } else {
*/
        filterDoc.all.filterInfo.value = encodeURI(filterInfo);
        filterDoc.all.listForm.submit();
//    }
}

function showPagination(first, last, total) {
    if (parent.document.all.alphaBar) {
        parent.document.all.alphaBar.redisplay(first,last,total);
    }
}

function showSpecificPagination(paginationWidgetName, first, last, total) {
    if (parent.document.getElementById(paginationWidgetName)) {
        parent.document.getElementById(paginationWidgetName).redisplay(first,last,total);
    } else if (parent.document.getElementById("alphaBar")) {
        parent.document.getElementById("alphaBar").redisplay(first,last,total);
    }
}

function goFirstPage(total, listFrameId) {
    var pageAmt = 50;
    var end = pageAmt;
    if (end > total) end = total;
    document.frames(listFrameId).document.all.pageInfo.value = "1/" + end;
    document.frames(listFrameId).document.all.listForm.submit();
}

function goPrevPage(current, total, listFrameId) {
    var pageAmt = 50;
    var start = current - pageAmt;
    if (start < 1) start = 1;
    var end = start + (pageAmt - 1);
    if (end > total) end = total;
    document.frames(listFrameId).document.all.pageInfo.value = start + "/" + end;
    document.frames(listFrameId).document.all.listForm.submit();
}

function goNextPage(current, total, listFrameId) {
    var pageAmt = 50;
    var start = current + pageAmt;
    if (start > total) {
        // Off end...we were on the last page...shouldn't be here
        return;
    }
    var end = start + (pageAmt - 1);
    if (end > total) end = total;
    document.frames(listFrameId).document.all.pageInfo.value = start + "/" + end;
    document.frames(listFrameId).document.all.listForm.submit();
}

function goLastPage(current, total, listFrameId) {
    var pageAmt = 50;
    var start = current;
    while (start + pageAmt <= total) {
        start = start + pageAmt;
    }
    var end = start + (pageAmt - 1);
    if (end > total) end = total;
    document.frames(listFrameId).document.all.pageInfo.value = start + "/" + end;
    document.frames(listFrameId).document.all.listForm.submit();
}

// Functions to handle local lists (lists that are populated from a hidden
// field instead of from their XMLGetter class).  The listinfo should be set
// by the XMLGetter (UI Generator) class, but no listdata.

/*
 * Handles populating the local list from a hidden, but only after the list
 * has been fully loaded.  This should be called from the onload of a page.
 *
 * The listFrameName is the ID of the iframe holding the list, e.g., "listFrame".
 * The hiddenName is the name of the hidden field containing the delimited
 *     data that should be used to populate the list.  Of course, the number of
 *     "cells" of data per row should equal the number of columns in the table.
 */
function delayedPopulateLists(listFrameName, hiddenName){
    if ( window.frames[listFrameName] &&
            window.frames[listFrameName].document.all.tags("table")[0] &&
            window.frames[listFrameName].document.all.tags("table")[0].rows.length > 0 ){
        populateLists(listFrameName, hiddenName);
    } else{
        window.setTimeout("delayedPopulateLists('"+listFrameName+"','"+hiddenName+"');",1000);
    }
}

/*
 * Uses populateListFromHiddenField() to do so.
 */
function populateLists(listFrameName, hiddenName){
    var hiddenObj = window.document.getElementById(hiddenName);
    populateListFromHiddenField(hiddenObj,window.frames[listFrameName]);
    return true;
}

/*
 * Expects a list containing rows and cells.  Encodes the data in the list into
 * the hiddenField hidden where each row is delimited by a tab ("\t") and each
 * cell in each row is delimited by a vertical bar ("|").  If the first cell
 * has an ID attribute, the value is prepended as the first cell.  Otherwise, that
 * cell will be empty.
 */
function populateHiddenFieldFromList(hiddenField, listFrame) {
    var comp = "";
    var tbl = listFrame.document.all.tags("table")[0];
    for ( var i = 1; i < tbl.rows.length; i++){
        var row = tbl.rows[i];
        if (row.cells[0].id) {
            comp += row.cells[0].id + "|";
        } else {
            comp += "|";
        }
        for (var j = 0; j < row.cells.length; j++) {
            comp += row.cells[j].innerHTML;
            if (j+1 < row.cells.length) comp += "|";
        }

        comp +="\t";
    }
    hiddenField.value = comp;
}

/*
 * Expects a hidden field, hiddenField, containing data encoded where each row
 * is delimited by a tab ("\t") and each cell in each row is delimited by a
 * vertical bar ("|").  This is then used to populate a list with rows and
 * cells.  The last cell is stored in the ID field on the first cell.
 */
function populateListFromHiddenField(hiddenField, listFrame) {
    var tbl = listFrame.document.all.tags("table")[0];
    while ( tbl.rows.length > 1){
        tbl.deleteRow(tbl.rows.length-1);
    }
    var comp = hiddenField.value;
//alert("hidden value = " + comp);
    var lines = comp.split("\t");
    for ( var i = 0; i < lines.length; i++){
        var fields = lines[i].split("|");
//alert("fields length = " + fields.length);
        if ( fields.length > 1 ){
            var row = tbl.insertRow();
            var cell = row.insertCell();
//alert("fields[0]=" + fields[0]);
            cell.id = fields[0];
            for ( var j = 1; j < fields.length; j++){
                if (j != 1) cell = row.insertCell();
                cell.innerHTML = fields[j];
//alert("fields[" + j + "]="+fields[j]);
            }
        }
    }
    tbl.init();
//alert("tbl.rows.length=" + tbl.rows.length);
//for (var m = 0; m < tbl.rows.length; m++) {
//    alert("tbl.rows["+m+"]="+tbl.rows[m].innerHTML);
//}
}

/*
 * Returns an array of the indexes in a list of the selected rows.
 *
 * The list parameter is the document of a list frame.
 */
function getListSelectionIndexArray(list) {
    var n = 0;
    var arr = new Array();
    var rows = list.all.tags("TR");
    if (rows.length > 0) {
        for (var i=0; i<rows.length; i++) {
            if (rows[i].runtimeStyle.backgroundColor != "") {
            	arr[n] = i;
            	n++
            }
        }
    }
    return arr;
}

function arrayFromRowString(rowStr) {
    return rowStr.split("|");
}

/*
 * Deletes the selected rows from a local list and updates the hiddenField
 * encoded value.  This should be called after the user has been prompted for
 * confirmation (use getListTextSelection() to determine how many rows are
 * selected) because this function just deletes the selected stuff.
 */
function deleteListRow(hiddenField, listFrame) {
    var tbl = listFrame.document.all.tags("table")[0];
    var idxArr = getListSelectionIndexArray(tbl);
    var selRowTxt = getListTextSelection(tbl);

    for ( var i = idxArr.length - 1 ; i >= 0; i--){
        tbl.deleteRow(idxArr[i]);
    }

    populateHiddenFieldFromList(hiddenField, listFrame);
    tbl.init();
}

function updateListRow(hiddenField, listFrame, rowIndex, valueArray) {
    if (rowIndex == 0) return;
    var tbl = listFrame.document.all.tags("table")[0];
    var row = tbl.rows[rowIndex];

    row.cells[0].id = valueArray[0];
    for ( var i = 0; i < row.cells.length; i++)
    {
        row.cells[i].innerText = valueArray[i+1];
    }

    populateHiddenFieldFromList(hiddenField, listFrame);
    tbl.init();
}

function addListRow(hiddenField, listFrame, valueArray) {
    var tbl = listFrame.document.all.tags("table")[0];
    if ( valueArray && valueArray.length ) {
        var row = tbl.insertRow();

        var cell = row.insertCell();
        cell.id = valueArray[0];
        for ( var i = 1; i < valueArray.length; i++) {
            if (i > 1) cell = row.insertCell();
            cell.innerHTML = valueArray[i];
        }
    }

    populateHiddenFieldFromList(hiddenField, listFrame);
    tbl.init();
}

function removeFromLocalList(hiddenField, listFrame, keyName) {
    var name = getMessage(keyName);
    var properName = name.charAt(0).toUpperCase() + name.substring(1, name.length);
    var tbl = listFrame.document.all.tags("table")[0];
    var idxArr = getListSelectionIndexArray(tbl);
    var selRowTxt = getListTextSelection(tbl);

    var okToDelete;
    var msg;
    var title;
    if (selRowTxt.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return;
    } else if (selRowTxt.length == 1) {
        msg = formatMessage(getMessage("js_remove_question_prompt"), name);
        title = formatMessage(getMessage("js_remove_title"), properName);
    }else {
        msg = formatMessage(getMessage("js_remove_multiple_confirm_prompt"), selRowTxt.length, name);
        title = formatMessage(getMessage("js_remove_multiple_title"), properName);
    }
    var okToDelete = msgBox(msg, title);
    if (okToDelete == "ok") {
        deleteListRow(hiddenField, listFrame);
    }
}

function deleteFromLocalList(hiddenField, listFrame, keyName) {
    var name = getMessage(keyName);
    var properName = name.charAt(0).toUpperCase() + name.substring(1, name.length);
    var tbl = listFrame.document.all.tags("table")[0];
    var idxArr = getListSelectionIndexArray(tbl);
    var selRowTxt = getListTextSelection(tbl);

    var okToDelete;
    var msg;
    if (selRowTxt.length==0) {
        alert(formatMessage(getMessage("js_no_selection_error"), name, name));
        return;
    } else if (selRowTxt.length == 1) {
        msg = formatMessage(getMessage("js_delete_confirm_prompt"), name);
    }else {
        msg = formatMessage(getMessage("js_delete_multiple_confirm_prompt"), selRowTxt.length, name);
    }
    var okToDelete = msgBox(msg, getMessage("js_delete_confirm_title"), "okCancel", 2, "images/deleteIcon.gif");
    if (okToDelete == "ok") {
        deleteListRow(hiddenField, listFrame);
    }
}

/* An example Delete function...
function deleteFlatTableRow(hiddenField, listFrame) {
    var tbl = listFrame.document.all.tags("table")[0];
    var idxArr = getListSelectionIndexArray(tbl);
    var selRowTxt = getListTextSelection(tbl);

    var okToDelete = false;
    if (selRowTxt.length==0) {
        alert("No Transaction sets are selected.\r\rTo select a Transaction set, click anywhere on a row.");
    } else if (selRowTxt.length == 1) {
    	okToDelete = confirm("Delete the Transaction set " + selRowTxt[0] + "?");
    }
    else {
        okToDelete = confirm("Delete the selected Transaction set(s)?");
    }
    if(okToDelete) {
        deleteListRow(hiddenField, listFrame);
    }
}
*/

/* An example Edit function...
 * Essentially, it constructs parameters to a JSP from the row, displays a
 * dialog with the content, then gets a return value that is an array of
 * values that should be set into the row.  This is very specific to the
 * edit dialog.
function updateFlatTableRow(hiddenField,listFrame,jspfile) {
    var tbl = listFrame.document.all.tags("table")[0];
    var idx = getListSelectionIndex(tbl);


    if ( idx > 0 )
   {
        var row = tbl.rows[idx];

        var params = "?p1=x";

        for ( var i = 0; i < row.cells.length; i++)
        {
            params += "&column"+(i+1)+"="+escape(row.cells[i].innerText);
        }
        params += "&column5="+row.tName;
        if ( row.conventionSegmentElement && row.elementValue )
        {
             params += "&column6=on";
             params += "&column7="+row.conventionSegmentElement;
             params += "&column8="+row.elementValue;
        }
        var r = openDialog("work/edi-x12/"+jspfile+params, '600', '450');

        if ( r.length )
        {
            var found = "false";

            var parts = hiddenField.value.split("\t");

            for(var x = 0; x < parts.length; x++ )
            {
                var trans = parts[x].split( "|" );

  //            alert( trans[0] );
  //            alert( parts[x] );

                if( ( trans[0] == r[0] ) &&
                    ( trans[1] == r[1] ) &&
                    ( trans[2] == r[2] ) &&
                    ( trans[3] == r[3] ) )
                {
                   found = "true";
                }

         }

         if( found == "false" )
         {
            updateListRow(listFrame, idx, r); // Note: doesn't handle extra fields
         }
         else
         {
            alert("This transaction already exists for this division relationship" );
         }
        }
    }
}
*/

/* An example Add function...
function addFlatTableRow(hiddenField,listFrame,jspfile) {
    var r = openDialog("work/edi-x12/"+jspfile, '600', '450');
     var found = "false";

    var parts = hiddenField.value.split("\t");

    for(var x = 0; x < parts.length; x++ )
    {
        var trans = parts[x].split( "|" );

//      alert( trans[0] );
//      alert( parts[x] );

        if( ( trans[0] == r[0] ) &&
             ( trans[1] == r[1] ) &&
             ( trans[2] == r[2] ) &&
             ( trans[3] == r[3] ) )
      {
         found = "true";
      }


    }


    if ( found == "false" )
    {
        if ( r && r.length )
        {
            var row = listFrame.document.all.tags("table")[0].insertRow();
            for ( var i = 0; i < 4; i++){
                var cell = row.insertCell();
                cell.innerText = r[i];
            }
            row.tName = r[4];
            if ( r[5] == true){
                row.conventionSegmentElement = r[6];
                row.elementValue = r[7];
            }
         else
            {
                row.conventionSegmentElement = "";
                row.elementValue = "";
            }

        }
    }
    else
    {
        alert("This transaction already exists for this division relationship" );
    }

    populateHiddenField(hiddenField,listFrame);

}
*/

function searchTree(queryFieldName, treeFrameName) {
    var queryField = document.getElementById(queryFieldName);
    var searchFor = queryField.value;
    if (searchFor=="") {
        queryField.focus();
        alert(getMessage("js_enter_search_string_prompt"));
        return;
    }
//alert('document.getElementById("' + treeFrameName + '")=' + document.getElementById(treeFrameName));
//alert('document.getElementById("' + treeFrameName + '").document=' + document.getElementById(treeFrameName).document);
//alert('document.getElementById("' + treeFrameName + '").document.all.tags("DIV").length=' + document.getElementById(treeFrameName).document.all.tags('DIV').length);
//alert('document.frames["' + treeFrameName + '"].document.getElementById("groupsTree")=' + document.getElementById(treeFrameName).document.getElementById("groupsTree"));
//alert('document.frames["' + treeFrameName + '"].document.all.tags("DIV")[0]=' + document.frames[treeFrameName].document.all.tags('DIV')[0]);
    document.frames[treeFrameName].document.all.tags('DIV')[0].find(searchFor);
}

function getSelectedTreeItem(tree, treeIdName) {
    var coll = tree.all.tags("DIV");
    var selectedItem = -1;
    for (i=0; i < coll.length; i++) {
        if (coll[i].getAttribute("ID") != treeIdName) {
            var divLinks = coll[i].all.tags("A");
            if (divLinks.length > 0) {
                var nextLink = divLinks[0];
                if (nextLink.style.backgroundColor != "") {
                    selectedItem = i;
                    break;
                }
            }
        }
    }
    if (selectedItem == -1) return undefined;
    var divTags = tree.all.tags("DIV");
    return divTags[selectedItem];
}

function getSelectedTreeItemId(treeFrameName, treeIdName) {
    var itemId = "";
    var tree = frames[treeFrameName].document;
    var selectedDiv = getSelectedTreeItem(tree, treeIdName);
    if (selectedDiv == undefined) return "";

    // Get the ID of the selected item
    itemId = selectedDiv.getAttribute("ID");
    return itemId;
}

function setFrameContent(frameObj, helptopic) {
    if ((frameObj != null) && (frameObj.location != null))
        frameObj.location.href=helptopic;
}

var helpWin;
function showHelp(helpurl, helptopic) {
   if (helpurl == undefined || helpurl == "") helpurl = "adminui/appadmn_help.htm";
   if (helptopic == undefined) helptopic = "";
   var strURL = "/af/docs/" + helpurl;
   var strHelpOptions = "";
   helpWin = open(strURL, "vtAFHelpWindow", strHelpOptions);
   if (helptopic != "") {
       setTimeout("setFrameContent(helpWin.frames['bsscright'], '" + "/af/docs/" + helptopic + "')", 500);
   }
}

function submitPickList() {
    var okButton = parent.document.getElementById("btnOk");
    if (okButton) {
        okButton.click();
    } else {
        alert("no OK button");
    }
}

function handleListRefresh(interval) {
    refreshVar = setTimeout('doListRefresh(false)', interval);
}

function cancelListRefresh() {
    if (refreshVar && refreshVar != undefined) {
//alert("cancelling list refresh");
        clearInterval(refreshVar);
    }
}

function doListRefresh(forceRefresh) {
    if (forceRefresh || (firstItem && firstItem == 1)) {
        document.all.operation.value = "noop";
        document.forms[0].submit();
    }
}

/***************************************************************
*                  used by JYFWGL Webapp					   *
***************************************************************/

function doStartService(itemsToStart, fromList) {
    fromList.listForm.operation.value = "start";
    fromList.listForm.rowsToOperateOn.value = itemsToStart;
    fromList.listForm.submit();
}

function doStopService(itemsToStop, fromList) {
    fromList.listForm.operation.value = "stop";
    fromList.listForm.rowsToOperateOn.value = itemsToStop;
    fromList.listForm.submit();
}

function doDeleteService(itemsToDelete, fromList) {
    fromList.listForm.operation.value = "delete";
    fromList.listForm.rowsToOperateOn.value = itemsToDelete;
    fromList.listForm.submit();
}

function doRevokeService(itemsToRevoke, fromList) {
    fromList.listForm.operation.value = "revoke";
    fromList.listForm.rowsToOperateOn.value = itemsToRevoke;
    fromList.listForm.submit();
}


/***************************************************************
*                  added by liuli			   *
***************************************************************/
function clickLink(url) {
    top.mainFrame.location=url;
}
