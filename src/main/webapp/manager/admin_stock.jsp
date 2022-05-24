<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="com.turna.entity.StockBean"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理</title>
</head>
<body>

 <%ArrayList<StockBean>list = (ArrayList < StockBean >)request.getAttribute("list"); %>

 <p>ホーム　　＞　　在庫管理</p>


 商品名：<form action="url" method="get">
 <input type="search" name="search" placeholder="キーワードを入力">
 <input type="submit" name="submit" value="検索">
 </form>

<%-- <form action = "/MyShop/admin_stock_editing">--%>
 <table border = "1">
 <tr>
	<td>商品CD 商品名 在庫数</td><td>　</td>
 </tr>

 <% for(int i = 0; i < list.size(); i++){ %>
 <tr>
	<td><%= list.get(i).getItem_code() %></td>
	<td><%= list.get(i).getItem_name() %></td>
	<td><%= list.get(i).getStock() %></td>
	<td> <form method = "POST" action ="/MyShop/admin_stock_editing?item_code=<%= list.get(i).getItem_code()%>">
	<input type="submit" name = "submit" value="編集"></form></td>
	
	
 </tr>
 <% } %>
 </table>





 <input type="submit" name = "submit" value="戻る">

 
</body>
</html>