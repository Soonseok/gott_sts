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
<h1>write_view</h1>
<form action="write" method="post">
<table width="100%">
	<tr>
		<td>이름</td>
		<td><input type="text" name="bname" size="50" /></td>	
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="btitle" size="50" /></td>	
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="bcontent" id="bcontent" cols="30" rows="10">content</textarea></td>	
	</tr>
</table>
<input type="submit" value="write" width="100%"/>
</form>

</body>
</html>