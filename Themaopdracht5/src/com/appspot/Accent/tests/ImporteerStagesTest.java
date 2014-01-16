package com.appspot.Accent.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ImporteerStagesTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testImporteren() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "stage");
		selenium.type("name=password", "begeleider");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		
		selenium.click("link=Beheerders pagina");
		selenium.waitForPageToLoad("30000");
		selenium.type("xpath=(//input[@name='bestand'])[2]", "C:\\Users\\Wouter\\Desktop\\bestand1.csv");
		selenium.click("//input[@value='Importeer stages met CSV']");
		selenium.waitForPageToLoad("30000");
		
		selenium.click("link=Beheerders pagina");
		selenium.waitForPageToLoad("30000");
		selenium.type("xpath=(//input[@name='bestand'])[2]", "C:\\Users\\Wouter\\Desktop\\bestand2.csv");
		selenium.click("//input[@value='Importeer stages met CSV']");
		selenium.waitForPageToLoad("30000");
		
		selenium.click("link=Beheerders pagina");
		selenium.waitForPageToLoad("30000");
		selenium.type("xpath=(//input[@name='bestand'])[2]", "C:\\Users\\Wouter\\Desktop\\bestand3.csv");
		selenium.click("//input[@value='Importeer stages met CSV']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
