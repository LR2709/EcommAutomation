package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;




public class ProductPageTest extends BaseTest {

	@BeforeClass
	public void preSetup() {
		ap =lp.login(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = ap.doSearch("imac");
		pp = searchpage.clickProduct("iMac");
	}

	@Test
	public void productNameTest() {
		String name = pp.getProductHeader();
		Assert.assertEquals(name, "iMac", AppError.PRODUCT_NOT_EXIST);
	}
	
	@Test
	public void productURLTest()
	{
		String url = pp.getProductInfoPageURL();
		Assert.assertTrue(url.contains(AppConstants.PRODUCT_PAGE_PARTIAL_URL), AppError.URL_NOT_EXIST);
	}

}
