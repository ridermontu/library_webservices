package com.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.logger.Log;
import com.library.model.Book;
import com.library.model.CategoryBookRelation;
import com.library.model.Categoryofbook;
import com.library.model.dao.BookDAO;
import com.library.model.dao.CategoryofbookDAO;
import com.library.model.dao.impl.BaseDAOImpl;
import com.library.service.BaseService;
import com.library.service.BookService;
import com.library.vo.CategoryRequest;

@Service
public class BookServiceImpl extends BaseServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Autowired
	CategoryofbookDAO categoryofbookDAO;
	
	private static @Log Logger LOG;

	@Override
	@Transactional
	public List<Book> getAll() {

		return bookDAO.getAll();
	}

	@Transactional
	@Override
	public CategoryRequest save(CategoryRequest categoryRequest) {
		// TODO Auto-generated method stub

		Book book = categoryRequest.getBook();
		bookDAO.save(book);
		List<Categoryofbook> categoryofbooks = categoryRequest.getCategoryofbook();
		for (Categoryofbook categoryofbook : categoryofbooks) {

			// categoryofbook.getId()
			Categoryofbook categoryofbook2 = categoryofbookDAO.getById(categoryofbook.getId());

			CategoryBookRelation categoryofbookrel = new CategoryBookRelation();
			categoryofbookrel.setBook(book);

			categoryofbookrel.setCategoryofbook(categoryofbook2);
			categoryofbookDAO.save(categoryofbookrel);

		}

		return categoryRequest;
	}

}
