<%@page import="com.turna.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ include file="admin_menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理日付選択画面</title>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>
<script src="../js/jquery-1.12.4.min.js"></script>
</head>
<body>
	<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_order">注文管理</a>
	</div>

	<form action="<%=request.getContextPath()%>/manager/admin_order_day"
		method="post">

		<style type="text/css"></style>


		<input type="text" name="select_day" value="注文日選択"
			onclick="c.show(this)"> <input type="submit" value="決定">
	</form>

</body>
</html>