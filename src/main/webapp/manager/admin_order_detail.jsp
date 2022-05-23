<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--注文番号--%>
<%=session.getAttribute("order_id")%>
<%--商品CD--%>
<%=session.getAttribute("item_id")%>
<%--送り状ナンバー--%>
<%=session.getAttribute("delivery_id")%>
商品名 価格 個数

発送完了日 2022-05-23
発送ステータス
入金ステータス
</body>
</html>