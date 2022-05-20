<%@page import="com.turna.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー一覧</title>
</head>
<body>
	<div class="main-wrap">

		<table class="result-tab" width="100%">
			
			
			<tr>

				<th>ID</th>
				<th>氏名</th>
				<th>EMAIL</th>
				<th>電話番号</th>
				<th>詳細</th>
			</tr>
			<tr align="center">
			<c:forEach var="u" items="${userlist }">
				<td>${u.user_id}</td>
				<td>${u.user_name}</td>
				<td>${u.user_email}</td>
				<td>${u.user_phonenumber}</td>
				<td><form action="//admin_user_detail?id=${u.user_id }
					method="post">
					<input type="submit" name="submit" value="詳細">
				</form></td>

		
		
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>