package com.library.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.exception.ValidationException;
import com.library.logger.Log;
import com.library.model.Book;
import com.library.service.BaseService;
import com.library.service.BookService;
import com.library.service.impl.EmailSenderImpl;
import com.library.vo.CategoryRequest;


@Controller
@RequestMapping("/book")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
public class BookController {
	
@Autowired
BookService bookService;

@Autowired
BaseService baseService;

@Autowired
MailSender mailSender;



public BookController() {
	System.out.println("Servcie has been Deployed");
}

@RequestMapping(method=RequestMethod.GET)
ResponseEntity<List<Book>>getAll(){
	EmailSenderImpl emailSender=new EmailSenderImpl();
	emailSender.setMailSender(mailSender);
	emailSender.sendMail("pradeep.rathore2629@yahoo.com","pradeep.rathore2629@gmail.com", "tt", "hi");
	List<Book> books=bookService.getAll();
	return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	
}



@RequestMapping(method=RequestMethod.POST)

ResponseEntity<CategoryRequest>save(@RequestBody CategoryRequest categoryRequest){

 CategoryRequest result=bookService.save(categoryRequest);
		return new ResponseEntity<CategoryRequest>(result,HttpStatus.CREATED);
	
}




@RequestMapping(method=RequestMethod.PUT)
ResponseEntity<Book>update(){
	Book book=new Book();
	book.setAuthor("Pradeep");
	book.setTitle("JAVA");
	Book result=baseService.update(book);
	return new ResponseEntity<Book>(result,HttpStatus.CREATED);
	
}

@RequestMapping(method=RequestMethod.DELETE)
ResponseEntity<Book>delete(){
	return new ResponseEntity<Book>(new Book(),HttpStatus.CREATED);
	
}



}
