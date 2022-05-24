<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel = "stylesheet" type = "text/css" href ="../css/login.css ">
<link rel = "stylesheet" type = "text/css" href ="../css/login.css ">
</head>
<body>

<div align = center>
 <h2>管理者ログイン</h2>
	<form method="POST" action="/MyShop/user/user_login" name="loginform">
	        <p>
	        <label for="uid">ID:</label>
	        <input type="text" name="account_name"  />
	        </p>
	        <p>
	        <label for="pwd">パスワード:</label>
	        <input type="password" name="pass"  maxlength="16" />
	        </p>
	        <input type="submit" value="ログイン"  />
	       
	        
	</form>
	<font color = "red">
	         <%String msg = String.valueOf(request.getAttribute("error"));
	        if(msg == "ユーザー名、またはパスワードが間違っています。"){ %>
	        <%=msg%>
	        <%}; %>
	</font>
</div>	
</body>
</html>