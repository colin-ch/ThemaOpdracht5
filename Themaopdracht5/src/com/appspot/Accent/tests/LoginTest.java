package com.appspot.Accent.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class LoginTest{
	private Selenium selenium;
	private Objectify ofy;

	@Before
	public void setUp() throws Exception {
		LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
		ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) lod.getAllLeerlingen();
		Leerling l1 = new Leerling("123username", "123pass", null, null, null, null, null, null);
		ObjectifyService.register(Leerling.class);
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://project-omega.appspot.com/");
		selenium.start();
		if(leerlingen != null){
		for(Leerling l : leerlingen){
			if(l.getUsername().equals(l1.getUsername()) && l.getPassword().equals(l1.getPassword())){
			}
			else{
				ofy.put(l1);
			}
		}
		}
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




