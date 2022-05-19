<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="bean.HumanBean"%>

<%
ArrayList<HumanBean> list = (ArrayList<HumanBean>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報</title>
</head>
<body>
	<form action="/MyShop/admin_user" method="post">

		<%--セッションからユーザ情報を取り出し、データ行を作成する --%>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>

		<%=session.getAttribute("id")%>
		<%=session.getAttribute("name")%>
		<%=session.getAttribute("kana")%>
		<%=session.getAttribute("birthday")%>
		<%=session.getAttribute("adress")%>
		<%=session.getAttribute("phonenumber")%>
		<%=session.getAttribute("postcode")%>
		<%=session.getAttribute("building")%>
		<%=session.getAttribute("roomnumber")%>

		<%
		}
		%>


		<input type="submit" name="submit" value="戻る">
	</form>


</body>
</html>