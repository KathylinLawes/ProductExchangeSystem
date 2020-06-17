<%--
Copyright (c) 2020,大佬求带飞组
文件名称：Seller.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是实现卖家的信息显示

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
<link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"href="css/font-awesome.min.css"> 
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style type="text/css">
        	.picture{
				width:120px;
				height: 150px;
				
				margin-top:8px;
				margin-right:3px ;
				border: 0px solid black;
				float: left;
				margin-left: 8px;
			}
			.thumbnail{
				height:150px;
			}
        	
        .all{
        	border:0px solid black;
        	width:100%;
        	height:612px;
        	min-width:1200px;
        }
        .online{
        	border:5px solid dodgerblue;
        	border-radius: 20px;
        	width:540px;
        	height: 350px;
        	float: left;
        	position:absolute;
        	left:60px;
        }
        .downline{
        	border:5px solid dodgerblue;
        	border-radius: 20px;
        	width:580px;
        	height: 350px;
        	float:left;
        	position:absolute;
        	left:750px;
        }
        .tab-left{
        	float:left;
        	width:50px;
        	height: 350px;
        }
      
        .transfer{
        	border: 0px solid black;
        	float: left;
        	width: 140px;
        	height: 350px;
        	line-height: 300px;
        	text-align: center;
        	position:absolute;
        	left:600px;
        }
       
        .check{
        	
        	text-align: center;
        }
        .header{
        border: 1px solid black;
        	width: 100%;
        	height: 100px;
        }
        
        .co{
        	position: absolute;
        	top:150px;
        	border: 0px solid black;
        	width: 100%;
        	
        	height: 450px;
        }
        
        .transferbutton_on{
        	border: 0px solid blue;
        	width: 38%;
        	height: 80px;
        	position:absolute;
        	bottom:0px;
        	left: 65px;
        	text-align: center;
        }
        
         .transferbutton_down{
        	border: 0px solid blue;
        	width: 40%;
        	height: 80px;
        	position:absolute;
        	bottom:0px;
        	left: 750px;
        	text-align: center;
        }
        
        .panel-body{
        	font-size:16px;
        	color:blue;
        	font-weight:bold;
        }
        
        
        
        </style>
        <script>
        function getJsonObjLength(jsonObj) {          //获取商品对象的个数
            var Length = 0;
            for (var item in jsonObj) {
               Length++;
        	}
            return Length;
        }
        </script>
        
        
        
        
        <script>
        window.onload = function(){            //下一页
            $("#next").click(function(){  
            	
                var page=$("#page").val();
                var page1=parseInt(page);
                page1+=1;
                $("#page").val(page1);
                commodity();
            });  
 				
        	$("#previous").click(function(){   //上一页
                var page=$("#page").val();
                var page1=parseInt(page);
                page1=page1-1;
                $("#page").val(page1);
                commodity();
            });  
        	
        	$("#commoditydown").click(function(){
       			 obj = document.getElementsByName("down");
       			    check_val = [];
       			    for(k in obj){
       			        if(obj[k].checked)
       			            check_val.push(obj[k].value);
       			    }
       			   // alert(check_val);
       			   var jsonString=JSON.stringify(check_val);
       			 $.ajax({
          			type:"post",
          			url:"../CommodityDown",
          			data: {data:jsonString},
          			dataType:"json",
          			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
          			success:function(result){
          				
       			    commodity();
       			    downcommodity();
       			 } 
       			
  			
        	});
        	});		 
        	
        	
        	$("#commodityOn").click(function(){         //获取check选中的商品
       			 obj = document.getElementsByName("on");
       			    check_val = [];
       			    for(k in obj){
       			        if(obj[k].checked)
       			            check_val.push(obj[k].value);
       			    }
       			   // alert(check_val);
       			   var jsonString=JSON.stringify(check_val);
       			 $.ajax({
          			type:"post",
          			url:"../CommodityOn",
          			data: {data:jsonString},
          			dataType:"json",
          			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
          			success:function(result){
          			  commodity();
         			   downcommodity();
          				
          			}
       			    
       			 });  
       			
  				
        	});
           
        }  
        </script>
        
      
        
       <script>          //该函数负责展示上架商品
        function commodity(){
        	
        	var currentpage;
     	   var id=<%=session.getAttribute("sellerid")%>  //获取卖家id
     	   
     	  var input=$("#page").val();     //获取输入框的值,如果是空，设为1，并将当前页设为1。如果非空，将当前页设为输入框的页数
     	  
     	   if(input==""||input<=0){
     		  $("#page").val("1");
     		  currentpage=1;
     	   }else{
     		   currentpage=input;
    	   }
     	  
     		$.ajax({
     			type:"post",
     			url:"../Commoditymanage",
     			data:{"id":id},
     			dataType:"json",
     			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
     			success:function(result){
     				//alert("成功");
     				var count = getJsonObjLength(result);
     				var panelstr="您共有"+count+"件上架商品";
     				$("#panel-body").html(panelstr);
     				//对超页进行处理
     				var sumpage1=count/8;
     				var sumpage=parseInt(sumpage1)+1;
     				if(currentpage>sumpage){
     					currentpage=sumpage;
     					 $("#page").val(sumpage);
     				}
     				
     				//此处开始循环遍历商品	
     				var begin=(currentpage-1)*8;
     				var end=begin+8;
     				if(end>count){
     					end=count;     //对于商品超量进行处理
     				}
     				var str="";
     				
     				for(begin;begin<end;begin++){
     					str+="<div class='picture'><div class='thumbnail'><img src='../upload/"+result[begin].picture+"' alt='...' class='img-responsive' style='width: 100px;height:100px'><div class='caption'><div class='check'>"+result[begin].cname+" <input type='checkbox' name='down' value='"+result[begin].cid+"'></div></div></div></div>";	
     				}
     				
     				$("#online").html(str);
     				
     			}			
     		}); 
     	
     	 }
        </script>
        
        <script>          //该函数负责展示下架商品
        function downcommodity(){
        	
        	var currentpage;
     	   var id=<%=session.getAttribute("sellerid")%>  //获取卖家id
     	  var input=$("#downpage").val();     //获取输入框的值,如果是空，设为1，并将当前页设为1。如果非空，将当前页设为输入框的页数
     	  
     	   if(input==""||input<=0){
     		  $("#downpage").val("1");
     		  currentpage=1;
     	   }else{
     		   currentpage=input;
    	   }
     	  
     		$.ajax({
     			type:"post",
     			url:"../downCommoditymanage",
     			data:{"id":id},
     			dataType:"json",
     			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
     			success:function(result){
     				var count = getJsonObjLength(result);
     				//var panelstr="您共有"+count+"件商品";
     			//	$("#panel-body").html(panelstr);
     				//对超页进行处理
     				var sumpage1=count/8;
     				var sumpage=parseInt(sumpage1)+1;
     				if(currentpage>sumpage){
     					currentpage=sumpage;
     					 $("#downpage").val(sumpage);
     				}
     				
     				//此处开始循环遍历商品	
     				var begin=(currentpage-1)*8;
     				var end=begin+8;
     				if(end>count){
     					end=count;     //对于商品超量进行处理
     				}
     				var str="";
     				
     				for(begin;begin<end;begin++){
     					str+="<div class='picture'><div class='thumbnail'><img src='../upload/"+result[begin].picture+"' alt='...' class='img-responsive' style='width: 100px;height:100px'><div class='caption'><div class='check'>"+result[begin].cname+" <input type='checkbox' name='on' value='"+result[begin].cid+"'></div></div></div></div>";	
     				}
     				
     				$("#downline").html(str);
     				
     			}			
     		}); 
     	
     	 }
        </script>
        
        
        
       
