package com.library.service;

import java.util.List;

import com.library.model.Book;
import com.library.model.CategoryBookRelation;

public interface CategorybyBookService {
	
  List<Book> getCategorybyBook(String category);
}
