<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者側</title>
</head>
<body>
	<li><a href="admin_index.jsp">ホームページ</a></li>
	<li><a href="#">管理者</a></li>
	<li><a href="#">exit</a></li>
	<div>
		<h1>メニュー</h1>
		<ul >
			<li><a href="/MyShop/manager/admin_douserselect">ユーザ管理</a></li>
			<li><a href="/MyShop/manager/admin_cateselect">カテゴリ管理</a></li>
			<li><a href="/MyShop/manager/admin_itemselect">商品管理</a></li>
			<li><a href="admin_order.jsp">オーダー管理</a></li>
			<li><a href="admin_message.jsp">売上管理</a></li>
		

		</ul>
	</div>
</body>
</html>