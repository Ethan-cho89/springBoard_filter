<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/login.jsp</title>
<style>
	#wrap{width:500px; margin:auto; text-align: center;}
</style>
</head>
<body>
<div id="wrap">
	<form method="post" action="${pageContext.request.contextPath }/member/login">
		<h1>LOGIN PAGE</h1>
		<label for="id">ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" id="id" name="id"><br>
		<label for="pwd">PASSWORD&nbsp;</label>
		<input type="password" id="pwd" name="pwd"><br>
		<div id="result" style="font-size:5px; color:red">${errMsg }</div>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>