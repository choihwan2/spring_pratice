<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:forEach items="${list }" var="emp">
사번 : ${emp.employee_id } 성 : ${emp.last_name } 이름 : ${emp.first_name } <br>
	</c:forEach>
	
	
	<form action="/mvc/mybatis/detailemp">
	사번 : <input type="text" name = "employee_id">
	<input type ="submit" value="조회">
	<input type ="button" id ="ajaxbtn" value="사원부르기">	
	</form>
	<div id = "div"></div>
	
	<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
	<script>
	$("#ajaxbtn").on('click', function() {
		$.ajax({
			url : '/mybatis/ajaxdetailemp' ,
			data : {"employee_id" : $("#employee_id").val()} ,
			type : "get" ,
			dataType : 'json' ,
			success : function( serverdata ){
				//{"status" : true, "time" : "2020년 2월 ..."}
				$("#div").append(serverdata.employee_id + " - " + serverdata.last_name + " - " + serverdata.first_name + " - " + serverdata.hire_date + " - " + serverdata.department_id + " - " + serverdata.email + "<br>");
				$("#div").css("color", "red");
				$("#div").css("border","2px solid green");
			}
		});//ajax end
	}); //on end
	</script>

</body>
</html>