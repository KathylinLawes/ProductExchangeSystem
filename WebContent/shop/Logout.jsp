<%--
Copyright (c) 2020,大佬求带飞组
文件名称：Logout.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现登出操作

当前版本：1.2
作者：杨之正
完成时间：2020.6.11

取代版本：1.1
原作者：杨之正
完成日期：2020.6.4
--%>

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