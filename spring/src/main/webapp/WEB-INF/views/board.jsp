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
<style type="text/css">
table {
	float: left;
	border: 2px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
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
	<table>
		<tr align="center">
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>글쓴이</td>
			<td>작성시간</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="item" items="${board }">
			<tr>
				<td>${item.seq }</td>
				<td>${item.title }</td>
				<td>${item.contents }</td>
				<td>${item.writer }</td>
				<td>${item.time }</td>
				<td>${item.viewcount }</td>
				<td><form action="http://localhost:8080/mvc/boarddelete"
						method="post">
						<input type="hidden" name="seq" value=${item.seq }> <input
							type="text" name="password" placeholder="비밀번호" maxlength="6"
							style="width: 80px;"> <input type="submit" value="삭제">
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<form action="http://localhost:8080/mvc/boardselect">
		검색: <input type="text" name="seq" placeholder="찾고자하는 글 번호"> <input
			type="submit" value="검색">
	</form>
	<br>
	<h1>
		<a href="http://localhost:8080/mvc/boardinsert">글 추가하기</a>
	</h1>
</body>
</html>