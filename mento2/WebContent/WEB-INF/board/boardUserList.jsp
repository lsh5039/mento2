<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>

<style>
	table,tr,td,th{border:1px solid #333; border-collapse:collapse; cursor:pointer; text-align:center;}
	tr:hover{background-color:#f4f4f4;}


</style>

</head>

<body>
	<h2>가입한 회원 리스트</h2>
	<table>
		<tr>
			<th>회원no</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		
		<c:forEach var="vo" items="${list}">
			<tr onclick="goDetail(${vo.pk})">
				<td>${vo.pk }</td>
				<td>${vo.id }</td>
				<td>${vo.pw }</td>
				<td>${vo.name }</td>
			</tr>
		</c:forEach>
		

		
	</table>
	<a href="/board/join/page">회원등록</a>
	<script>
		function goDetail(pk){
			location.href="/detail?pk="+pk;//java script가 제공하는 get방식
		}
	
	
	</script>
	
</body>
</html>