</head>
<body>


	 <iframe src="head.jsp" style="width:100%; height: 50px; display: block;" frameborder="0" scrolling="no"></iframe>
	 <div class="all">
	<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"></h3>
    </div>
    <div class="panel-body" id="panel-body">
        
    </div>
</div>


	 
	 	<div class="co">
	 	
	 	<div class="online" id="online">   
			<!-- 上架商品框展示 -->
	 	</div>
	 	<div class="transfer">
	 		<img src="img/transfer.jpg" width="100px" height="100px">
	 	</div>
	 	
	 	
	 	<div class="downline" id="downline"></div>
	 	
	 	<div class="transferbutton_on">
	 		<input type="hidden" id="page" name="page" onBlur="commodity()">
	 		<button type="button" class="btn btn-info" id="previous">上一页</button>
	 		<button type="button" class="btn btn-danger" id="commoditydown">下架</button>
	 		<button type="button" class="btn btn-danger" >删除</button>
	 		<button type="button" class="btn btn-info" id="next">下一页</button>
	 	</div>
	 	<div class="transferbutton_down">
	 		<input type="hidden" id="downpage" name="downpage" onBlur="downcommodity()">
	 		<button type="button" class="btn btn-info" >上一页</button>
	 		<button type="button" class="btn btn-danger" id="commodityOn">上架</button>
	 		<button type="button" class="btn btn-danger" >删除</button>
	 		<button type="button" class="btn btn-info" >下一页</button>
	 		
	 	</div>
	 	
	 	
	 	</div>
	 	
	 	
	 	
	 	
	 </div>
	 
	 
	  <script type="text/javascript">  
	    commodity();
	    downcommodity();
	  </script>
</body>
</html>