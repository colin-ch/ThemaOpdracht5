package com.appspot.Accent.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.User;

public class JUnitUserTest {
	private String username;
	private String password;
	private String email;
	private User u;

	@Before
	public void setUp() throws Exception {
		username = "123";
		password = "123";
		email = "123@gmail.com";
		u = new User(username, password, email);
	}

	@Test
	public void testGetPassword() {
		if(u.getPassword() != null){
		}
		else{
			fail("Not yet implemented");
		}
	}

	@Test
	public void testSetPassword() {
		u.setPassword("1234");
		if(u.getPassword() != "1234"){
			fail("Not yet implemented");
		}
	}

	@Test
	public void testGetUsername() {
		if(u.getUsername() != null){
		}
		else{
			fail("Not yet implemented");
		}
	}

	@Test
	public void testSetUsername() {
		u.setUsername("12345");
		if(u.getUsername() != "12345"){
			fail("Not yet implemented");
		}
	}

	@Test
	public void testGetEmail() {
		if(u.getEmail() != null){
		}
		else{
			fail("Not yet implemented");
		}
	}

	@Test
	public void testSetEmail() {
		u.setEmail("1234@gmail.com");
		if(u.getEmail() != "1234@gmail.com"){
			fail("Not yet implemented");
		}
	}

}
