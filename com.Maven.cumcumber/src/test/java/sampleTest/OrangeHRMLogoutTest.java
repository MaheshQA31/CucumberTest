package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRMLogoutTest {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void testOnABSoft() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5);
		driver.findElement(By.linkText("Logout")).click();
		String expURL = "http://opensource.demo.orangehrmlive.com/index.php/auth/login";
		String actURL = driver.getCurrentUrl();

		Assert.assertEquals(expURL, actURL, "Both Url's are matching --- Successfully logedOut");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
