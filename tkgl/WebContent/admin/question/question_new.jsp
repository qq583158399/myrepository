<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" > 
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
 
<script type="text/javascript">

var courselist;
 
jQuery(document).ready(function() {
	
	var url="CourseServlet?action=get_course";
	 var args={"time":new Date()}; 
	$.getJSON(url, function(data){
		if(data.length==0){
			alert("当前系统里没有课程");
		}else{
			courselist=data;
			for(var i=0;i<data.length;i++){
				var courseId=data[i].courseId;
				var courseName=data[i].courseName;
				$("#course").append("<option value='"+courseId+"'>"+courseName+"</option>");
			}
			
		}
	});
	
	$("#course").change(function(){
		 
		$("#chapter option:not(:first)").remove();
		 
		var course=$(this).val();
		if(course!=""){
			var url="CourseServlet?action=get_chapter";
			var args={"courseId":course,"time":new Date()};
			$.getJSON(url,args,function(data){
				if(data.length==0){
					alert("当前课程没有章节");
					 $("#questionlist tr:not(:first)").remove();
				}else{
					for(var i=0;i<data.length;i++){
						var chapterId=data[i].chapterId;
						var chapterName=data[i].chapterName;
						$("#chapter").append("<option value='"+chapterId+"'>"+chapterName+"</option>");
					}
					 
				}
			});
		}
	});
	 
	
});

function save_program(){
	 var url ="QuestionServlet?action=save_program";
	 //alert($("#course").val());
	 var args={"courseId":$("#course").val() ,
			 "chapterId": $("#chapter").val(),
			 "programsTitle":$("#programsNameText").val() ,
		 "programsSource":$("#programsSourceText").val() ,
		 "spendTime":$("#spendTime_text").val() ,
		 "programsContext":$("#programsContextText").val() ,
		 "languageId":$("#languageId").val(),
		 "answer":$("#programsAnswerText").val(),
		 "time":new Date()}
	 
	 $.post(url,args,function(data){
		//alert(data);	
		 if(data==-1)return false;
			
			else $("#testdatabtn").attr("value",data);
		 
		});
	$("#testdatabtn").removeAttr("disabled");
	return false;
}
</script>
<body>
 
<div class ="container">
<form name="formlwn" id="programForm" role="form"  style="width:80%" action="QuestionServlet?action=save_program" method="post" onsubmit="return false;">
    <div class="input-group " >
            <span class="input-group-addon"  >选择课程</span>
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
 <div class="container">
 
 
	
	 
   
</div>  
</body>
</html>