package com.tkgl.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>,Preparable {
	public T model;
	public BaseAction() {
		// TODO Auto-generated constructor stub\
		ParameterizedType p=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class<T>) p.getActualTypeArguments()[0];
		try {
			model=(T) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void prepare() throws Exception{}
	public  T getModel(){
		return model;
	} 
}
