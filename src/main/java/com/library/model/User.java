package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	
 private	Long  id;
 
 @NotNull(message = "firstname is requird")
 
 private String firstName;
 
 @NotNull(message = "lastName is requird")
 
 private String lastName;
 
 @NotNull(message = "email is requird")
 private String email;
 @NotNull(message = "mobile is requird")
 private String mobile;
 @NotNull(message = "password is requird")
 private String password ;
 
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

 public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


@Column(name="firstname")
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

@Column(name="lastname")
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Column(name="email")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Column(name="mobile")
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}

@Column(name="password")
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}