package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginPageTest extends BaseTest {


	@Test(priority =1 )
	public void loginPageTitleTest() {

		String loginPageTitle = lp.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
    
    @Description("Checking the URL...")
	@Test(priority = 2)
	public void loginUrlTest()
	{
		String url = lp.getLoginPageURL();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_PARTIAL_URL),AppError.URL_NOT_EXIST);
	}
	@Test(priority = 3)
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkExists()
	{
		Assert.assertTrue(lp.forgotPwdLinkExists(), AppError.LINK_NOT_EXIST);
	}
	@Test(priority = 4)
	@Severity(SeverityLevel.CRITICAL)
	public void userLogin()
	{
		ap = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(ap.getAccountPageTitle(),AppConstants.ACCOUNT_PAGE_TITLE,AppError.TITLE_NOT_MATCHED);
	}
}
