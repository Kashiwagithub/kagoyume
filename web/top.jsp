<%-- 
    Document   : top
    Created on : 2016/06/13, 15:23:25
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <h1>かごいっぱいのゆめ</h1>
        <jsp:include page="/footer.jsp" />
        <p>ショッピングサイトを使っている時、こんな経験ありませんか？<br>
           「あれいいな」「これいいな」「あっ、関連商品のこれもいい」「20%オフセールだって！？　買わなきゃ！」・・・<br>
           そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。<br>
           「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」<br>
           仕方がありません。無駄遣いは厳禁です。<br>
           でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？<br>
           できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。<br>
           このサービスは、そんなフラストレーションを解消するために生まれた
        </p>
        <p div id ="description">
          『金銭取引が絶対に発生しない』『いくらでも、どんなものでも購入できる(気分になれる)』<br>
        </p>
        <p>
           『ECサイト』です
        </p>
        <form action ="Search" method ="GET">
            <input type="search" name="product_name" size="30" maxlength="30" autofocus>
            <input type="submit" value="Yahoo!ショッピングで検索">
        </form>
    </body>
</html>
