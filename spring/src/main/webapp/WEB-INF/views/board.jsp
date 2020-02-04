<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="test.BoardVO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 mvc 테스트</title>
</head>
<body>
	<h1>컨트롤러 에서 전달 받은 값</h1>
	<h3>게시판</h3>
	<%-- 	<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("board");
	
	for(BoardVO vo : list){
		out.println(vo.getSeq());
	}
	%> --%>
	<table border="1">
		<tr align="center">
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>글쓴이</td>
			<td>작성시간</td>
			<td>비밀번호</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="item" items="${board }">
			<tr>
				<td>${item.seq }</td>
				<td>${item.title }</td>
				<td>${item.contents }</td>
				<td>${item.writer }</td>
				<td>${item.time }</td>
				<td>${item.password }</td>
				<td>${item.viewcount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>