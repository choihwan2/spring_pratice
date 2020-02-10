<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detailemp</title>
</head>
<body>
사번 : ${emp.employee_id } 성: ${emp.last_name } 이름: ${emp.first_name } 부서코드: ${emp.department_id }<br>
이메일 : ${emp.email } 전화번호: ${emp.phone_number } 직종코드: ${emp.job_id } 급여: ${emp.salary }
</body>
</html>