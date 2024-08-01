package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	protected LoginPage lp;
	protected Properties prop;
	protected AccountPage ap;
	protected SearchResultsPage searchpage;
	protected ProductPage pp;
	protected RegisterPage regPage;

	@Parameters("browser")
	@BeforeTest
	public void init() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		lp = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
