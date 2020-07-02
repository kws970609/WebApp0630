<%@page import="com.the.model.board.BoardDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.the.model.board.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!BoardDAO boardDAO = new BoardDAO();
%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="reboard" class="com.the.model.board.Board"></jsp:useBean>
<jsp:setProperty property="*" name="reboard"/>
<jsp:getProperty property="team" name="reboard"/>
<jsp:getProperty property="rank" name="reboard"/>
<jsp:getProperty property="depth" name="reboard"/>
<%
//답변 등록(내가본 이후의 글들의 rank를 1씩 증가)
//update reboard set = rank+1
// where team = 내본팀 and rank > 내본rank
// insert into reboard(reboard_id, ~depth)
//values (~,내본팀team, 내본rank+1,내본 depth+1);
boardDAO.updateRank(reboard);

boardDAO.reply(reboard);

//추후 응답이 완료된후에, 클라이언트의 브라우저로 하여금 다시 재접속
//하라는 명령임..
response.sendRedirect("/board/list.jsp");

/*if(result!=0){
	out.print("<script>");
	out.print("alert('등록성공');");
	out.print("location.href='/reboard/list.jsp';");
	out.print("</script>");
}else{
	out.print("<script>");
	out.print("alert('등록실패');");
	out.print("history.back();");
	out.print("</script>");
}*/
%>





















