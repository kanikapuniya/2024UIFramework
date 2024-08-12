package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	By logout = By.linkText("Logout");
	By search = By.xpath("(//input[@name = \"search\"])[1]");
	By accHeaders = By.cssSelector("div#content h2");
	By searchIcon = By.xpath("//div[@id=\"search\"]//button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.ACCOUNTS_PAGE_TITLE);
		return title;
	}

	public String getAccPageUrl() {
		String url = eleUtil.waitForUrlIs(AppConstants.DEFAULT_TIMEOUT, AppConstants.ACCOUNTS_PAGE_URL_PARAMS);
		return url;
	}

	public Boolean isLogoutButtonPresent() {
		return driver.findElement(logout).isDisplayed();
	}

	public Boolean isSearchBoxPresent() {
		return eleUtil.doEleIsDisplayed(search);
	}
	
	public searchResultsPage searchPerform(String productName) {
		System.out.println("product name is : " + productName);
		//System.out.println("searchResults is: "+ searchResults);
		if(isSearchBoxPresent()) {
		eleUtil.doSendKeys(search, productName);
		eleUtil.doClick(searchIcon);
		return new searchResultsPage(driver);
	}
		else {
			System.out.println("search box is not present.");
			return null;
		}
	}

	public ArrayList<String> areAccHeadersPresent() {
		List<WebElement> listOfHeaders = eleUtil.waitForElementsVisible(accHeaders, AppConstants.DEFAULT_TIMEOUT);
    	//List<WebElement> listOfHeaders = driver.findElements(accHeaders);
    	ArrayList<String> actArrayList = new ArrayList<String>();
    	for(WebElement e: listOfHeaders) {
    		String actualHeaders = e.getText();
    		actArrayList.add(actualHeaders);
    	}
    	return actArrayList;
    }

}
