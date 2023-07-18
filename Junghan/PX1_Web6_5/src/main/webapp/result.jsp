<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>결과 페이지</title>
</head>
<body>
    <h1>결과 페이지</h1>
    <p>나눗셈 결과: <%= request.getAttribute("result") %></p>
    <script>
        console.log("나눗셈 결과: " +  <%= request.getAttribute("result") %>);
    </script>
    <a href="/">입력 화면으로 돌아가기</a>
</body>
</html>
