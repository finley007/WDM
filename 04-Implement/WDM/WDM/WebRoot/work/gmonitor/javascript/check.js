/*************************************************************************************
 *格式校验，
 *
 *************************************************************************************
 */
function isInt( d_int)
{
		var checkOK = "0123456789-,";
		var checkStr = d_int;
		var allValid = true;
		var decPoints = 0;
		var allNum = "";
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			for (j = 0;  j < checkOK.length;  j++)
			if (ch == checkOK.charAt(j))
			break;
			if (j == checkOK.length)
			{
				allValid = false;
				break;
			}
		if (ch != ",")
			allNum += ch;
		}
		return (allValid)
 }

function isFloat( d_float)
{
		var checkOK = "0123456789-,.";
		var checkStr = d_float;
		var allValid = true;
		var decPoints = 0;
		var allNum = "";
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			for (j = 0;  j < checkOK.length;  j++)
			if (ch == checkOK.charAt(j))
			break;
			if (j == checkOK.length)
			{
				allValid = false;
				break;
			}
			if ( (ch == '-') && (i!=0) )			
			{
				allValid = false;
				break;
			}			
			if (ch != ",")
				allNum += ch;				
			if (ch == ".")
				decPoints += 1;				
		}				
		if ( decPoints > 1 )
		{
			allValid = false;
		}
		return (allValid)
}

function isDate( d_date)
{		
		var checkStr = d_date;

		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			if ((i==4) || (i==7)) 
			{
				if ( ch!='-' )
				{
					return (false);
				}
			}
			else
			{
				if (ch<'0' || ch > '9')
				{
					return (false);
				}
				if ( (i==5 && ch>'1')||(i==8 && ch>'3') ) {
   				return (false);
				}
			}									
		}				
		return (true);
}
function isTime( d_time)
{		
		var checkStr = d_time;
		var hour1='0';
		var hour2='0';
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			if (i==2) 
			{
				if ( ch!=':' )
				{
					return (false);
				}
			}
			else
			{
				if (ch<'0' || ch > '9')
				{
					return (false);
				}
				if ( (i==0 && ch>'2')||(i==3 && ch>'5') ) 
				{
   					return (false);
				}
				if(i==0)
				{
					hour1=ch;
				}
				if(i==1)
				{
					hour2=ch;				
				}
				if((hour1=='2')&&(hour2>'3'))
				{
					return (false);
				}
			}		
							
		}				
		return (true);
}
function isEmail( d_email)
{		
		var checkStr = d_email;
		var emailtag = false;
		var emaildot=0
		var emailat=0
		
		if (checkStr.length<7) return (false);
		if (checkStr.charAt(0)=='@') return (false);
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			
			if (ch=='@') emailat++;	
			if (ch=='.') emaildot++;	
		}				
		
		if (( emailat==1 ) && ( emaildot>=1 )) 
		{
		emailtag = true;
		}
		return (emailtag);  	
}
//判断是否包含中文字符。
function hasAChinese(string){
     for(i=0;i<string.length;i++)
	 if(string.charCodeAt(i)>=0x4e00)
	    return true;
	 return false;

}

//added by zhangtong, 20040810
//去除字符串两头的空格
function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
//得到字符串绝对长度(汉字按两个字符计)
function getStrLen(str) {
    var i, counter, length;
    str=trim(str);
    length = str.length;
    counter = 0;
    for (i = 0; i < length; i ++)
    {
        if (str.charCodeAt(i) > 255 || str.charCodeAt(i) < 0)
        {
            counter +=2;
        }
        else 
        {
            counter +=1;
        }
    }
    return counter;
}
//added end
