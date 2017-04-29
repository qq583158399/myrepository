package com.tkgl.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.tkgl.domain.User;
import com.tkgl.service.UserService;
@Controller
public class LoginAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private UserService us;
	public User getModle(){
		return user;
	}
	@SkipValidation
	public String toLogin(){
		return "loginPage";
		
	}
	
	public String login(){
		return SUCCESS;
		}
	@Override
	public void validate() {
		clearFieldErrors();
		if(model.getUsername()==null||model.getUsername().trim().isEmpty()){
			addFieldError("username","用户名不能为空");
		}
		if(model.getPassword()==null||model.getPassword().trim().isEmpty()){
			addFieldError("password","密码不能为空");
		}
		if(hasErrors()){
			return ;
		}
		User user=us.loginValidate(model.getUsername(),model.getPassword());
		if(user==null){
			addFieldError("login", "用户名或密码错误");
		}
		else{
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}
	}
}
