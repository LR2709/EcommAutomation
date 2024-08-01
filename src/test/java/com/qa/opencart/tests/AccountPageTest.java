package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSetUp() {
		ap = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String accTitle = ap.getAccountPageTitle();
		Assert.assertTrue(accTitle.contains(AppConstants.ACCOUNT_PAGE_TITLE), AppError.TITLE_NOT_MATCHED);
	}

	@Test
	public void accPageURLTest() {
		String accURL = ap.getAccPageURL();
		Assert.assertTrue(accURL.contains(AppConstants.ACC_PARTIAL_URL), AppError.URL_NOT_EXIST);
	}

	@Test
	public void accPageHeadersTest() {
		Assert.assertEquals(ap.accPageHeadersList(), AppConstants.ACCPAGE_HEADER_LIST, AppError.LIST_NOT_MATCHED);
	}

	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] { { "iphone", 1 }, { "samsung", 2 }, { "macbook", 3 }, { "canon", 1 }, { "imac", 1 } };
	}

	@Test(dataProvider = "getSearchData")
	public void searchTest(String searchKey, int resultsCount) {
		searchpage = ap.doSearch(searchKey);
		Assert.assertEquals(searchpage.getSearchResultsCount(), resultsCount, AppError.RESULT_COUNT_NOT_MATCHED);
	}

}
