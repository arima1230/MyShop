<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.turna.entity.Order" %>
<%@ include file="admin_menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文日リスト</title>
</head>


<body>
	<div class="crumb-list">
		<a href="/MyShop/manager/admin_index.jsp">ホーム</a><span
			class="crumb-step">&gt;</span><a class="crumb-name"
			href="admin_order_day">注文日管理</a>

<div> <%--検索機能つける --%>
     発送ステータス <form>
    <select name="発送ステータス">
      <option>未</option>
      <option>発送中</option>
      <option>発送済</option>
    </select></form>
    
     入金ステータス<form>
    <select name="入金ステータス">
      <option>未</option>
      <option>入金済</option>
    </select></form>
    
    
    <%
	ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list");
	%>
    
    <table border="1">
		<tr align="center">
				<td>注文番号</td>
				<td>発送ステータス</td>
				<td>入金ステータス</td>
				<td>詳細</td>
			</tr>
		<%--リストからユーザ情報を取り出し、データ行を作成する --%>
		<%-- for (int i = 0; i < list.size(); i++) { --%>
		<tr align="center">
		
		<td><%=session.getAttribute("order_id")%></td>
		<td><%=session.getAttribute("deli_status")%></td>
		<td><%=session.getAttribute("pay_status")%></td>
		
			<%-- >td><%=list.get(i).getOrder_id()%></td>
			<td><%=list.get(i).getDeli_status()%></td>
			<td><%=list.get(i).getPay_status()%></td>
			<td>
				<form action="/manager/admin_order_detail?order_id=<%=list.get(i).getOrder_id()%>"
					method="post">
					<input type="submit" name="submit" value="詳細">
				</form>
			</td--%>
		</tr>
	</table>
	
	<%--
	}
	--%>  
</div>
<button type="button" onclick="history.back()">戻る</button>
</body>
</html>