<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>write</title>
</head>
<body>
	<h1>Write</h1>
	<form action="">
		<fieldset>
		<label for="gname">이름</label>
		<input type="text" name="gname" id="gname" />
		<label for="gtitle">제목</label>
		<textarea name="gtitle" id="gtitle" cols="30" rows="1"></textarea>
		<label for="gcontent">내용</label>
		<textarea name="gcontent" id="gcontent" cols="30" rows="10"></textarea>
		</fieldset>
		<div>
			<hr />
		</div>
		<input type="submit" value="저장" />
	</form>
</body>
</html>