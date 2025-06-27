<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" href="https://cdn.simplecss.org/simple.min.css">
<style>
body{
	margin-top: 4rem;
}
.pagination-wrapper {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 1rem;
}
.pagination-controls {
	display: flex;
	justify-content: center;
	gap: 8px; /* 버튼들 간 간격 넓힘 */
	flex-wrap: wrap;
}
.pagination-controls a,
.pagination-controls span {
	border: 1px solid #0d47a1;
	border-radius: 6px;
	padding: 4px 10px;
	color: #0d47a1;
	text-decoration: none;
	font-size: 0.9rem;
}
.pagination-controls a:hover {
	background-color: #E0ECFF;
}
.pagination-controls .nav {
	background-color: #0d47a1;
	color: white;
	font-weight: bold;
}
.pagination-controls .disabled {
	pointer-events: none;
	background-color: #ccc;
	color: white;
	border-color: #ccc;
}
.pagination-controls .current {
	background-color: #0d47a1;
	color: white;
	font-weight: bold;
}
.pagination-controls .spacer {
	display: inline-block;
	border:none;
	width: 24px;
}
}
.page-info-bar {
	margin-bottom: 2rem;
	display: flex;
	justify-content: space-between;
	width: 100%;
}
.page-info-bar h1 {
	margin: 0;
}
.page-info-bar .info {
	text-align: right;
	font-size: 0.9rem;
}
</style>
</head>
<body>

<!-- 제목 + 우측 정보 -->
<div class="page-info-bar">
	<h1>list</h1>
	<div class="info">
		전체 글 : ${totRowCnt }<br />
		현재 페이지 / 전체 페이지 : ${searchVO.page } / ${searchVO.totPage }
	</div>
</div>

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

<!-- 테이블 출력 (기존 스타일 유지) -->
<table>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>제목</td>
		<td>날자</td>
		<td>조회수</td>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.bid}</td>
		<td>${dto.bname}</td>
		<td>
			<c:set value="${dto.bindent}" var="endIndent" />
			<c:forEach begin="1" end="${dto.bindent}" var="cnt">
				<c:if test="${cnt ne 1}">&nbsp;&nbsp;</c:if>
				<c:if test="${cnt eq endIndent}">
					<img src="/static/images/arrow-right.gif" alt="" />
				</c:if>
			</c:forEach>
			<a href="content_view?bid=${dto.bid}">${dto.btitle}</a>
		</td>
		<td>${dto.bdate}</td>
		<td>${dto.bhit}</td>
	</tr>
	</c:forEach>
</table>

<!-- 글쓰기 버튼 (기본 스타일 유지) -->
<button type="button" onclick="location.href='write_view'">글작성</button>
</body>
</html>
