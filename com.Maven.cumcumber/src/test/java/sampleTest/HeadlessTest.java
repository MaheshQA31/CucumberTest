package sampleTest;

import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class HeadlessTest {

	@Test
	public void headLessTest() {
		ProfilesIni pr = new ProfilesIni();
		System.setProperty("phontomjs.binary.path", "");
		PhantomJSDriver driver = new PhantomJSDriver();
		driver.get("http://google.com");

	}
}
