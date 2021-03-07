<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write.jsp</title>
<style>
	#wrap{width:500px; margin:auto; text-align: center;}
</style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/board/insert">
	<div id="wrap">
		<h1>글작성 페이지</h1>
		<input type="hidden" value="${id }" name="writer">
		글쓴이<input type="text" size=20 value="${id }" id ="writer" disabled="disabled" ><br>
		제목<input type="text"  size=20 name ="title"><br>
		내용<br>
		<textarea rows=5 cols=50 name="content"></textarea><br>
		<input type="submit" value="등록"> | <input type="reset" value="초기화">
	</div>
</form>
</body>
</html>