package com.library.service;

import java.util.List;

import com.library.model.IssuBook;
import com.library.vo.IssuBookRequest;
import com.library.vo.ResponseOfIssuBook;

public interface IssuBookService extends BaseService {

	
	ResponseOfIssuBook save(IssuBookRequest issuBookRequest);
	
	List<IssuBook> summiteBooks(IssuBookRequest issuBookRequest);
}
