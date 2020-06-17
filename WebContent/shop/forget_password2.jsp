<%--
Copyright (c) 2020,大佬求带飞组
文件名称：forget_password2.jsp
文件标识：详见校园二手交易系统设计说明书
摘         要：本文件完成的主要功能是完成输入验证码的界面显示

当前版本：1.2
作者：杨之正
完成时间：2020.6.11

取代版本：1.1
原作者：杨之正
完成日期：2020.6.4
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="com.nwpu.bean.User" %>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@page import="com.nwpu.dao.managerforgetpasswordDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Forget-password</title>
	<link rel="stylesheet" type="text/css" href="style/register-login.css">
    <style type="text/css">

        body,
        html{
            margin: 0;
            padding: 0;
            border: 0;
            font-family: 'Nunito', sans-serif;
        }

        body{background:#F7FAFC;}

        canvas{
            margin: 0;
            padding: 0;
            display: block; /*  ˉ\_(ツ)_/ˉ  */
            touch-action: none;
        }



    #button1{
		position:relative;
        left:300px;
        top:40px;
    z-index: 0;
        border-style:none;
        background:White;
    width:100px;
    height:30px;}</style>
</head>
<body>

    <div id="box"></div>

    <canvas></canvas>

    <div class="cent-box register-box">
	<div>
        <b><h2>找回密码</h2></b>
        <p>请输入验证码:</p>
        </br>
        </div>
    <div>
    
    <div class="login form">
                 <form action="../sendemail" method="post">
                <div class="group">
                <div class="group-ipt verify">
                    <input type="text" name="code" id="code" class="ipt" placeholder="请输入验证码" required maxlength="6">
                </div>
              </div>

                </div>

        <div class="button">
        <button type="submit" class="login-btn register-btn" id="button">下一步</button>
            </a></div>
            </form>
            </div>
        <div class="footer">
        <i><p>学生管理系统</p></i>
    </div>
        <script src='js/particles.js' type="text/javascript"></script>
    <script src='js/background.js' type="text/javascript"></script>
    <script src='js/jquery.min.js' type="text/javascript"></script>
    <script src='js/layer/layer.js' type="text/javascript"></script>
    <script src='js/index.js' type="text/javascript"></script>
    <script type="text/javascript">
//60秒倒计时
    var countdown=60;
    function settime(val) {
        if (countdown == 0) {
            val.removeAttribute("disabled");
            val.value="get code";
            countdown = 60;
            return false;
        } else {
            val.setAttribute("disabled", true);
            val.value="Again(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {
            settime(val);
        },1000);

    }
    </script>
       <script>
            function mySubmit(){}
            </script>
            <script> 
            var errori ='<%=request.getParameter("error")%>';
            if(errori=='yes'){
             alert("账号不存在!");
            }
          </script>


        <script>
            var canvas = document.querySelector('canvas');
            canvas.height = window.innerHeight;
            canvas.width = window.innerWidth;
            c = canvas.getContext('2d');

            window.addEventListener('resize', function(){
                canvas.height = window.innerHeight;
                canvas.width = window.innerWidth;

                initCanvas();
            })

            var mouse = {
                x: undefined,
                y: undefined
            }
            window.addEventListener('mousemove',
                function (event) {
                    mouse.x = event.x;
                    mouse.y = event.y;
                    drawCircles();
                }
            )
            window.addEventListener("touchmove",
                function (event) {
                    let touch = event.touches[0];
                    mouse.x = touch.clientX;
                    mouse.y = touch.clientY;
                    drawCircles();
                }
            )

            function Circle(x, y, radius, vx, vy, rgb, opacity, birth, life){
                this.x = x;
                this.y = y;
                this.radius = radius;
                this.minRadius = radius;
                this.vx = vx;
                this.vy = vy;
                this.birth = birth;
                this.life = life;
                this.opacity = opacity;

                this.draw = function() {
                    c.beginPath();
                    c.arc(this.x, this.y, this.radius, Math.PI * 2, false);
                    c.fillStyle = 'rgba(' + rgb +','+ this.opacity +')';
                    c.fill();
                }

                this.update = function(){
                    if (this.x + this.radius > innerWidth || this.x - this.radius < 0) {
                        this.vx = -this.vx;
                    }

                    if (this.y + this.radius > innerHeight || this.y - this.radius < 0) {
                        this.vy = -this.vy;
                    }

                    this.x += this.vx;
                    this.y += this.vy;

                    this.opacity = 1- (((frame - this.birth) * 1) / this.life);

                    if (frame > this.birth + this.life){
                        for (let i = 0; i < circleArray.length; i++){
                            if (this.birth == circleArray[i].birth && this.life == circleArray[i].life){
                                circleArray.splice(i, 1);
                                break;
                            }
                        }
                    } else{
                        this.draw();
                    }
                }

            }

            var circleArray = [];

            function initCanvas() {
                circleArray = [];
            }

            var colorArray = [
                '355,85,80',
                '9,80,100',
                '343,81,45'
            ]

            function drawCircles(){
                for (let i = 0; i < 6; i++) {
                    let radius = Math.floor(Math.random() * 4) + 2;
                    let vx = (Math.random() * 2) - 1;
                    let vy = (Math.random() * 2) - 1;
                    let spawnFrame = frame;
                    let rgb = colorArray[Math.floor(Math.random() * colorArray.length)];
                    let life = 100;
                    circleArray.push(new Circle(mouse.x, mouse.y, radius, vx, vy, rgb, 1, spawnFrame, life));

                }
            }

            var frame = 0;
            function animate() {
                requestAnimationFrame(animate);
                frame += 1;
                c.clearRect(0, 0, innerWidth, innerHeight);
                for (let i = 0; i < circleArray.length; i++ ){
                    circleArray[i].update();
                }

            }

            initCanvas();
            animate();

            // This is just for demo purposes :
            for (let i = 1; i < 110; i++) {
                (function (index) {
                    setTimeout(function () {
                        mouse.x = 100 + i * 10;
                        mouse.y = 100;
                        drawCircles();
                    }, i * 10);
                })(i);
            }
        </script>



</body>
</html>