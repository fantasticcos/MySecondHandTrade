<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>

</head>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	body
	{
		
	}
	.login
	{
		position:relative;
		box-sizing: border-box;
		border: 1px dotted blue;
		background-color:#FFE1FF;
		width:450px;
		height: 400px;
	}
	.login h2
	{
		text-align:center;
		margin-top:10px;
  		border-bottom:thick solid #FFAEB9;
	}
	.login .content
	{
		position:absolute;
		margin:30px auto;
		align-items:center;
		box-sizing: border-box;
		border-top: 2px  thick  #FFAEB9;
	}
	.textVcode
	{
		
		width: 45px;
	}
	.textVcode span{
		margin-top:-5px;: 
	}
	input
	{
		line-height: 20px;
		margin-bottom: 5px;
	}
	img
	{
		line-height: 20px;
	}
	.btnlogin
	{
		width: 35px;
		height: 20px;
		border-radius: 3px;
	}
	.btnregister
	{
		width: 35px;
		height: 20px;
		border-radius: 3px;
	}
	.i_user
	{
		position: absolute;left: 0；z-index:5;margin-top: 8px
		background-image: url(../img/acc.png); /*引入图片图片*/
      	background-repeat: no-repeat; /*设置图片不重复*/
     	 background-position: 0px 0px; /*图片显示的位置*/
     	      width: 20px; /*设置图片显示的宽*/
      		height: 20px; /*图片显示的高*/
	}
	.i_pwd
	{
		position: absolute;left: 0；z-index:5;margin-top: 8px
		background-image: url(../img/pwd.png); /*引入图片图片*/
      	background-repeat: no-repeat; /*设置图片不重复*/
     	 background-position: 0px 0px; /*图片显示的位置*/
     	  width: 20px; /*设置图片显示的宽*/
    	  height: 20px; /*图片显示的高*/
	}
</style>
<body>
	<div class="login">
			<h2>用户登录</h2>
			<div class="content">
			<form name="frm1" action="Login" method="post">
					<div class="frm">用户名:&nbsp;
					<input type="text" name=acc class=" txtuser" />
					<i class="i_user"></i>
					</div>
					<div class="frm">密&nbsp;&nbsp;&nbsp;码:&nbsp;
					<input type="password" name="pwd" class="txtpwd" />
					<i class="i_pwd"></i>
					</div>
				<div class="frm">验证码:&nbsp;
					<input type="text" name="userVCode" class="textVcode" />
						<span>
						<img src="ValidateServlet" id="validate" onclick="change()" />
						<a href="javascript:change()">看不清，换- -张</a>
						</span>
				</div>
				<div class="btns">
					<input type="submit" name="login" class="btnlogin" value="登录" />
					<input type="button" name="register" class="btnregister"
					onclick="window.open(register.html')" value="注册"/>
					<a href="register.jsp">没有账号？点击注册</a>
				</div>
				</form>
				</div>
		</div>
				<script type="text/javascript">
						function change() {
							document.getElementById("validate").src="ValidateServlet?random="+Math.random();
						}
				</script>
</body>
</html>