package com.appspot.Accent.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class BeoordelingAanmakenTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
	}

	@Test
	public void testBeoordelingAanmakentesten() throws Exception {
		selenium.open("/");
		selenium.type("name=username", "stage");
		selenium.type("name=password", "begeleider");
		selenium.click("css=input.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=li.icn_new_article > a");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=leerlingen", "Kevin van Bijsteren");
		selenium.click("name=initStage");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=stages", "40");
		selenium.click("name=create");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=1");
		selenium.click("name=2");
		selenium.click("name=radio1");
		selenium.click("name=radio2");
		selenium.click("name=save");
		selenium.waitForPageToLoad("30000");
		assertEquals("U heeft succesvol een beoordeling gemaakt.", selenium.getText("//section[@id='main']/h4[3]"));
		selenium.click("css=li.icn_new_article > a");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=leerlingen", "Michelle  Klop");
		selenium.click("name=initStage");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=stages", "711");
		selenium.click("name=create");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=1");
		selenium.click("name=2");
		selenium.click("name=radio1");
		selenium.click("name=save");
		selenium.waitForPageToLoad("30000");
		assertFalse("U heeft succesvol een beoordeling gemaakt.".equals(selenium.getText("//section[@id='main']/h4[3]")));
		selenium.click("css=li.icn_new_article > a");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=leerlingen", "Mirelle  Beekhuis");
		selenium.click("name=initStage");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=stages", "40");
		selenium.click("name=create");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=1");
		selenium.click("name=radio1");
		selenium.click("name=save");
		selenium.waitForPageToLoad("30000");
		assertEquals("U heeft succesvol een beoordeling gemaakt.", selenium.getText("//section[@id='main']/h4[3]"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
