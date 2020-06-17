<%--
Copyright (c) 2020,大佬求带飞组
文件名称：order.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是购买界面的显示

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
<title>下单界面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"href="css/font-awesome.min.css"> 
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
     <style>
          .top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	.main{
        		position: absolute;
        		left: 350px;
        		border: 1px solid gray;
        		 width: 600px;
        		height: 780px;
        		background-color: ghostwhite;
        	}
        	.pictureline{
        		border: 0px solid black;
        		width: 100%;
        		height: 140px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        	}
        	.cinformation{
        		border: 0px solid black;
        		height: 560px;
        		width: 100%;
        		display: flex;
        	}
        	.picture{
        		border: 1px solid black;
        		width:130px ;
        		height: 130px;	
        	}
        	.leftline{
        		border: 0px solid black;
        		width: 25%;
        		height:550px;
        	}
        	.rightline{
        		border: 0px solid black;
        		width: 75%;
        		height:560px ;
        	}
        	.cname{
        		border: 0px solid black;
        		width: 300px;
        		height: 60px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        		font-size: 18px;
        	}
        	.cprice{
        		border: 0px solid black;
        		width: 300px;
        		height: 50px;
        		color: red;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        		font-size: 18px;
        	}
        	.cdescribe{
        		border: 0px solid black;
        		width: 420px;
        		height: 85px;
        		display: flex;
        		align-items: center;
        		
        		
        	}
        	.seller{
        		border: 0px solid black;
        		width: 300px;
        		height: 50px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        		font-size: 18px;
        	}
        	.sschool{
        		border: 0px solid black;
        		width: 300px;
        		height: 70px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        		font-size: 18px;
        	}
        	.buyer{
        		border: 0px solid black;
        		width: 300px;
        		height: 60px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        		font-size: 18px;
        	}
        	.btel{
        		border: 0px solid black;
        		width: 300px;
        		height: 60px;
        		display: flex;
        		align-items: center;
        		
        	}
        	.address{
        		border: 0px solid black;
        		width: 520px;
        		height: 120px;
        		display: flex;
        		align-items: center;
        	}
        	.submitbottom{
        		border: 0px solid black;
        		width: 100%;
        		height: 80px;
        		display: flex;
        		align-items: center;
        		justify-content: center;
        	}
        	
     </style>
     <script>
     	function usercheck(form){           //对是否登录进行检查
			//alert(form.buyerid.value);
			
			alert("下单成功");
			return true;
		}

     </script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){         //获取商品id，并用ajax将值传给servlet，servelet在数据库中检索，将获取的信息返回给ajax，ajax接收数据
	var carid;
	var url=window.location.search;
	//alert(url);
	if(url.indexOf("?")!=-1){   //取出商品cid
		var str=url.substr(1);
		
		carid=str.split("=")[1];
		//alert(carid);
		
	}else{
		alert("页面无法正常加载");
	}
	
	$.ajax({
		type:"post",
		url:"../orderadd",
		data:{"carid":carid},
		dataType:"json",
		contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
		success:function(result){
			var addpicture="<img width='130px' height='130px' src='../upload/"+result[0].picture+"'>";
			$("#picture").html(addpicture);	
			var addcname=result[0].cname;
			$("#cname").html(addcname);
			
			var addprice=result[0].price+"￥";
			$("#cprice").html(addprice);
			var addcdescribe=result[0].describe;
			$("#cdescribe").html(addcdescribe);
			var sonlinename=result[0].sonlinename;
			$("#seller").html(sonlinename);
			var sschool=result[0].sschool;
			$("#sschool").html(sschool);
			var bonlinename=result[0].bonlinename;
			$("#buyer").html(bonlinename);
			
			var cid=result[0].cid;
			document.getElementById("cid").value=cid;
			var id=result[0].sid;
			document.getElementById("sid").value=id;
			var stel=result[0].stel;
			document.getElementById("stel").value=stel;
			var bid=result[0].bid;
			document.getElementById("ssschool").value=sschool;
		}	
	}); 
	
	
})

</script>
<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
<div class="top2"></div>
	<div class="main">
    		<div class="pictureline">
    			<div class="picture" id="picture"></div>
    		</div>
    		<form method="post" onSubmit="return usercheck(this);" action="../Recording">
    		<div class="cinformation">
    			<div class="leftline">
    				<table style="width: 130px; height: 500px; color: gray " border="0" >
    					<tr>
    						<td align="right">商品名称:<input type="hidden" name="cid" id="cid"></td>
    						
    					</tr>
    					<tr>
    						<td align="right">价格:</td>
    					</tr>
    					<tr>
    						<td align="right">描述:</td>
    					</tr>
    					<tr>
    						<td align="right">卖家:<input type="hidden" name="sid" id="sid"><input type="hidden" name="stel" id="stel"><input type="hidden" name="ssschool" id="ssschool"></td>
    					</tr>
    					<tr>
    						<td align="right">卖家所属院校:</td>
    					</tr>
    					<tr>
    						<td align="right">买家:</td>
    					</tr>
    					<tr>
    						<td align="right">买家联系方式:</td>
    					</tr>
    					<tr>
    						<td align="right">买家收货地址:</td>
    					</tr>
    				</table>
    			</div>
    			<div class="rightline">
    				<div class="cname" id="cname"></div>
    				<div class="cprice" id="cprice"></div>
    				<div class="cdescribe" id="cdescribe"></div>
    				<div class="seller" id="seller"></div>
    				<div class="sschool" id="sschool"></div>
    				<div class="buyer" id="buyer"></div>
    				<div class="btel" id="btel"><input  name="btel" type="text" style="width: 200px; height: 25px;"></div>
    				<div class="address" id="address"><textarea cols="50" name="baddress"  rows="6"></textarea></div>
    			</div>	
    		</div>
    		<div class="submitbottom">
    			<button type='submit' class='btn btn-danger' style='width:80px'>提交订单</button>
    		</div>
    		</form>
    	</div> 
</body>
</html>