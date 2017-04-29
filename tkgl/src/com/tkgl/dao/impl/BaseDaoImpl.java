package com.tkgl.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tkgl.dao.BaseDao;


public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sf;
	private Class<T> clazz;
	public BaseDaoImpl() {
		ParameterizedType p=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) p.getActualTypeArguments()[0];
	}
	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	@Override
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void bathEntityByHql(String hql, Object... objects) {
		Query q=sf.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}

	@Override
	public T loadEntity(int id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	@Override
	public T getEntity(int id) {
		// TODO Auto-generated method stub
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHql(String hql, Object... objects) {
		// TODO Auto-generated method stub
		Query q=sf.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	@Override
	public Object uniqueResult(String hql, Object... objects) {
		// TODO Auto-generated method stub
		Query q=sf.getCurrentSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}
	
}
