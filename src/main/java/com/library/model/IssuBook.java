package com.library.model;

import java.util.List;

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
@Table(name="bookIssu")
public class IssuBook {

	Long id;
	User user;
	Book book;
	String bookIssuDate;
	
	String summiteDate;
	
	Long bookcharge;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="issuDate")
	public String getBookIssuDate() {
		return bookIssuDate;
	}
	public void setBookIssuDate(String bookIssuDate) {
		this.bookIssuDate = bookIssuDate;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Column(name="summiteDate")
	public String getSummiteDate() {
		return summiteDate;
	}
	public void setSummiteDate(String summiteDate) {
		this.summiteDate = summiteDate;
	}
	
	@Column(name="bookcharge")
	public Long getBookcharge() {
		return bookcharge;
	}
	public void setBookcharge(Long bookcharge) {
		this.bookcharge = bookcharge;
	}
	
	
	
	
}
