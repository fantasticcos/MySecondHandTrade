<%@page import="com.two.GetBuy"%>
<%@ page language="java" import="java.util.ArrayList,com.two.body.Goods" contentType="text/html; charset=UTF-8"
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
        box-sizing: border-box;
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
    .info{
        float: right;
    }
    input, select, textarea {
    font-family: microsoft yahei,Helvetica,Tahoma,Arial,sans-serif;
    outline: none;
    border: none;
    
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
    .search-box{
        background-color: rgba(228, 239, 240, 0.747);
        margin-top: 20px;
        margin-left: 30px;
        margin-right: 30px;
        height: 97px;

        
    }
    .search{
        border: #00a4ff 1px solid;
        margin-left: 280px;
        margin-top: 20px;
        width: 480px;
        height: 50px;
        border-radius: 10px;
        display: inline-block;
    }
    .s-btn{
        text-decoration: none;
        width: 60px;
        padding-top: 10px;
        padding-bottom: 15px;
        bottom: 20px;
        border-radius: 5px;
        border: #00a4ff 1px solid;
        background-color: #c8e1e6;
        color: #FFF;
        font-size: 20px;
        display: inline-block;
    }
    .manythings{
        background-color: rgba(228, 239, 240, 0.747);
        border: #c8e1e6 solid 1px;
        height: 600px;
        margin-top: 5px;
        margin-left: 30px;
        margin-right: 30px;
    }
    .catagory{
        
        margin-left: 10px;
        background-color: #FFF;
        width: 200px;
        display: inline-block;
        height: 250px;
        border: #2ac3e2 solid 1px;
    }
    .flow{
        margin-left: 100px;
        width: 500px;
        height: 250px;
        display: inline-block;
        position: relative;
        border: #2ac3e2 solid 1px;
        overflow: hidden;
    }
    .personal
    {
       position: absolute;
       right: 50px;
       top: 180px;
        width: 300px;
        height: 250px;
        display: inline-block;
        border: #2ac3e2 solid 1px;
        background-color: #FFF;
    }
     li{
         list-style-type: none;
        margin: 0px;
        padding-left: 20px;
    }
    .box {
            width: 450px;
            height: 300px;
            border: 1px solid #ccc;
            margin: 0px auto;
            padding: 5px;
 
        }
        .inner{
            margin-top: 0;
            width: 500px;
            height: 300px;
            position: relative;
            overflow: hidden;
        }
        .inner img{
            width: 500px;
            height: 300px;
            vertical-align: top
        }
        .box ul {
            width: 1000%;
            position: absolute;
            list-style: none;
            left:0;
            top: 0;
        }
       
        .inner li{
            padding: 0;
            float: left;
 
        }
 
        ol {
            position: absolute;
            height: 20px;
            right: 20px;
            bottom: 20px;
            text-align: center;
            padding: 5px;
        }
        ol li{
            display: inline-block;
            width: 20px;
            height: 20px;
            line-height: 20px;
            background-color: #fff;
            margin: 5px;
            cursor: pointer;
 
        }
        ol .current{
            background-color: red;
        }
        #arr{
            display: none;
        }
        #arr span{
            width: 40px;
            height: 40px;
            position: absolute;
            left: 5px;
            top: 50%;
            margin-top: -20px;
            background: #fff;
            cursor: pointer;
            line-height: 40px;
            text-align: center;
            font-weight: bold;
            font-family: '黑体';
            font-size: 30px;
            color: #000;
            opacity: 0.5;
            border: 1px solid #fff;
        }
        #arr #right {
            right: 5px;
            left: auto;
        }
        .member-db
        {
            text-align: center;
        }
        .count{
            display: inline-block;
        }
		#user-pic
		{
			width:48px;
			height: 48px;
			margin-top:15px;
			vertical-align: middle;
			border-radius: 50%;
		}




        
