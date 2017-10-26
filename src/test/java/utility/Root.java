package utility;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Root {

	protected static AppiumDriver<WebElement> driver;

	@BeforeMethod
	public void driverSetup() throws InterruptedException, IOException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("BROWSER_NAME", "Android");
		cap.setCapability("VERSION", "4.4.2");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability("APP_ACTIVITY", "com.adobe.creativesdk.aviary.AdobeImageEditorActivity");
		cap.setCapability("AVD", "emulator");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4444/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
	}
}