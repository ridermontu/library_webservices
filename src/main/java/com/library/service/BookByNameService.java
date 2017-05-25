package com.library.service;

import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.vo.BookbyName;


public interface BookByNameService {
	
	Book bookbyname(BookbyName bookbyName);

}
