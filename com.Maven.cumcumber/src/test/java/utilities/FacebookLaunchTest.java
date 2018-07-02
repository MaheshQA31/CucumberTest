package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookLaunchTest {

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		System.setProperty("webdriver.firefox.marionette", "");
		
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}

	@Test
	public void launchFacebook() {

		driver.findElement(By.id("email")).sendKeys("mahesh.ram2121@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("mahesh@1234");
		driver.findElement(By.id("u_0_8")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
