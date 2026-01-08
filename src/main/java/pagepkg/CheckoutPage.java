package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement checkouttext;
	@FindBy(name="firstName")
	WebElement firstname;
	@FindBy(name="lastName")
	WebElement lastname;
	@FindBy(name="postalCode")
	WebElement pcode;
	
	@FindBy(name="continue")
	WebElement continuebtn;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishbtn;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement backhomebtn;
	
	@FindBy(id="react-burger-menu-btn")
	WebElement hamburgermenu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutext() {
		return checkouttext.getText();
		
	}
	public void setdetails(String fname,String lname,String postalcode) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		pcode.sendKeys(postalcode);
		
	}
	public void clickcontinue() {
		continuebtn.click();
	}
	public void clickfinish() {
		finishbtn.click();
	}
	public void clickbackhome() {
		backhomebtn.click();
	}
	public void clickhamburger() {
		hamburgermenu.click();
	}
	public void clicklogout() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement logotbtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout_sidebar_link']")));
		logotbtn.click();
	}
}
