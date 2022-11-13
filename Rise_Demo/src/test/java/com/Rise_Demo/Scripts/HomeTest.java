package com.Rise_Demo.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Rise_Demo.Pages.HomePage;

public class HomeTest extends BaseTest {
	HomePage home;

	@Test(priority = 5)
	public void verifySelectProductSauceLabsBackpack() {
		home = new HomePage(driver);
		home.selectProductsauceLabsBackpack();
		home.addProductSauceLabsBackpack();
		Assert.assertEquals(home.getErrorText(), "Sauce Labs Backpack");
	}

	@Test(priority = 6)
	public void verifySelectProductSauceLabsFleeceJacket() {
		home = new HomePage(driver);
		home.selectProductSauceLabsFleeceJacket();
		home.addProductSauceLabsFleeceJacket();
		Assert.assertEquals(home.getJacketText(), "Sauce Labs Fleece Jacket");
	}

	@Test(priority = 7)
	public void verifySelectProductTestAllTheThingsTShirtRed() {
		home = new HomePage(driver);
		home.selectProductTestAllTheThingsTShirtRedProduct();
		home.addProductTestAllTheThingsTShirtRedProduct();
		Assert.assertEquals(home.product1Assert(), "Test.allTheThings() T-Shirt (Red)");

	}
}
