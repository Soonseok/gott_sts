<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>Login</title>
<style>
	.form-row {
		display: flex;
		align-items: center;
		margin-bottom: 10px;
	}
	.form-row label {
		width: 80px;
		font-weight: bold;
	}
	.form-row input {
		flex: 1;
	}
</style>
</head>
<body>
	<h1>loginform</h1>
	<form action="loginconfirm">
		<div class="form-row">
			<label for="id">id:</label>
			<input type="text" id="id" name="id" />
		</div>
		<div class="form-row">
			<label for="pw">pw:</label>
			<input type="text" id="pw" name="pw" />
		</div>
		<div class="form-row">
			<label for="hobby">hobby:</label>
			<input type="text" id="hobby" name="hobby" />
		</div>
		<input type="submit" value="login" />
	</form>
</body>
</html>
