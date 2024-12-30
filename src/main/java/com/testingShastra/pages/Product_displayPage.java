package com.testingShastra.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.waitsFor;

public class Product_displayPage {
	public Product_displayPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "input[formaction=\"/cart/add-to-cart/ref=dp_start-bbf_1_glance\"]")
	private static WebElement addTocartButton;

	@FindBy(css = "span#productTitle")
	private static WebElement dressproductTitle;

	@FindBy(css = "span.a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay")
	private static WebElement dressproductprice;

	
	public void clickOnAddToCart() {
		waitsFor.visiblityOfElement(addTocartButton);
		Keyword.scrollwindow(addTocartButton);
		Keyword.clickOn(addTocartButton);
	}

	public String getNameOfProduct() {
		waitsFor.visiblityOfElement(dressproductTitle);
		return Keyword.getText(dressproductprice);
	}

	public String getpriceOfProduct() {
		waitsFor.visiblityOfElement(dressproductprice);
		String price = Keyword.getText(dressproductprice);
		return price;
	}

}
