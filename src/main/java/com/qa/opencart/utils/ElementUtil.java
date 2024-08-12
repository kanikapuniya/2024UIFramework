package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	private Select select;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doEleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public ArrayList<String> getElementsTextList(By locator){
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			if(text.length()!=0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	//-----------------------wait -----------------------------------//
	public String waitForTitleIs(int timeout, String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		else return null;
		
	}
	
	public String waitForUrlIs(int timeout, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		else return null;
	}
	
	public String waitForUrlContains(int timeout, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlContains(urlValue))) {
			return driver.getCurrentUrl();
		}
		else return null;
	}
	
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void doSendKeysWithWait(By locator, int timeout, String value) {
		waitForElementPresence(locator, timeout).getText();
	}
	
	public WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	//------------------------Drop down utils------------------------//
	public void doSelectDropDownByIndex(By locator,int index) {
		select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectDropDownByVisibleText(By locator,String text) {
		select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectDropDownByValue(By locator, String value) {
		select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public List<WebElement> getDropDownOptions(By locator) {
		select = new Select(getElement(locator));
		return select.getOptions();
	}
	
	public int getDropDownOptionsCount(By locator) {
		return getDropDownOptions(locator).size();
		
	}
}
