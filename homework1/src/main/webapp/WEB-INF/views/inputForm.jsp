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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('form').submit(function(){
		if($('#name').val().length<1){
			alert('이름은 한글자 이상 입력하세요');
			return false;
		}
		if($('.score').val()<0 || $('.score').val()>100 ){
			alert('점수는 0점과 100점 사이값을 입력하세요');
			return false;
		}
	});
});
</script>
</head>
<body>
<div id="wrap">
	<p>현재 총 ${cnt }명</p>
	<form action="${conPath }/input.do">
		<table>
			<tr><td colspan="2">개인 정보 입력</td></tr>
			<tr><td>이름:</td><td><input type="text" name="name" id="name" ></td>
			<tr><td>국어:</td><td><input type="number" name="kor" class="score" required="required"></td>
			<tr><td>영어:</td><td><input type="number" name="eng" class="score" required="required"></td>
			<tr><td>수학:</td><td><input type="number" name="mat" class="score" required="required"></td>
			<tr><td colspan="2"><input type="submit" value="입력"></td></tr>
		</table>
	</form>
</div>
</body>
</html>