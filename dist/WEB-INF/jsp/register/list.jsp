<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>회원 목록</title>
</head>
<body>
	<p>전체 ${totalCount }건</p>
	<form action="./app/list">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
		
		<a href="./app/register/write"> [글 쓰기]</a>

	<table>
		<thead>
			<tr>
				<td>글번호</td>
				<td>작성자 학번</td>
				<td>작성자 이름</td>
				<td>제목</td>
				<td>글내용</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td>${article.articleId}</td>
					<td>${article.userId}</td>
					<td>${article.name}</td>
					<td><a href="./app/register/read?articleId=${article.articleId}">${article.title}</td>
					<td>${article.content}</td>
					<td>${article.udate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>