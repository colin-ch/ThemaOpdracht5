package com.appspot.Accent.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;

public class BeoordelenTest {


	@Test
	public void test() {
		CompetentieOfyDAOImpl c = new CompetentieOfyDAOImpl();
		LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		String wd = "123";
		int uniek = 53621;
		int stage = 1;
		
		if(c.getAllCompetenties() == null || l.getAllLeerlingen() == null){
			fail("Not yet implemented");
		}
		else{
		//	createStellingBeoordeeld(wd, uniek, stage);
		}
	}

}
