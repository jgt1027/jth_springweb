<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<p>
		<span><a href="./app/main">홈</a></span> | <span><a href="./app/members">회원목록</a></span>
		| <span><a href="./app/list">게시판</a></span> |
		<c:choose>
			<c:when test="${!empty sessionScope.MEMBER }">
				<span><a href="./app/member/memberinfo">${MEMBER.name }</a></span> | 
			<span><a href="./app/logout">로그아웃</a></span>
			</c:when>
			<c:otherwise>
				<span><a href="./app/loginForm">로그인</a></span> |
				<span><a href="./app/register/step1">회원가입</a></span>
			</c:otherwise>
		</c:choose>
	</p>
</header>