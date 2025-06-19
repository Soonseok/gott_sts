<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>Title</title>
</head>
<body>
	<h2>What Did You Eat</h2>
	<fieldset>
			가게 : <fieldset>${store }</fieldset> <br />
			메뉴 : <fieldset>${menu }</fieldset> <br />
			가격 : <fieldset>${price }</fieldset> <br />
	</fieldset>
</body>
<style>
body {
	justify-items: center;
	margin: 5%;
}

fieldset {
	width: 300px;
	padding: 16px;
	border: 2px solid #ccc;
	border-radius: 8px;
}

.row {
	display: flex;
	justify-content: flex-start;
	margin-bottom: 8px;
	width: 100%;
}
</style>
</html>