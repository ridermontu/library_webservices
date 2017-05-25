package com.library.controller;

import javax.xml.transform.Result;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.model.Book;
import com.library.service.BookByNameService;
import com.library.vo.BookbyName;

@Controller
@RequestMapping("/bookbyname")
public class BookByNameController {

	@Autowired
	BookByNameService bookByNameService;
	



	public BookByNameController() {

		System.out.println("Book by name service deployed");

	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<Book> bookbyna(@RequestBody BookbyName bookbyName) {
		Book bookk = bookByNameService.bookbyname(bookbyName);
		return new ResponseEntity<Book>(bookk, HttpStatus.CREATED);
	}
	
	
	

}
