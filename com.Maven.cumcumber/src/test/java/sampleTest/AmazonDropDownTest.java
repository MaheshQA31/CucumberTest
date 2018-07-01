package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonDropDownTest {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Test
	public void newToursLoginTest() throws InterruptedException {

		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		Thread.sleep(5);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		driver.findElement(By.className("nav-input")).click();
		
		String actTitle = "Amazon.in: harry potter: Books";
		String expTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle, "Gmail links is working properly");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
