package pagepkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
WebDriver driver;
	
	@FindBy(xpath="//div[@class='header_label']/div")
	WebElement homeheader;
	@FindBy(xpath="//*[@id='header_container']/div[2]/div/span/select")
	WebElement dropdown;
	
	@FindBy(xpath="//button[@iclass='btn btn_primary btn_small btn_inventory  ']")
	WebElement products;
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement carticon;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String verifyHeaderText() {
		return homeheader.getText();
	}
	public void setDropdown(String value) {
		Select s=new Select(dropdown);
		s.selectByValue(value);
	}
	public String verifyTitle() {
		return driver.getTitle();
		
	}
	public void selectProducts() {
		List<WebElement> products=driver.findElements(By.xpath("//button[@iclass='btn btn_primary btn_small btn_inventory  ']"));
		for(WebElement product:products) {
			product.click();
		}
	}
	//public void clickcart() {
		
			//carticon.click();
			
			
		//}
}
