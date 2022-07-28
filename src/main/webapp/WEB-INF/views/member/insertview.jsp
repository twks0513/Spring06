<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function errorchk(){
		if(${error1 == 1}){
			location.href='error'
		}else{
			form.submit()
		}
	}
</script>
	<h1>InsertView.jsp</h1>
	<form id="form" action="insert" method="post">
	<table border="1">
		<tr>
			<th>아이디</th> <td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>이름</th> <td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" onclick="errorchk()">저장</button></td>
		</tr>
	</table>
	</form>
</body>
</html>