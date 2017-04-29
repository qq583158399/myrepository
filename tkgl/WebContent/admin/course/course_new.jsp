<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
</head>
<body>
<div class ="container">
<form name="formlwn" id="programForm" role="form"  style="width:80%" action="QuestionServlet?action=save_program" method="post" onsubmit="return false;">
    <div class="input-group " >
            <span class="input-group-addon"  >任课老师</span>
            <select  class="form-control" id="course" name="courseId" >
		<option value="0">未选择</option>
		</select>
		<span class="input-group-addon">选择章节</span>
           <select  class="form-control" id="chapter" name= "chapterId">
			<option value="0">未选择</option>
		</select>
      </div>
	 <div class="input-group" >
            <span class="input-group-addon">题目名称</span>           
           <input type="text" class="form-control" id="programsNameText" name ="programsTitle">
     </div> 
     <br>
			<div class=" form-group">
				<textarea class="form-control" style="margin: 0px auto"
					rows="11" placeholder="题目描述" id="programsContextText"
					name="programsContext"></textarea>
			</div> 
	 <div class="input-group" > 
	 	
	 		<button type="button" class="btn btn-primary">添加题目</button>

     </div> 
 </form>
</div>
</body>
</html>