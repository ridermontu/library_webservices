package com.library.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.model.dao.BaseDAO;



@Repository("baseDAO")
public class BaseDAOImpl implements BaseDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public <T> T save(T entity) {
		getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public <T> T update(T entity) {
		getCurrentSession().update(entity);
		return entity;
	}

	@Override
	public <T> T delete(T entity) {
		getCurrentSession().delete(entity);
		return entity;
	}
	
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

	protected Criteria createCriteria(Class cl){
		return getCurrentSession().createCriteria(cl);
	}
}
