<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<div class="col-md-2">
			<!--左侧菜单栏-->
			<div class="leftsidebar_box">
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
					<dd class="first_dd"><a href="#">查询用户</a></dd>
				</dl>
		
			</div>
		</div>

		<!--右侧主要界面-->
		<div class="col-md-9" id="main">
				<div style="padding: 70px 40px 30px;">
	
	<div style="float: left; margin-top: 8px"><label>搜索：</label></div>	
	<form class="bs-example bs-example-form" role="form" action="/tkgl/selectUser_query.action" method="post" >
		<div class="row">
			<div class="col-lg-9">
				<div class="input-group">
					<input type="text" class="form-control" style="width: 800px" placeholder="按编号或用户名查询" name="query" id="query">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" onclick="get_students_page()">
							Go!
						</button>
					</span>
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 --><br>	
		</div><!-- /.row -->
	</form>
</div>

		<button class="btn-primary" data-toggle="modal" data-target="#addModal" style="position: absolute; top:73px;left:1000px;height: 30px;width: 80px;background-color: #338cb7;border-radius: 4px">添加用户</button>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="addModalLabel">
					添加用户
				</h4>
			</div>
			
			<div class="modal-body">
				<form action="/tkgl/selectUser_addUser.action" method="post" id="addForm">
				<label style="margin-top: 7px">用户名：</label>
				 <input type="text" class="form-control" name="username" placeholder="请输入用户名"  id="usename" value="">
				<label style="margin-top: 7px">密码：</label>
				 <input type="text" class="form-control" name="password" placeholder="请输入密码"  id="password" value="">
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="user_add()" id="addUser">
					添加
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

	<table class="table table-bordered">
 
  <thead>
    <tr>
      <th align="center" style="text-align: center;">编号</th>
      <th align="center" style="text-align: center;">用户名</th>
      <th align="center" style="text-align: center;">注册时间</th>
      <th align="center" style="text-align: center;">操作</th>
    </tr>
  </thead>
  <tbody>
  
  	<s:iterator var="user" value="users">
    <tr>
      <td align="center">${user.userId }</td>
      <td align="center">${user.username }</td>
      <td align="center">${user.createTime}</td>
      <td align="center"><a  data-toggle="modal" data-target="#myModal" onclick="beforeModel(${user.userId})">修改</a>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <a href="/tkgl/selectUser_delete.action?userId=${user.userId}">删除</a></td>
    </tr>
    
    </s:iterator>
    
    
  </tbody>
</table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改密码
				</h4>
			</div>
			<div class="modal-body">
				 <input type="text" class="form-control" name="password" placeholder="请输入修改的密码"  id="password" value="">
				<input type="hidden" id="userId" value="">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="user_update()" id="update">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
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
	});
	function get_students_page(){
		var query=$("#query");
		 $("#questionlist").load("/tkgl/selectUser_query.action",{"query":query.val()}); 
	}
	function user_update(){
		/* $('#myModal').modal('hide') */
			  $.post("/tkgl/selectUser_update.action",
					  {"userId":$("#userId").val(),"password":$("#password").val()},
					  function(data){
			    		
				  }

			  );
	} 
	function beforeModel(obj1){
		$("#userId").val(obj1);
		$.post(
				"/tkgl/selectUser_queryUser.action",
				 {"userId":$("#userId").val()},
				 function(data){
				 		$("#password").val(data);
				  }

				);
	};
	function user_add(){
		$("#addForm").submit();
	}

	
</script>

</html>