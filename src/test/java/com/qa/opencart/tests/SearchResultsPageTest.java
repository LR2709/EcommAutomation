package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

public class SearchResultsPageTest extends BaseTest {

	@BeforeClass
	public void preSetup() 
	{
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = ap.doSearch("imac");
	}

	@Test
	public void getSearchPageURLTest() {

		String url = searchpage.getSearchPageURL();
		Assert.assertTrue(url.contains(AppConstants.SEARCH_PAGE_PARTIAL_URL), AppError.URL_NOT_EXIST);
	}

	@Test
	public void searchProductNameTest()
	{
		String header = searchpage.searchResultPageHeader();
		Assert.assertEquals(header,AppConstants.SEARCH_RESULT_PAGE_HEADER, AppError.URL_NOT_EXIST);
	}

	@Test
	public void searchButtonTest()
	{
		Assert.assertTrue(searchpage.isSearchbuttonExists());
	}
	
	
	
}
