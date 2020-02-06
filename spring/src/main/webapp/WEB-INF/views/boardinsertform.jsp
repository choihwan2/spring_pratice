<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기합니다</h1>
<form action="http://localhost:8080/mvc/boardinsert" method="post"><br>
제목 : <input type="text" name = "title"> <br>
내용 : <textarea name= "contents" rows="10" cols="50"></textarea> <br>
작성자 : <input type="text" name = "writer"> <br>
암호 : <input type="password" name = "password"><br>
<input type="submit" value="글쓰기 완료.">
</form>

</body>
</html>