<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title> 목록</title>
</head>
<body>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
	<p>전체 ${totalCount }건</p>
	<form action="./app/list">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
		
		<a href="./app/article/write"> [글 쓰기] </a>
	</form>

	<table>
		<thead>
			<tr>
				<td>글번호</td>
				<td>작성자 학번</td>
				<td>작성자 이름</td>
				<td>제목</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${aritcle}">
				<tr>
					<td>${article.articleId}</td>
					<td>${article.userId}</td>
					<td>${article.name}</td>
					<td><a href="./app/article/read?articleId=${article.articleId}">${article.title}</a></td>
					<td>${article.udate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>