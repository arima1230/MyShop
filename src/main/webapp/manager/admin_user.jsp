<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ管理</title>
</head>
<body>
<div class="main-wrap">
<a href="/MyShop/manager/admin_useradd.jsp">新增ユーザ</a>
	<table class="result-tab" width="100%">
		<tr>
			
			<th>ID</th>
			<th>氏名</th>
			<th>EMAIL</th>
			<th>電話番号</th>
			<th>詳細</th>
			
		</tr>
		
		<c:forEach var ="u" items="${userlist }">
		<tr>
		<td>${u.user_id }</td>
		<td>${u.user_name }</td>
		<td>${u.user_sex }</td>
		<td>${u.user_email }</td>
		<td>${u.user_phone }</td>

		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>