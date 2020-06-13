<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!-- 购物车模块 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
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
        	.main{
        		position:absolute;
        		left:230px;
        		border:0px solid black;
        		width: 900px;
        		height: 840px;
        	}
        	.commodity{
        		border: 1px solid gainsboro;
        		height: 120px;
        		width: 100%;
        		display: flex;
        	}
        	.picture{
        		border:1px solid gainsboro;
        		width:15%;
        		
        	}
        	.centerinformation{
        		border:0px solid gainsboro;
        		display:flex;
        		
        		width: 65%;
        	}
        	.rightinformation{
        		border:0px solid gainsboro;
        		width: 25%;
        		display:flex;
        		align-items:center;
        		justify-content:center;
        		
        	}
        	.name{
        		border:0px solid gainsboro;
        		height: 40px;
        		width: 25%;
        		font-weight:bold;
        		display:flex;
        		align-items:center;
        		
        	}
        	.describe{
        		border-left: 1px solid gainsboro;
        		border-right: 1px solid gainsboro;
        		height: 118px;
        		width: 50%;
        		display:flex;
        		align-items:center;
        		justify-content:center;
        	}
        	.price{
        		border:0px solid gainsboro;
        		height:90px;
        		width: 25%;
        		display:flex;
        		align-items:center;
        		justify-content:center;
        		font-size:20px;
        		color:red;
        	}
        	.top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	.shoppingcar{
        		width:100%;
        		height:65px;
        		border-bottom:3px solid gainsboro;
        		background-image:url(img/carlogo.jpg);
        	}
        </style>
</head>
<body>



<script type="text/javascript">



	$(document).ready(function(){
		$.ajax({
			type:"post",
			url:"../Shopping",
			dataType:"json",
			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
			success:function(result){
				var count;
				count=getJsonObjLength(result)   //getJsonObjLength是自己封装的函数
			//	alert(count);				
				var commoditylist="";
				var sum=0;
				
				for(var i=0;i<count;i++){
					sum+=result[i].price;	
					commoditylist+="<div class='commodity'><div class='picture'><img src='../upload/"+result[i].picture+"' width='120px' height='115px'></div><div class='centerinformation'><div class='name'>"+result[i].cname+"</div><div class='describe'>"+result[i].describe+"</div><div class='price'>"+result[i].price+"￥</div></div><div class='rightinformation'><a href='order.jsp?carid="+result[i].carid+"'><button type='button' class='btn btn-danger' style='width:80px'>购买</button></a></div></div>";
				}
				$("#main").html(commoditylist);
			}			
		}); 
	})

	</script>
	<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
    	<div class="top2"></div>
    	<div class="shoppingcar"></div>
      	<div class="main" id="main">
    <!-- 		<div class="commodity">
    			<div class="picture"><img src="../upload/1519714708538.jpg" width="120px" height="115px"></div>
    			<div class="centerinformation">
    				<div class="name">六级英语</div>
    				<div class="describe">六级英语阅读，考研必备</div>
    				<div class="price">1200￥</div>
    			</div>
    			<div class="rightinformation"><button type="button" class="btn btn-danger">购买</button></div>
    		</div>
   		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		<div class="commodity">
    			<div class="picture"></div>
    			<div class="centerinformation">
    				<div class="name"></div>
    				<div class="describe"></div>
    			</div>
    			<div class="rightinformation"></div>
    		</div>
    		-->
    	</div>
</body>
</html>