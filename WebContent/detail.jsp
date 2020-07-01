<%@ page language="java" import="com.two.body.Goods,com.two.GetBuy" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    
    <title>欢迎来到牛牛二手商城！</title>
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
    h4{
    text-align: center;
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
    .show {
    position:absolute;
    	width: 1190px;
    	height: 420px;
    	margin: 20px;
    	background-color: #ffffff;
    }
 	
    .show img{
    position:relative;
    	margin:10px;
    	width: 400px;
    	height: 400px;
    	overflow: hidden;
    	display: inline-block;
    }
    .info{
    position:absolute;
    	display: inline-block;
    	border: grey solid 1px;
    	display: inline-block;
    	box-sizing: border-box;
    	top:0;
    	width: 400px;
    	height: 400px;
    	padding: 20px;
    }
    .shopper{
   		 border: grey solid 1px;
    	position:absolute;
    	display: inline-block;
    	right:0px;
    	box-sizing: border-box;
    	width: 350px;
    	height: 400px;
    	
    }
    .views{
    	display:inline-block;
    	width: 100px;
    	
    }
    .count{
    display:inline-block;
   	 width: 100px;
    }
    .addcart{
	    font-weight: bold;
		display: inline-block;
		text-decoration: none;
		width: 120px;
		height: 30px;
		line-height: 30px;
		margin: 0 10px 0 0;
		background-color: #ff6600;
		color: #FFF;
		text-align: center;
		border-radius: 5px;
		border:none;
    }
    .tocart
    {
    	font-weight: bold;
	display: inline-block;
	text-decoration: none;
	width: 120px;
	height: 30px;
	line-height: 30px;
	margin: 0 10px 0 0;
	background-color: #ff6600;
	color: #FFF;
	text-align: center;
	border-radius: 5px;
	border:none;
    }
    .comments{
    	overflow: scroll;
    }
</style>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Goods gd=(Goods)request.getAttribute("good");
		
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
           
            <div class="show">
            	<img alt="img/loading.gif" src="<%=gd.getPic()%>" class="pic">
            	<div class="info">
            		<h4>商品名:<%=gd.getName() %></h4><hr><br><br>
            		<strong><em>价格：&nbsp;&nbsp;&nbsp;&nbsp;<%=gd.getPrice() %></em></strong>
            		<hr><br><br>
            		<h5>描述：&nbsp;&nbsp;&nbsp;&nbsp;<%=gd.getDesc() %></h5><br><br>
            		<hr><br><br>
            		<div class="views">
            			<a href="javascript:showcomments()" >
            				<span>
            					<%=new GetBuy().getcomnum(gd.getNo()) %>
            				</span><br>
            				<span>
            					评论人数
            				</span>
            			</a>
            		</div>
            		<div class="count">
            			<a >
            				<span>
            					<%=new GetBuy().getbbuynum(gd.getNo())%><br>
            					购买人数
            				</span>
            			</a>
            		</div>
            		<br><br>
            		<a href="AddCart?No=<%=gd.getNo() %>" class="addcart">加入购物车</a>
            		<a href="showCart.jsp" class="tocart">查看购物车</a>
            	</div>
            	<div class="shopper">
            	<br><br>
            		<h4>发布者 : </h4><hr><br><br>
            		<div class="comments" id="blank">
            		</div>
            	</div>
            	
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
        
        function showcomments()
        {
        	var res=getData('get',
					'getcomment',
					true,
					'No=<%=gd.getNo()%>',
					function(ajax)
					{
						console.log('数据请求正常');
						var collections=eval("("+ajax.responseText+")");
						console.log(collections);
						var blank=document.getElementById('blank');
						for(var i=0;i<collections.result.length-1;i++)
						{
							var l1=document.createElement('h5');
							l1.innerText="用户ID："+collections.result[i].ID;
							var l2=document.createElement('span');
							l2.innerText="时间:"+collections.result[i].time;
							var l3=document.createElement('span');
							l3.innerText="评论内容："+collections.result[i].content;
							blank.appendChild(l1);
							blank.appendChild(l2);
							blank.appendChild(l3);
						}
						
						
						
						
					},
					function(ajax){console.log('数据请求失败');});
        }
        
        </script>
</body>
</html>