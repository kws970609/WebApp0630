
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//서버측에 선택한 파라미터에 대한 결과 요청하기!!
//get : 얻어올때?변수=값 ,  /post: 전송목적
function send(){
	form1.action="/movie1/result.jsp";
	form1.submit();// 전송!!
}
</script>
</head>
<body>
	<form name="form1" method="post">
		<select name="movie">
			<option value="parasite">parasite</option>
			<option value="starwars">starwars</option>
			<option value="007">007</option>
		</select>
	</form>
	<button onclick="send()">전송</button>
	
</body>
</html>
























