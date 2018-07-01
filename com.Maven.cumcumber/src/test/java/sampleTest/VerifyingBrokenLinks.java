package sampleTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyingBrokenLinks {

	static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.firefox.marionette", "");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@Test
	public void authenticationWind() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links availabele is: " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLinkActivate(url);
		}

	}

	public static void verifyLinkActivate(String linkUrl) {

		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(linkUrl + " -- " + httpURLConnection.getResponseMessage());
			} else if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " -- " + httpURLConnection.getResponseMessage() + " "
						+ httpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e2) {

			e2.printStackTrace();
		}
	}

	@AfterTest
	public void terminateBrowser() {

		driver.close();

	}

}