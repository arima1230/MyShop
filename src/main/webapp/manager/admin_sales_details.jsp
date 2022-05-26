<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*"%>
    <%@ page import="com.turna.entity.SalesBean"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上詳細</title>
</head>
<body>

<%ArrayList<SalesBean>list1 = (ArrayList < SalesBean >)request.getAttribute("list1"); %>

ホーム　＞　売上管理　＞　売上詳細


売上日


<table border = "1">
<tr>
	<th>商品CD　商品名　カテゴリ　価格　売却点数　小計</th>
</tr>

 <% for(int i = 0; i < list1.size(); i++){ %>
<tr>
	<td><%= list1.get(i).getItem_code() %></td>
	<td><%= list1.get(i).getItem_name() %></td>
	<td><%= list1.get(i).getCategory_name() %></td>
	<td><%= list1.get(i).getPrice() %></td>
	<td><%= list1.get(i).getNum_of_items() %></td>
	<td><%= list1.get(i).getSub_total() %></td>
</tr>
</table>
 <% } %>


ページ


<table>
	<tr>
		<td>合計金額</td>
		<td><%=request.getAttribute("total") %>円</td>
	</tr>
</table>



<input type="submit" name = "submit" value="戻る">

</body>
</html>