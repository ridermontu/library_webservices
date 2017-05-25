package com.library.model.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.CategoryBookRelation;
import com.library.vo.CategoryRequest;


public interface CategoryBookRelDAO extends BaseDAO  {
	
	List<CategoryBookRelation>  getBookBycategory(String categorytype);

}
