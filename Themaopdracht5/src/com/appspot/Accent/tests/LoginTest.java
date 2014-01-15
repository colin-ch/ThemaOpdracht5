package com.appspot.Accent.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class LoginTest{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//TestData t = new TestData();
		//t.aanmaken();
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
		
	}

	@Test
	public void simpelLogintest() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "abc");
		selenium.type("name=password", "abc");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Dashboard I Admin Panel".equals(selenium.getTitle()));
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}
	@Test
	public void spatieLoginTest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "abc abc");
		selenium.type("name=password", "abcd");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Dashboard I Admin Panel".equals(selenium.getTitle()));
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}
	@Test
	public void aanhalingstekenLogintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "abc\"abc");
		selenium.type("name=password", "abcde");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Dashboard I Admin Panel".equals(selenium.getTitle()));
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}
	@Test
	public void spatie2Logintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", " abc");
		selenium.type("name=password", "abcdef");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Dashboard I Admin Panel".equals(selenium.getTitle()));
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}
	@Test
	public void uitroeptekenLogintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "cb!a");
		selenium.type("name=password", "cba");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Dashboard I Admin Panel".equals(selenium.getTitle()));
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}
	@Test
	public void foutwwLogintest() throws Exception{
		selenium.open("/LogoutServlet.do");
		selenium.type("name=username", "abc");
		selenium.type("name=password", "qwerty");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Login".equals(selenium.getTitle()));
	}

	@Test
	public void foutnameLogintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "qwerty");
		selenium.type("name=password", "abc");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Login".equals(selenium.getTitle()));
	}
	@Test
	public void hoofdletternaamLogintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "ABC");
		selenium.type("name=password", "abc");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Login".equals(selenium.getTitle()));
	}
	@Test
	public void hoofdletterwLogintest() throws Exception{
		selenium.open("/");
		selenium.type("name=username", "abc");
		selenium.type("name=password", "ABC");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue("Login".equals(selenium.getTitle()));
	}
	

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}




