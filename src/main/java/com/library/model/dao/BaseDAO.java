package com.library.model.dao;

public interface BaseDAO {
<T> T save(T entity);
<T> T update(T entity);
<T> T delete(T entity);
}
