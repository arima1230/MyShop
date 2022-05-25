<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ管理</title>
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
			href="admin_cateselect">カテゴリ管理</a>
	</div>
	<form action="/MyShop/manager/admin_docateadd" method="post"
		id="myform" name="myform">
		<table>
			<tbody>

				<tr>
					<th>分類</th>
					<td><select name="parentId">
							<option value="0" selected="selected">親分類</option>
							<c:forEach var="cate" items="${catelist }">
								<c:if test="${cate.category_parents_id == 0}">
									<option value="${cate.category_id }">${ cate.category_name}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<th>カテゴリ名：</th>
					<td><p>
							<input id="title" name="className" size="30" value="" type="text"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"><span></span>
						</p></td>
				</tr>
				<tr>
					<th></th>
					<td><input value="追加" type="submit" > </td>
				</tr>
			</tbody>
		</table>
		<font color = "red">
		<%if ( request.getAttribute("a") != null ){
		 String msg = "値を入力してください";%>
		  <%= msg%>
		 <% };%>
		</font>
	</form>
	<div class="main-wrap">

		<table class="result-tab" width="40%" border="1" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>カテゴリ名</th>
				<th>操作</th>
			</tr>

			<c:forEach var="cate" items="${catelist }">
				<c:if test="${cate.category_parents_id == 0 }">
					<tr>
						<td>${cate.category_id }</td>
						<td>|-${cate.category_name }</td>
						<td><a href="admin_tocateupdate?id=${cate.category_id }">変更</a><a href="javascript:catedel(${cate.category_id })">削除</a></td>
					</tr>
					<c:forEach var="ccate" items="${catelist }">
						<c:if test="${ccate.category_parents_id == cate.category_id }">
							<tr>
								<td>${ccate.category_id }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${ccate.category_name }</td>
								<td><a href="admin_tocateupdate?id=${ccate.category_id }">変更</a><a href="javascript:catedel(${ccate.category_id })">削除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
			<script>
				function catedel(id) {
					if (confirm("削除しますか")) {
						location.href = "admin_docatedel?id=" + id;
					}
				}
			</script>
		</table>
		<div class="list-page"></div>
	</div>
</body>
</html>