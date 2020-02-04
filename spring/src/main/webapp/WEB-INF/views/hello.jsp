<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 테스트</title>
</head>
<body>
<h1>컨트롤러 에서 전달 받은 값 : ${model}</h1>
<h1>컨트롤러 에서 전달 받은 값 : <%=request.getAttribute("model") %></h1>
</body>
</html>