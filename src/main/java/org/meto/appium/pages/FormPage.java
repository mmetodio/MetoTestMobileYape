package org.meto.appium.pages;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.meto.appium.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.DefaultElementByBuilder;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		PageFactory.initElements(new AppiumElementLocatorFactory(initsesion, Duration.ofSeconds(1), new DefaultElementByBuilder(MobilePlatform.ANDROID, AutomationName.ANDROID_UIAUTOMATOR2)), this);
		PageFactory.initElements(new AppiumElementLocatorFactory(driver, Duration.ofSeconds(4000), new DefaultElementByBuilder(MobilePlatform.ANDROID, AutomationName.ANDROID_UIAUTOMATOR2)), this);

	}
		
	@AndroidFindBy(xpath="//android.view.View[@text='Flights']")
	private WebElement initsesion;
	
	
	@AndroidFindBy(xpath="//input[@id='username']")
	//@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
	private WebElement nameUser;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Contraseña']")
	private WebElement namePass;

	
	public FormPage setInitSesion()
	{
		initsesion.click();
		return this;
	}
	
	public FormPage setNameUser(String name) {
		nameUser.sendKeys(name);
		//driver.hideKeyboard();
		return this;
		
	}

	public FormPage setNamePass(String pass) {
		namePass.sendKeys(pass);
		return this;
	}

	

	
	
}
