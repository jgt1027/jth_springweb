<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>글 조회</title>

</head>
<body>

<c:choose>
		<c:when test="${!empty sessionScope.MEMBER }">
			<c:if test="${article.userId == sessionScope.MEMBER.memberId }">
<a href="./app/article/update?articleId=${article.articleId}">[수정]</a>
<a href="./app/article/delete?articleId=${article.articleId}">[삭제]</a>
</c:if>
		</c:when>
		<c:otherwise>
			<p>
				<a href="./app/loginForm">[로그인]</a>
			</p>
			<p>
				<a href="./app/register/step1">[회원 가입]</a>
			</p>

		</c:otherwise>
	</c:choose>
	<table>
        <tr>
            <td>작성일자 : ${article.udate}</td>
        </tr>
        <tr>
            <td>글번호 : ${article.articleId}</td>
        </tr>
        <tr><td>학  번 :${article.userId}</td></tr>
        <tr><td>이  름 :${article.name}</td></tr>
        <tr>
            <td>글제목 :${article.title}</td>
        </tr>
        <tr>
            <td> 글 내 용 </td></tr>
            <tr>
            <td><p>${article.contentHtml }</p></td>
        </tr>
	</table>
		<a href="./app/list">[목  록]</a>
</body>
</html>