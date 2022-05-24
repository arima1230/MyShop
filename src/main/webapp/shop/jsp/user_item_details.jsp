<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <!--ショップホームのリンク作成-->
  <a><img class="image2" src="shop/image/IMG_9550.jpg"></a>
  <!--「商品詳細」の文字表示  -->
  <h3 style="text-align: center">商品詳細</h3>
  <!-- 商品画像の表示 -->
  <div class="flex1">
    <div>
      <img class="image" src="shop/image/IMG_9297.jpg">
    </div>
    <!-- 商品詳細説明 -->
    <div>
      <p>商品名</p>
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
  <!-- 戻る -->
  <div class="flex2">
    <button class="buttonA">戻る</button>
    <!-- カートに移動 -->
    <button class="buttonB" style="float: right;">カートに移動</button>
    </div>
</body>
</html>