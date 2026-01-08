package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(name="user-name")
	WebElement usernamefield;
	
	@FindBy(name="password")
	WebElement passwrdfield;
	
	@FindBy(name="login-button")
	WebElement loginbtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String un) {
		usernamefield.sendKeys(un);
		
	}
	public void setPassword(String pswd) {
		passwrdfield.sendKeys(pswd);
		
	}
	public void clickLogin() throws Exception {
		loginbtn.click();
		
		
	}
	
	
	
	
}
