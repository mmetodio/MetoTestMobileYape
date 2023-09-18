package org.meto.appium.tests;

import java.lang.reflect.Method;

import org.meto.appium.base.TestBase;
import org.meto.appium.pages.FormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TFLogin extends TestBase{
	FormPage formPage;
//	FormProspect formProspect;
//	FormCustomer formCustomer;
	
	@BeforeMethod
	public void beforeMethod(Method method) {

		formPage = new FormPage(driver);
	//	formProspect = new FormProspect(driver);

		
	}
	
	@Test
	public void FillForm() throws InterruptedException{

		formPage.setInitSesion();
		formPage.setNameUser("valerio.oropeza@gmail.com");
	//	formPage.setNamePass("Surgir.2026");
		
	}
	
	
	
	
	

	
}
