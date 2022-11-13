package com.Rise_Demo.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public WebDriver driver;

	public WaitUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public WebElement WaitForElementTobeVisilble(WebElement elementToBeLoaded, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;

	}

	public WebElement WaitForElementTobeClickable(WebElement elementToBeLoaded, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;

	}

}
