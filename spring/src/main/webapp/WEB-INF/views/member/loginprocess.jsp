<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%=request.getAttribute("member") %>
<%=session.getAttribute("member") %>
${sessionScope.memeber }
${memeber } --%>
<h1>${member.userid } 회원님 로그인 하셨습니다</h1>
<h1>회원님의 이름은 ${member.name } 입니다.</h1>

<h2><a href="/mvc/member/mypage"> 내정보 보러가기</a></h2><br>
<a href = "/mvc/member/logout">로그아웃 하기</a>

</body>
</html>