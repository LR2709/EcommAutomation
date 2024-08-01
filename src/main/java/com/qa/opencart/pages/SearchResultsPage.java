package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

	private WebDriver driver;

	private By searchResultProduct = By.cssSelector("div.product-thumb");
	private By searchHeader = By.cssSelector("div#content h2");
	private By searchButton = By.id("button-search");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSearchPageTitle() {
		String searchTitle = driver.getTitle();
		return searchTitle;
	}

	public String getSearchPageURL() {
		String searchURL = driver.getCurrentUrl();
		return searchURL;
	}

	public int getSearchResultsCount() {
		List<WebElement> list = driver.findElements(searchResultProduct);
		int size = list.size();
		System.out.println("Matching Products found: " + size);
		return size;

	}

	public String searchResultPageHeader() {
		String header = driver.findElement(searchHeader).getText();
		return header;

	}
	
	public boolean isSearchbuttonExists() {
		return driver.findElement(searchButton).isDisplayed();
		}
    public ProductPage clickProduct(String productName)
    {
    	driver.findElement(By.linkText(productName)).click();
    	return new ProductPage(driver);
    }
	
}
