<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz 01 - core</title>
</head>
<body>
	<h1>1. JSTL core 변수</h1>
	<c:set var="number1" value="36"/>
	<c:set var="number2" value="3"/>
	<h2>첫번째 숫자 : ${number1} </h2>
	<h2>두번째 숫자 : ${number2} </h2>
	<h1>2. JSTL core 연산</h1>
	<h2>더하기 : ${number1 + number2}</h2>
	<h2>빼기 : ${number1 - number2}</h2>
	<h2>곱하기 : ${number1 * number2}</h2>
	<h2>나누기 : ${number1 / number2}</h2>
	<h1>3. JSTL core out</h1>
	<h3><c:out value="<title>core out</title>" /></h3>
	<h1>4. JSTL core if</h1>
	<c:if test="${number1 + number2 / 2 > 10}">
		<h1>${(number1 + number2) /2}</h1>
	</c:if>
	
	<c:if test="${number1 + number2 / 2 < 10}">
		<h3>${(number1 + number2) /2}</h3>
	</c:if>
	<c:if test="${number1 * number2 > 100}">
		<c:out value="<script>alert('너무 큰수입니다.');</script>" escapeXml="false"/>
	</c:if>
</body>
</html>