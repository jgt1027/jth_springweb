<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
	<form action="./app/register/writ" method="post">
		<p>
			학번 : 2014041064
		</p>
		<p>
			이름 : 정 택 환
		</p>
		<p>
			제목 : <br> <input type="text" name="title" value="${param.title }">
		</p>
		<p>
			내용 : <br> <textarea name="content" value="${param.content }" ></textarea>
		</p>
		<button type="submit">작성 완료</button>
		</form>
</body>
</html>