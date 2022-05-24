<%@page import="com.turna.entity.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報詳細</title>
</head>
<body>
	<div class="main-wrap">
		<table class="result-tab" width="100%">
			<tr>
				<td>ID</td>
				<td>氏名</td>
				<td>カナ</td>
				<td>生年月日</td>
				<td>メールアドレス</td>
				<td>電話番号</td>
				<td>郵便番号</td>
				<td>住所</td>
				<td>建物名</td>
				<td>部屋番号</td>
			</tr>

			<tr align="center">
				<td><%=session.getAttribute("user_id")%></td>
				<td><%=session.getAttribute("user_name")%></td>
				<td><%=session.getAttribute("kana")%></td>
				<td><%=session.getAttribute("birthday")%></td>
				<td><%=session.getAttribute("email")%></td>
				<td><%=session.getAttribute("phone_number")%></td>
				<td><%=session.getAttribute("adress")%></td>
				<td><%=session.getAttribute("building")%></td>
				<td><%=session.getAttribute("room_number")%></td>
			</tr>

		</table>
	</div>
	<button type="button" onclick="history.back()">戻る</button>
</body>
</html>