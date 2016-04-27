/**
 * 
 */
package com.wordpress.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.wordpress.Pages.*;
import com.worpress.SelectBrowser.*;



/**
 * @author lipika
 *
 */


public class verifyWordpressLogin {
	
	
	//variables for URL and Browser
	String Url ="https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F";
	String browserName ="firefox";
	WebDriver driver = null;
	
	//variables for input parameters
	String validUserId="chandra.lipika@gmail.com";
	String validPassword="sushant@84";
	String inValidUserId="chandrssa.lipika@gmail.com";
	String invalidPassword="sushant@8434";
	
	@BeforeMethod
	public void selectBrowser(){
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	// valid userid and password
	@Test
	public void verifyValidLogin(){	
				
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		String actualText = driver.findElement(By.xpath("//span[@class='masterbar__item-content']")).getText();
		Assert.assertEquals(actualText,"My Site");
		
		
	}
	
	// Invalid password
	@Test
	public void verifyInValidPasswordLogin(){		
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver=login.typeUsername(validUserId);
		driver=login.typePassword(invalidPassword);
		driver = login.clickLogin();
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		String actualText = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		Assert.assertTrue(actualText.contains("The password you entered for the email address"));
		
		//skipping a testcase
		throw new SkipException ("skipping the testcase");
	}
	
	// Invalid userid
	@Test
	public void verifyInValidUserIdLogin(){
		
		
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver=login.typeUsername(inValidUserId);
		driver=login.typePassword(validPassword);
		driver = login.clickLogin();
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		String actualText = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		Assert.assertTrue(actualText.contains("Invalid email address"));
		
		//Deliberately failing		
		Assert.fail("Failing the testcase deliberatly");
			
	}
	
	//logout
	@Test(dependsOnMethods={"verifyValidLogin"})
	public void verifyLogout(){
		
				
		// calling login page 	
		LoginPage login = new LoginPage(driver);
		driver =login.validLogin(validUserId,validPassword);
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		HomePage homePage= new HomePage(driver);
		driver=homePage.clickMeImage();
		driver=homePage.clickSignOut();
		String actualText = driver.findElement(By.xpath("//div/ul/li/a[@href='https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F']")).getText();
		Assert.assertEquals(actualText,"Sign In");
	}
	
	}