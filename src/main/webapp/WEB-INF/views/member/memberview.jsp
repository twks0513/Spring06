<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberView.jsp</h1>
	
	
	<table border="1">
		<tr>
			<td>아이디</td><td>이름</td>
		</tr>
		<c:choose>
			<c:when test="${list.size() == 0 }">
				<tr>
					<td colspan="2">데이터 없음</td>
				</tr>			
			</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.id }</td><td>${dto.name }</td>
						</tr>
					</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="index">인덱스 가기</a>
	<a href="insertview">데이터 추가</a>
</body>
</html>