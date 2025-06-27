<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>ecryptlogin</title>
</head>
<body>
	<h1>ecryptlogin</h1>
<form action="encryptlogin" method="post">
		<fieldset>
			아이디 : <input type="text" name="id" class="row"/><br />
			비밀번호 : <input type="text" name="pass" class="row"/><br />
			<input type="submit" value="encryptlogin" class="sendButton"/>
		</fieldset>
	</form>
</body>
<style>
	  body{
	  	justify-items: center;
	  	margin: 5%;
	  }
	  fieldset {
	    width: 40vw;
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
	  .sendButton{
	  	width: 100%;
	  }
	</style>
</html>