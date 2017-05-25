package com.library.vo;

import java.util.List;

import com.library.model.Book;
import com.library.model.Categoryofbook;

public class CategoryRequest {
	
Book book;
List<Categoryofbook> categoryofbook;

public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public List<Categoryofbook> getCategoryofbook() {
	return categoryofbook;
}
public void setCategoryofbook(List<Categoryofbook> categoryofbook) {
	this.categoryofbook = categoryofbook;
}

}
