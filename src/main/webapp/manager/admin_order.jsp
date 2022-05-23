
<%@page import="com.turna.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<%
	ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list");
	%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>
<script src="../js/jquery-1.12.4.min.js"></script>
</head>
<body>  
<form action="/Myshop/OrderDayServlet?id=<%=list.get(i).getOder_id()%>" method="post">

<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_cateselect">オーダー管理</a>
	</div>
		<style type="text/css">
html, body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}
html {
  display: table;
}
body {
  display: table-cell;
  text-align: center;
  vertical-align: middle;
}
</style>
		
          <div><input type = "text" value="注文日選択" onclick ="c.show(this)"></div>
        <input type="submit" name="submit" value="決定"></form>
          
</body>
</html>