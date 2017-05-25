package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.model.Book;
import com.library.service.BaseService;
import com.library.service.CategorybyBookService;



@Controller
@RequestMapping("/category")
public class CategoryofBookController {
	
	@Autowired
	CategorybyBookService categorybyBookService;
	

	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Book>> getcategory(@RequestParam String category){
		
		List<Book> books=categorybyBookService.getCategorybyBook(category);
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		}

}
