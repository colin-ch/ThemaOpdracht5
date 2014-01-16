package com.appspot.Accent.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class StellingWijzigenTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testStellingWijzigen() throws Exception {
		selenium.open("/LogoutServlet.do");
		selenium.type("name=username", "stage");
		selenium.type("name=password", "begeleider");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Competenties bekijken");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
