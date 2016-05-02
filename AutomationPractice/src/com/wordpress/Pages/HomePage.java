package com.wordpress.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver ;
	public HomePage(WebDriver driver ){
		this.driver=driver;
	}
	
	By createPost = By.xpath("//div/header/a[@title='Create a New Post']");
	By meImage = By.xpath("//div/header[@id ='header']/a[4]");
	By signOut = By.xpath("//ul/div/button[@title='Sign out of WordPress.com']");
	
	
	
	public WebDriver clickCreatePost(){
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.findElement(createPost).click();
		return driver;
		
	}
	public WebDriver clickMeImage(){
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.findElement(meImage).click();
		return driver;
		
	}
	public WebDriver clickSignOut(){
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.findElement(signOut).click();
		return driver;		
	}
}
