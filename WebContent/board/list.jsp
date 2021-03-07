<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
<style>
	#wrap{width:500px; margin:auto; text-align: center;}
</style>
</head>
<body>
<div id="wrap">
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<table border="1" width="500">
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="vo" items="${list }">
	<tr>
		<td>${vo.num }</td>
		<td>${vo.writer }</td>
		<td>${vo.title }</td>
		<td><a href="${cp }/board/edit?num=${vo.num}">수정</a></td>
		<td><a href="${cp }/board/delete?num=${vo.num}">삭제</a></td>
	</tr>
	</c:forEach>		
</table>
	<c:if test="${startPageNum>10 }">
		<a href="${cp }/board/list?pageNum=${startPageNum-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }">
				<span style="color:black">[${i}]</span>
			</c:when>
			<c:otherwise>
				<a href="${cp}/board/list?pageNum=${i}"><span style="color:blue">[${i}]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${endPageNum<pageCount }">
		<a href="${cp }/board/list?pageNum=${endPageNum+1}">[이전]</a>
	</c:if>
<a href="${cp }/main.jsp">MAIN</a>
</div>
</body>
</html>