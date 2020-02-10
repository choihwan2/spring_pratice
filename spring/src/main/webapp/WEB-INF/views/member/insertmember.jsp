<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertMember</title>
</head>
<body>
<h1>회원가입 창입니다.</h1>
<form action="/mvc/member/insertmember" method="post">
ID : <input type="text" placeholder="아이디는 필수입니다" required="required" name="userid"><br>
PW : <input type="password" name="password"><br> 
이름 : <input type= "text" name="name"><br>
전화번호: <input type="text" name="phone"> <br>
<input type="submit" value="가입">
</form>
</body>
</html>