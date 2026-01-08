package testpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.BaseClass;

public class HomeTest extends BaseClass {

	@Test(priority=2)
	public void homepagetest() throws Exception {
		test=extent.createTest("hometest");
		String actualheadertext=homepage.verifyHeaderText();
		String expected="Swag Labs";
		Assert.assertEquals(actualheadertext, expected);
		homepage.setDropdown("lohi");
		String actualtitle=homepage.verifyTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle,"Swag Labs");
		homepage.selectProducts();
		
		//homepage.clickcart();
		
		
	}
}
