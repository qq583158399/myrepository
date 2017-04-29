package com.tkgl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tkgl.dao.BaseDao;
import com.tkgl.domain.User;
import com.tkgl.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Resource(name = "userDao")
	private BaseDao<User> userDao;

	@Override
	public boolean isUsernameRegist(String username) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.name=?";
		List<User> users = this.findEntityByHql(hql, username);
		if (users.isEmpty() || users == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEmailRegist(String email) {
		String hql = "from User u where u.eamil=?";
		List<User> users = this.findEntityByHql(hql, email);
		if (users.isEmpty() || users == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User loginValidate(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		List<User> users = this.findEntityByHql(hql, username, password);
		if (users.isEmpty() || users == null) {
			return null;
		} else {
			return users.get(0);
		}
	}

	@Override
	public List<User> queryAllUser() {
		String hql = "from User u";
		List<User> list = this.findEntityByHql(hql);
		return list;
	}

	@Override
	public List<User> queryUsersByHql(String query) {
		if (isNumber(query)) {
			String hql = "from User u where u.userId=? or u.username like ?";
			List<User> list = this.findEntityByHql(hql, Integer.parseInt(query), "%" + query + "%");
			return list;
		} else {
			String hql = "from User u where  u.username like ?";
			List<User> list = this.findEntityByHql(hql, "%" + query + "%");
			return list;
		}
	}
	
	@Override
	public void updatePassword(Integer userId,String password) {
		String hql="update User u set u.password=? where u.userId=?";
		this.bathEntityByHql(hql,password,userId);
	}

	private boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
