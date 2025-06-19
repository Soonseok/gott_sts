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
	<h1>ModelView2</h1>
	<fieldset>
	<legend>Hobbies</legend>
		<c:forEach items="${hobbies }" var="hobby" varStatus="st">
			${hobby } <c:if test="${not st.last }">, </c:if>
		</c:forEach>
	</fieldset>
	<fieldset>
	<legend>Hobbies</legend>
		<c:forEach begin="0" end="${hobbies.size()-1 }" var="i" varStatus="st">
			${hobbies[i] } <c:if test="${not st.last }">, </c:if>
		</c:forEach>
	</fieldset>
	<fieldset>
	<legend>Hobbies</legend>
		<c:forEach items="${hobbies }" var="hobby">
			${hobby } <br />
		</c:forEach>
	</fieldset>
</body>
</html>