package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.waitsFor;

public class AddToCart {

	public AddToCart() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(id = "add-to-cart-button")
	private static WebElement addToCartButton;

	@FindBy(xpath = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private static WebElement messageofProductadded;
	@FindBy(xpath = "//select[@id=\"native_dropdown_selected_size_name\"]")
	private static WebElement sizeDropDown;
	
	@FindBy(xpath="//a[@href=\"/cart?ref_=sw_gtc\"]")
	private static WebElement goToCartBttn;
	
	@FindBy(css="span[data-a-selector=\"value\"]")
	private static WebElement getOnePrdctQty;
	
	@FindBy(css="span.a-icon.a-icon-small-add")
	private static WebElement increaseQty;
	@FindBy(css="span.a-icon.a-icon-small-remove")
	private static WebElement decreaseQty;
	
	@FindBy(css="span[data-a-selector=\"value\"]")
	private static WebElement afterAddingPrdct;
	
	@FindBy(css="span#sc-subtotal-label-activecart")
	private static WebElement itemSubtotal;

	public static void selectSize() {
		Keyword.scrollwindow(sizeDropDown);
		Keyword.handleDropDown(sizeDropDown);
	}
	public static void clickOnAddToCartButton() {
		waitsFor.VisibilityOfElemntMethod(addToCartButton);
		Keyword.scrollwindow(addToCartButton);

	}
	public static boolean displayIsItemAddedToCart() {
		waitsFor.VisibilityOfElemntMethod(messageofProductadded);
		return Keyword.isDisplayed(messageofProductadded);

	}
	public static boolean isButtnAddToCartDisplay() {
		waitsFor.VisibilityOfElemntMethod(addToCartButton);
		return Keyword.isDisplayed(addToCartButton);
	}
	public static void clickOnGotoCartBttn() {
		waitsFor.VisibilityOfElemntMethod(goToCartBttn);
		Keyword.clickOn(goToCartBttn);
	}
	public static int getQtyOfProductBefore() {
		String singlePrdctQty= Keyword.getText(getOnePrdctQty);
		return Keyword.getIntValueFromStringFormat(singlePrdctQty);
	}
	public static void clickOnIncreaseQtyOfPrdct() {
		Keyword.clickOn(increaseQty);
	}
	public static void clickOnDecreaseQtyOfPrdct() {
		Keyword.clickOn(decreaseQty);
	}
	public static int QtyOfPrdctAfterAction() {
		waitsFor.VisibilityOfElemntMethod(afterAddingPrdct);
		String incrseqtyPrdct= Keyword.getText(afterAddingPrdct);
		return Keyword.getIntValueFromStringFormat(incrseqtyPrdct);
	}
	public static int getQntyofSubtotal() {
		waitsFor.VisibilityOfElemntMethod(itemSubtotal);
		String subtotalQtyPrdct= Keyword.getText(itemSubtotal);
		return Keyword.getIntValueFromStringFormat(subtotalQtyPrdct);
	}
	
	
}
