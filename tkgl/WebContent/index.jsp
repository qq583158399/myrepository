<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>题库管理首页</title>
<link href="/tkgl/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/tkgl/bootstrap/css/index.css" rel="stylesheet">
<script src="/tkgl/bootstrap/js/jquery-2.1.1.js" type="text/javascript"></script>
<script src="/tkgl/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
	<!--导航栏开始-->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header" style="margin-left: 50px">
			    <a class="navbar-brand" href="#">题库管理</a>
			</div>
		
			<div  style="margin-left:1250px">
		        <ul class="nav navbar-nav">
		            <li ><a href="#">登录</a></li>
		        </ul>
		         <ul class="nav navbar-nav">
		            <li ><a href="#">注册</a></li>
		        </ul>
	    	</div>

    	</div>
	</nav>
	
	<div class="container">
		<!--左侧布局-->
		<div >
			<!--左侧菜单栏-->
			<!-- <div class="leftsidebar_box">
				<div class="line"></div>
				<dl class="system_log">
					<dt >题目管理<img src="bootstrap/images/left/select_xl01.png"></dt>
					<dd class="first_dd"><a href="#">充值记录</a></dd>
					<dd><a href="#">短信充值记录</a></dd>
					<dd><a href="#">消费记录</a></dd>
					<dd><a href="#">操作记录</a></dd>
				</dl>
			
				<dl class="channel">
					<dt>章节管理<img src="bootstrap/images/left/select_xl01.png"></dt>
					<dd class="first_dd"><a href="#">渠道主页</a></dd>
					<dd><a href="#">渠道标准管理</a></dd>
					<dd><a href="#">系统通知</a></dd>
					<dd><a href="#">渠道商管理</a></dd>
					<dd><a href="#">渠道商链接</a></dd>
				</dl>
			
				<dl class="cloud">
					<dt>课程管理<img src="bootstrap/images/left/select_xl01.png"></dt>
					<dd class="first_dd"><a href="#">平台运营商管理</a></dd>
				</dl>
			
				<dl class="source">
					<dt>试卷管理<img src="bootstrap/images/left/select_xl01.png"></dt>
					<dd class="first_dd"><a href="#">图片库</a></dd>
					<dd><a href="#">链接库</a></dd>
					<dd><a href="#">推广管理</a></dd>
				</dl>


				<dl class="custom">
					<dt >用户管理<img src="bootstrap/images/left/select_xl01.png"></dt>
					<dd class="first_dd"><a href="/tkgl/selectUser_selectAll.action">查询用户</a></dd>
				</dl>
		
			</div> -->	
			
			<div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" id="myNav">
                <li class="active"><a href="#section-1">第一部分</a></li>
                <li><a href="#section-2">第二部分</a></li>
                <li><a href="#section-3">第三部分</a></li>
                <li><a href="#section-4">第四部分</a></li>
                <li><a href="#section-5">第五部分</a></li>
            </ul>
        </div>
		</div>

		<!--右侧主要界面-->
		<div class="col-md-9" id="main">
			<h1 style="letter-spacing: 10px;font-size: 40px;margin-top: 80px;margin-left: 230px; ">欢迎使用题库管理系统！</h1>
		</div>

	</div>
</body>


<script type="text/javascript">

	//菜单栏脚本
	$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
	$(".leftsidebar_box dt img").attr("src","bootstrap/images/left/select_xl01.png");
	$(function(){
		$(".leftsidebar_box dd").hide();
		$(".leftsidebar_box dt").click(function(){
			$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
			$(this).css({"background-color": "#317eb4"});
			$(this).parent().find('dd').removeClass("menu_chioce");
			$(".leftsidebar_box dt img").attr("src","bootstrap/images/left/select_xl01.png");
			$(this).parent().find('img').attr("src","bootstrap/images/left/select_xl.png");
			$(".menu_chioce").slideUp(); 
			$(this).parent().find('dd').slideToggle();
			$(this).parent().find('dd').addClass("menu_chioce");
		});
	})

</script>

</html>


