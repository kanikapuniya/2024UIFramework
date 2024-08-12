package com.qa.opencart.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final int DEFAULT_TIMEOUT = 5;
	public static final int DEFAULT_LARGE_TIMEOUT = 10;
	
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String LOGIN_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final String LOGIN_PAGE_URL_PARAMS = "?route=account/login";
	
	public static final String ACCOUNTS_PAGE_URL_PARAMS = "https://naveenautomationlabs.com/opencart/index.php?route=account/account";
	public static final List<String> ACCOUNTS_PAGE_HEADERS_LIST = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
}
