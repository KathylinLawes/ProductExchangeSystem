<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>   
<%@ page import="com.nwpu.bean.commodity" %>   
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
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
			.show{
				position: absolute;
				left:50px;
				border: 0px solid black;
				width:1100px;
        		height: 500px;	
			}
			
			.allpage{
				position:absolute;	
				width:900px;
				height:80px;
			    bottom:-120px;
				border:0px solid black;
			}
			.container{
				border: 0px solid black;
				margin: 0;
				
			}
			
			.picture{
				width: 180px;
				height: 250px;
				margin: left 3px;
				margin-top:8px;
				margin-right:3px ;
				border: 0px solid black;
				float: left;
				
			}
			.thumbnail{
				height:250px;
			}
			
			.row{
				
				width:1100px;
        		height: 500px;
			}
			.page{
				width:40px;
				height:40px;
				background-color:white;
				border:1px solid gainsboro;
				text-align:center;
				line-height:35px;
				float:left;
			}
		</style>
	</head>
	<body>
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		var nowpage=1;
		var url=window.location.search;
		//alert(url);
		if(url.indexOf("?")!=-1){   //若已经选择了页数，则用字符串取出页数
			var str=url.substr(1);
			//alert(str);
			nowpage=str.split("=")[1];
			//alert(nowpage);
		}else{
			nowpage=1;               //若未选择页数，将页数默认为第一页
		}
		
		$.ajax({
			type:"post",
			url:"../AllCommodity",
			dataType:"json",
			async:false,
			contenttype :"application/x-www-form-urlencoded;charset=utf-8", 
			success:function(result){
				//alert(result);
				var str="";
				//alert(result[2].picture);
			    var count = getJsonObjLength(result);
			   
			    var page=count/12;
			    var pagediv="";
			    var begin=(nowpage-1)*12;
			    var end=begin+12;
			    if(end>count)end=count;
			    for(var i=0;i<page;i++){
			    	pagediv+="<a href=display.jsp?page="+(i+1)+" ><div class='page'>"+(i+1)+"</div></a>";
			    }
				
				for(begin;begin<end;begin++){
					str+="<a href=commodity.jsp?cid="+result[begin].cid+" target='_parent'><div class='picture'><div class='thumbnail'><img src='../upload/"+result[begin].picture+"' alt='...'class='img-responsive' style='width: 140px;height:140px'><div class='caption'><h4>"+result[begin].cname+"</h4><p style='color:red;font-size:25px'>￥"+result[begin].price+"</p></div></div></div>";
					
				}
				//alert(pagediv);
				$("#allpage").html(pagediv);
				$("#row").append(str);
			}			
		}); 
	})
	
	
	
	

	
	</script>
	
	

	<div class="show">
		<div class="container">  <!-- 开加一个container的目的是为了让整体布局居中 -->
<!-- 开始 -->
			<div class="row" id="row"><!-- 将要加入的略缩图放入row中 -->
<!-- 第一张略缩图开始-->
				
			</div>

<!-- 结束 -->
			
		</div>
		<div class="allpage" id="allpage">
			
		</div>
		
</div>
 
	</body>
</html>