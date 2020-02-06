<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾은 게시물</title>
<style type="text/css">
td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<h1>검색한 게시물 번호 : ${selectboard.seq }</h1>
	<form action="http://localhost:8080/mvc/boardupdate" method="post">
		<table style="border-collapse: collapse;">
			<tr align="center">
				<td>글번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>글쓴이</td>
				<td>작성시간</td>
				<td>비밀번호</td>
				<td>조회수</td>
			</tr>
			<tr>
				<td><input type="text" name="seq" value=${selectboard.seq }
					readonly="readonly"></td>
				<td><input type="text" name="title" value=${selectboard.title }></td>
				<td><input type="text" name="contents"
					value=${selectboard.contents }></td>
				<td><input type="text" name="writer"
					value=${selectboard.writer }></td>
				<td>${selectboard.time }</td>
				<td><input type="text" name="password"
					value=${selectboard.password }></td>
				<td>${selectboard.viewcount }</td>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	<h3>
		<a href="http://localhost:8080/mvc/board">홈으로</a>
	</h3>
</body>
</html>