package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.model.User;
import com.library.service.LoginService;
import com.library.vo.LoginRequest;
import com.library.vo.Loginresponse;


@Controller
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Loginresponse> loginmethod(@RequestBody LoginRequest loginRequest) {
		
		Loginresponse loginresponse=loginService.loginrequest(loginRequest);
		
		return new ResponseEntity<Loginresponse>(loginresponse,HttpStatus.OK);
	};

}