</style>
<body>
	 <%
	 	request.setCharacterEncoding("utf-8");
	 response.setContentType("text/html;charset=utf-8");
	 	String acc="请登录！";
	 	String pic="./img//user.png";
	 	int buynum=0;
	 	int distrinum=0;
	 	boolean hadlogin=false;
	 	com.two.body.User cur=null;
	 	cur=(com.two.body.User)session.getAttribute("user");
	 	if(cur!=null)
	 		{
	 			hadlogin=true;
	 			acc=cur.getAcc();
	 			pic=cur.getPic();
	 			buynum=new GetBuy().getnum(cur.getID());
	 			distrinum=new GetBuy().getdisnum(cur.getID());
	 		}
	 	ArrayList<Goods> cart=(ArrayList<Goods>)session.getAttribute("cartlist");
	 	int cartnum=((cart==null||cur==null)?0:cart.size());
	 	String tar=hadlogin?"signout":"Login.jsp";
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
            
                
            <a href="Login.jsp" class="Face">首页
            </a>
          </div>
          
          
      </div>  <!--导航-->
      <div class="search-box">
        <input type="text" class="search" id="search">
        <div class="s-btn"><a href="guide/type.jsp?s=" onmouseover="search11(this)">搜 索</a></div>
        
      </div>
      <div class="manythings">
        <div class="catagory">
            <ul class="menu">
                <li><a href="guide/type.jsp?t=clothes">衣服</a></li>
                <li><a href="guide/type.jsp?t=shoes">鞋</a></li>
                <li><a href="guide/type.jsp?t=jiadian">家电</a></li>
                <li><a href="guide/type.jsp?t=shouji">手机</a></li>
                <li><a href="guide/type.jsp?t=zhubao">珠宝</a></li>
                <li><a href="guide/type.jsp?t=box">箱包</a></li>
                <li><a href="guide/type.jsp?t=watch">手表</a></li>
                <li><a href="guide/type.jsp?t=instrument">乐器</a></li>
                <li><a href="guide/type.jsp?t=tools">器械</a></li>
                <li><a href="guide/type.jsp?t=study">学习</a></li>
                <li><a href="guide/type.jsp?t=books">书本</a></li>
                <li><a href="guide/type.jsp?t=desk">桌椅</a></li>
            </ul>
        </div>
        <div class="flow" >
            
            <div class="box" id="box">
                <div class="inner">
                    <!--轮播图-->
                    <ul>
                        <li><a href="#"><img src="img\flow1.jpg" alt=""></a></li>
                        <li><a href="#"><img src="img\flow2.jpg" alt=""></a></li>
                        <li><a href="#"><img src="img\flow3.jpg" alt=""></a></li>
                        <li><a href="#"><img src="img\flow4.jpg" alt=""></a></li>
                        <li><a href="#"><img src="img\flow5.jpg" alt=""></a></li>
                    </ul>
                    <ol class="bar">
                        小按钮数量无法确定，由js动态生成
                    </ol>
                    <!--左右焦点-->
                    <div id="arr">
                        <span id="left"> <</span>
                        <span id="right">></span>
                    </div>
            
                </div>
            </div>

            
        </div>

        <div class="personal">
            <div class="member-db">
                <div class="wrappper">
                    <a href="<%=tar%>"><img id="user-pic" src="<%=pic %>" alt=""></a><br>
                    <span><%=acc %></span>
                </div>
            </div>
            <br><br>
            <div class="user-detail">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="hadbuyed.jsp" class="count"><span><%=buynum %></span><br><span>已购买</span></a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="showCart.jsp" class="count"><span><%=cartnum %></span><br><span>购物车</span></a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="haddistried.jsp" class="count"><span><%=distrinum %></span><br><span>已发布</span></a>
            </div>
        </div>
      </div>
      <script>
    var box=document.getElementById("box");
    var inner=box.children[0];
    var ulObj=inner.children[0];
    var list=ulObj.children;
    var olObj=inner.children[1];
    var arr=document.getElementById("arr");
    var imgWidth=inner.offsetWidth;
    var right=document.getElementById("right");
    var pic=0;
    //根据li个数，创建小按钮
    	function search11(a)
    	{
    		var content=document.getElementById('search').value;
    		console.log(a);
    		console.log(content);
    		if(content==null||content==="")
    			{
    				alert('你不可以搜索空的值');
    				a.herf="#";
    			}
    		a.href='guide/type.jsp?s='+content;
    	}
    for(var i=0;i<list.length;i++){
        var liObj=document.createElement("li");
 
        olObj.appendChild(liObj);
        liObj.innerText=(i+1);
        liObj.setAttribute("index",i);
 
        //为按钮注册mouseover事件
        liObj.οnmοuseοver=function () {
            //先清除所有按钮的样式
 
            for (var j=0;j<olObj.children.length;j++){
                olObj.children[j].removeAttribute("class");
            }
            this.className="current";
            pic=this.getAttribute("index");
            animate(ulObj,-pic*imgWidth);
        }
 
    }
 
 
    //设置ol中第一个li有背景颜色
    olObj.children[0].className = "current";
    //克隆一个ul中第一个li,加入到ul中的最后=====克隆
    ulObj.appendChild(ulObj.children[0].cloneNode(true));
 
    var timeId=setInterval(onmouseclickHandle,2500);
    //左右焦点实现点击切换图片功能
    box.οnmοuseοver=function () {
        arr.style.display="block";
        clearInterval(timeId);
    };
    box.οnmοuseοut=function () {
        arr.style.display="none";
        timeId=setInterval(onmouseclickHandle,1000);
    };
 
    right.οnclick=onmouseclickHandle;
    function onmouseclickHandle() {
        //如果pic的值是5,恰巧是ul中li的个数-1的值,此时页面显示第六个图片,而用户会认为这是第一个图,
        //所以,如果用户再次点击按钮,用户应该看到第二个图片
        if (pic == list.length - 1) {
            //如何从第6个图,跳转到第一个图
            pic = 0;//先设置pic=0
            ulObj.style.left = 0 + "px";//把ul的位置还原成开始的默认位置
        }
        pic++;//立刻设置pic加1,那么此时用户就会看到第二个图片了
        animate(ulObj, -pic * imgWidth);//pic从0的值加1之后,pic的值是1,然后ul移动出去一个图片
        //如果pic==5说明,此时显示第6个图(内容是第一张图片),第一个小按钮有颜色,
        if (pic == list.length - 1) {
            //第五个按钮颜色干掉
            olObj.children[olObj.children.length - 1].className = "";
            //第一个按钮颜色设置上
            olObj.children[0].className = "current";
        } else {
            //干掉所有的小按钮的背景颜色
            for (var i = 0; i < olObj.children.length; i++) {
                olObj.children[i].removeAttribute("class");
            }
            olObj.children[pic].className = "current";
        }
    }
    left.οnclick=function () {
        if (pic==0){
            pic=list.length-1;
            ulObj.style.left=-pic*imgWidth+"px";
        }
        pic--;
        animate(ulObj,-pic*imgWidth);
        for (var i = 0; i < olObj.children.length; i++) {
            olObj.children[i].removeAttribute("class");
        }
        //当前的pic索引对应的按钮设置颜色
        olObj.children[pic].className = "current";
    };
    
    //设置任意的一个元素,移动到指定的目标位置
    function animate(element, target) {
        clearInterval(element.timeId);
        //定时器的id值存储到对象的一个属性中
        element.timeId = setInterval(function () {
            //获取元素的当前的位置,数字类型
            var current = element.offsetLeft;
            //每次移动的距离
            var step = 10;
            step = current < target ? step : -step;
            //当前移动到位置
            current += step;
            if (Math.abs(current - target) > Math.abs(step)) {
                element.style.left = current + "px";
            } else {
                //清理定时器
                clearInterval(element.timeId);
                //直接到达目标
                element.style.left = target + "px";
            }
        }, 10);
    }
    
    
      </script>
</body>
</html>