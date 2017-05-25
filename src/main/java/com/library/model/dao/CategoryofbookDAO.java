package com.library.model.dao;

import java.util.List;

import com.library.model.Book;
import com.library.model.Categoryofbook;
import com.library.model.dao.impl.BaseDAOImpl;

public interface CategoryofbookDAO extends BaseDAO {
	
	Categoryofbook getById(Long id);

}
