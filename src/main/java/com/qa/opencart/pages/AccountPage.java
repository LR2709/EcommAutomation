package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;
import com.qa.opencart.utilities.TimeUtil;
*/
public class AccountPage {

	private WebDriver driver;
	//private ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	private By logoutLink = By.linkText("Logout");
	private By searchbox = By.name("search");
	private By accountLink = By.linkText("My Account");
	private By searchIcon = By.cssSelector("div#search button");
	private By headers = By.cssSelector("div#content h2");

	public String getAccountPageTitle() {
		String accPageTitle = driver.getTitle();
				//eleUtil.waitForTitleToBe(AppConstants.ACCOUNT_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		System.out.println("Account page title is: " + accPageTitle);
		return accPageTitle;
	}

	public String getAccPageURL() {
		String accPageurl = driver.getCurrentUrl();
				//eleUtil.waitForURLContains(AppConstants.ACC_PARTIAL_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("Account page url is : " + accPageurl);
		return accPageurl;
	}

	public List<String> accPageHeadersList() {
		List<WebElement> headersList = driver.findElements(headers);
				//eleUtil.waitForVisibilityOfElemenetsLocated(headers,TimeUtil.DEFAULT_MEDIUM_TIME);
		List<String> headersValue = new ArrayList<>();
		for (WebElement e : headersList) {
			String headerText = e.getText();
			headersValue.add(headerText);
		}
		return headersValue;
	}

	public boolean isSearchBoxExist() {
		return driver.findElement(searchbox).isDisplayed();
	}

	public boolean isLogoutLinkExist() {
		return driver.findElement(logoutLink).isDisplayed();
				//eleUtil.doIsDisplayed(logoutLink);
	}

	public boolean isAccountLinkExist() {
		return driver.findElement(accountLink).isDisplayed();
				//eleUtil.doIsDisplayed(accountLink);
	}

	public SearchResultsPage doSearch(String searchKey) {
		
		if (isSearchBoxExist()) {
			driver.findElement(searchbox).clear();
			driver.findElement(searchbox).sendKeys(searchKey);
			//eleUtil.doSendKeys(searchbox, searchKey);
			//eleUtil.doClick(searchIcon);
			driver.findElement(searchIcon).click();
			return new SearchResultsPage(driver);
		} else {
			System.out.println("search box is not displayed");
			return null;
		}

	}
}