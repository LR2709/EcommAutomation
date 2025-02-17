package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.utilities.CSVUtil;
import com.qa.opencart.utilities.ExcelUtil;
import com.qa.opencart.utilities.StringUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		regPage = lp.navigateToRegisterPage();
	}

	
	  @DataProvider 
	  public Object[][] userRegTestData() 
	  { 
		  return new Object[][] {
	  {"Arti", "automation", "9876787656", "arti@123", "yes"}, 
	  {"Praful","automation", "9876787690", "praful@123", "no"}, 
	  {"Madhu", "automation", "9876787876", "madhu@123", "yes"}
	  };
	  }
	 
	  @DataProvider 
	  public Object[][] userRegTestDataFromExcel() 
	  { 
		  return ExcelUtil.getData(AppConstants.REGISTER_SHEET_NAME);
	  }
	 
	  
	  @DataProvider 
	  public Object[][] userRegTestDataFromCSV() 
	  { 
		  return CSVUtil.csvData(AppConstants.REGISTER_SHEET_NAME);
	  }
	 
	  
   
	@Test(dataProvider="userRegTestDataFromCSV")
	public void userRegisterationTest(String firstName,String lastName,String telephone, String password, String subscribe)
	{
		Assert.assertTrue(regPage.userRegister(firstName, lastName,StringUtil.getRandonEmailId(),telephone,password,subscribe), AppError.USER_REG_NOT_DONE);
	}

}
