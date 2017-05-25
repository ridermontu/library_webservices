package com.library.model.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.model.Book;
import com.library.model.dao.BookDAO;

@Repository
public class BookDAOImpl extends BaseDAOImpl implements BookDAO {

	@Override
	@Transactional
	public List<Book> getAll() {
	Criteria criteria=createCriteria(Book.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public Book bookByName(String title) {
		// TODO Auto-generated method stub
		
		Criteria criteria=createCriteria(Book.class);
		Book book=(Book) criteria.add(Restrictions.eq("title", title)).uniqueResult();
		return book;
	}

	

}
