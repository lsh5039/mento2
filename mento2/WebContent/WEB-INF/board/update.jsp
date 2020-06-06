<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>정보수정</h2>
	<form method="post" action="/user/upd">
		<div><input type="hidden" name="pk" value="${one.pk }" ></div>
		<div>id:<input type="text" name="id" value="${one.id }"> </div>
		<div>pw:<input type="password" name="pw" value="${one.pw }"> </div>
		<div>name:<input type="text" name="name" value="${one.name }"> </div>
		<div><input type="submit" value="변경"> </div>
	</form>
	
	<a href="/user/list">회원 리스트</a>
	<a href="https://www.naver.com/">네이버</a>
</body>
</html>