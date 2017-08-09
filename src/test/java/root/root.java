package root;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.TakesScreenshot;

public class root {

	protected static AppiumDriver<WebElement> driver;
	String baseUrl;

	public root() {
		super();
	}

	@BeforeClass
	public void Setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		// with Appium Server 1.4.16.1

		cap.setCapability("BROWSER_NAME", "Android");
		cap.setCapability("VERSION", "4.4.2");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability("AVD", "emulator");

		cap.setCapability("noReset", true);

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4444/wd/hub"), cap);
	}

	@AfterMethod

	public void takeScreenShotOnFailure(ITestResult testResult)
			throws IOException, InterruptedException, ATUTestRecorderException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("misc/screenshots/", "Screenshot" + "_" + testResult.getStartMillis()
					+ "_" + testResult.getName() + "_" + Arrays.toString(testResult.getParameters()) + ".png"));
		}
	}

	public void restart() throws InterruptedException {

		driver.closeApp();
		driver.launchApp();

		Thread.sleep(1500);
	}

	@AfterClass

	public void driverQuit() throws InterruptedException {
		driver.quit();

		Thread.sleep(2500);
	}
}