<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품이름 입력</title>
</head>
<body>
    <form action="SaveCookieServlet" method="post">
        상품이름: <input type="text" name="product">
        <input type="submit" value="쿠키저장">
    </form>
    <form action="GetCookieServlet" method="get">
        <input type="submit" value="쿠키조회">
    </form>
</body>
</html>
