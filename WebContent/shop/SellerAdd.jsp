<%--
Copyright (c) 2020,大佬求带飞组
文件名称：SellerAdd.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现商家的添加

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
<title>添加商品</title>
</head>
<body>
	<head>
		<meta charset="UTF-8">
		<title></title>
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
			
			.top2{
        		width: 100%;
        		height: 80px;
        		background-image:url(img/head.jpg);
        	}
        	.Seller{
        		border: 1px solid black;
        		width: 900px;
        		height: 700px;
        		position:absolute;
        		top:130px;
        		left:210px;
        		background-color:white ;
        	}
     
        	.tjpicture{
        		width:100%;
        		height: 200px;
        		
        		border: 0px solid black;
        	}
        	.picture{
        		border: 1px solid black;
        		width: 140px;
        		height: 140px;
        		position: absolute;
        		top:20px;
        		left:300px;
        	}
        	.tj{
        		position: absolute;
        		top:135px;
        		left:440px;
        	}
        	.form-group{
        		height: 70px;
        	}
        	
		 </style>
		 
		 <script type="text/javascript">
/**
* 从 file 域获取 本地图片 url
*/
function getFileUrl(sourceId) {
var url;
if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
url = document.getElementById(sourceId).value;
} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
}
return url;
}

/**
* 将本地图片 显示到浏览器上
*/
function preImg(sourceId, targetId) {
var url = getFileUrl(sourceId);
var imgPre = document.getElementById(targetId);
imgPre.src = url;
}
</script> 
        <script>
        	function finalcheck(form){	
        		if(form.cname.value==''){
					alert('商品名称不能为空！');
					form.cname.focus();
					return false;
					}
        		if(form.cprice.value==''){
        			alert('商品价钱不能为空');
        			form.cprice.focus();
        			return false
        		}
        		if(form.cnumbers.value==''){
        			alert('数量不能为空');
        			form.cnubers.focus();
        			return false
        		}
        		if(form.cdiscribe.value==''){
        			alert('描述不能为空');
        			form.cdiscribe.focus();
        			return false
        		}
        		return true;
        	}
        </script>
	</head>
	<body style="background-color: ghostwhite ;">
		<iframe src="head.jsp" style="width:100%; height: 50px; display: block;" frameborder="0" scrolling="no"></iframe>
	    
	    <!--logo部分-->
	    <div class="top2"></div>
	    
	    <div class="Seller">
	    
	    <form class="form-horizontal" onSubmit="return finalcheck(this);"  action="../CommodityAdd"  method="post" enctype="multipart/form-data">		
	    		<!--图片信息-->
	    		<div class="tjpicture">
	    		<div class="picture" id="picture">
	    		<img id="imgPre" src="../upload/1519647149449.jpg" width="140px" height="140px" style="display: block;" />		    
	    		</div>
	    		<div class="tj">
	    			<input type="file" name="photo" id="photo" multiple="multiple" onchange="preImg(this.id,'imgPre');">
	    			 
	    			<script>
	    			
	    		
	    			
	    			</script>
	    		</div>
	    		</div>
	    		
	    		<!--文字信息-->
	    		<div class="form-group">
					<label  class="col-sm-2 control-label">商品名称：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  name="cname">
						</div>
					
	    		</div>
	    		
	    		
	    		<div class="form-group">
					<label  class="col-sm-2 control-label" >商品价钱：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  name="cprice">
						</div>
					
	    		</div>
	    		<div class="form-group">
					<label  class="col-sm-2 control-label" >商品类别：</label>					
       	&nbsp;&nbsp;&nbsp;<select style="width:280px;height:35px" name="type">
  								<option value ="book">书籍</option>
  								<option value ="clothes">衣服</option>
  								<option value="shoe">鞋</option>
  								<option value="bicyle">自行车</option>
  								<option value="electric">电器</option>
  								<option value="other">其它</option>
						  </select>
	    		</div>
	    		
	    		<div class="form-group" >
					<label  class="col-sm-2 control-label" >商品描述：</label>
						<div class="col-sm-8">
							<textarea class="form-control"  name="cdescribe" rows="5"  maxlength="200" onchange="this.value=this.value.substring(0, 200)" onkeydown="this.value=this.value.substring(0, 200)" onkeyup="this.value=this.value.substring(0, 200)" ></textarea>
						</div>
					
	    		</div>
	    		<div class="form-group">
	                 <input type="submit" value="提交"> 		
	    		</div>
	    	</form>
	    </div>

</body>
</html>