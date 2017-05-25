package com.library.model.dao;

import java.util.List;

import com.library.model.Book;
import com.library.model.User;

public interface UserDAO extends BaseDAO {
	User getByemailid(String email);
	List<User> getAll();	
	
	

}
