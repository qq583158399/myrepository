package com.tkgl.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.tkgl.dao.BaseDao;
import com.tkgl.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {	
	private BaseDao<T> dao ;
	private Class<T> clazz ;
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	@Autowired
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	public void updateEntity(T t) {
		dao.updateEntity(t);
	}
	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}
	public void saveEntity(T t) {
		dao.saveEntity(t);
	}
	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}
	public void bathEntityByHql(String hql, Object... objects) {
		dao.bathEntityByHql(hql, objects);
	}
	public T loadEntity(int id) {
		return (T) dao.loadEntity(id);
	}
	public T getEntity(int id) {
		return (T) dao.getEntity(id);
	}
	public List<T> findEntityByHql(String hql, Object... objects) {
		return dao.findEntityByHql(hql, objects);
	}
		
}
