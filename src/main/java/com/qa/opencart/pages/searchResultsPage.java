package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class searchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productSearchLayout = By.cssSelector("div.product-layout");
	
	
	public searchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public boolean isSearchSuccessfull() {
		List<WebElement> searchList = eleUtil.waitForElementsVisible(productSearchLayout, AppConstants.DEFAULT_LARGE_TIMEOUT);
		if(searchList.size()>0) {
			System.out.println("search is successfully done");
			return true;
		}
		return false;
	}
	
	public productResultPage selectProduct(String mainProductName) {
		By product = By.linkText(mainProductName);
		eleUtil.doClick(product);
		return new productResultPage(driver);
	}
	

}
