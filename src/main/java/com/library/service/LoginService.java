package com.library.service;

import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.vo.LoginRequest;
import com.library.vo.Loginresponse;

public interface LoginService {
	
	Loginresponse loginrequest(LoginRequest loginRequest);

}
