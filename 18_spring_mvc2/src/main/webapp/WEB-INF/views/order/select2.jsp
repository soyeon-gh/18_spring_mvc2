<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select2</title>
</head>
<body>
	<div align="center" style="margin-top: 100px">
		<h1>${from }</h1>
		<br>
		<table border="1">
			<tr align="center">
				<th>회원 아이디</th>
				<th>주문 번호</th>
				<th>상품 코드</th>
				<th>상품 이름</th>
				<th>상품 가격</th>
				<th>주문 개수</th>
				<th>최종 결제 금액</th>
				<th>주문 일시</th>
			</tr>
			<c:forEach var="order" items="${orderList }">
				<tr align="center">
					<td>${order.memberId }</td>
					<td>${order.orderId }</td>
					<td>${order.productCode }</td>
					<td>${order.productName }</td>
					<td><fmt:formatNumber value="${order.productPrice }"/>원</td>
					<td><fmt:formatNumber value="${order.orderCount }"/>개 </td>
					<td><fmt:formatNumber value="${order.totalPrice }"/>원</td>
					<td><fmt:formatDate value="${order.orderDate }"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>