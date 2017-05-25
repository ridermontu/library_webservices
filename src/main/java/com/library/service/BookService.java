package com.library.service;

import java.util.List;

import com.library.model.Book;
import com.library.vo.CategoryRequest;

public interface BookService {
List<Book> getAll();

CategoryRequest save(CategoryRequest categoryRequest);
}
