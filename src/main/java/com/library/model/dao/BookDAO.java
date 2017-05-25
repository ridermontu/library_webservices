package com.library.model.dao;

import java.util.List;

import com.library.model.Book;

public interface BookDAO extends BaseDAO  {
	List<Book> getAll();
	
	Book bookByName(String title );
		
}
