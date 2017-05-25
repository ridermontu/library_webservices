package com.library.model.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.model.Book;
import com.library.model.Categoryofbook;
import com.library.model.dao.CategoryofbookDAO;

@Repository
public class CategoryofbookDaoImpl extends BaseDAOImpl implements CategoryofbookDAO {
	@Transactional
	@Override
	public Categoryofbook getById(Long id) {
		
		return (Categoryofbook) createCriteria(Categoryofbook.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	

}
