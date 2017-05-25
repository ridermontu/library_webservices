package com.library.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.dao.BookDAO;
import com.library.service.BookByNameService;
import com.library.vo.BookbyName;
@Service
public class BookByNameServiceImpl extends BaseServiceImpl implements BookByNameService {

	@Autowired
	BookDAO bookDAO;
	
	@Override
	@Transactional
	public Book bookbyname(BookbyName bookbyName) {
		// TODO Auto-generated method stub
	Book  book=	bookDAO.bookByName(bookbyName.getTitle());
		
		return book ;
	}

	

}
