package basepkg;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pagepkg.CartPage;
import pagepkg.CheckoutPage;
import pagepkg.HomePage;
import pagepkg.LoginPage;

public class BaseClass {
public static WebDriver driver;
public LoginPage loginpage;
public HomePage homepage;
public CartPage cartpage;
public CheckoutPage chkoutpage;


public static ExtentSparkReporter reporter;
public static ExtentTest test;
public static ExtentReports extent;

@BeforeTest
public void setup() {
	reporter=new ExtentSparkReporter("./Reports/report.html");//where do u want ur reportsand what name do u want is set here
	reporter.config().setDocumentTitle("Automation report");
	reporter.config().setReportName("Functional Test");
	reporter.config().setTheme(Theme.DARK);
	extent=new ExtentReports();
	extent.attachReporter(reporter);//attaching the report
	extent.setSystemInfo("hostname","localhost");
	extent.setSystemInfo("os" ,"windows");
	extent.setSystemInfo("testername", "abc");
	extent.setSystemInfo("browsername", "chrome");
	driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
}

@BeforeMethod
public void beforemethod(Method method) {
	loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	cartpage=new CartPage(driver);
	chkoutpage=new CheckoutPage(driver);
	test=extent.createTest(method.getName());
}

@AfterMethod
public void aftermethod(ITestResult result) throws Exception
{
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(Status.FAIL,"test case failed is"+result.getName());
		test.log(Status.FAIL,"test case failed is"+result.getThrowable());
		String screenshotpath=screenshotMethod(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
		
	}else if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP,"test case skipped is"+result.getName());
}else {
	
test.log(Status.PASS,"test case passed is"+result.getName());
	
}
}

public static String screenshotMethod(WebDriver driver,String screenshotname) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	String destination="./Screenshots/"+screenshotname+".jpeg";
	FileHandler.copy(src, new File(destination));
	return destination;
	
}


@AfterTest
public void aftertest() {
	extent.flush();//this should be given to get reports
}
}
