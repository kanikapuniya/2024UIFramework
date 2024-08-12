package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.Driverfactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.productResultPage;
import com.qa.opencart.pages.searchResultsPage;

public class BaseTest {
	Driverfactory df;
	
	public WebDriver driver;
	public LoginPage loginPage;
	public Properties prop;
	public AccountsPage accPage;
	public searchResultsPage searchResults;
	public productResultPage productHeader;
	
	
	
	@BeforeTest
	public void setup() {
		
		System.out.println("1st step------- setup---driverfactory");
		
		df = new Driverfactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
