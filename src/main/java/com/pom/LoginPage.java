package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	@FindBy(id = "email") private WebElement username;
	@FindBy(name = "pass") private WebElement password;
	@FindBy(id = "login") private WebElement login;
	public LoginPage(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1,this);
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	

}
