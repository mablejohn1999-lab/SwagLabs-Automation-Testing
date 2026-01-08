package testpkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.BaseClass;

public class CheckoutTest extends BaseClass {

	@Test(priority=4)
	public void checkouttest() {
		test=extent.createTest("checkouttest");
		String actualtext=chkoutpage.verifycheckoutext();
		Assert.assertEquals(actualtext,"Checkout: Your Information");
		chkoutpage.setdetails("Mable", "rose", "3455");
		chkoutpage.clickcontinue();
		chkoutpage.clickfinish();
		chkoutpage.clickbackhome();
		chkoutpage.clickhamburger();
		chkoutpage.clicklogout();
	}
}
