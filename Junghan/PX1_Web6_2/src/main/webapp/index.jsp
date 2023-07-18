<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>테스트 데이터 전송(한글)</title>
</head>
<body>
    <form action="MyServlet" method="post">
        데이터: <input type="text" name="stuff">
        <input type="submit" value="전송">
    </form>
</body>
</html>