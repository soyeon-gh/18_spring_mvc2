<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<!-- 


	CREATE DATABASE SPRING_MVC2_EX;
	
	USE SPRING_MVC2_EX;
	
	CREATE TABLE T_MEMBER(
		ID VARCHAR(30),
		PW VARCHAR(30),
		NAME VARCHAR(30),
		GENDER VARCHAR(5),
		BIRTH_Y VARCHAR(5),
		BIRTH_M VARCHAR(5),
		BIRTH_D VARCHAR(5),
		BIRTH_GN VARCHAR(5),
		HP1 VARCHAR(5),
		HP2 VARCHAR(5),
		HP3 VARCHAR(5),
		SMSSTS_YN VARCHAR(2),
		EMAIL VARCHAR(30),
		EMAILSTS_YN VARCHAR(2)
	);
	
	INSERT INTO T_MEMBER VALUES("user1","1234","사용자1","101","2000","01","01","2","010","1234","5678","Y","user1@gmail.com","Y");
	INSERT INTO T_MEMBER VALUES("user2","1234","사용자2","102","2020","12","31","1","010","2345","6789","Y","user2@gmail.com","Y");
	
	SELECT * FROM T_MEMBER;


 -->
</head>
<body>
	<div align="center" style="margin-top: 100px">
		<form action="transfer1" method="post">  <!-- 2,3,4,5로 변환하여 확인 -->
		<h3>회원가입</h3>
		<table border="1" style="width:700px">
			<colgroup>
				<col width="20%" >
				<col width="80%">
			</colgroup>
			<tr>
				<td align="center">
					아이디
				</td>
				<td>
		            <input type="text" name="id" placeholder="아이디를 입력하세요." />	       
		        </td>
		    </tr>
	        <tr>
		        <td align="center">
		        	비밀번호
		        </td>
		        <td>
		        	<input name="pw" type="password" placeholder="비밀번호를 입력하세요." />
		        </td>
	        </tr>       
	        <tr>
		        <td align="center">
		        	이름
		        </td>
		        <td>
		        	<input type="text" name="name"  placeholder="이름을 입력하세요." />
		        </td>
	        </tr>                
		    <tr>
		        <td align="center">
		        	성별
		        </td>
		        <td>
		        	<input type="radio"  name="gender" value="101" checked /> 남성&emsp;&emsp;&emsp;
					<input type="radio"  name="gender" value="102" /> 여성
		        </td>
	        </tr>                              
	        <tr>
		        <td align="center">
		        	생년월일
		        </td>
		        <td>
	                <select name="birthY" >
						<c:forEach var="year" begin="1" end="100">
							<option value="${1921+year}">${ 1921+year}</option>
						</c:forEach>
						</select> 년 
						<select name="birthM" >
						  <c:forEach var="month" begin="1" end="12">
							  <option value="${month}">${month}</option>
						  </c:forEach>
						</select> 월  
						<select name="birthD" >
						<c:forEach var="day" begin="1" end="31">
							<option value="${day}">${day}</option>
						</c:forEach>
					</select> 일 &nbsp;
					<input type="radio"  name="birthGn" value="2" checked /> 양력
					<input type="radio"  name="birthGn" value="1" /> 음력
		        </td>
	        </tr>                                            
	        <tr>
		        <td align="center">
		        	핸드폰 번호
		        </td>
		        <td>
		        	<select name="hp1" >
						<option>없음</option>
						<option selected value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select> - 
					<input size="10px"  type="text" name="hp2" > - 
					<input size="10px"  type="text"name="hp3">
					<input  type="checkbox" name="smsstsYn"  value="Y" checked/> SMS 소식동의
		        </td>
	        </tr>                         
	        <tr>
		        <td align="center">
		        	이메일
		        </td>
		        <td>
		        	<input type="email"  name="email" > 
					<input type="checkbox" name="emailstsYn"  value="Y" checked/> E-mail 수신동의
		        </td>
	        </tr>                                                         
	        <tr>
		        <td colspan="2" align="center">
		        	<input type="submit" value="회원가입" >
		        </td>
		    </tr>                           
	     </table>
	     </form>
     </div>
</body>
</html>