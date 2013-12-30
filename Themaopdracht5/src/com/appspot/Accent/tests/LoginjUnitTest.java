/**
 * 
 */
package com.appspot.Accent.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * @author DiThomas
 *
 */
public class LoginjUnitTest {
	private Objectify ofy;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}



	
	@Test
	public void getUsernameTestCorrect(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertTrue(x.getUsername().equals("henk"));
	}
	
	@Test
	public void getUsernameTestFout(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertFalse(x.getUsername().equals("henki"));
	
	}
	
	@Test
	public void getUsernameTestHoofdletterGevoeligheid(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	
		assertFalse(x.getUsername().equals("Henk"));
	}
	
	@Test
	public void getUsernameTestSpaties(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	
		assertFalse(x.getUsername().equals("he nk"));
	}
	

	@Test
	public void getPasswordTestCorrect(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertTrue(x.getPassword().equals("test123"));
	}
	
	@Test
	public void getPasswordTestFout(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertFalse(x.getPassword().equals("test1234"));
	}
	
	@Test
	public void getPasswordTestHoofdletterGevoeligheid(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertFalse(x.getPassword().equals("Test123"));
	}
	@Test
	public void getPasswordTestSpaties(){
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling x = new Leerling("henk", "test123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );
	

		assertFalse(x.getPassword().equals("test 123"));
	}
	
//	@Test
//	public void getAllLeerlingenTest(){
//		ofy = ObjectifyService.begin();
//		LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
//		ArrayList<Leerling> leerlingen =   (ArrayList<Leerling>) lod.getAllLeerlingen();
//		assertTrue(leerlingen != null);
//
//		
//	}
	
}
