package com.appspot.Accent.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.service.DocentOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageBedrijfOfyDAOImpl;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
//imports van de JUnit test
public class JUnitLoginTest {
	private final LocalServiceTestHelper helper =
	        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	    @Before
	    public void setUp() {
	        helper.setUp();
	    }

	    @After
	    public void tearDown() {
	        helper.tearDown();
	    }
	

	    @Test
		public void testLoginSucces() {
		Objectify ofy = ObjectifyService.begin();
		ObjectifyService.register(Leerling.class);
		LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();
		//Dao klassen worden hiermee beschikbaar binnen de test
		//ofy.put(new Leerling( "123",  "123",  null, null, null, null, null, null));
		System.out.println("1");
		Object o = l.getAllLeerlingen();
		System.out.println("2");
		
		
		/*try {

			if (l.getAllLeerlingen() == null || d.getAllDocenten() == null || sb.getAllStageBedrijven() == null || 
					sbg.getAllBegeleiders() == null) {
				fail("Methode klopt niet");//Kijken of alle lijsten uit de datastore niet null zijn
			}
			else{ //getUsername() en getPassword() voor alle gebruikers
				for(Leerling le : l.getAllLeerlingen()){
					if(le.getUsername() == null || le.getPassword() == null){
						fail("Leerling is null");
					}
				}
				for(Docent de : d.getAllDocenten()){
					if(de.getUsername() == null || de.getPassword() == null){
						fail("Docent is null");
					}
				}
				for(StageBedrijf sbe : sb.getAllStageBedrijven()){
					if(sbe.getUsername() == null || sbe.getPassword() == null){
						fail("Stagebedrijf is null");
					}
				}
				for(StageBegeleider stb: sbg.getAllBegeleiders()){
					if(stb.getUsername() == null || stb.getPassword() == null){
						fail("Begeleider is null");
					}
				}
			}
		} 
		catch (Exception e) {
			fail("Exception login");
		}*/

	}

}

