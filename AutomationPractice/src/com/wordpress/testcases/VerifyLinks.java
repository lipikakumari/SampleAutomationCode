package com.wordpress.testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.Data.WordpressData;
import com.wordpress.SelectBrowser.chooseBrowser;

public class VerifyLinks {
	
	//Getting variables for URL and Browser from class WordpressData
	WordpressData wordpressData = new WordpressData();	
	String Url =wordpressData.getUrl();
	String browserName =wordpressData.getBrowser();
	
	//Initializing  driver
	WebDriver driver = null;
		
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	@DataProvider
	public Object[][] linksData(){
		
		chooseBrowser browserSelect = new chooseBrowser(driver);
		driver = browserSelect.userBrowser(browserName ,Url);
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());	
		
		Object[][] linkData = new Object[links.size()][1];
				 
		 for(int i=0;i<links.size();i++)
		 {		 
			 WebElement ele= links.get(i);		 
			 String linkUrl= ele.getAttribute("href");		 
			 driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);				 
			 linkData[i][0]=linkUrl;		 
			 
		 }
		 
		return linkData;
	}

	
	@Test(dataProvider="linksData")
	 public void verifyLink(String linkUrl)
	 {
	        try 
	        {
	           URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();   
	                
	           if(httpURLConnect.getResponseCode()==200){
	        	   
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());  
	               
	            }
	           else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  {
	        	   
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	               
	            }
	           else{
	        	   
	        	   System.out.println(linkUrl+" - "+httpURLConnect.getResponseCode()+" - "+httpURLConnect.getResponseMessage());
	        	
	           }
	           
	           Assert.assertTrue(199 < httpURLConnect.getResponseCode() 
	        		   & httpURLConnect.getResponseCode() < 400);
	        } catch (Exception e) {
	           System.out.println(e);
	        }
	      
	 } 
	 
}
