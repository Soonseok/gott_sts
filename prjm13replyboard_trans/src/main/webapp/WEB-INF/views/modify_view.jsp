<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>Insert title here</title>
</head>
<body>
<h1>modify_view</h1>
<form action="modify" method="post">
<input type="hidden" name="bid" value="${content_view.bid }" />
	<table width="100%">
	<tr>
		<td>번호</td>
		<td>${content_view.bid }</td>
	</tr>
	<tr>
		<td>히트</td>
		<td>${content_view.bhit }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="bname" value="${content_view.bname }" /></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="btitle" value="${content_view.btitle }" /></td>
	</tr>
	</table>
	<fieldset>
		<legend>내용</legend>
		<textarea name="bcontent" rows="10">${content_view.bcontent }</textarea>
	</fieldset>
	<input type="submit" value="수정" />
	<button type="button" onclick="location.href='list'">목록</button>
	<button type="button" onclick="" id="deleteBtn">삭제</button>
</form>
</body>
<style>
	#deleteBtn{
		float: right;
		margin-top: 1rem;
		background-color: rgb(255, 0, 0);
		border-color: rgb(255,0,0);
	}
	#deleteBtn:hover{
		background-color: rgb(255,100,100);
		border-color: rgb(255,100,100);
	}
</style>
</html>