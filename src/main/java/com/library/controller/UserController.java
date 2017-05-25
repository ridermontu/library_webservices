package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.BaseService;
import com.library.service.BookService;
import com.library.service.UserService;
import com.library.service.impl.BaseServiceImpl;
import com.library.service.impl.EmailSenderImpl;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")

public class UserController {

	@Autowired
	UserService userService;


	public UserController() {

		System.out.println("User service has been deployed");
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<User> save(@RequestBody User user) {

		User result = userService.save(user);
		return new ResponseEntity<User>(result, HttpStatus.CREATED);

	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<User>> getAllUser() {

		List<User> result = userService.getAlluser();
		return new ResponseEntity<List<User>>(result, HttpStatus.CREATED);

	}
	

}
