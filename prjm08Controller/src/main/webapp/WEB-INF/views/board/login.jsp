<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>login</title>
</head>
<body>
	<h1>login</h1>
	<fieldset>
		<form action="./loginconfirm" method="post">
			<label for="id" class="label">id:</label> 
			<input type="text" id="id" name="id" class="row" /> 
			
			<label for="pw" class="label">pwd:</label>
			<input type="text" id="pwd" name="pwd" class="row" /> 
			
			<input type="submit" value="login" class="sendButton" />
		</form>
	</fieldset>
</body>
<style>
body {
	justify-items: center;
	margin: 5%;
}

fieldset {
	width: 40vw;
	padding: 16px;
	border: 2px solid #ccc;
	border-radius: 8px;
}

legend {
	font-weight: bold;
	padding: 0 8px;
}

.row {
	display: flex;
	justify-content: flex-start;
	margin-bottom: 8px;
	width: 100%;
}

.label {
	width: 80px;
	font-weight: bold;
}

.sendButton {
	width: 100%;
}
</style>
</html>