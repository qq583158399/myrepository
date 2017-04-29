package com.tkgl.service;

import java.util.List;

import com.tkgl.domain.User;

public interface UserService extends BaseService<User> {
	public boolean isUsernameRegist(String username);
	public boolean isEmailRegist(String email);
	public User loginValidate(String username,String password);
	public List<User> queryAllUser();
	public List<User> queryUsersByHql(String query);
	public void updatePassword(Integer userId,String password);
}
