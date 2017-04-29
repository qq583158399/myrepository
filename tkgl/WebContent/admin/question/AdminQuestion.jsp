<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<base href="<%=basePath%>" > 
<head>
<style type="text/css">
 html{
 min-width: 400px;
 
}
</style>
<meta charset="UTF-8">
 
<title>后台管理</title>

  <script src="<%=basePath %>bootstrap/js/jquery-2.1.1.js"></script>
   	<link href="<%=basePath %>bootstrap/css/bootstrap.css" rel="stylesheet">
   	<link href="<%=basePath %>bootstrap/css/bootstrap-theme.css" rel="stylesheet">
    <link href="<%=basePath %>bootstrap/css/blog-home.css" rel="stylesheet">
  
     <script src="<%=basePath %>bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
     <div class="container">
       <div class="navbar-header">
         <a class="navbar-brand" href="#">系统管理首页</a>
       </div>

       <!-- Collect the nav links, forms, and other content for toggling -->
       <div class="collapse navbar-collapse navbar-ex1-collapse">
         <ul class="nav navbar-nav">
           <li><a href="#">题库管理</a></li>
         </ul>
        <ul class="nav navbar-nav">
           <li><a href="#">模板管理</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
         	<li><a href="question_left.jsp" data-target="#testid" >登录</a></li>
         	<li><a href="Register.jsp" target="_blank">注册</a></li>
         </ul>        
       </div><!-- /.navbar-collapse -->
     </div><!-- /.container -->
   </nav>
<div class="container  " style="min-width:1000px" >
<div class="row col-xs-2 col-md-2" style="min-width:130px">
 <jsp:include page="question_left2.jsp"></jsp:include>
            
 </div>
 <div class="row col-xs-10 col-md-10" style="min-width:800px">
 <div class="container" id="questionlist"></div>
<br>
 
 </div>
</div>

 
		

</body>
   <script>
       
        
        </script>
</html>