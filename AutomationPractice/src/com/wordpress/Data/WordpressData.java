package com.wordpress.Data;

public class WordpressData {
	
	String Url ="https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F";
	String browserName ="chrome";
	String validUserId="chandra.lipika.test@gmail.com";
	String validPassword ="Test@1234";
	
	//Url for secure site
	//String Url ="https://www.cacert.org/";

	public String getUrl(){
		return Url;
	}
	
	public String getBrowser(){
		return browserName;
	}
	public String getvalidUserId(){
		return validUserId;
	}
	
	public String getvalidPassword(){
		return validPassword;
	}


}
