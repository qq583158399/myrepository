package com.tkgl.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse resp)
    		  throws ServletException, IOException{   	  
              //获取参数来确定用户想要调用的方法名称
 		 req.setCharacterEncoding("utf-8");
 		 resp.setContentType("text/html;charset='utf-8'");
    	 String methodName=(String) req.getParameter("method");
		 
 		 if(methodName==null||methodName.trim().isEmpty()){
	    	   throw new RuntimeException("没有给出参数,无法调用所需要的"
 		                                                              +methodName+"()方法");
	     }
 		 
		 Class<? extends BaseServlet> c=this.getClass();
		 Method method=null;
		 
		 try {
			
			 method=c.getMethod(methodName,
					 HttpServletRequest.class,HttpServletResponse.class);
		 } catch (Exception e) {
            
			 throw new RuntimeException("你所给出的方法:"+methodName+"()不存在");
		
		 } 
		 String zhilin=null;
		 try {
			
			 zhilin=(String) method.invoke(this,req,resp);
			
		} catch (Exception e) {
			System.out.println("你给出的方法"+methodName
					+"(HttpRequestServlet,HttpResponseServlet)内部抛出了异常");
			throw new RuntimeException(e);
		}
		 
	/*	if(zhilin==null||zhilin.trim().isEmpty()){	
				
			}else if(zhilin.contains(":")){
				
				int index=zhilin.indexOf(":");
				String head=zhilin.substring(0, index);
				String body=zhilin.substring(index+1, zhilin.length());
				
				if(head.equals("f")){
					req.getRequestDispatcher(body).forward(req, resp);
				}else if(head.equals("s")){
					resp.sendRedirect(req.getContextPath()+body);
				}else{
					throw new RuntimeException("该指令在当前版本不被支持");
				}
			}else{
				//没有前缀默认为转发
				req.getRequestDispatcher(zhilin).forward(req, resp);
			}
			*/
		 
      }

}
