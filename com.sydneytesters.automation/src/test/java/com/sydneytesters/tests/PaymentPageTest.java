package com.sydneytesters.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sydneytesters.base.TestBaseSetup;
import com.sydneytesters.pageobjects.HerokuappBasePage;

public class PaymentPageTest extends TestBaseSetup{

	WebDriver driver = null;
	
	@BeforeClass
	public void setUp() {
		driver =getDriver();
	}
	
	
	/*	Testcase to buy insurance , happy path 	 	
	 Assumption : Payment under 50 dollars is not accepted , in order to make the payment success 
	 input values in getquote function should result in a quote of more than 50 dollars  */
	
	@Test
	 public void getCarQuote_buyInsurance(){	
		
		new HerokuappBasePage(driver).clickGetCarQuote().selectCarMake().enterYear().enterAge()
		.selectGender().selectState().enterEmail().clickGetQuote()
		.clickBuyInsurance().enterNameOnCard().enterEmailUsrname().enterPassword().enterCardNumber()
		.enterCardExpMonth().enterCardExpYear().enterCardCVV()
		.clickPayNow().verifySuccessPayMessage();
			
	}
}
