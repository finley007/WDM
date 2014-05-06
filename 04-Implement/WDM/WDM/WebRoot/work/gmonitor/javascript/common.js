// use this function for common multi selector
//notice: selected_workType as the return 
function showPostDialog(selected_workType,url,width,height){
	
    
	showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;
    retval= window.showModalDialog(url, "", "dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );
	if( retval != null ){
		selected_workType.value = retval;
	}else{
		//alert("canceled");
	}
}

function showSoErrInfoDialog(url,width,height){
	showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;
    window.showModalDialog(url, "", "dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );
}

function showFavoriteDialog(url,width,height){
	showx = event.screenX - event.offsetX - 4 - 210 ; // + deltaX;
	showy = event.screenY - event.offsetY + 18; // + deltaY;
	newWINwidth = 210 + 4 + 18;
    window.showModalDialog(url, "", "dialogWidth:"+width+"px; dialogHeight:"+height+"px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );
}

function testRegExp(type,str){
	if(type == "ip")
		return /((?:(?:25[0-5]|2[0-4]\d|[01]?\d?\d)\.){3}(?:25[0-5]|2[0-4]\d|[01]?\d?\d))/.test(str);
	else if(type == "mac")
		return /^([0-9a-fA-F]{2})(([/\s:-][0-9a-fA-F]{2}){5})$/.test(str);
	else if(type == "apgroup")
		return /[A-Za-z0-9_]{1,255}/.test(str);
	else if(type == "numbder")
		return /[1-9][0-9]*/.test(str);
	else if(type == "ascii5")
		return /[\x00-\x7f]{5}/.test(str);
	else if(type == "ascii8")
		return /[\x00-\x7f]{8,63}/.test(str);
	else
		return true;
}

//删除左右两端的空格 
function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, ""); 
} 

//计算包含英文字母的unicode字符串的实际长度
function getUnicodeLength(unicode){
	var length = 0;
	var codes = unicode.split(";");
	for(var i in codes){
		if(codes[i].length <= 0)
			continue;
		length++;
		if(codes[i].length > 8)
			length += codes[i].length - 8;
	}
	return length;
}

