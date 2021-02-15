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
		contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
		success:function(result){
			
			var count = getJsonObjLength(result);
			
			var str="";
			for(var i=0;i<count;i++){
				str+="<tr><td>"+result[i].bid+"</td><td>"+result[i].realname+"</td><td>"+result[i].onlinename+"</td><td>"+result[i].school+"</td><td><input type='checkbox'></td></tr>";
			}
		
			$("#blist").append(str);
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
		
	
	</div>
	<table class="table table-striped">
    <thead>
    <tr>
        <th>用户编号</th>
        <th>真实姓名</th>
        <th>网名</th>
        <th>所属院校</th>
        <th> </th>
    </tr>
    </thead>
    <tbody id="blist">
    	
    
  
    </tbody>
   
</table> 
</div>

</body>
</html>