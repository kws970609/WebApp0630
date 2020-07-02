<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
/*
재사용 가능한 코드를 객체로 분리시켜, 유지보수성을 높인 개발방식을
javaEE분야에서는 model1 방식 이라 한다!!

장점: 코드의 재사용성이 높아진다
단점: 디자인 코드 (View)에 디자인 외에 자바 코드가 남아있다....
	이 경우, 디자인을 버린다면?

	
	우리의 최종 목표 MVC인데, 현재의 모델1방식에서는 디자인페이지와 컨트롤러 역할의 코드가 합쳐져있는 상태..
	Model : 로직, 데이터
	View : 디자인
	Controller : 디자인과 로직을 분리시켜주는 역할의 객체
	
	
						
	javaEE 분야에서 MVC패턴을 적용한 개발패턴을 가리켜 '모델2' 방식이라 한다!!
	
	MVC 패턴이란?
	-재사용성과 유지보수성을 높이기위해 
	 디자인과 로직을 완전히 분리시키는 개발 패턴
	 전산 분야에서 잘 알려진 개발 방법(선배들의 경험이 녹아든 패턴)
	 
	 Model2 패턴?
	 -MVC 개발 이론을 자바의 기술로 반영한 개발패턴을 의미
	 
	 Model : .pojo(Plain Old Java Object: 플랫폼에 중립적인 순수한 자바)
	 View : .jsp ()
	 Controller: .java(서블릿)
	
*/
	String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	<%=msg%>
</body>
</html>






























