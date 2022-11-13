package com.Rise_Demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Rise_Demo.Utilities.WaitUtilities;

public class LoginPage {
	WaitUtilities wait;
	WebDriver driver;
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;
	@FindBy(xpath = "//button[@class='error-button']")
	WebElement errorCloseButton;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement logoutOptionSelect;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement userlogout;
	@FindBy(xpath = "//span[@class='title']")
	WebElement welcomepagetext;
	@FindBy(xpath = "//h4[text()='Accepted usernames are:']")
	WebElement assertText;
	@FindBy(xpath="//div[@class='error-message-container error']")
	WebElement errorAssert;
	

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		wait = new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String email1) {
		wait.WaitForElementTobeClickable(userName, 60);
		userName.sendKeys(email1);
	}

	public void setPassword(String password1) {
		wait.WaitForElementTobeClickable(password, 60);
		password.sendKeys(password1);
	}

	public void clickLogin() {
		wait.WaitForElementTobeClickable(loginButton, 60);
		loginButton.click();
	}

	public void close() {
		errorCloseButton.click();
	}

	public void userLogout() {
		wait.WaitForElementTobeClickable(logoutOptionSelect, 60);
		logoutOptionSelect.click();
		wait.WaitForElementTobeClickable(userlogout, 60);
		userlogout.click();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public String getWelcomePageText() {
		return welcomepagetext.getText();
	}

	public String getLoginText() {
		return assertText.getText();
	}
	
}
