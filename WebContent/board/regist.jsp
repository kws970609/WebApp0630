<%@ page import="com.the.model.board.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! BoardDAO boardDAO = new BoardDAO(); %>
<!-- 아래와 같이 태그이되, 서버에서만 실행될 수 잇는 태그를 가리켜 빈즈 태그라 한다!! 

아래의 태그는 ReBoard reBoard = new ReBoard();
-->
<jsp:useBean id="board" class="com.the.model.board.Board"/>
<%request.setCharacterEncoding("utf-8"); %>
<!-- 아래의 태그는 VO를 생성한 후 setter로 파라미터를 넣는 작업과 같다 
 아래의 * 가 동작하려면 반드시, html 파라미터 명과 VO의 멤버변수명이 같아야한다!!
-->

<jsp:setProperty property="*" name="board"/>
<%
	//파라미터를 넘겨받아 오라클에 넣기
	int result = boardDAO.insert(board);

	System.out.println(result);
	
	//지정한 URL로 재접속을 시도하라!!
	//여기서 실행부가 응답을 하는것이 아니라, 톰캣에게 준비된 응답객체를
	//전달하면, 톰캣이 이 response객체를 이용하여 응답을 하게된다..
	//response.sendRedirect("/board/list.jsp");
	
	int x=5;
%>




























