<%--
Copyright (c) 2020,大佬求带飞组
文件名称：commodity.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现商品的显示

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
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"href="css/font-awesome.min.css"> 
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
        	.navgation{
        		width: 100%;
        		height: 30px;
        		background-color: gainsboro;
        	}
        	.commodity{
        		border: 0px solid black;
        		width: 90%;
        		height: 500px;
        		position: absolute;
        		left: 35px;
        		top: 240px;
        	}
        	.sellerinformation{
        		border: 1px solid gainsboro;
        		position:absolute;
        		width: 1180px;
        		height: 70px;
        		left: 85px;
        	}
        	.sellerinformation1{
        		border-right: 1px solid gainsboro;
        		width: 200px;
        		height: 100%;
        		float:left;
        	}
        	
        	
        	.commoditypicture{
        		width: 60%;
        		height: 500px;
        		border: 0px solid black;
        		float: left;
        		display: flex;
        		justify-content:center; 
				align-items:center; 
        	}
        	.price{
        		
        		text-align: center;
        		line-height: 60px;
        		border: 0px solid black;
        		
        		width: 100px;
        		height: 65px;
        		font-size: 18px;
        		color: grey;
        		
        		
        		
        	}
        	.price2{
        		position: absolute;
        		left: 800px;
        		top:40px;
        		border: 0px solid black;
        		height: 65px;
        		width:200px;
        		text-align: center;
        		
        	}
        	
        	.picture{
        		width: 450px;
        		height: 450px;
        		border: 0px solid black;
        		align-items: center;
				justify-content: center;
        	}
        	.introuduce{
        		width: 40%;
        		height: 500px;
        		border: 1px solid gainsboro;
        		float:  left;
        	}
        	.information{
        		height: 400px;
        		width: 100%;
        		border-bottom: 0px solid gainsboro;
        	}
        	.list1{
        		height: 100px;
        		border-bottom: 1px solid gainsboro;
        	}
        	.list2{
        		border: 0px solid black;
        		position:absolute;
        		top:120px;
        	}
        	
        	.buy{
        		position: absolute;
        		top:380px;
        		left:880px;
        		width: 200px;
        		height: 140px;
        	}
        	
        	.share{
        		position: absolute;
        		top:430px;
        		left:880px;
        	}
        	
        	.top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	
        	.cname{
        		
        		width:500px;
        		height:20px;
        		border:0px solod black;
        	}
        	
        	.cdescribe{
        		border:0px solid black;
        		width:90%;
        		height:100%;
        		line-height:17px;
        	}
        	.sellerinformation1{
        		line-height:30px;
        		text-align:center;
        		font-size:16px;
        		font-weight:bold;
        		font-family:黑体;
        	}
        </style>
        <script>
		function usercheck(form){           //对是否登录进行检查
			//alert(form.buyerid.value);
			if(form.buyerid.value=='null'){
				alert('还未登录，请先登录！');
				return false;
				}
			alert("已添加");
			return true;
		}
	</script>
        
        
        
        <script>
        	$(document).ready(function(){                 //将商品编号，传到AddCar模块
        		$("#btn").click(function(){
 
        			$("#aForm").submit();
        			//alert("123");
        		})
        	});
        </script>
       
       
</head>
<body>
     <script type="text/javascript">  
	
	$(document).ready(function(){         //获取商品id，并用ajax将值传给servlet，servelet在数据库中检索，将获取的信息返回给ajax，ajax接收数据
		var cid;
		var url=window.location.search;
		//alert(url);
		if(url.indexOf("?")!=-1){   //取出商品cid
			var str=url.substr(1);
			//alert(str);
			cid=str.split("=")[1];
			
		}else{
			alert("页面无法正常加载");
		}
		
		$.ajax({
			type:"post",
			url:"../Commodity",
			data:{"cid":cid},
			dataType:"json",
			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
			success:function(result){
				var cnamestr="<strong><font size='5'>&nbsp;&nbsp;&nbsp;"+result[0].cname+"</font></strong>";
				$("#cname").html(cnamestr);
				var cpricestr="<font size='6' color='gray'>￥</font><font size='6' color='red'>"+result[0].price+"</font>";
				$("#price2").html(cpricestr);
				var picturestr="<img style='width: 450px; height: 450px;' src='../upload/"+result[0].picture+"'> ";
				$("#picture").html(picturestr);
				var cdescribestr=result[0].describe;
				$("#cdescribe").html(cdescribestr);
				var schoolstr=result[0].sschool;
				$("#school").html(schoolstr);
				var onlinenamestr="卖家:"+result[0].sonlinename;
				$("#sellerinformation1").html(onlinenamestr);
				var rankstr="<br />等级:"+result[0].srank;
				$("#sellerinformation1").append(rankstr);
			}			
		}); 
	})

	</script>
	
	
	
	
<iframe src="head.jsp" style="width:100%; height: 50px; display: block;"frameborder="0" scrolling="no"></iframe>
	<div class="top2"></div>
	
	<div class="navgation">
   			 商品种类
		</div>
		
		<div class="sellerinformation">
			<div class="sellerinformation1" id="sellerinformation1"></div>
			
			
		</div>
		
		<form method="post" id="aForm" onSubmit="return usercheck(this);" action="../AddCar">
		
		<div class="commodity">
			<div class="commoditypicture">
				<div class="picture" id="picture"></div>
			</div>
			<div class="introuduce">
				
					<div class="information">
						<div class="list1">
							 <div class="cname" id="cname"></div>
							<div class="price2" id="price2">
								
								
							</div>
						</div>
						<div class="list2">
							<table border="0" style="width: 490px; height: 260px; text-align: left;">
								<tr valign="top">
									<td style="width: 8%;"></td>
									<td style="width: 15%;">成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色:</td>
									<td style="width: 3%;"></td>
									<td>非全新</td>
								</tr>
								<tr valign="top">
									<td></td>
									<td>所在院校:</td>
									<td></td>
									<td><div class="school" id="school"></div></td>
									
								</tr>
								<tr valign="top">
									<td></td>
									<td>交易方式:</td>
									<td></td>
									<td>非全新</td>
									
								</tr>
								<tr valign="top">
									<td></td>
									<td>联系方式:</td>
									<td></td>
									<td>电话</td>
									
								</tr>
								<tr valign="top"><!-- 存放商品id信息，便于传值 -->
									<td><input type="hidden" name="commodityid" value="<%out.print(request.getParameter("cid")); %>"></td>
									
									<td>商品描述:</td>
									<td><input type="hidden" name="buyerid" id="buyerid" value="<%out.print(session.getAttribute("bid"));%>"></td>
									<td  height="100px"><div class="cdescribe" id="cdescribe"></div></td>
								</tr>
							</table>
						</div>
						<div class="buy">
							<button type="button" id="btn" class="btn btn-primary btn-lg btn-block" >加入购物车</button>
							
						</div>
					
						
						<div class="share">
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="img/conf/share.png" style="width:40px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="img/conf/agree.png" style="width:40px">
						</div>
					</div>
					
			</div>
		</div>
		
		</form>
	
     
</body>
</html>