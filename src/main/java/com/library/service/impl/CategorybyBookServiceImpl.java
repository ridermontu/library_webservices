package com.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.CategoryBookRelation;
import com.library.model.dao.CategoryBookRelDAO;
import com.library.service.CategorybyBookService;
@Service
public class CategorybyBookServiceImpl extends BaseServiceImpl implements CategorybyBookService {
	
	
	
	@Autowired
	CategoryBookRelDAO categorybookrelDAo;
	
	
           

	@Override
	public List<Book> getCategorybyBook(String category) {
		// TODO Auto-generated method stub
		ArrayList<Book> bookss=new ArrayList<Book>();
		List<CategoryBookRelation> categoryBookRelations=categorybookrelDAo.getBookBycategory(category);
		
		for(CategoryBookRelation categoryBookRelationObj :categoryBookRelations){
			bookss.add(categoryBookRelationObj.getBook());
			
		}
		
		return bookss;
	}
	

	
	

	


}
