<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버들</title>
</head>
<body>
	<c:forEach var="m" items="${members }">
		<h3>
			아이디: <a href="http://localhost:8080/mvc/crud/get?id=${m.key }">${m.key }</a>${m.value }
		</h3>
		<br>
	</c:forEach>

</body>
</html>