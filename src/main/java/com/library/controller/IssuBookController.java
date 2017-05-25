package com.library.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.model.IssuBook;
import com.library.service.IssuBookService;
import com.library.vo.IssuBookRequest;
import com.library.vo.ResponseOfIssuBook;

@Controller
@RequestMapping("/issubook")
public class IssuBookController {

	@Autowired
	IssuBookService issuBookService;
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<ResponseOfIssuBook>  issuBookstoUser(@RequestHeader(value="user_Token") String user_Token,@RequestBody IssuBookRequest issuBookRequest){
		
		ResponseOfIssuBook responseOfIssuBook=issuBookService.save(issuBookRequest);
		return new ResponseEntity<ResponseOfIssuBook>(responseOfIssuBook,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/summite",method=RequestMethod.POST)
	ResponseEntity<List<IssuBook>>  summitebook(@RequestBody IssuBookRequest issuBookRequest){
		
		List<IssuBook> issuBooks=issuBookService.summiteBooks(issuBookRequest);
		return new ResponseEntity<List<IssuBook>>(issuBooks,HttpStatus.OK);
		}
	
}
