<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ管理</title>
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
								<c:if test="${cate.cate_parent_id == 0}">
									<option value="${cate.cate_id }">${ cate.cate_name}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<th>カテゴリ名：</th>
					<td><input id="title" name="className" size="30" value=""
						type="text"></td>
				</tr>
				<tr>
					<th></th>
					<td><input value="追加" type="submit"> <input
						onClick="history.go(-1)" value="戻る" type="button"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="main-wrap">

		<table class="result-tab" width="40%" border="1" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>カテゴリ名</th>
				<th>操作</th>
			</tr>

			<c:forEach var="cate" items="${catelist }">
				<c:if test="${cate.cate_parent_id == 0 }">
					<tr>
						<td>${cate.cate_id }</td>
						<td>|-${cate.cate_name }</td>
						<td><a href="#">変更</a><a href="">削除</a></td>
					</tr>
					<c:forEach var="ccate" items="${catelist }">
						<c:if test="${ccate.cate_parent_id == cate.cate_id }">
							<tr>
								<td>${ccate.cate_id }</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${ccate.cate_name }</td>
								<td><a href="#">変更</a><a href="">削除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</table>
		  <div class="list-page">  1/1 ページ</div>
	</div>
</body>
</html>