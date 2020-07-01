<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<style>
 *{
            margin: 0;
            padding: 0;
        }
        body{
  
            font-size: 18px;
            line-height: 1.8;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background: url(https://i.alipayobjects.com/e/201311/1V4o0zhQPN_src.jpg) no-repeat;
        }
        #person{
            margin-left: 80px;
            height: 100px;
            width: 200px;
            position: relative;
            
        }
        .desc span{
            position: absolute;
            margin-top: 0px;
            width: 80px;
        }
        
        h2{
            text-align: center;
        }
        .but{
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .b1{
            width: 50%;
            align-items: center;
            border: 0;
        }
        b2{
            width: 50%;
            align-items: center;
            border: 0;
        }
        span{
            display: flex;
        }
        #xxx{
            display: flex;
        }
        .in{
            width: 200px;
        }
        select{
            padding: 5px;
        }
        .t_form{
            width: 400px;
			top:300px;
            align-items: center;
            background: rgb(252,252,252);
            box-shadow: 0px 1px 5px 0px;
            border-radius: 8px;
        }
        .banner{
            position:relative;
            background: url(./theme-pic.jpg) no-repeat 0 200px;
            margin:0 auto;
            width: 1000px;
             height:678px;
        }
		.add_promot{
			border: 1px solid #FFCC00;
			background-color: #ffffda;
			padding-left: 5px;
			padding-right: 5px;
			line-height: 20px;
		}
		.ok_promot{
			border: solid 1px #01be00;
			background-color: #e6ffe4;
			background-image: url(./li_ok.gif);
			background-repeat: no-repeat;
			background-position: 5px 2px;
			padding: 2px 5px 0px 25px ;
			line-height: 20px;
		}
		.error_promot{
			border: 1px solid #ff3300;
			background-color: #fff2e5;
			background-image: url(./li_err.gif);
			background-repeat: no-repeat;
			background-position: 5px 2px;
			padding: 2px 5px 0px 25px ;
			line-height: 20px;
		}

</style>
<body>
	<div class="t_form">
			<div><h2 >会员注册</h2></div>
            <form action="BookAddServlet" method="post" id="tform" enctype="multipart/form-data" onSubmit="return check(this)">
                会员账号:<input class="in" id="acc" type="text" name="acc"  
				placeholder="提示:不能为空"
				onfocus="usernameFocus()"
				onblur="usernameBlur()"
				>*
				<div id="accid">
				</div>
				昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input class="in" type="text" name="2acc"><br>
                会员密码:<input class="in" id="pwd" type="password" name="pwd">*
                <br>
                重复密码:<input class="in" id="pwd2" type="password" name="pwd2">*
                <div>
                    性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
                    <input type="radio" value="男" name="s" id="" checked>男
                    <input type="radio" value="女" name="s" id="">女
                </div>
             	<div>
             		选择头像:
             		<input type="file" name="pic">
             	</div>
               
				
                
                
                
                
              
               
             
                <div class="but">
                    <div class="b1">
                        <button id="btn" type="submit" >提交</button>
                    </div>
                    <div class="b2">
                        <button >取消</button>
                    </div>
                </div>
                
            </form>
        </div>
    
    <script type="text/javascript">
		
    	function check(tform)
		{
			if(tform.acc.value=="")
			{
				alert("请输入用户名");
				tform.acc.value='';
				tform.acc.focus();
				return false;
			}
			if(tform.pwd.value!=tform.pwd2.value)
			{
				alert("两次密码不一致，请重新输入");
				tform.pwd.value='';
				tform.pwd2.value='';
				tform.pwd.focus();
				return false;
			}
			
			
		}
		function usernameFocus()
		{
			var username=document.getElementById("accid");
			username.className="add_promot";
			username.innerHTML="1，有字母，下划线，数字，点，减号组成<br> 2，只能以数字，字母开头或结尾，且长度为4-18";
		}
		function usernameBlur()
		{
			var username=document.getElementById("acc");
			var usernameid=document.getElementById("accid");
			var reg=/^[0-9a-zA-Z][0-9a-zA-Z_.-]{2,16}[0-9a-zA-Z]$/;
			if(username.value=='')
			{
				usernameid.className="error_promot";
				usernameid.innerHTML="用户名不能为空";
				return false;
			}
			if(reg.test(username.value)==false)
			{
				usernameid.className="error_promot";
				usernameId. innerHTML="1、由字母、数字、下划线、点、减号组成"
				+"<br/>2、只能以数字、字母开头或结尾，且长度为4-18";
				return false;

			}
			usernameid.className="ok_promot";
			usernameid.innerHTML="用户名输入真确";
			return true;
		}
		
    </script>
</body>
</html>