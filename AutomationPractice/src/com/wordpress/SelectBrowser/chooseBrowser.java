package com.wordpress.SelectBrowser;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class chooseBrowser {

	WebDriver driver ;
	
	public chooseBrowser(WebDriver driver){
		this.driver= driver;
	}
	
	public WebDriver userBrowser ( String browserName , String URL ){
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/lipika/work/chromedriver");
			driver = new ChromeDriver();			
		}
		else{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
	}

	
}
