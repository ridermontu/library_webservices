package com.library.model.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.model.Book;
import com.library.model.CategoryBookRelation;
import com.library.model.Categoryofbook;
import com.library.model.dao.CategoryBookRelDAO;
import com.library.model.dao.CategoryofbookDAO;
import com.library.vo.CategoryRequest;
@Repository
public class CategoryBookRelDAOImpl extends BaseDAOImpl implements CategoryBookRelDAO {
		String CATEGORY_ALIAS="c";
		
	@Transactional	
	@Override
	public List<CategoryBookRelation> getBookBycategory(String categorytype) {
		// TODO Auto-generated method stub
		
		Criteria criteria=createCriteria(CategoryBookRelation.class);
		criteria.createAlias("categoryofbook", CATEGORY_ALIAS);
		criteria.add(Restrictions.eq(CATEGORY_ALIAS+"."+"categorytype", categorytype));
		
		List<CategoryBookRelation> categoryBookRelations=criteria.list();
		return categoryBookRelations ;
	}
	

	
}
