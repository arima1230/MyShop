<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品追加</title>
</head>
<body>
	<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_itemselect">商品管理</a><span class="crumb-step">&gt;</span><span>商品追加</span>
	</div>
	<form action="/MyShop/manager/admin_doitemadd" method="post" enctype="multipart/form-data"
		id="myform" name="myform">
		<table>
			<tbody>

				<tr>
					<th>商品名：</th>
					<td><input id="title" name="itemName" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>商品CD：</th>
					<td><input id="title" name="itemCode" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>カテゴリ：</th>
					<td><select name="parentId">
							<c:forEach var="p" items="${plist }">
								<option value="${p.category_id }" disabled="disabled">|-${p.category_name }</option>
								<c:forEach var="c" items="${clist }">
									<c:if test="${c.category_parents_id == p.category_id}">
										<option value="${p.category_id }-${c.category_id }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.category_name }</option>
									</c:if>
								</c:forEach>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<th>商品画像：</th>
					<td><input id="title" name="photo" size="50" value=""
						type="file"></td>
				</tr>

				<tr>
					<th>価格：</th>
					<td><input id="title" name="itemPrice" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>商品詳細：</th>
					<td><input id="title" name="itemDesc" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>在庫数：</th>
					<td><input id="title" name="itemStock" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th></th>
					<td><input value="登録" type="submit"> <input
						onClick="history.go(-1)" value="戻る" type="button"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
