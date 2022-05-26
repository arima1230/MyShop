<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
</script>
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
	<form method="POST" action="/MyShop/user/user_login" name="loginform" id = "loginform" >
	        <p>
	        <label for="uid">ID:</label>
	        <input type="text" name="account_name" maxlength ="100"  required pattern ="^[0-9A-Za-z]+$" id = "input" title = "英数字を入力してください" />
	        </p>
	        <p>
	        <label style = diplay for="pwd">パスワード:</label>
	        <input type="password" name="pass"  maxlength="16" required pattern = "^[0-9A-Za-z]+$"  id = "input2" title = "英数字を入力してください"/>
	        </p>
			<p>
				<font color = "red">
				         <%String msg = String.valueOf(request.getAttribute("error"));
				        if(msg == "ユーザー名、またはパスワードが間違っています。"){ %>
				        <%=msg%>
				        <%}; %>
				</font>
			</p>
	        <input type="submit" value="ログイン" id ="submit"  />
	</form>
</div>	
</body>
<script>
const VALID_MESSAGE_REQUIRED = "値を入力してください";
const VALID_MESSAGE_PATTERN = "英数字を入力してください";
$("input").each(function(index, elem) {
    if(elem.validity.valueMissing){
        elem.setCustomValidity(VALID_MESSAGE_REQUIRED);
    }
    elem.addEventListener("keyup", function (event) {
        if(elem.validity.valueMissing){
            elem.setCustomValidity(VALID_MESSAGE_REQUIRED);
        } else if(elem.validity.patternMismatch) {
            elem.setCustomValidity(VALID_MESSAGE_PATTERN );
        } else {
            elem.setCustomValidity("");
        }
    });
});
</script>
</html>