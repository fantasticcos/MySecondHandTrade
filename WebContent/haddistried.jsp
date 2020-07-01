<%@page import="com.two.body.distribute"%>
<%@page import="com.two.GetBuy"%>
<%@page import="com.two.body.trades"%>
<%@page import="java.util.List"%>
<%@ page language="java" import="com.two.body.Goods" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    
    <title>评论</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    body{
        background: url(https://i.alipayobjects.com/e/201311/1V4o0zhQPN_src.jpg) no-repeat;
    }
    .top {
    background: #e4b535;
    height: 48px;
    }
    .Logo {
    background: url(./img/ox.png) no-repeat;
    width: 100px;
    height: 45px;
    margin-left: 15px;
    float: left;
    }
    .welcome{
        float: left;
        font-size: 40px;
        color: #ec1d1d;
    }
    
    input, select, textarea {
    font-family: microsoft yahei,Helvetica,Tahoma,Arial,sans-serif;
    outline: none;
    border: none;
    
    }
  
    .manythings{
        background-color: rgba(228, 239, 240, 0.747);
        border: #c8e1e6 solid 1px;
        height: 600px;
        margin-top: 5px;
        margin-left: 30px;
        margin-right: 30px;
    }


    
    .UserInfo {
    float: right;
    padding: 4px 30px 0 10px;
    min-width: 140px;
}
    .ShowMenu {
        position: relative;
    }
    .Face {
    line-height: 40px;

    text-align: left;
    color: #FFF;
}
    a {
        outline: none;
        color: #00a4ff;
        text-decoration: none;
       
    }
    .page{
        position: absulote;
        bottom: 0;
    }
    .tag
    {
    margin-top:30px;
    	height: 100px;
    	width: 1218px;
    }
    .go{
    margin-top: 30px;}
    .go a{
    color: red;
    }
</style>
<body>
<%
	List<distribute> list=null;
	com.two.body.User u=(com.two.body.User)session.getAttribute("user");
	String no=u.getID();
	GetBuy tool=new GetBuy();
	if(no!=null)
	 list=tool.getdis(no);
%>
        <div class="top">
          <div class="Logo">

          </div>
          <div>
              <span class="welcome">
                  牛牛二手
              </span>
          </div>
          <div class="ShowMenu UserInfo">
            
                
            <a href="index.jsp" class="Face">首页
            </a>
          </div>
         
          
        </div> 
        <div  class="manythings">
            <%if(list!=null){
	            for(distribute t : list)
	            {
            %>
            <div class="tag">
            	<h5>货号：<%=t.getNo() %></h5><hr><br>
            	<span>类型：<%=tool.reflectGoods(t.getNo()).getType() %></span><br>
            	<span>商品名：<%=tool.reflectGoods(t.getNo()).getName() %></span><br>
            	<span>价格：<%=tool.reflectGoods(t.getNo()).getPrice() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="delete0('<%=t.getNo()%>')">下架</button><br>
            	<strong>时间:  <%=t.getTime()%></strong><br>
            </div>
            <%
            }
            }
            %>
            <div class="go">
            	<a  href="distrubute.jsp">选择此处来发布商品吧！</a>
            </div>
            
        </div> 
       <script type="text/javascript">
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
       
       function delete0(no)
       {
    	   var res=getData('get',
   				'deleteGood',
   				true,
   				'No='+no,
   				function(ajax)
   				{
   					console.log('请求删除正常');
   					alert(ajax.responseText);
   					window.location=location;
   					
   				},
   				function(ajax){console.log('删除请求失败');});
       }
       
       </script>
</body>
</html>