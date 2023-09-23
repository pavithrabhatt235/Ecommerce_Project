package application.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import application.pages.HomePage;

public class BaseClass {
 public WebDriver driver;
 public HomePage homepage;

	@BeforeMethod
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://automationexercise.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage=new HomePage(driver);
		homepage.verifyHomePageIsVisible();
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
