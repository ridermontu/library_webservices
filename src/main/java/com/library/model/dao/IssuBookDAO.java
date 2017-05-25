package com.library.model.dao;

import java.util.List;

import com.library.model.Book;
import com.library.model.IssuBook;
import com.library.model.User;
import com.library.vo.IssuBookRequest;
import com.library.vo.ResponseOfIssuBook;

public interface IssuBookDAO extends BaseDAO {
 // ResponseOfIssuBook issuBook(IssuBookRequest  issuBookRequest);
	
	User getUserById(Long id);
	
	Book getBooksbyName(String bookName);
	
	List<IssuBook> summiteBookdate(Long User_id,Long book_id);
}
