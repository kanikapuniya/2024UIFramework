package com.qa.opencart.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {
		System.out.println("---------acc setup method -----------");
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("---------account(driver) return kiya by loginpage -----------");
	}

	@Test(priority=2)
	public void accPageTitleTest() {
		String actAccPageTitle = accPage.getAccTitle();
		Assert.assertEquals(actAccPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority=1)
	public void accPageUrl() {
		String acrAccPageUrl = accPage.getAccPageUrl();
		Assert.assertEquals(acrAccPageUrl, AppConstants.ACCOUNTS_PAGE_URL_PARAMS);
	}

	@Test(priority=3)
	public void accPageLogoutButton() {
		Assert.assertTrue(accPage.isLogoutButtonPresent());
	}

	@Test(priority=4)
	public void accSearchBoxPresent() {
		Assert.assertTrue(accPage.isSearchBoxPresent());
	}

	@Test(priority=5)
	public void accHeadersPresent() {
		ArrayList<String> accHeaders = accPage.areAccHeadersPresent();
		System.out.println("headers are: " + accHeaders);
		Assert.assertEquals(accHeaders,AppConstants.ACCOUNTS_PAGE_HEADERS_LIST);
	}
	
	@Test(priority=6)
	public void isSearchBoxPresent() {
		Boolean value = accPage.isSearchBoxPresent();
		Assert.assertTrue(true);
	}
	
	@DataProvider
	public Object[][] getProductKey(){
		return new Object[][] {
			{"Macbook"},
			{"imac"},
			{"samsung"}
			};
		}
	
	@Test(dataProvider="getProductKey", priority=7)
	public void searchCheckTest(String productKey) {
		searchResults = accPage.searchPerform(productKey);
		System.out.println("searchResults is: "+ searchResults);
		Assert.assertTrue(searchResults.isSearchSuccessfull());
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Macbook", "MacBook Pro"},
			{"Macbook", "Macbook Air"},
			{"Samsung", "Samsung SyncMaster 941BW"},
			{"iMac", "iMac"}
		};
	}
	
	@Test(dataProvider="getProductData", priority=7)
	public void searchTest(String searchKey, String mainProductName) {
		searchResults = accPage.searchPerform(searchKey);
		if(searchResults.isSearchSuccessfull()) {
			productHeader = searchResults.selectProduct(mainProductName);
			String actualProductHeader = productHeader.getProductHeader(mainProductName);
			Assert.assertEquals(actualProductHeader, mainProductName);
			
		}
	}
}

