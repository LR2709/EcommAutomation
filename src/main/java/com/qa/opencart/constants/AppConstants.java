package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String CONFIG_FILE_PATH = "./src/test/resources/config.properties";
	public static final String QA_FILE_PATH = "./src/test/resources/qa.properties";
	public static final String DEV_FILE_PATH = "./src/test/resources/dev.properties";
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String LOGIN_PAGE_PARTIAL_URL = "route=account/login";
	public static final List<String> ACCPAGE_HEADER_LIST = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	public static final String ACC_PARTIAL_URL = "route=account/account12";
	public static final String PRODUCT_PAGE_PARTIAL_URL ="route=product/product";
	public static final String SEARCH_PAGE_PARTIAL_URL ="route=product/search";
	public static final String SEARCH_RESULT_PAGE_HEADER= "Products meeting the search criteria";
	public static final CharSequence USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
		
	}
