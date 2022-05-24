<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>会員情報登録</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">



</head>
<body>
<form method="post" action=""><%--  ミカン  --%><%--  --%>
<input type="submit" name= shophome value="ショップホーム">
</form>

<p>会員情報登録</p>

<form method="post" name=a  action=" /MyShop/DoUserInput">

<div>
<p>
<label for="account_name">アカウント名：</label>
<input type="text" size="20" name="account_name" id="account_name" maxlength="100" required>
</p>
</div>


<div>
<p>
<label for="user_name">氏名：</label>
<input type="text" size="20" name="user_name" id="user_name" maxlength="30" required>
</p>
</div>


<div>
<p>
<label for="kana">フリガナ：</label>
<input type="text" size="20" name="kana" id="kana" maxlength="100" required>
</p>
</div>


<div>
<p>
<label for="pass">パスワード：</label>
<input type="password" size="20" name="pass" id="pass" maxlength="16" required>
</p>
</div>

<div>
<p>
<label for="passcon">パスワード確認：</label>
<input type="password" size="20" name="passcon" id="passcon" maxlength="16" required>
</p>
</div>

<div>
<p>
<label for="male">男性</label>
<input type="radio" name="sex" value="男性" checked id="male">

<label for="female">女性</label>
<input type="radio" name="sex" value="女性" id="female">
</p>
</div>

<div>
<p>
<input type="date" name="birthday">
</p>
</div>


<div>
<p>
<label for="email">メールアドレス：</label>
<input type="text" size="20" name="email" id="email" maxlength="100" required>
</p>
</div>

<div>
<p>
<label for="phone_number">電話番号：</label>
<input type="tel" size="20" name="phone_number" id="phone_number" maxlength="11" required>

<%--
<label for="phone_number2">-</label>
<input type="tel" size="20" name="phone_number2" id="phone_number2" maxlength="4"required>
<label for="phone_number3">-</label>
<input type="tel" size="20" name="phone_number3" id="phone_number3" maxlength="4" required>
 --%>
 
</p>
</div>

<div>
<p>
<label for="post_code">郵便番号：</label>
<input type="tel" size="20" name="post_code" id="post_code" maxlength="7" required>

<%--
<label for="post_code2">-</label>
<input type="tel" size="20" name="post_code2" id="post_code2" maxlength="4" required>
--%>
</p>
</div>

<div>
<p>
<label for="adress">住所１：</label>
<input type="text" size="20" name="adress" id="adress" maxlength="100" required>
</p>
</div>

<div>
<p>
<label for="building">住所２：</label>
<input type="text" size="20" name="building" id="building" maxlength="100">
</p>
</div>

<div>
<p>
<label for="room_number">住所３：</label>
<input type="text" size="20" name="room_number" id="room_number" maxlength="10">
</p>
</div>

<input type="submit" value="登録"> 
<input type="button" value="戻る" onClick="history.go(-1)">

</form>
</body>
</html>