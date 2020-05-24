<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员中心</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet"href="css/font-awesome.min.css"> 
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <style>
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
        
        
        
        	.form-bg{
    background: white;
}
.form-horizontal{
    background: white;
    padding-bottom: 40px;
    border-radius: 15px;
    text-align: center;
}
.form-horizontal .heading{
    display: block;
    font-size: 35px;
    font-weight: 700;
    padding: 35px 0;
    border-bottom: 1px solid #f0f0f0;
    margin-bottom: 30px;
}
.form-horizontal .form-group{
    padding: 0 40px;
    margin: 0 0 25px 0;
    position: relative;
}
.form-horizontal .form-control{
    background: #f0f0f0;
    border: none;
    border-radius: 20px;
    box-shadow: none;
    padding: 0 20px 0 45px;
    height: 40px;
    transition: all 0.3s ease 0s;
}
.form-horizontal .form-control:focus{
    background: #e0e0e0;
    box-shadow: none;
    outline: 0 none;
}
.form-horizontal .form-group i{
    position: absolute;
    top: 12px;
    left: 60px;
    font-size: 17px;
    color: #c8c8c8;
    transition : all 0.5s ease 0s;
}
.form-horizontal .form-control:focus + i{
    color: #00b4ef;
}
.form-horizontal .fa-question-circle{
    display: inline-block;
    position: absolute;
    top: 12px;
    right: 60px;
    font-size: 20px;
    color: #808080;
    transition: all 0.5s ease 0s;
}
.form-horizontal .fa-question-circle:hover{
    color: #000;
}
.form-horizontal .main-checkbox{
    float: left;
    width: 20px;
    height: 20px;
    background: #11a3fc;
    border-radius: 50%;
    position: relative;
    margin: 5px 0 0 5px;
    border: 1px solid #11a3fc;
}
.form-horizontal .main-checkbox label{
    width: 20px;
    height: 20px;
    position: absolute;
    top: 0;
    left: 0;
    cursor: pointer;
}
.form-horizontal .main-checkbox label:after{
    content: "";
    width: 10px;
    height: 5px;
    position: absolute;
    top: 5px;
    left: 4px;
    border: 3px solid #fff;
    border-top: none;
    border-right: none;
    background: transparent;
    opacity: 0;
    -webkit-transform: rotate(-45deg);
    transform: rotate(-45deg);
}

.form-horizontal .text{
    float: left;
    margin-left: 7px;
    line-height: 20px;
    padding-top: 5px;
    text-transform: capitalize;
}
.form-horizontal .btn{
    float: center;
    font-size: 14px;
   /* color: #fff;
    background: #00b4ef;*/
    border-radius: 30px;
    padding: 10px 25px;
    border: none;
    text-transform: capitalize;
    transition: all 0.5s ease 0s;
}
@media only screen and (max-width: 479px){
    .form-horizontal .form-group{
        padding: 0 25px;
    }
    .form-horizontal .form-group i{
        left: 45px;
    }
    .form-horizontal .btn{
        padding: 10px 20px;
    }
}
.container{
	position:absolute;
	top:120px;
	left:100px;
}
		</style>
       
</head>
<body style="background: url(img/a_login.jpg);background-size: cover;" background-size: cover;">
<%
	String selleronlinename=(String)session.getAttribute("admin");
	if(selleronlinename==null){
		response.sendRedirect("a_login.html");
	}
%>
<iframe src="head.jsp" style="width:100%; height: 50px; display: block;" frameborder="0" scrolling="no"></iframe>
		<div class="container">
    	<div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" method="post" name="login" action="../loginServlet">
                <span class="heading">管理员中心</span>
                	<div class="form-group">
                    	
                	</div>
                	
                	<div class="form-group">
                    	<button type="button" class="btn btn-success" onclick="window.location.href='adminuser.jsp'" >用户管理</button>
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	<button type="button" class="btn btn-info" onclick="window.location.href='admincommodity.jsp'">商品管理</button>
                	</div>
                	<div class="form-group">
                    	<button type="button" class="btn btn-success" onclick="window.location.href='index.html'">返回首页</button>
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	<button type="button" class="btn btn-info" onclick="window.location.href='Logout.jsp'">注销登录</button>
                	</div>
                	<div class="form-group">
                		&nbsp;
                	</div>
                	
           			 </form>
        		</div>
    		</div>
		</div>
</body>
</html>