
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.turna.entity.User" %>


<html>
<head>
<title>ユーザー一覧</title>
</head>
<body>
	
	<%--一覧画面 --%>

	<br>	<%
	ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
	%>
	<table border="1">
		<tr align="center">
				<td>ID</td>
				<td>氏名</td>
				<td>EMAIL</td>
				<td>電話番号</td>
				<td>詳細</td>
			</tr>
		<%--リストからユーザ情報を取り出し、データ行を作成する --%>
		<% for (int i = 0; i < list.size(); i++) { %>
		<tr align="center">
			<td><%=list.get(i).getUser_id()%></td>
			<td><%=list.get(i).getUser_name()%></td>
			<td><%=list.get(i).getEmail()%></td>
			<td><%=list.get(i).getPhonenumber()%></td>
			<td>
				<form action="/MyShop/manager/admin_detuserservlet?user_id=<%=list.get(i).getUser_id()%>"
					method="post">
					<input type="submit" name="submit" value="詳細">
				</form>
			</td>
		<tr>
	
	
	<%
	}
	%>
</table>

</body>
</html>