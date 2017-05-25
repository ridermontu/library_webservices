package com.library.vo;

import java.util.List;

import com.library.model.Book;
import com.library.model.User;

public class ResponseOfIssuBook {
	User user;
	List<String> bookName;
    String Date;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<String> getBookName() {
		return bookName;
	}
	public void setBookName(List<String> bookName) {
		this.bookName = bookName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}

}
