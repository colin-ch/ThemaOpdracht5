package com.appspot.Accent.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class StageAanmakenTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testStageAanmaken() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "stage");
		selenium.type("name=password", "begeleider");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Beheerders pagina");
		selenium.waitForPageToLoad("30000");
		selenium.click("//button[@onclick=\"window.location.href='StageAanmaken.jsp';\"]");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=leerlingen", "Rick");
		selenium.type("name=begeleiders", "123@gmail.com");
		selenium.type("name=opleider", "daan");
		selenium.type("name=bedrijf", "bedrijf1");
		selenium.type("name=begin", "11-01-14");
		selenium.type("name=einde", "11-04-14");
		selenium.click("name=stage");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
