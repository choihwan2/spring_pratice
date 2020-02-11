<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지입니다.</h1>
<form action="/mvc/member/loginprocess" method="post">
ID : <input type="text" name="userid"> <br>
PW : <input type="password" name="password"><br>
<input type = "submit" value="로그인">
<h2><a href ="/mvc/member/insertmember">회원가입</a></h2>

</form>
</body>
</html>