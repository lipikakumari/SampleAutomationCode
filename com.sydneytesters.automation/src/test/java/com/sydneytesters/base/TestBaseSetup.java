package com.sydneytesters.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {
	
	private WebDriver driver;
	static String driverPath = "/lib/chromedriver";

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		
		if(browserType.equals("chrome")){
			driver = initializeChromeDriver(appURL);
		}
		else if(browserType.equals("firefox")){
			driver = initializeFirefoxDriver(appURL);
		}
		else{
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initializeFirefoxDriver(appURL);
		}
		
	}

	

	private static WebDriver initializeChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+ driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initializeFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.navigate().to(appURL);		
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
