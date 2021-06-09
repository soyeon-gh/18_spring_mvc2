<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<div align="center" style="margin-top: 100px">
		<h1>${from }</h1>
		<br>
		<table border="1">
			<tr align="center">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>출생연도</th>
				<th>출생월</th>
				<th>출생일</th>
				<th>양력/음력</th>
				<th>연락처1</th>
				<th>연락처2</th>
				<th>연락처3</th>
				<th>SMS수신여부</th>
				<th>이메일</th>
				<th>이메일수신여부</th>
			</tr>
			<c:forEach var="member" items="${memberList}">
				<tr align="center">
					<td>${member.id }</td>
					<td>${member.pw }</td>
					<td>${member.name }</td>
					<td>${member.gender }</td>
					<td>${member.birthY }</td>
					<td>${member.birthM }</td>
					<td>${member.birthD }</td>
					<td>${member.birthGn }</td>
					<td>${member.hp1 }</td>
					<td>${member.hp2 }</td>
					<td>${member.hp3 }</td>
					<td>${member.smsstsYn }</td>
					<td>${member.email }</td>
					<td>${member.emailstsYn }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>