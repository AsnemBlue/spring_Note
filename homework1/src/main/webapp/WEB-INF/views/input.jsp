<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<p>현재 총 ${cnt }명</p>
	<table>
		<tr><td colspan="2">결과는 다음과 같습니다.</td></tr>
		<tr><td>이름 : </td><td>${student.name }</td></tr>
		<tr><td>국어 : </td><td>${student.kor }</td></tr>
		<tr><td>영어 : </td><td>${student.eng }</td></tr>
		<tr><td>수학 : </td><td>${student.mat }</td></tr>
		<tr><td>총점 : </td><td>${student.kor+student.eng+student.mat }</td></tr>
		<tr><td>평균 : </td><td><fmt:formatNumber value="${(student.kor+student.eng+student.mat)/3}" pattern=".00"/></td></tr>
		<tr><td colspan="2">
			<button onclick="history.back()">뒤로가기</button>
			<button onclick="location.href='${conPath }/inputForm.do'">다시입력</button>
		</td></tr>
	</table>
</div>
</body>
</html>