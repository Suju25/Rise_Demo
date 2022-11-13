package com.Rise_Demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Rise_Demo.Utilities.WaitUtilities;

public class HomePage {
	WaitUtilities wait;
	WebDriver driver;
	@FindBy(xpath = "//a[@id='item_4_title_link']")
	WebElement sauceLabsBackpackProduct;
	@FindBy(xpath = "//button[@id='back-to-products']")
	WebElement productpage;
	@FindBy(xpath = "//a[@id='item_5_title_link']")
	WebElement sauceLabsFleeceJacketProduct;
	@FindBy(xpath = "//a[@id='item_3_title_link']")
	WebElement testAllTheThingsTShirtRedProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement sauceLabsBackpackAddCart;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement sauceLabsFleeceJacketAddCart;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	WebElement testAllTheThingsTShirtRedProductAddCart;
	@FindBy(xpath = "//div[@class='inventory_details_name large_size']")
	WebElement validationText;
	@FindBy(xpath = "//span[@class='title']")
	WebElement productText;
	@FindBy(xpath="(//div[@class='inventory_item_name'])[1]")
	WebElement bagAssert;
	@FindBy(xpath="(//div[@class='inventory_item_name'])[4]")
	WebElement jacketAssert;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		wait = new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public void selectProductsauceLabsBackpack() {
		wait.WaitForElementTobeClickable(sauceLabsBackpackProduct, 60);
		sauceLabsBackpackProduct.click();

	}

	public void addProductSauceLabsBackpack() {

		wait.WaitForElementTobeClickable(sauceLabsBackpackAddCart, 60);
		sauceLabsBackpackAddCart.click();
		wait.WaitForElementTobeClickable(productpage, 60);
		productpage.click();
	}

	public void selectProductSauceLabsFleeceJacket() {
		wait.WaitForElementTobeClickable(sauceLabsFleeceJacketProduct, 60);
		sauceLabsFleeceJacketProduct.click();

	}

	public void addProductSauceLabsFleeceJacket() {

		wait.WaitForElementTobeClickable(sauceLabsFleeceJacketAddCart, 60);
		sauceLabsFleeceJacketAddCart.click();
		wait.WaitForElementTobeClickable(productpage, 60);
		productpage.click();

	}

	public void selectProductTestAllTheThingsTShirtRedProduct() {
		wait.WaitForElementTobeClickable(testAllTheThingsTShirtRedProduct, 60);
		testAllTheThingsTShirtRedProduct.click();

	}

	public void addProductTestAllTheThingsTShirtRedProduct() {
		wait.WaitForElementTobeClickable(testAllTheThingsTShirtRedProductAddCart, 60);
		testAllTheThingsTShirtRedProductAddCart.click();

	}

	public String product1Assert() {
		return validationText.getText();
	}

	public String getProductAssertText() {
		return productText.getText();
	}
	public String getErrorText(){
		
		return bagAssert.getText();
	}
public String getJacketText(){
		
		return jacketAssert.getText();
	}


}
