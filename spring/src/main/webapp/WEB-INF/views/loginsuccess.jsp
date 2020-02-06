<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>loginsuccess.jsp 파일이 보입니다.</h1>
	회원님의 아이디는: ${loginVO.id }입니다.<br>
	회원님의 아이디는: ${loginVO.pw }입니다.<br> 
	회원님의 아이디는: ${loginVO.age }입니다.<br> 
	로그인 상태는${loginresult } 입니다.
</body>
</html>