package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
   private WebDriver driver;
   private ElementUtil eleUtil;
	
	//by locator
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButon = By.xpath("//input[@value='Login']");
	By forgotPassword = By.xpath("(//a[contains(@href, \"/forgotten\")])[1]");
	
	
	// page constructor	
	
	public LoginPage(WebDriver driver) {
		System.out.println("---------driver uthaya -----------");
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//page actions
	public String getTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.LOGIN_PAGE_TITLE);
		System.out.println("login page title : " + title);
		return title;
	}
	
	public boolean getUrl() {
		String url = eleUtil.waitForUrlIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.LOGIN_PAGE_URL);
		System.out.println("the url is: " + url);
		if(url.contains(AppConstants.LOGIN_PAGE_URL_PARAMS)) {
			return true;
		}
		return false;
	}
	
	public boolean isForgotPWDLinkExist() {
		return eleUtil.doEleIsDisplayed(forgotPassword);
		
	}
	
	public AccountsPage doLogin(String username, String pswd) {
		
		//eleUtil.doSendKeysWithWait(email, AppConstants.DEFAULT_TIMEOUT, username);
		eleUtil.doSendKeys(email, username);
		eleUtil.doSendKeys(password, pswd);
		eleUtil.doClick(loginButon);
		
		return new AccountsPage(driver);
		
	}
}
