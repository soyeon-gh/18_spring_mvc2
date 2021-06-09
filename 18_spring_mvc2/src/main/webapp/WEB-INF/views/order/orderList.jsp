<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전송 확인</title>
</head>
<!-- 

	CREATE DATABASE SPRING_MVC2_EX;
	
	USE SPRING_MVC2_EX;
	
	CREATE TABLE T_ORDER_LIST(
		MEMBER_ID 		VARCHAR(30),
		ORDER_ID 	  	VARCHAR(30),
		PRODUCT_CODE 	VARCHAR(30),
		PRODUCT_NAME	VARCHAR(30),
		PRODUCT_PRICE	INT,
		ORDER_COUNT		INT,
		TOTAL_PRICE		INT,
		ORDER_DATE  DATE
	);
	
	INSERT INTO T_ORDER_LIST VALUES("user1","req1","0x001","기계식키보드",37000,1,37000,now());
	INSERT INTO T_ORDER_LIST VALUES("user1","req2","0x002","무소음 마우스",24000,3,72000,now());
	INSERT INTO T_ORDER_LIST VALUES("user1","req3","0x003","장패드",7000,7,49000,now());
	INSERT INTO T_ORDER_LIST VALUES("user2","req4","0x001","기계식키보드",37000,10,370000,now());
	
	SELECT * FROM T_ORDER_LIST;


 -->
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
					<td><fmt:formatNumber value="${order.orderCount }"/>원 </td>
					<td><fmt:formatNumber value="${order.totalPrice }"/>원</td>
					<td><fmt:formatDate value="${order.orderDate }"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>