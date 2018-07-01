package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailLinksVerify {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void newToursLoginTest() {

		driver.findElement(By.linkText("Gmail")).click();
		String actTitle = "Gmail - Free Storage and Email from Google";
		String expTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle, "Gmail links is working properly");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
