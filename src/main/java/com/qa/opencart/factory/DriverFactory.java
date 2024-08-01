package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	private static ThreadLocal<WebDriver> tLDriver = new ThreadLocal<WebDriver>();
	
	public static String highlight;

//	Initializing the driver in different types of browsers
	/**
	 * This is to initialize the browser
	 * 
	 * @param browser
	 */
	public WebDriver initDriver(Properties prop) {
		String browser = prop.getProperty("browser");
		switch (browser.toLowerCase().trim()) {
		case "chrome":
		//	driver = new ChromeDriver();
			tLDriver.set(new ChromeDriver());
			break;
		case "firefox":
			//driver = new FirefoxDriver();
			tLDriver.set(new FirefoxDriver());
			break;
		case "edge":
			//driver = new EdgeDriver();
			tLDriver.set(new EdgeDriver());
			break;
		case "safari":
			//driver = new SafariDriver();
			tLDriver.set(new SafariDriver());
			break;
		default:
			System.out.println("Pass the correct borwser name" + browser);
			throw new BrowserException(AppError.BROWSER_NOT_FOUND);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	/*
	 * Get the local copy of the driver
	 */
	
	public static WebDriver getDriver()
	{
	return	tLDriver.get();
	}

	/**
	 *
	 *
	 *
	 */
	public Properties initProp() {
		FileInputStream ip = null;
		prop = new Properties();
		// mvn clean install -Denv = "qa"

		String envName = System.getProperty("env");
		if (envName == null) {
			System.out.println("You have passed the null environemnt, hence running on the qa enviroment");
			try {
				ip = new FileInputStream(AppConstants.QA_FILE_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream(AppConstants.QA_FILE_PATH);

					break;
				case "dev":
					ip = new FileInputStream(AppConstants.DEV_FILE_PATH);
					break;
				case "prod":

					ip = new FileInputStream(AppConstants.CONFIG_FILE_PATH);
					break;
				default:
					System.out.println("Pass the correct environment" + envName);
				}
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	
	public static String getScreenshot(String methodName) {
		
		// Get the driver instance
        TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
        
        // Take the screenshot and save it to a temporary location
        File srcFile = screenshotTaker.getScreenshotAs(OutputType.FILE);
        
        // Define the path for the screenshots folder
        String screenshotsDirPath = System.getProperty("user.dir") + "/screenshots";
        
        // Create the screenshots folder if it doesn't exist
        File screenshotsDir = new File(screenshotsDirPath);
        if (!screenshotsDir.exists()) {
            if (screenshotsDir.mkdirs()) {
                System.out.println("Folder 'screenshots' created successfully at: " + screenshotsDirPath);
            } else {
                System.out.println("Failed to create the folder 'screenshots' at: " + screenshotsDirPath);
            }
        }

        // Define the destination path for the screenshot
        String screenshotPath = screenshotsDirPath + "/" + methodName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(screenshotPath);

        // Copy the screenshot to the destination path
        try {
            FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsolutePath();
	}

}
