package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="categoryBookRelation")
public class CategoryBookRelation {
	
	Long id;
	Book book;
	Categoryofbook categoryofbook;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	public Categoryofbook getCategoryofbook() {
		return categoryofbook;
	}
	public void setCategoryofbook(Categoryofbook categoryofbook) {
		this.categoryofbook = categoryofbook;
	}
	
	
	
}
