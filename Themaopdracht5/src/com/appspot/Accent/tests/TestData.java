package com.appspot.Accent.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class TestData {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testTestdata() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "123");
		selenium.type("name=password", "123");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Beheerders pagina");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=button");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=username", "abc");
		selenium.type("name=wachtwoord", "abc");
		selenium.type("name=email", "123@gmail.com");
		selenium.type("name=klas", "1");
		selenium.type("name=begeleiders", "123@gmail.com");
		selenium.type("name=gebdat", "11-11-13");
		selenium.type("name=roepnaam", "1");
		selenium.type("name=achternaam", "1");
		selenium.click("name=leerling");
		selenium.waitForPageToLoad("30000");
		
		
		
		selenium.click("link=Loguit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
