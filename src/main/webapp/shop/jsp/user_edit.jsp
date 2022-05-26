<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>会員情報変更</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

<%
String sex = (String) request.getAttribute("sex");
%>


</head>
<body>
<form method="post" action=""><%--  ミカン  --%><%--  --%>
<input type="submit" name= shophome value="ショップホーム">
</form>

<p>会員情報変更</p>

<form method="post" name=a  action=" /MyShop/DoUserEdit">

<div>
<p>
<c:if test="${message1 != null }">
<%=request.getAttribute("message1") %>
</c:if>
</p>
</div>

<div>
<p>
<label for="account_name">アカウント名：</label>
<input type="text" size="20" name="account_name" id="account_name" maxlength="100"  value = <%=session.getAttribute("account_name") %>  required>
</p>
</div>


<div>
<p>
<label for="user_name">氏名：</label>
<input type="text" size="20" name="user_name" id="user_name" maxlength="30" value = <%=session.getAttribute("user_name") %> required>
</p>
</div>


<div>
<p>
<label for="kana">フリガナ：</label>
<input type="text" size="20" name="kana" id="kana" maxlength="100" value = <%=session.getAttribute("kana") %> required>
</p>
</div>


<div>
<p>
<label for="pass">パスワード：</label>
<input type="password" size="20" name="pass" id="pass" maxlength="16" value = <%=session.getAttribute("pass") %> required>
</p>
</div>

<div>
<p>
<label for="passcon">パスワード確認：</label>
<input type="password" size="20" name="passcon" id="passcon" maxlength="16" value = <%=session.getAttribute("pass") %> required>
</p>
</div>

<c:if test="${sex == '男性' }">
<div>
<p>
性別：
<label for="male">男性</label>
<input type="radio" name="sex" value="男性" checked id="male">

<label for="female">女性</label>
<input type="radio" name="sex" value="女性" id="female">
</p>
</div>
</c:if>

<c:if test="${sex == '女性' }">
<div>
<p>
性別：
<label for="male">男性</label>
<input type="radio" name="sex" value="男性" id="male">

<label for="female">女性</label>
<input type="radio" name="sex" value="女性" checked id="female">
</p>
</div>
</c:if>

<div>
<p>
<label for="birthday">生年月日:</label>
<input type="date" name="birthday" id="birthday" value = <%=session.getAttribute("birthday") %> required>
</p>
</div>


<div>
<p>
<label for="email">メールアドレス：</label>
<input type="text" size="20" name="email" id="email" maxlength="100" value =  <%=session.getAttribute("email") %> required>
</p>
</div>

<div>
<p>
<label for="phone_number">電話番号：</label>
<input type="tel" size="20" name="phone_number" id="phone_number" maxlength="11" value =  <%=session.getAttribute("phone_number") %> required>

</p>
</div>

<div>
<p>
<label for="post_code">郵便番号：</label>
<input type="tel" size="20" name="post_code" id="post_code" maxlength="7" value =  <%=session.getAttribute("post_code") %> required>

</p>
</div>

<div>
<p>
<label for="adress">住所１：</label>
<input type="text" size="20" name="adress" id="adress" maxlength="100" value =  <%=session.getAttribute("adress") %> required>
</p>
</div>

<div>
<p>
<label for="building">住所２：</label>
<input type="text" size="20" name="building" id="building" maxlength="100" value =  <%=session.getAttribute("building") %> >
<label for="room_number">住所３：</label>
<input type="text" size="20" name="room_number" id="room_number" maxlength="10" value =  <%=session.getAttribute("room_number") %> >
</p>
</div>

<div>
<p>
<c:if test="${message != null }">
<%=request.getAttribute("message") %>
</c:if>
</p>
</div>

<input type="submit" value="変更"> 
<input type="button" value="戻る" onClick="history.go(-1)">

</form>
</body>
</html>