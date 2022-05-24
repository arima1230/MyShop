<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.turna.entity.StockBean"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫編集</title>
</head>
<body>

  <%
  	String no = request.getParameter("no");
  %>

<form action="/MyShop/admin_stock_editing">
<% if (no.equals("1")){%>

ホーム　＞　在庫管理　＞　在庫編集

<table>
	<tr>
		<td>商品CD：</td>
		<td><%=session.getAttribute("item_code") %></td>
	</tr>
	
	<tr>
		<td>商品名：</td>
		<td><%=session.getAttribute("item_name") %></td>
	</tr>

	<tr>
		<td>在庫数：</td>
		<td><input type="text" name ="stock" value="<%=session.getAttribute("stock") %>"></td>
	</tr>
</table>



 <input type="submit" name = "submit" value="登録">
  <input type="submit" name = "submit" value="戻る">
  
    <% } %>
    
    
    <% if (no.equals("2")){%>

ホーム　＞　在庫管理　＞　在庫編集

<table>
	<tr>
		<td>商品CD：</td>
		<td><%=session.getAttribute("item_code") %></td>
	</tr>
	
	<tr>
		<td>商品名：</td>
		<td><%=session.getAttribute("item_name") %></td>
	</tr>

	<tr>
		<td>在庫数：</td>
		<td><input type="text" name ="stock" value="<%=session.getAttribute("stock") %>"></td>
	</tr>
</table>

<p>登録しました</p>

 <input type="submit" name = "submit" value="登録">
  <input type="submit" name = "submit" value="戻る">
  
    <% } %>
    
    
    
  </form>

  
</body>
</html>