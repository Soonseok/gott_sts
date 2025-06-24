<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>list</title>
</head>
<body>
	<h1>GList</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.gid }</td>
				<td>${dto.gname }</td>
				<td><a href="content_view?gid=${dto.gid }">${dto.gtitle }</a></td>
				<td>${dto.gdate }</td>
				<td>${dto.ghit }</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='write'">글쓰기</button>
</body>
</html>