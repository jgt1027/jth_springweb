<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
	<form action="./app/article/update2" method="post">
	
	 <p>글번호 :
     <input name="articleId" value="${article.articleId}" type="text" readonly="readonly"/></p>
       
		<p>
			제목 : <br> <input type="text" name="title" value="${article.title }">
		</p>
		<p>
			내용 : <br> <textarea name="content" value="${article.content }" ></textarea>
		</p>
		<button type="submit">작성 완료</button>
		</form>
</body>
</html>