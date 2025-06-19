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
		<form action="foodview">
			가게 : <input type="text" id="store" name="store" class="row" /> <br />
			메뉴 : <input type="text" id="menu" name="menu" class="row" /> <br />
			가격 : <input type="text" id="price" name="price" class="row" /> <br />
			<input type="submit" value="제출" class="sendButton" />
		</form>
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

.sendButton {
	width: 100%;
}
</style>
</html>