package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;
import com.qa.opencart.utilities.TimeUtil;

import io.qameta.allure.Step;

/*import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;
import com.qa.opencart.utilities.TimeUtil;*/

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By locators
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver)  ;
	}

	// public age actions/method

	public String getLoginPageTitle() {
		String title = driver.getTitle();
				//eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		System.out.println("login page title is : " + title);
		return title;
	}
    @Step("Getting the page URL..")
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
				//eleUtil.waitForTitleContains(AppConstants.LOGIN_PAGE_PARTIAL_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("login page url is : " + url);
		return url;
	}
    @Step("Getting the forgot link exists....")
	public boolean forgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
				//eleUtil.doIsDisplayed(forgotPwdLink);
	}
    @Step("Login with username:...")
	public AccountPage login(String username, String pwd) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		/*
		 * eleUtil.doSendKeys(email, username, TimeUtil.DEFAULT_TIME);
		 * eleUtil.doSendKeys(password, pwd, TimeUtil.DEFAULT_TIME);
		 * eleUtil.doClick(loginBtn);
		 */
		return new AccountPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		eleUtil.doClick(registerLink, TimeUtil.DEFAULT_TIME);
		return new RegisterPage(driver);
	}
}
