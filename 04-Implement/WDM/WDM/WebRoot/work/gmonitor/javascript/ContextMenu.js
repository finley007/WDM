$(function(){
document.oncontextmenu=function(){return false;}//��Ļ�Ҽ�
document.onmousemove=mouseMove;//��¼���λ��
});
var mx=0,my=0;
function mouseMove(ev){Ev=ev||window.event;var mousePos=mouseCoords(Ev);mx=mousePos.x;my=mousePos.y;} 
function mouseCoords(ev){
	if(ev.pageX||ev.pageY){return{x:ev.pageX,y:ev.pageY};}
	return{x:ev.clientX,y:ev.clientY+$(document).scrollTop()};
}

$.fn.extend({RightMenu: function(id,pid,ev,options){options = $.extend({menuList:[]},options);var menuCount=options.menuList.length;
	if (!$("#"+id)[0]){
		var divMenuList="<div id=\""+id+"\" class=\"div_RightMenu\"><div><ul class='ico'>";
		divMenuList+="<li style=\"font-weight:bold;\">���չʾ��ѡ��</li>"
		for(var i=0;i<menuCount;i++){
			divMenuList+="<li class=\"RMli_"+options.menuList[i].menuclass+"\" id=\"item\"><input type=\"checkbox\" class=\"checkbox\" name=\""+options.menuList[i].menuclass+"\"></input>"+options.menuList[i].menuName+"</li>";
		}
		divMenuList += "<li><input type=\"button\" class=\"submit\" onclick=\""+ev+"\" value=\"ѡ��\"></li></ul></div><div>";
		$("body").append(divMenuList).find("#"+id).hide().find("li#item")
		.bind("mouseover",function(){$(this).addClass("RM_mouseover");})
		.bind("mouseout",function(){$(this).removeClass("RM_mouseover");});
		$("#"+pid).click(function(){$("#"+id).hide();});
	}
	return this.each(function(){
		this.oncontextmenu=function(){
			var mw=$('body').width(),mhh=$('html').height(),mbh=$('body').height(),
				w=$('#'+id).width(),h=$('#'+id).height(),
				mh=(mhh>mbh)?mhh:mbh;//���߶� �Ƚ�html��body�ĸ߶�
			if(mh<h+my){my=mh-h;}//����
			if(mw<w+mx){mx=mw-w;}//����
			$("#"+id).hide().css({top:my,left:mx}).show();
		}
	});
    }
});