<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>pk :  ${one.pk }</p>
	<p>id : ${one.id }</p>
	<p>pw : ${one.pw }</p>
	<p>name : ${one.name }</p>
	<div>
		<button type="button" onclick="goDel(${one.pk })">삭제</button>
		<button type="button" onclick="goUpd(${one.pk })">수정</button>
	</div>
	
	<script>
		function goDel(pk){
			if(confirm(pk+"번 회원을 삭제하시겠습니까?")){
				location.href="/user/del?pk="+pk;
			}
		}
		
		function goUpd(pk){
			if(confirm(pk+"번 회원을 수정하시겠습니까?")){
				location.href="/user/upd?pk="+pk;
			}
		}

	</script>
	
	
</body>
</html>