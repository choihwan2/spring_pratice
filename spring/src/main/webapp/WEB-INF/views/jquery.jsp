<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQUERY</title>
</head>
<body>
	<form action="/a">
		<input type="text" id="a2" name="a">
		<!-- 서버전송파라미터명 = name 
			 htmltag를 써서 그거에 대한 동작을 주기위한 이름 = id -->
		<input id="btn2" type="button" value="전송">
	</form>

	<img src="<%=request.getContextPath()%>/resources/images/google.png">
	<h1>호호호</h1>
	<h1 id="we">호호호</h1>
	<h1>호호호</h1>
	<input id="btn" type="button" value="클릭">
	<div id="result"></div>


	<script
		src="<%=request.getContextPath()%>/resources/jquery-3.2.1.min.js"></script>
	<script>
		var a = 0;
		$("#btn").on('click', function() {
			$("#result").append("<h3>추가합니다</h3>" + a);
			a++;
		});
		$("#we").css("color", "blue");

		$("#btn2").on('click', function() {
			//location.href= '/a?a= + "$("#a2").val();"입력값';
			$("form").submit();
		});
	</script>

</body>
</html>