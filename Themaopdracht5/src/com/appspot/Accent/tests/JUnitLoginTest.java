package com.appspot.Accent.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.User;

public class JUnitLoginTest {

	// testcase inloggen A1.1
	@Test
	public void testLoginSucces() {
		ArrayList<User> allUsers = new ArrayList<User>();
		User user = new User("123","123","123@gmail.com");
		allUsers.add(user);
		User u = new User("123", "123", "123@gmail.com");

		try {
			for (User us : allUsers) {
				if (u.equals(us)) {
				}
				else{
					fail("gebruiker niet bekend");
				}
			}
		} catch (Exception e) {
			fail("Onjuiste gebruikersnaam/wachtwoord combinatie");
		}

	}
	// testcase inloggen A1.2
	@Test
	public void testLoginFail() {
		ArrayList<User> allUsers = new ArrayList<User>();
		User user = new User("123","123","123@gmail.com");
		allUsers.add(user);
		User u = new User("564675", "123", "123@gmail.com");

		try {
			for (User us : allUsers) {
				if (u.equals(us)) {
					fail("Deze gebruiker is bekend");
				}
			}
		} catch (Exception e) {
			fail("Onjuiste gebruikersnaam/wachtwoord combinatie");
		}

	}

}