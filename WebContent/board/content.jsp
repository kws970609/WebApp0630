<%@page import="com.the.model.board.BoardDAO"%>
<%@page import="com.the.model.board.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! BoardDAO boardDAO = new BoardDAO(); %>
<%
	int board_id = Integer.parseInt(request.getParameter("board_id"));
	Board board = boardDAO.select(board_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=button] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.reply {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	display: none;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
<script>
	$(function() {
		CKEDITOR.replace("content");
		
		//답변폼 슬라이드 토글 버튼
		$($("input[type='button']")[0]).click(function(){
			$($(".reply")[0]).slideToggle("slow");
		});
		
		//목록버튼
		$($("input[type='button']")[1]).click(function(){
			location.href="/board/reply.jsp";
		});
		
		//수정 버튼
		$($("input[type='button']")[2]).click(function(){
			$($("form")[0]).attr({
				"action":"/board/edit.jsp",
				"method":"post"
			});
			$($("form")[0]).submit();
		});
		//삭제 버튼
		$($("input[type='button']")[3]).click(function(){
			
		});
		
		$($("input[type='button']")[4]).click(function(){
			//서버에 답변글 등록 요청!!
			$($("form")[1]).attr({
				"method":"post",
				"action":"/board/reply.jsp"
			});
			$($("form")[1]).submit();
		});
		
	});
</script>
</head>
<body>

	<h3>상세보기</h3>

	<div class="container">
		<form>
			<input type="hidden" name="reboard_id" value="<%=board.getBoard_id()%>"/>
			<input type="text" id="title" name="title" value=<%=board.getTitle() %>> 
			<input type="text" id="writer" name="writer" value=<%=board.getWriter() %>>
			<textarea id="content" name="content" style="height: 200px"><%=board.getContent()%></textarea>
			<input type="button" value="답변">
			<input type="button" value="수정">
			<input type="button" value="삭제">
			<input type="button" value="목록">
		</form>
	</div>
	<div class="reply">
		<form>
			<input type="hidden" name="team" value="<%=board.getTeam()%>"/>
			<input type="hidden" name="rank" value="<%=board.getRank()%>"/>
			<input type="hidden" name="depth" value="<%=board.getDepth()%>"/>
			
			<input type="text" id="title" name="title" value=<%//=reboard.getTitle() %>> 
			<input type="text" id="writer" name="writer" value=<%//=reboard.getWriter() %>>
			<textarea id="content" name="content" style="height: 200px"><%//=reboard.getContent()%></textarea>
			<input type="button" value="답변등록">
		</form>
	</div>
</body>
</html>
























