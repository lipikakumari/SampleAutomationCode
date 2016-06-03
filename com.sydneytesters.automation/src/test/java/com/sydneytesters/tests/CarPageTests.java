package com.sydneytesters.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import com.sydneytesters.base.TestBaseSetup;
import com.sydneytesters.pageobjects.HerokuappBasePage;


public class CarPageTests extends TestBaseSetup{
	
	WebDriver driver = null;
	


	@BeforeClass
	public void setUp() {
		driver =getDriver();
	}
	
	//Testcase to get quote , happy path , input data is taken as parameters from TestNg.xml
	@Test
	 public void enterDetailsOfCar_getCarQuote()	{		
			new HerokuappBasePage(driver).clickGetCarQuote()
			.selectCarMake().enterYear().enterAge().selectGender().selectState().enterEmail()
			.clickGetQuote().verifyBuyInsuranceRendering();
	
	}

}
