<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAXSUCCESS</title>
</head>
<body>
	<%=request.getParameter("id")%>
	회원님
	<%=request.getParameter("pw")%>
	암호를 입력하셨습니다.

	<%
		boolean status = false;
		String loginTime ="---";
		if (request.getParameter("id").equals("ajax") && request.getParameter("pw").equals("ajax")) {
			status = true;
			loginTime = new Date().toLocaleString();
		}
	%>
	<%=status%><br>
	<%=loginTime%><br>

</body>
</html>