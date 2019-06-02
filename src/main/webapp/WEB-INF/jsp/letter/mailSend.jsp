<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>받은 편지함</title>
</head>
<body>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
	<p>전체 ${count }건</p>
	<form action="./app/letter/mailSend">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${count / 20 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>

	<table>
		<thead>
			<tr>
				<td>편지번호</td>
				<td>받은 사람</td>
				<td>받은 사람 번호</td>
				<td>제목</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="letter" items="${letters}">
				<tr>
					<td>${letter.letterId}</td>
					<td>${letter.receiverId}</td>
					<td>${letter.receiverName}</td>
					<td><a href="./app/letter/mailView?letterId=${letter.letterId}">${letter.title}</a></td>
					<td>${letter.cdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>