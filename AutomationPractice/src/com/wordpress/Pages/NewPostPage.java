package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewPostPage {
	WebDriver driver ;
	public NewPostPage(WebDriver driver ){
		this.driver=driver;
	}
	
	By newPostTitle = By.xpath("//input[@placeholder='Title']");
	By publishButton = By.className("editor-ground-control__publish-combo");
	By newPostBody=By.xpath(".//div/iframe[@id='tinymce-1_ifr']");
	By publishSuccess= By.cssSelector(".notice__text>span");
	
	
	public WebDriver typeTitle(String title){
		driver.findElement(newPostTitle).sendKeys(title);
		driver.findElement(newPostTitle).sendKeys(Keys.TAB);
		return driver;
	}
	
	public WebDriver typeNewPostBody(String body){
		driver.findElement(newPostBody).sendKeys(body);
		return driver;
	}
	
	public WebDriver clickPublishButton(){
		driver.findElement(publishButton).click();
		return driver;
	}
	public boolean publishSuccess(){
		return driver.findElement(publishSuccess).isDisplayed();
		
	}
	
}
