<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<h1>ModelAttribute를 통해 cnt,list</h1>
	<h2>cnt : ${cnt }</h2>
	<h2>list : ${list }</h2>
	<h1>result1 : 개인정보</h1>
	<h2>name 	:${name 	 }</h2>
	<h2>id 	:${id 	 }</h2>
	<h2>pw 	:${pw 	 }</h2>
	<h2>age 	:${age 	 }</h2>
	<h2>email 	:${email	 }</h2>
	<h2>address:${address }</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath }/'">처음부터 가시 시작하기</button>
</body>
</html>