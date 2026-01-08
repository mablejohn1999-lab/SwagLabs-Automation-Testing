package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
WebDriver driver;
	
	@FindBy(xpath="//div[@class='primary_header']/div[3]/a")
	WebElement carticon;
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement carttext;
	@FindBy(name="checkout")
	WebElement chkoutbtn;
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickcart() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement icon=wait.until(ExpectedConditions.elementToBeClickable(carticon));
		
		icon.click();
	
		
	}
	public String pageverification() {
		return driver.getCurrentUrl();
		
	}
	
	
	public String verifycartext() {
		
		return carttext.getText();
		
		
	
	}
	public void clickchkout() {
		chkoutbtn.click();
	}
	
	
	
}
