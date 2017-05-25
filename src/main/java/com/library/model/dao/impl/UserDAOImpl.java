package com.library.model.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.model.User;
import com.library.model.dao.*;
@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	@Override
	@Transactional
	public List<User> getAll() {
		Criteria criteria=createCriteria(User.class);
		return criteria.list();
	}
	
	@Override
	@Transactional
	public User getByemailid(String email) {
		Criteria criteria=createCriteria(User.class);
	
		User user =(User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
		return user;
	}

	
	
	

}
