<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>글 조회</title>

</head>
<body>
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