<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/update.jsp</title>
</head>
<body>
<div id="wrap">
	<div id="box" style="width:500px">
		<form action="${pageContext.request.contextPath }/board/edit" method="post">
			<input type="hidden" name="num" value="${vo.num }">
			<input type="hidden" name="writer" value="${vo.writer }">
			<input type="hidden" name="regdate"	value="${vo.regdate }">
			글번호<input type="text" name="n" value="${vo.num }" disabled="disabled"><br>
			글쓴이<input type="text" name="w" value="${vo.writer }" disabled="disabled"><br>
			제목<input type="text"	name="title" value="${vo.title }"><br>
			내용<br>
			<textarea rows="5" cols="50">${vo.content }</textarea><br>
			<input type="submit" value="수정하기"> | <a href="${pageContext.request.contextPath }/main.jsp">메인</a>
		</form>
	</div>
</div>
</body>
</html>