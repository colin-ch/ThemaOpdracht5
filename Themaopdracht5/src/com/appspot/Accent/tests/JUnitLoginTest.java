public class JUnitLoginTest {
	
	@Before
	public void setup(){
		ArrayList<User> allUsers = new ArrayList<User>();
		allUsers = (ArrayList<User>) getServletContext().getAttribute("users");
	}
	
	// testcase inloggen A1.1/A1.2
	@Test
	public void testLoginSucces() {
		User u = new User("123", "123", "123@gmail.com");
		boolean loginsucces = false;
		try {
			for (User us : allUsers) {
				if (u.equals(us)) {
					loginsucces = true;
				}
			}
		} catch (Exception e) {
			fail("Onjuiste gebruikersnaam/wachtwoord combinatie");
		}

	}
	@Test(expected=Exception)
	public void testLoginFail() {
		User u = new User("564675", "123", "123@gmail.com");
		boolean loginsucces = false;
		try {
			for (User us : allUsers) {
				if (u.equals(us)) {
					loginsucces = true;
				}
			}
		} catch (Exception e) {
			fail("Onjuiste gebruikersnaam/wachtwoord combinatie");
		}

	}

}