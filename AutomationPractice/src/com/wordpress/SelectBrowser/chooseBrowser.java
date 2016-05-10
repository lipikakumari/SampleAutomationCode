package com.wordpress.SelectBrowser;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class chooseBrowser {

	WebDriver driver ;
	
	public chooseBrowser(WebDriver driver){
		this.driver= driver;
	}
	
	public WebDriver userBrowser ( String browserName , String URL ){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			//It create firefox profile
			FirefoxProfile profile=new FirefoxProfile();			 
			// This will set the true value
			profile.setAcceptUntrustedCertificates(true);
			
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "/home/lipika/work/chromedriver");
			driver = new ChromeDriver(cap);			
		}
		else{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
	}

	
}
