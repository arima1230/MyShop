<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<style>
label{
    display: inline-block;
    text-align: right;
    width: 90px;
}
</style>
<div align = center>
 <h2>管理者ログイン</h2>
	<form method="POST" action="/MyShop/user/user_login" name="loginform">
	        <p>
	        <label for="uid">ID:</label>
	        <input type="text" name="account_name"  required pattern ="^[0-9A-Za-z]+$"/>
	        </p>
	        <p>
	        <label style = diplay for="pwd">パスワード:</label>
	        <input type="password" name="pass"  maxlength="16" required pattern = "^[0-9A-Za-z]+$"/>
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