
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>메인</title>
</head>
<body>
	<p>환영합니다.</p>

	<c:choose>
		<c:when test="${!empty sessionScope.MEMBER }">
		>
			<p>memberId: ${MEMBER.memberId }, email: ${MEMBER.email }, name:
				${MEMBER.name }</p>
			<p>
				<a href="./app/logout">[로그아웃]</a>
			</p>
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
	<p>
		<a href="./app/members">[회원 목록]</a>
	</p>
	<p>
		<a href="./app/article/list">[게시판]</a>
	</p>
</body>
</head>
</html>