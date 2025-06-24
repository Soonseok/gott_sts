<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>content view</title>
</head>
<body>
	<h1>content view</h1>
	<h2>${content_view.gtitle }</h2>
	<table>
		<tr>
			<td>글 번호</td>
			<td>${content_view.gid }</td>
			<td>조회수</td>
			<td>${content_view.ghit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${content_view.gname }</td>
			<td>작성일</td>
			<td>${content_view.gdate }</td>
		</tr>
	</table>
	<fieldset>
		${content_view.gcontent }
	</fieldset>
	<div><hr /></div>
	<button onclick="location.href='/list'">목록</button>
</body>
</html>