package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
    
	public WebDriver driver;
	public Properties prop;
    /**
     * this method is to initialise the driver
     * @param browserName
     * @return the driver
     */
	
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").toLowerCase();
		
		if(browserName.equals("chrome")) {
			//WebDriverManager.chromedriver().clearDriverCache().setup();
			//WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			
		    driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		else if(browserName.equals("safari")) {
		    driver = new SafariDriver();
		}
		else {
			System.out.println("please check your browser name again: " +browserName );
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	
	public Properties initProp() {
	    prop = new Properties();
		
		try {
			FileInputStream file = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
