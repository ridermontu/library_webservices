package com.library.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.logger.Log;
import com.library.model.User;
import com.library.model.dao.UserDAO;
import com.library.service.UserService;


@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{

	@Autowired
	UserDAO  userDAO;
	
	private static @Log Logger LOG;
	
	
	@Transactional
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		
		userDAO.save(user);
		return user;
	}

	@Transactional
	@Override
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		List<User> users=userDAO.getAll();
	
		return users;
	}

	

	
}
