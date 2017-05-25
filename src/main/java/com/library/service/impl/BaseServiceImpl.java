package com.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.dao.BaseDAO;
import com.library.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService{
	@Autowired
	BaseDAO baseDAO;
	
	@Override
	public <T> T save(T entity) {
		baseDAO.save(entity);
		return entity;
	}

	@Override
	public <T> T update(T entity) {
		baseDAO.update(entity);
		return entity;
	}

	@Override
	public <T> T delete(T entity) {
		baseDAO.delete(entity);
		return entity;
	}

}
