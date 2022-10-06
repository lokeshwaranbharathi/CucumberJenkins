package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public  static WebDriver driver;
	
	public static WebDriver setUp(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
		//		System.setProperty("webdriver.chrome.driver",
		//				"C:\\Users\\lokeshwaran\\eclipse-workspace\\FacebookProject\\Driver\\chromedriver.exe");
			 WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
}
			else if (browserName.equalsIgnoreCase("gecko")) {
		//	System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
				 WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				
			}
			else {
				System.out.println("Invalid Browser");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
	public static void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	public static void sendKey(WebElement element, String value) {

		element.sendKeys(value);

	}
	public static void directClick(WebElement element) {

		element.click();

	}
	public static void id(String value) {
		driver.findElement(By.id(value));

	}

	public static void name(String value) {
		driver.findElement(By.name(value));

	}

	public static void xpath(String value) {
		driver.findElement(By.xpath(value));

	}
	
	public static void getscreenshot(String filename) throws IOException {

		 try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			 File sourcefile = ts.getScreenshotAs(OutputType.FILE);
			 File destinationfile = new File(System.getProperty("user.dir")+"\\test-output"+ filename + ".png");
			 FileUtils.copyFile(sourcefile, destinationfile);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
