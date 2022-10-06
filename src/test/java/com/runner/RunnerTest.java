package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.helper.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/featurefile",
		glue = "com/stepdefinition",
		monochrome = true,
		stepNotifications = true,
		dryRun = false,
	//	publish = true
		plugin = //"pretty"
		       //  "usage"
		     //  "html:target/cucumber-report/facebook.html"
		       //  "json:target/cucumber-report/facebook.json"
		        //    "junit:target/cucumber-report/facebook.xml"
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		    
		
		
		)
public class RunnerTest {
	public static WebDriver driver;
	
	@BeforeClass
	public static  void launch() throws IOException {
		String browser = FileReaderManager.getInstance().getCrInstance().getBrowser();
        driver = BaseClass.setUp(browser);
	}
	
	@AfterClass
	public static  void tearDown() {
		driver.quit();

	}

}
