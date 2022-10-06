package com.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManagaer;
import com.pom.LoginPage;
//import com.runner.Runner;
import com.runner.RunnerTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {
	public static WebDriver driver= RunnerTest.driver;
	
//	LoginPage lp;
//	HomePage hp;
//	Search se;
	PageObjectManagaer pom = new PageObjectManagaer(driver);

	@Before
	
	public  void beforehook(Scenario scenario) {
		
            String name = scenario.getName();
            System.out.println(name);
	}
	
	@After
	public void afterhook(Scenario scenario) throws IOException {
		Status status = scenario.getStatus();
		System.out.println(status);
		if (scenario.isFailed()) {
			getscreenshot(scenario.getName());
		}
      
	}

	@Given("user launch the application")
	public void user_launch_the_application() throws IOException {
		
	//	getUrl("http://www.facebook.com");
		String address = FileReaderManager.getInstance().getCrInstance().getAddress();
		getUrl(address);
		System.out.println("www.facebook.com");
	}

	@When("user enter with below data")
	public void user_enter_with_below_data(DataTable dataTable) {	
		//lp=new LoginPage(driver);	
		List<Map<String, String>> asMaps = dataTable.asMaps(String.class, String.class);
		
		String username = asMaps.get(0).get("username");
		String password = asMaps.get(0).get("password");
		
	//	sendKey(lp.getUsername(), username);
	//	sendKey(lp.getPassword(), password);
		sendKey(pom.getLp().getUsername(), password);
		sendKey(pom.getLp().getPassword(), password);
		System.out.println(username);
		System.out.println(password);
	}

	@Then("user click login button")
	public void user_click_login_button() {
		//lp=new LoginPage(driver);
	//	directClick(lp.getLogin());
		directClick(pom.getLp().getLogin());
		System.out.println("success");
	}
}
