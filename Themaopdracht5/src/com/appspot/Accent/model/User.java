package com.appspot.Accent.model;

public class User {
	private String username;
	private String password;
	private String email;
	
	public User(String us, String pw, String em){
		username = us;
		password = pw;
		email = em;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
