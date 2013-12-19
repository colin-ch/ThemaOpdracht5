package com.appspot.Accent.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class LoginTest{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "123");
		selenium.type("name=password", "123");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertEquals("Dashboard I Admin Panel", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}




