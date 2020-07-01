// Ajax封装

function getData(method,url,async,data,deal200,deal400)
{
	var ajax;
	if(window.XMLHttpRequest)
	{
		ajax=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		ajax=new ActiveXObject("Msxml12.XMLHTTP");
	}
	ajax.onreadystatechange=function()
	{
		if(ajax.readyState==4)
		{
			if(ajax.status==404)
			{
				if(deal404)
				deal404(ajax);//想怎么处理获得的数据显示，自己传自己定义的函数过来
			}
			else if(ajax.status==200)
			{
				if(deal200)
				deal200(ajax);
			}
		}
		else
		{
			console.log("暂未获取到数据(想要UI上的显示请更新此处代码)");
		}
	}
	if("get"==method)
	{
		ajax.open(method,url+(data==null?"":"?"+data),async);
		ajax.send(null);
	}
	else if("post"==method)
	{
		ajax.send("post",url,async);
		ajax.setRequestHeader("Content-Type","x-www-form-urlencoded");
		ajax.send(data);
	}
}