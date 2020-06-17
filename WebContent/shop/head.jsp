<%--
Copyright (c) 2020,大佬求带飞组
文件名称：admin.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现头部信息的展示

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"href="css/font-awesome.min.css"> 
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
        	.top1{
        		width: 100%;
        		height: 50px;
        		background-color: ;
        		position: relative;
        		border: 0px solid black;
        	}
        	.nav{
				display: flex;
				
			}
			.nav>li>a{
				color: white;
			}
        </style>
    </head>
    <body>
   
    	 <div class="top1">
	    	<div class="navbar navbar-fixed-top" style="background-color:#FFAD86;display: flex; align-items: center; ">
			<div class="hei">
				
				<ul class="nav">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li >
						<a href="login.html" target="_parent" class="active">登录</a>
					</li>
					<li>
						<a href="buyercenter.jsp" target="_parent" class="active">买家中心</a>
					</li>
					<li>
						<a href="Sellercenter.jsp" target="_parent" class="active">卖家中心</a>
					</li>
					<li>
						<a href="index.html" target="_parent" class="active">主页</a>
					</li>
					
				</ul>
				
		</div>	
		<div style="position: absolute; right: 50px;">
		<%
		 String onlinename=(String)session.getAttribute("bonlinename");
		 String selleronlinename=(String)session.getAttribute("selleronlinename");
		 if(onlinename==null&&selleronlinename==null){
			 out.print("游客");
		 }if(selleronlinename!=null){
			 out.print("卖家:"+selleronlinename);
		 }if(selleronlinename==null&&onlinename!=null){
			 out.print("买家:"+onlinename);
		 }
		%>
		</div>
	    </div>
 	</body>
</html>