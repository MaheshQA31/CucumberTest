package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursLogin {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

	@Test
	public void newToursLoginTest(){
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}