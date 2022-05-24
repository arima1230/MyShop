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
				<th>ID</th>
				<th>氏名</th>
				<th>カナ</th>
				<th>生年月日</th>
				<th>メールアドレス</th>
				<th>電話番号</th>
				<th>郵便番号</th>
				<th>住所</th>
				<th>建物名</th>
				<th>部屋番号</th>
			</tr>
			
			<tr align="center">
				<td><%=session.getAttribute("id")%></td>
				<td><%=session.getAttribute("name")%></td>
				<td><%=session.getAttribute("kana")%></td>
				<td><%=session.getAttribute("birthday")%></td>
				<td><%=session.getAttribute("email")%></td>
				<td><%=session.getAttribute("phonenumber")%></td>
				<td><%=session.getAttribute("adress")%></td>
				<td><%=session.getAttribute("building")%></td>
				<td><%=session.getAttribute("roomnumber")%></td>
			</tr>
			
			
			
			
			<!--  tr align="center">
			<c:forEach var="u" items="${userlist }">
				<td>${u.user_id}</td>
				<td>${u.user_name}</td>
				<td>${u.kana}</td>
				<td>${u.birthday}</td>
				<td>${u.email}</td>
				<td>${u.phonenumber}</td>
				<td>${u.postcode}</td>
				<td>${u.adress}</td>
				<td>${u.building}</td>
				<td>${u.roomnumber}</td>
				
		</tr>
		</c:forEach>-->
		</table>
	</div>
	<button type="button" onclick="history.back()">戻る</button>
</body>
</html>