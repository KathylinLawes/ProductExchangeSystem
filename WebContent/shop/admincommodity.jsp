<%--
Copyright (c) 2020,大佬求带飞组
文件名称：admincommodity.jsp
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
        <script>
        function getJsonObjLength(jsonObj) {
            var Length = 0;
            for (var item in jsonObj) {
               Length++;
        	}
            return Length;
       }
        </script>
        <style>
        	.usertable{
        		border: 0px solid black;
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
		url:"../AllCommodity",
		dataType:"json",
		contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
		success:function(result){
			
			var count = getJsonObjLength(result);
			
			var str="";
			for(var i=0;i<count;i++){
				str+="<tr><td>"+result[i].cid+"</td><td>"+result[i].cname+"</td><td>"+result[i].price+"</td><td>"+result[i].id+"</td></tr>";
			}
		
			$("#slist").append(str);
		}
	})
	</script>
	<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
    <div class="top2"></div>
	<div class="usertable">
	<div class="leftline">
		&nbsp;
		<button type="button" class="btn btn-primary btn-lg btn-block">管理商品信息</button>
		&nbsp;
		
	
	</div>
	<table class="table table-striped">
    <thead>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>所属卖家</th>
    </tr>
    </thead>
    <tbody id="slist">
    </tbody>
   
</table> 
</div>

</body>
</html>