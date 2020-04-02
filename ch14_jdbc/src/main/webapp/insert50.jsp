<%@page import="com.tj.ch14.dto.BoardDto"%>
<%@page import="com.tj.ch14.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	BoardDao bDao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=0; i<55; i++){
		dto.setBname("홍길동"+i);
		dto.setBtitle("제목"+i);
		dto.setBcontent("내용"+i);
		dto.setBip("192.168.29.31");
		int result = bDao.write(dto);
		System.out.println(result==BoardDao.SUCCESS?i+" : 성공":i+" : 실패");
	}
	String conPath = request.getContextPath();
	response.sendRedirect(conPath+"/list.do");
	%>
</body>
</html>