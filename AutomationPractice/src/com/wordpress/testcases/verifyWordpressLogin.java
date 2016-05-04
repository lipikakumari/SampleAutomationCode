/**
 * 
 */
package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.wordpress.Data.WordpressData;
import com.wordpress.Pages.*;
import com.worpress.SelectBrowser.*;




/**
 * @author lipika
 *
 */


public class verifyWordpressLogin {
	
	
	//Getting variables for URL and Browser from class WordpressData
	WordpressData wordpressData = new WordpressData();	
	String Url =wordpressData.getUrl();
	String browserName =wordpressData.getBrowser();
	
	//Initializing  driver
	WebDriver driver = null;
	
	
	@BeforeMethod
	public void selectBrowser(){
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	@DataProvider
	public Object[][] loginData(){
		
		Object[][] loginData = new Object[1][2];
		loginData[0][0]=wordpressData.getvalidUserId();
		loginData[0][1]=wordpressData.getvalidPassword();
		return loginData;
	}
	
	// valid userid and password
	@Test(dataProvider="loginData")
	public void verifyValidLogin(String validUserId,String validPassword){	
				
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		//Test Assertion
		String actualText = driver.findElement(By.xpath("//span[@class='masterbar__item-content']")).getText();
		Assert.assertEquals(actualText,"My Site");
		
		
	}
	
	// Invalid password
	@Test (dataProvider="loginData")
	public void verifyInValidPasswordLogin(String validUserId,String validPassword){		
		
		//Invalid password
		String invalidPassword="Test@1234234";
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver=login.typeUsername(validUserId);
		driver=login.typePassword(invalidPassword);
		driver = login.clickLogin();
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		//Test Assertion
		String actualText = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		Assert.assertTrue(actualText.contains("The password you entered for the email address"));
		
		//deliberatly skipping a testcase
		throw new SkipException ("deliberatly skipping the testcase");
	}
	
	// Invalid userid
	@Test(dataProvider="loginData")
	public void verifyInValidUserIdLogin(String validUserId,String validPassword){
		
		//Invalid UserID
		String inValidUserId="chandrssa.lipika.tet@gmail.com";		
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver=login.typeUsername(inValidUserId);
		driver=login.typePassword(validPassword);
		driver = login.clickLogin();
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		//Test Assertion
		String actualText = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		Assert.assertTrue(actualText.contains("Invalid email address"));
		
		//Deliberately failing		
		Assert.fail("Failing the testcase deliberatly");
			
	}
	
	//logout
	@Test(dependsOnMethods={"verifyValidLogin"},dataProvider="loginData")
	public void verifyLogout(String validUserId,String validPassword){
		
				
		// calling login page 
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		//wait 20 second for page to load
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		// calling home page 
		HomePage homePage= new HomePage(driver);
		driver=homePage.clickMeImage();
		driver=homePage.clickSignOut();
		
		//Test Assertion
		String actualText = driver.findElement(By.xpath("//div/ul/li/a[@href='https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F']")).getText();
		Assert.assertEquals(actualText,"Sign In");
	}
	
	}
