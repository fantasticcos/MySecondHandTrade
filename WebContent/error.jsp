<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3; url=Login.jsp">
<title>登录失败</title>
</head>
<body>
	<font size="6">对不起,</font>
	<h4 class="text"> 用户名或密码错误或您未登录 <span id="second"></span>秒后跳转至登录页面</h4>
	<font size="7" color="red">
	<script type="text/javascript">
		var sec=document.getElementById('second');
        var s=4;
		(function back (){
            sec.innerHTML=s-1;
            s--;
			setTimeout(back,1000);
            
		})();
    </script>
</body>
</html>