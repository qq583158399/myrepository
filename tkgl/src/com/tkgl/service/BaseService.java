package com.tkgl.service;

import java.util.List;

public interface BaseService<T> {
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void bathEntityByHql(String hql,Object...objects);
	public T loadEntity(int id);
	public T getEntity(int id);
	public List<T> findEntityByHql(String hql,Object...objects);
}
