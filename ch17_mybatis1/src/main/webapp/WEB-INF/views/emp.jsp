<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/emp.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<div id="wrap">
		<form action="">
			사원명<input type="text" name="ename" value="${searchEmp.ename }">
			직책<input type="text" name="job" value="${searchEmp.job}">
			부서번호 <select name="deptno">
				<option value="0">모든부서</option>
				<c:forEach items="${deptList }" var="dept">
					<option value="${dept.deptno }" 
						<c:if test="${dept.deptno==searchEmp.deptno }">
							selected="selected"
						</c:if>
					>${dept.dname }</option>
				</c:forEach>
			</select>
			<input type="submit">
		</form>
		<table>
			<tr><th>사원번호</th><th>이름</th><th>직챗</th><th>mgr</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>
			<c:forEach items="${empList }" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.sal}</td>
					<td>${emp.comm}</td>
					<td>${emp.deptno}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>