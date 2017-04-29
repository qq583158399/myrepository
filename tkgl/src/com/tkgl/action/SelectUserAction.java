package com.tkgl.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tkgl.domain.User;
import com.tkgl.service.UserService;

@Controller
public class SelectUserAction extends BaseAction<User> implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private String query;
	private User model=new User() ;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	@Autowired
	private UserService us;
	private HttpServletResponse response;
	public User getModel() {
		return model;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	public void setModel(User model) {
		this.model = model;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String selectAll(){
		users = us.queryAllUser();
		return "success";
	}
	public String query(){
		users=us.queryUsersByHql(query);
		
		return SUCCESS;
		
	}
	public String delete() throws IOException{
		us.deleteEntity(model);
		users=us.queryAllUser();
		/*String password=model.getPassword();*/
		return SUCCESS;
	}
	public String queryUser(){
		User user = us.getEntity(model.getUserId());
		result=user.getPassword();
		System.out.println(result);
		return  SUCCESS;
	}
	public String update(){
		us.updatePassword(model.getUserId(),model.getPassword());
		users=us.queryAllUser();
		return SUCCESS;
	}
	public String addUser(){
		us.saveEntity(model);
		users=us.queryAllUser();
		return SUCCESS;
	}

}
