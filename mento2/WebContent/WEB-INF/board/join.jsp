<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form method="post" action="/board/join/page">
		<div>id:<input type="text" name="id"> </div>
		<div>pw:<input type="password"name="pw"> </div>
		<div>name:<input type="text" name="name"> </div>
		<div><input type="submit" value="가입"> </div>
	</form>
	
	<a href="/user/list">회원 리스트</a>
	<a href="https://www.naver.com/">네이버</a>
	
</body>
</html>