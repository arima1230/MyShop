
<%@page import="com.turna.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/calendar.js"></script>
<script src="../js/function.js"></script>
<script src="../js/jquery-1.12.4.min.js"></script>
</head>
<body>    
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
		<form action="admin_order_detail" method="post">
          <div><input type = "text" value="注文日選択" onclick ="c.show(this)"></div>
        <input type="submit" name="submit" value="決定">
          
</body>
</html>