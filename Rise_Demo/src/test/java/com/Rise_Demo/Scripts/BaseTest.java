package com.Rise_Demo.Scripts;

import com.Rise_Demo.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {

	public static Properties prop = null;
	public static WebDriver driver;

	public static void testbase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources" + "\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@AfterMethod

	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());
		}
	}

	private String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\target\\" + name + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		testbase();

		if (browser.equalsIgnoreCase(Constants.CHROMEBROWSER)) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase(Constants.FIREFOXBROWSER)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(Constants.EDGEBROWSER)) {

			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new Exception(Constants.BROWSERNOTCORRECT);
		}
		String baseurl = prop.getProperty("baseurl");
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
