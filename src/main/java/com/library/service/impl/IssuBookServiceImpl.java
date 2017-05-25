package com.library.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.IssuBook;
import com.library.model.User;
import com.library.model.dao.BookDAO;
import com.library.model.dao.IssuBookDAO;
import com.library.service.IssuBookService;
import com.library.vo.IssuBookRequest;
import com.library.vo.ResponseOfIssuBook;

@Service
public class IssuBookServiceImpl extends BaseServiceImpl implements IssuBookService {

	@Autowired
	IssuBookDAO issuBookDao;

	@Autowired
	BookDAO bookDao;

	@Override
	@Transactional
	public ResponseOfIssuBook save(IssuBookRequest issuBookRequest) {

		// issuBookRequest contain User id, list of book name ,date

		Long user_id = issuBookRequest.getUser_Id(); // =======get user to id

		// String date= issuBookRequest.getDate();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		User user = issuBookDao.getUserById(user_id); // =========get user to
														// database

		List<String> bookNamee = issuBookRequest.getBookName(); // ======get
																// list of books
		int arrylength = bookNamee.size(); // request
		for (int i = 0; i < arrylength; i++) {
			String bookname = bookNamee.get(i);

			Book book = bookDao.bookByName(bookname);
			// Book book = issuBookDao.getBooksbyName(bookname);

			IssuBook issubooks = new IssuBook(); // new Object of model class of
													// issu book
			issubooks.setUser(user); // ============set user in madel class
			issubooks.setBookIssuDate(date); // ===========set date in model
			issubooks.setBook(book); // ========set list of books

			issuBookDao.save(issubooks);
		}

		/*
		 * for (String bookName : bookNamee) { // Book
		 * book=bookDao.bookByName(bookName); Book book =
		 * issuBookDao.getBooksbyName(bookName);
		 * 
		 * IssuBook issubooks = new IssuBook(); // new Object of model class of
		 * // issu book issubooks.setUser(user); // ============set user in
		 * madel class issubooks.setBookIssuDate(date); // ===========set date
		 * in model issubooks.setBook(book); // ========set list of books
		 * 
		 * issuBookDao.save(issubooks); }
		 */

		ResponseOfIssuBook responseOfIssuBook = new ResponseOfIssuBook();

		responseOfIssuBook.setBookName(bookNamee);
		responseOfIssuBook.setDate(date);
		responseOfIssuBook.setUser(user);

		return responseOfIssuBook;
	}

	@Override
	@Transactional
	public List<IssuBook> summiteBooks(IssuBookRequest issuBookRequest) {
		// TODO Auto-generated method stub
		List<IssuBook> issuBooks=null;
		ArrayList<IssuBook> issuBookss=new ArrayList<IssuBook>();
		String summiteDate = issuBookRequest.getDate();
		User user = issuBookDao.getUserById(issuBookRequest.getUser_Id());

		List<String> booksName = issuBookRequest.getBookName();
		for (int i = 0; i < booksName.size(); i++) {

			Book book = bookDao.bookByName(booksName.get(i));
			//System.out.println(issuBookRequest.getUser_Id()+book.getId());
			 issuBooks = issuBookDao.summiteBookdate(issuBookRequest.getUser_Id(),book.getId());
			
			 for (IssuBook issuBook : issuBooks) {
				 issuBookss.add(issuBook);
				 issuBook.setSummiteDate(summiteDate);
				 Long charge=(long) 100;
				 issuBook.setBookcharge(charge);
				 issuBookDao.update(issuBook);
			}

		}

		return issuBookss;
	}

	
	
}
