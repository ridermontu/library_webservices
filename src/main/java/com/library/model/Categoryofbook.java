package com.library.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="categoryofbook")
public class Categoryofbook {
	
	private long id;
	private String categorytype;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	@Column(name="categorytype")
	public String getCategorytype() {
		return categorytype;
	}
	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}
	
	
	
}