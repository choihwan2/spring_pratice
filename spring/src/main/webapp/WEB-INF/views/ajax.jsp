<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
	<form action="/mvc/ajaxlogin">
		ID: <input type="text" name="id" id="id"><br> PW: <input
			type="text" name="pw" id="pw"><br> <input type="submit"
			value="로그인"> <input id="ajaxbtn" type="button"
			value="ajax로그인">
	</form>

	<div></div>
	<img src="/mvc/resources/images/google.png">
	
	<input type ="text" id = "seq">
	<input type ="button" id = "ajaxboardbtn" value="게시물줭">
	<div id = "boarddiv"></div>
	<script src="/mvc/resources/jquery-3.2.1.min.js"></script>
	<script>
	$("#ajaxbtn").on('click', function() {
		$.ajax({
			url : '/mvc/ajaxlogin2' ,
			data : {"id" : $("#id").val() , 'pw' : $("#pw").val() } ,
			type : "get" ,
			dataType : 'json' ,
			success : function( serverdata ){
				//{"status" : true, "time" : "2020년 2월 ..."}
				$("div").html(serverdata.status + " - " + serverdata.time);
				$("div").css("color", "red");
				$("div").css("border","2px solid blue");
				
			}
		});//ajax end
	}); //on end
	
	$("#ajaxboardbtn").on('click', function() {
		$.ajax({
			url : '/mvc/ajaxboard' ,
			data : {"seq" : $("#seq").val()} ,
			type : "get" ,
			dataType : 'json' ,
			success : function( serverdata ){
				//{"status" : true, "time" : "2020년 2월 ..."}
				$("#boarddiv").append(serverdata.seq + " - " + serverdata.title + " - " + serverdata.writer + " - " + serverdata.contents + " - " + serverdata.time + " - " + serverdata.viewcount + "<br>");
				$("#boarddiv").css("color", "red");
				$("#boarddiv").css("border","2px solid green");
				
			}
		});//ajax end
	}); //on end
	</script>

</body>
</html>