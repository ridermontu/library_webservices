package com.library.vo;

import java.util.List;

public class IssuBookRequest {
	List<String> bookName;
	// String categoryBook;
	Long user_Id;
	String date;

	public List<String> getBookName() {
		return bookName;
	}

	public void setBookName(List<String> bookName) {
		this.bookName = bookName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

}
