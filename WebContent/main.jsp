<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/main.jsp</title>
<style>
	#wrap{width:500px; margin:auto; text-align: center;}

</style>
</head>
<body>
<div id="wrap">
<h1>MAIN PAGE</h1>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${empty sessionScope.id }">
		<a href="${cp }/member/login">로그인</a><br>
	</c:when>
	<c:otherwise>
		<a href="${cp }/member/logout">로그아웃</a><br>
	</c:otherwise>
</c:choose>
<a href="${cp }/board/write.jsp">글쓰기</a><br>
<a href="${cp }/board/list">글목록</a><br>
</div>
</body>
</html>