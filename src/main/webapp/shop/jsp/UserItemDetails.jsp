<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "java.util.*" %>
 <%@ page import = "com.turna.entity.Item" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <title>商品詳細画面</title>
</head>
<body>
<style>
.flex1 {
  display: flex;
  justify-content: flex-start;
  padding: 20px;
}
.flex1  div {
  width: 100%;
  margin: 10px;
  padding: 10px;
}
.image {
  width: 200px;
  height: 200px;
}
.image2 {
  margin: 10px;
  width: 100px;
  height: 100px;
}
.flex2 {
  display: flex;
  justify-content: flex-end;
  margin: 10px;
  padding: 10px;
}
.buttonA {
  margin: 10px;
}
.buttonB {
  margin: 10px;
}
</style>
	  <!--ショップホームのリンク作成-->
  <a><img class="image2" src="shop/image/IMG_9550.jpg"></a>
  <!--「商品詳細」の文字表示  -->
  <h3 style="text-align: center">商品詳細</h3>
 <% ArrayList<Item> list = (ArrayList<Item>)request.getAttribute("list"); %>
 <% session.setAttribute("item_id" , list.get(0).getItem_id() ); %>
 <% session.setAttribute("item_name" , list.get(0).getItem_name() ); %>
 <% session.setAttribute("price" , list.get(0).getPrice() ); %>
 <% session.setAttribute("image_path" , list.get(0).getImage_path() ); %>
  <!-- 商品画像の表示 -->
  <div class="flex1">
    <!-- 商品詳細説明 -->
   
	    <%for(int i = 0 ; i < list.size() ; i++){ %>
	     <div>
	       <img class="image" src=<%=list.get(i).getImage_path() %>>
	     </div>
	     <div>
	      <p><%= list.get(i).getItem_name()%></p>
	      <p><%= list.get(i).getItem_code() %></p>
	      <p><%= list.get(i).getPrice() %></p>
	      <p><%= list.get(i).getDetail() %></p>
	      <p><%= list.get(i).getStock() %></p>
	      <%} %> 
	      <form method = "post" action = "/MyShop/UserCartServlet">
	      <select name = "stock">
	      <%
			for (int i = 1; i <= 100; i++) {
			out.print("<option value=\"" + i + "\">" + i + "</option>");
			}
			%>
		  </select>
	      <button type="submit">カートに追加</button>
	      </form> 
	    </div>
　</div>
 
  <!-- 戻る -->
  <div class="flex2">
    <button class="buttonA">戻る</button>
    <!-- カートに移動 -->
    <button class="buttonB" style="float: right;">カートに移動</button>
    </div>
</body>
</html>