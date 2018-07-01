package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookLogin {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Test
	public void facebookLoginTest() {

		driver.findElement(By.id("email")).sendKeys("ram.mahesh1234@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("mahesh@12345");
		driver.findElement(By.id("u_0_2")).click();

		String actTitle = "Log in to Facebook | Facebook";
		String expTitle = driver.getTitle();

		Assert.assertEquals(actTitle, expTitle, "Title verified succssfully");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
