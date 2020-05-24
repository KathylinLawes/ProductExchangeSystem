<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
          .top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	.orders{
        		border:3px solid grey;
        		width: 905px;
        		height: 600px;
        		position: absolute;
        		left:230px;
        	}
        	.table-striped{
        		border: 0px solid black;
        		width: 900px;
        	}
        	
        
        	th{
        		border-right: 1px solid gainsboro;
        		text-align: center;
        	}
        	td{
        		border-right: 1px solid gainsboro;
        	}
        </style>
</head>
<body>
<script>
var id="<%=session.getAttribute("id")%>"; 

$.ajax({
	type:"post",
	url:"../SellerOrders",
	data:{"id":id},
	dataType:"json",
	contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
	success:function(result){
			
			var count = getJsonObjLength(result);
			var str="";
			for(var i=0;i<count;i++){
				str+="<tr><td>"+result[i].cid+"</td><td>"+result[i].cname+"</td><td>"+result[i].bonlinename+"</td><td>"+result[i].stel+"</td><td>"+result[i].sschool+"</td><td>"+result[i].picture+"</td></tr>";
			}
			$("#list1").append(str);
		}
	})
</script>


<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
<div class="top2"></div>
<div class="orders">
    		<table class="table table-striped">
    			<thead>
   					<tr>
   						<th width="60px" >商品编号</th>
   						<th width="120px" >商品名称</th>
        			  	<th width="100px" >买家</th>
       				 	<th width="120px" >买家电话</th>
        				<th width="100px" >买家院校</th>
        				<th width="200px">买家收件地址</th>
   					 </tr>
    			</thead>
    			<tbody id="list1">
    				
    			</tbody>	
    		</table>
    	</div>

</body>
</html>