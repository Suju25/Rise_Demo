package com.Rise_Demo.Scripts;

import org.testng.annotations.Test;

import com.Rise_Demo.Constants.Constants;
import com.Rise_Demo.Pages.LoginPage;
import com.Rise_Demo.Utilities.ExcelRead;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseTest

{
	LoginPage login;

	@Test(dataProvider = "standarduserlogin", priority = 4)
	public void verifyLoginwithStandardUser(String email1, String password1) {
		login = new LoginPage(driver);

		login.setUserName(email1);
		login.setPassword(password1);
		login.clickLogin();
		Assert.assertEquals(login.getWelcomePageText(), "PRODUCTS");

	}

	@Test(dataProvider = "problemuserlogin", priority = 3)
	public void verifyLoginwithProblemUser(String email1, String password1) {
		login = new LoginPage(driver);

		login.setUserName(email1);
		login.setPassword(password1);
		login.clickLogin();
		login.userLogout();
		Assert.assertEquals(login.getLoginText(), "Accepted usernames are:");

	}

	@Test(dataProvider = "performanceglitchuserlogin", priority = 2)
	public void verifyWithPerformanceGlitchUser(String email1, String password1) {
		login = new LoginPage(driver);
		login.setUserName(email1);
		login.setPassword(password1);
		login.clickLogin();
		login.userLogout();
		Assert.assertEquals(login.getLoginText(), "Accepted usernames are:");

	}

	@Test(dataProvider = "lockedoutuserlogin", priority = 1)
	public void verifyWithLockedOutUser(String email1, String password1) {
		login = new LoginPage(driver);
		login.setUserName(email1);
		login.setPassword(password1);
		login.clickLogin();
		login.close();
		login.refresh();
		Assert.assertEquals(login.getLoginText(), "Accepted usernames are:");

	}

	@DataProvider
	public Object[][] standarduserlogin() throws Exception

	{
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "standarduserlogin");
		return data;
	}

	@DataProvider
	public Object[][] problemuserlogin() throws Exception

	{
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "problemuserlogin");
		return data;
	}

	@DataProvider
	public Object[][] performanceglitchuserlogin() throws Exception

	{
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "performanceglitchuserlogin");
		return data;
	}

	@DataProvider
	public Object[][] lockedoutuserlogin() throws Exception

	{
		Object[][] data = ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "lockedoutuserlogin");
		return data;
	}

}
