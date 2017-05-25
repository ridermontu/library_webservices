package com.library.vo;

import com.library.model.User;

public class Loginresponse {
  User user;
  String token;
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
}
