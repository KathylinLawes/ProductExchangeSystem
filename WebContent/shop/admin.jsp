<%--
Copyright (c) 2020,大佬求带飞组
文件名称：admin.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现管理员信息的显示

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
        	.usertable{
        		border: 1px solid black;
        		width: 100%;
        		height: 520px;
        		display: flex;
        		justify-content: left;
        	}
        	.table-striped{
        		border: 1px solid black;
        		width: 75%;
        	}
        	
        	.top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	
        	.leftline{
        		width:20%;
        		birder:1px solid black;
        		background-color: white;
        	}
        	
        </style>
</head>
<body>
	<script>
	$.ajax({
		type:"post",
		url:"../AllUser",
		dataType:"json",
		async:false,
		contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
		success:function(result){
			
		}
	})
	</script>
	<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
    <div class="top2"></div>
	<div class="usertable">
	<div class="leftline">
		&nbsp;
		<button type="button" class="btn btn-primary btn-lg btn-block">管理用户信息</button>
		&nbsp;
		<button type="button" class="btn btn-primary btn-lg btn-block">管理商品信息</button>
		&nbsp;
	
	</div>
	<table class="table table-striped">
    <thead>
    <tr>
        <th>用户编号</th>
        <th>真实姓名</th>
        <th>网名</th>
        <th>所属院校</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>001</td>
        <td>Rammohan </td>
        <td>Reddy</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>002</td>
        <td>Smita</td>
        <td>Pallod</td>
        <td>A</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
        <td>003</td>
        <td>Rabindranath</td>
        <td>Sen</td>
        <td>A+</td>
    </tr>
    <tr>
       <td>上一页 </td>
       <td>下一页</td>
       <td></td>
       <td></td>
    </tr>
  
    </tbody>
   
</table> 

</body>
</html>