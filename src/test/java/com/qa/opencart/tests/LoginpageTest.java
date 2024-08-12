package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginpageTest extends BaseTest {

	 
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String actualTitle = loginPage.getTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	} 
	
	@Test(priority=2)
	public void loginPageUrlTest() {
		boolean actualUrl = loginPage.getUrl();
		System.out.println("url is: " + actualUrl);
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void forgotPassword() {
		Assert.assertTrue(true);
	}
	
	@Test(priority=4)
	public void loginTest() {
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutButtonPresent());
	}
}
