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

public class Root {

	protected static AppiumDriver<WebElement> driver;

	@BeforeClass
	public void Setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities(); // with Appium Server 1.4.16.1
		cap.setCapability("BROWSER_NAME", "Android");
		cap.setCapability("VERSION", "4.4.2");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability("AVD", "emulator");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4444/wd/hub"), cap);
	}

	@AfterMethod // do screenshot when test gone wrong - now I am using another tool - shutterbug
					// - i'll change this pretty soon
	public void takeScreenShotOnFailure(ITestResult testResult)
			throws IOException, InterruptedException, ATUTestRecorderException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("test-output/screenshots/", "Screenshot" + "_" + testResult.getStartMillis() + "_"
							+ testResult.getName() + "_" + Arrays.toString(testResult.getParameters()) + ".png"));
		}
		driver.closeApp();
		driver.launchApp();
	}

	@AfterClass
	public void driverQuit() throws InterruptedException {
		driver.quit();
	}
}