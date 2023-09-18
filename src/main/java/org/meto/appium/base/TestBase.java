package org.meto.appium.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import javax.lang.model.element.Element;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.app.SupportsAppWaitActivityOption;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.opentelemetry.context.Context;

import org.meto.appium.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase extends AppiumUtils{

	 public static  AndroidDriver driver;
	 public AppiumDriverLocalService service;
	
	@SuppressWarnings("hiding")
	@BeforeSuite
	public static <MobileElement> void setup(ITestContext testContext) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c",false));
		
	//	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), cap);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), cap);
		
		driver.get("https://www.booking.com");
	//	((SupportsAppWaitActivityOption<UiAutomator2Options>) cap).setAppWaitActivity("booking.com"); //new
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
	}
	


	@AfterSuite
	public void teardown() {
		 driver.quit();
		
		 
	}

}
