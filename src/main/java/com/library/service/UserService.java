package com.library.service;



import java.util.List;

import com.library.model.User;

public interface UserService {

	User save(User user);
	
	List<User> getAlluser();
}
