<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 String bid=(String)session.getAttribute("bid");
	 String bonlinename=(String)session.getAttribute("bonlinename");
	 
	 String selleronlinename=(String)session.getAttribute("selleronlinename");
	 String sellerid=(String)session.getAttribute("sellerid");
	 session.setAttribute("selleronlinename",null);
	 session.setAttribute("bonlinename",null);
	 session.setAttribute("bid",null);
	 session.setAttribute("sellerid",null);

	%>
	<script type="text/javascript">
		alert("注销成功");
	</script>
	<%
	response.sendRedirect("index.html");
	%>
	
</body>
</html>