<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<title>list</title>
</head>
<body>
<div class="page-info-bar">
	<h1>GList</h1>
	<div class="info">
		전체 글 : ${totRowCnt }<br />
		현재 / 전체 페이지 : ${searchVO.page } / ${searchVO.totPage }
	</div>
</div>
<div><br /></div>
<!-- 페이징 UI -->
<div class="pagination-wrapper">
	<div class="pagination-controls">
		<!-- 처음 / 이전 -->
		<c:set var="prevPage" value="${searchVO.page - 1}" />
		<c:if test="${prevPage < 1}">
		    <c:set var="prevPage" value="1" />
		</c:if>
		<a class="nav <c:if test='${searchVO.page == 1}'>disabled</c:if>'" href="list?page=1">처음</a>
		<a class="nav <c:if test='${searchVO.page == 1}'>disabled</c:if>'" href="list?page=${prevPage}">이전</a>

		<!-- 구분 공간 -->
		<span class="spacer"></span>

		<!-- 숫자 버튼 -->
		<c:forEach begin="${searchVO.pageStart}" end="${searchVO.pageEnd}" var="i">
			<c:choose>
				<c:when test="${i eq searchVO.page}">
					<span class="current">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="list?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 구분 공간 -->
		<span class="spacer"></span>

		<!-- 다음 / 마지막 -->
		<c:set var="nextPage" value="${searchVO.page + 1}" />
		<c:if test="${nextPage > searchVO.totPage}">
		    <c:set var="nextPage" value="${searchVO.totPage}" />
		</c:if>
		<a class="nav <c:if test='${searchVO.page == searchVO.totPage}'>disabled</c:if>'" href="list?page=${nextPage}">다음</a>
		<a class="nav <c:if test='${searchVO.page == searchVO.totPage}'>disabled</c:if>'" href="list?page=${searchVO.totPage}">마지막</a>
	</div>
</div>

<!-- 테이블 출력 -->
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.gid }</td>
				<td>${dto.gname }</td>
				<td><a href="content_view?gid=${dto.gid }">${dto.gtitle }</a></td>
				<td>${dto.gdate }</td>
				<td>${dto.ghit }</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='write'">글쓰기</button>
</body>
</html>