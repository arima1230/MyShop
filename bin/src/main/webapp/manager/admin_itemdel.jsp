<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除</title>
</head>
<body>
	<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_itemselect">商品管理</a><span class="crumb-step">&gt;</span><span>商品削除</span>
	</div>

	<form action="/MyShop/manager/admin_doitemdel" method="get"
		enctype="multipart/form-data" id="myform" name="myform">
		<input type="hidden" name="itemId" value="${item.item_id }"> <input
			type="hidden" name="deleteFlag" value="${item.deleteflag }">
		<input type="hidden" name="parenId" value="${item.category_id }">
		<input type="hidden" name="photo" value="${item.image_path }">
		<input type="hidden" name="itemPrice" value="${item.price }">
		<input type="hidden" name="itemDesc" value="${item.detail }">
		<input type="hidden" name="itemStock" value="${item.stock }">
		<table>
			<tbody>

				<tr>
					<th>商品CD：</th>
					<td><input id="title" name="itemCode" size="50"
						value="${item.item_code }" type="text"></td>
				</tr>
				<tr>
					<th>商品名：</th>
					<td><input id="title" name="itemName" size="50"
						value="${item.item_name }" type="text"></td>
				</tr>

				<tr>
					<th></th>
					<td><input value="削除" type="submit"> <input
						onClick="history.go(-1)" value="戻る" type="button"></td>
				</tr>

				<!--  <script>
				function itemdel(id) {
					if (confirm("削除しますか")) {
						location.href = "admin_doitemdel?id=" + id;
					}
				}
			</script>-->
			</tbody>
		</table>
	</form>
</body>
</html>