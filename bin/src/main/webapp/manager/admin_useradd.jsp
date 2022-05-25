<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ追加</title>
</head>
<body>
	<a href="admin_index.jsp">ホームページ</a>
	<form action="/MyShop/manager/admin_douseradd" method="post"
		id="myform" name="myform">
		<table>
			<tbody>

				<tr>
					<th>ユーザID：</th>
					<td><input id="title" name="userId" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>ユーザ名：</th>
					<td><input id="title" name="name" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>パスワード：</th>
					<td><input id="title" name="passWord" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>パスワード確認：</th>
					<td><input id="title" name="rePassWord" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>性別：</th>
					<td><input type="radio" name="sex" value="T" checked="checked">男
						<input type="radio" name="sex" value="F">女</td>
				</tr>

				<tr>
					<th>生年月日：</th>
					<td><input id="title" name="birthday" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>メール：</th>
					<td><input id="title" name="email" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>電話番号：</th>
					<td><input id="title" name="phone" size="50" value=""
						type="text"></td>
				</tr>

				<tr>
					<th>届け先：</th>
					<td><input id="title" name="address" size="50" value=""
						type="text"></td>
				</tr>


				<tr>
					<th></th>
					<td><input value="ok" type="submit"> <input
						onClick="history.go(-1)" value="戻る" type="button"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>