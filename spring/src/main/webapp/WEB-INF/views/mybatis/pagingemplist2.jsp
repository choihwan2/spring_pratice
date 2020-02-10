<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pagingemplist2</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:forEach items="${paginglist }" var="emp">
사번 : ${emp.employee_id } 성 : ${emp.last_name } 이름 : ${emp.first_name } 입사일 : ${emp.hire_date } <br>
	</c:forEach>
</body>
</html>