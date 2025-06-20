<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>Join View</title>
</head>
<body>
	<h1>Join View</h1>
	<div>
	<h4>HttpServletRequest req, Model model<br /> OR <br />@RequestParam("id")String id, 
			@RequestParam("name")String name, 
			@RequestParam("email")String email, 
			Model model</h4>
	${id }<br />
	${name }<br />
	${email } <br />
	</div>
	<hr />
	<div>
	<h4>@ModelAttribute("join") Member member</h4>
	${join.id }<br />
	${join.name }<br />
	${join.email }<br />
	</div>
	<hr />
	<div>
	<h4>@RequestParam("id")String id, 
			@RequestParam("name")String name, 
			@RequestParam("email")String email, 
			Model model</h4>
	${member.id }<br />
	${member.name }<br />
	${member.email }<br />
	</div>
</body>
</html>