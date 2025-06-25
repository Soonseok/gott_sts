<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>reply_view</title>
</head>
<body>
	<h1>reply_view</h1>
	<form action="reply" method="post">
		<input type="hidden" name="bid" value="${reply_view.bid }" />
		<input type="hidden" name="bgroup" value="${reply_view.bgroup }" />
		<input type="hidden" name="bstep" value="${reply_view.bstep }" />
		<input type="hidden" name="bindent" value="${reply_view.bindent }" />
		<table width="100%">
			<tr>
				<td>번호</td>
				<td>${reply_view.bid }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${reply_view.bhit }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bname"
					value="${reply_view.bname }" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"
					value="${reply_view.btitle }" /></td>
			</tr>
		</table>
		<fieldset>
			<legend>내용</legend>
			<textarea name="bcontent" rows="10">${reply_view.bcontent }</textarea>
		</fieldset>
		<input type="submit" value="답변달기" />
		<button type="button" onclick="location.href='list'">목록</button>
	</form>
</body>
</html>