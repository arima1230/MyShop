<%@page import="com.turna.entity.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>オーダー管理詳細</title>
</head>
<body>

<%--注文番号--%>
<%=session.getAttribute("order_id")%>
<%--商品CD--%>
<%=session.getAttribute("item_id")%>
<%--送り状ナンバー--%>
<%=session.getAttribute("delivery_id")%>
<%--商品名 価格 個数--%>
<%=session.getAttribute("item_name")%>
<%=session.getAttribute("price")%>
<%=session.getAttribute("num_of_item")%>
<%-- 発送完了日 2022-05-23--%>
<%=session.getAttribute("create_at")%>
<%--発送ステータス 入金ステータス(変更ボタンも)--%>
<%=session.getAttribute("deli_stutas")%>
<%=session.getAttribute("pay_stutas")%>
</body>
</html>