package sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchChrome {

	WebDriver driver;

	@Test
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SeleniumAutomationTopics\\ALL JARS\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
	}
}
