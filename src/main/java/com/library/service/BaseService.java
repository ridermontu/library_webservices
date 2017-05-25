package com.library.service;

public interface BaseService {
	<T> T save(T entity);
	<T> T update(T entity);
	<T> T delete(T entity);

}
