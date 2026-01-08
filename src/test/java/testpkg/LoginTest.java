package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;

public class LoginTest extends BaseClass{

	
	@Test(priority=1)
	public void login() throws Exception {
		test=extent.createTest("logintest");//to give heading for test results and to separate results of each test.java class you created
		loginpage.setUsername("standard_user");
		loginpage.setPassword("secret_sauce");
		loginpage.clickLogin();
		Thread.sleep(3000);
		
		
	}
}
