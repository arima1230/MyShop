<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規登録</title>
    <script src="js/calendar.js"></script>
	<script src="js/function.js"></script>
	<script src="js/jquery-1.12.4.min.js"></script>
 <style>
    	.reg p .error {
    		display:inline-block;
    		border:1px solid #ff855a;
    		background-color:#ffe8e0;
    		height:25px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    	}
    </style>
    <!-- test -->
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post"><h1><a href=""></a></h1>
        <p><h1>新規登録</h1></p>
        <p><input type="text" name="userId" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="ユーザID"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="ユーザ名"><span></span></p>
        <p><input type="text" name="passWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="パスワード"><span></span></p>
        <p><input type="text" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="パスワード確認"><span></span></p>
        <p>
        <input type="radio" name="sex" value="T" checked="checked">男
        <input type="radio" name="sex" value="F">女
        </p>
        <p><input type="text" name="birthday" value="" onfocus ="c.show(this)" placeholder="生年月日"></p>
        <p><input type="text" name="email" value="" placeholder="メール"></p>
        <p><input type="text" name="phone" value="" placeholder="電話番号"></p>
        <p><input type="text" name="address" value="" placeholder="住所"></p>
        
       
        <p><input type="submit" name="" value="登録"></p>
        
        </a></p>
        <p class="txt"><a href="/MyShop/login.jsp"><span></span>アカウント持っています</a></p>
      </form>
</div>
</body>
</html>