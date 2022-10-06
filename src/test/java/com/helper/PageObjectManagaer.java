package com.helper;

import org.openqa.selenium.WebDriver;

import com.pom.LoginPage;

public class PageObjectManagaer {
	public static WebDriver driver;
	private LoginPage lp;
//	private HomePage hp;
	

	public PageObjectManagaer(WebDriver driver2) {
		this.driver = driver2;
	}

	public LoginPage getLp() {
		lp = new LoginPage(driver);
		return lp;
	}
//	public HomePage getHp() {
//		Hp = new HomePage(driver);
//		return Hp;
//	}

}
