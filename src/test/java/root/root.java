package root;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class root {

	protected static AppiumDriver<WebElement> driver;

	public root() {
		super();
	}

	@BeforeClass
	public void Setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		// with Appium Server 1.4.16.1

		cap.setCapability("BROWSER_NAME", "Android");
		cap.setCapability("VERSION", "4.4.2");
		// I'm using the older supported Android version for testing
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability("AVD", "emulator");

		cap.setCapability("noReset", true);

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4444/wd/hub"), cap);
	}

	@AfterClass

	public void driverQuit() throws InterruptedException {
		driver.quit();

		Thread.sleep(2500);
	}
}