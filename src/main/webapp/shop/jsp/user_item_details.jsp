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
  <link rel="stylesheet" href="shop/css/user_item_details.css">
  <title>商品詳細画面</title>
</head>
<body>
<style>
.flex1 {
  display: flex;
  justify-content: flex-start;
  padding: 20px;
}

.flex1 div {
  width: 100%;
  margin: 10px;
  padding: 10px;
}

.image {
  width: 200px;
  height: 200px;
}

.image2 {
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
 
  <!-- 商品画像の表示 -->
  <div class="flex1">
    <div>
      <img class="image" src="shop/image/IMG_9297.jpg">
    </div>
    <!-- 商品詳細説明 -->
    <%for(int i = 0 ; i < list.size() ; i++){ %>
    <div>
      <p><%=list.get(i).getItem_name()%></p>
      <p>商品CD</p>
      <p>商品価格</p>
      <p>商品詳細説明</p>
      <select>
        <option value="個数選択" selected>個数選択</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
      <button>カートに追加</button>
    </div>
  </div>
 <%} %> 
  <!-- 戻る -->
  <div class="flex2">
    <button class="buttonA">戻る</button>
    <!-- カートに移動 -->
    <button class="buttonB" style="float: right;">カートに移動</button>
    </div>
</body>
</html>