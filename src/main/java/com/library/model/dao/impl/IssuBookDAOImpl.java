package com.library.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.model.Book;
import com.library.model.IssuBook;
import com.library.model.User;
import com.library.model.dao.IssuBookDAO;
import com.library.vo.IssuBookRequest;
import com.library.vo.ResponseOfIssuBook;

@Repository
public class IssuBookDAOImpl extends BaseDAOImpl implements IssuBookDAO {

	ArrayList <Book> books=new ArrayList<Book>();
	
	
	@Override
	@Transactional
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		
		Criteria criteria = createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("id",id)).uniqueResult();
		return user;
	}

	
	@Override
	@Transactional
	public Book getBooksbyName(String bookName) {
		// TODO Auto-generated method stub
		
		Criteria criteria = createCriteria(Book.class);
		Book book =  (Book) criteria.add(Restrictions.eq("title",bookName));
		return book;
	}


	@Override
	@Transactional
	public List<IssuBook> summiteBookdate(Long user_id,Long book_id) {
		// TODO Auto-generated method stub
		
		String obj="c";
		String bookobj="a";
		
		
		//int iduser=user_id.intValue();
		
		Criteria criteria=createCriteria(IssuBook.class);
		
		
		 criteria.createAlias("user",obj);
		 criteria.createAlias("book",bookobj);
		 criteria.add(Restrictions.eq(obj+"."+"id", user_id));
		 criteria.add(Restrictions.eq(bookobj+"."+"id",book_id));	
				
		List<IssuBook> issuBooks=criteria.list();
		return issuBooks;
	}


	
//.createAlias("book",bookobj)

//.add(Restrictions.eq(bookobj+"."+"id",book_id));	
	
	

	
	

}
