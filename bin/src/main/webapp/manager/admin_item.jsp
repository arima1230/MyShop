<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<script src="js/function.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<style>
p .error {
	display: inline-block;
	border: 1px solid #ff855a;
	background-color: #ffe8e0;
	height: 25px;
	line-height: 25px;
	padding: 0px 20px;
	margin-left: 20px;
}
</style>
</head>
<body>
	<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_itemselect">商品管理</a>
	</div>
	<form action="/MyShop/manager/admin_toitemadd" method="post"
		id="myform" name="myform">
		<a href="/MyShop/manager/admin_toitemadd">商品追加</a>

	</form>
	<div class="main-wrap">

		<table class="result-tab" width="40%" border="1" cellspacing="0">
			<tr>
				<th>商品CD</th>
				<th>商品名</th>
				<th>操作</th>
			</tr>

			<c:forEach var="item" items="${itemlist }">
				<tr>
				
					<td>${item.item_code }</td>
					<td><img src="../img/item/${item.image_path }"
								height="80">${item.item_name }</td>
					<td><a href="admin_toitemupdate?id=${item.item_id }">編集</a> <a
						href="admin_toitemdel?id=${ item.item_id}">削除</a></td>
				</tr>
			</c:forEach>

		</table>
		<div class="list-page"></div>
	</div>
</body>
</html>