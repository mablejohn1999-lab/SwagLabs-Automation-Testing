package testpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.BaseClass;

public class CartTest extends BaseClass {

	@Test(priority=3)
	public void carttest() throws Exception {
		test=extent.createTest("carttest");
		cartpage.clickcart();
		//String actual=cartpage.pageverification();
		//System.out.println(actual);
		//Assert.assertTrue(actual.contains("cart"),"not true");
		
		String actualtext=cartpage.verifycartext();
		Assert.assertEquals(actualtext,"Your Cart");
		cartpage.clickchkout();
	}
	
}
