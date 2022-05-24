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
			href="admin_cateselect">カテゴリ管理</a><span class="crumb-step">&gt;</span><span>カテゴリ編集</span>
	</div>
	<form action="/MyShop/manager/admin_docateupdate" method="post"
		id="myform" name="myform">
		<input type="hidden" name="id" value="${cate1.category_id }">
		<table>
			<tbody>

				<tr>
					<th>親分類</th>
					<td><select name="parentId">
							<option value="0">親分類</option>
							<c:forEach var="cate" items="${catelist }">
								<c:if test="${cate.category_parents_id == 0}">
									<c:if test="${cate1.category_parents_id == cate.category_id}">
										<option value="${cate.category_id }" selected="selected">${ cate.category_name}</option>
									</c:if>
									<c:if test="${cate1.category_parents_id != cate.category_id}">
										<option value="${cate.category_id }">${ cate.category_name}</option>
									</c:if>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<th>カテゴリ名：</th>
					<td><input id="title" name="className" size="30"
						value="${cate1.category_name }" type="text"></td>
				</tr>
				<tr>
					<th></th>
					<td><input value="変更" type="submit" name="submit"> <a href="admin_cateselect"><input
						 value="戻る" type="button" onclick="window.location.href('admin_cateselect')"></a></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>