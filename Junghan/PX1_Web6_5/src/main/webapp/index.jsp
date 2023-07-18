<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>나눗셈 계산기</title>
</head>
<body>
    <h1>나눗셈 계산기</h1>
    <form id="calculatorForm" method="post" action="DivideServlet">
        <label for="numerator">분자를 입력하세요: </label>
        <input type="number" id="numerator" name="numerator" required>
        <br>
        <label for="denominator">분모를 입력하세요: </label>
        <input type="number" id="denominator" name="denominator" required>
        <br>
        <br>
        <input type="submit" value="나누기">
    </form>
</body>
</html>
