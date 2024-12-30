package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.waitsFor;

public class AddedToCartPage {

	public AddedToCartPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	

	@FindBy(xpath = "//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private static WebElement messageofProductadded;
	@FindBy(xpath = "//select[@id=\"native_dropdown_selected_size_name\"]")
	private static WebElement sizeDropDown;
	
	@FindBy(xpath="//a[@href=\"/cart?ref_=sw_gtc\"]")
	private static WebElement goToCartBttn;
	
	@FindBy(css="span[data-a-selector=\"value\"]")
	private static WebElement getOnePrdctQty;
	
	
	
	@FindBy(css="span[data-a-selector=\"value\"]")
	private static WebElement afterAddingPrdct;
	
	@FindBy(css="span#sc-subtotal-label-activecart")
	private static WebElement itemSubtotal;

	public static void selectSize() {
		Keyword.scrollwindow(sizeDropDown);
		Keyword.handleDropDown(sizeDropDown);
	}
	
	public  boolean displayIsItemAddedToCart() {
		waitsFor.visiblityOfElement(messageofProductadded);
		return Keyword.isMessageDisplayed(messageofProductadded);

	}
	
	public  void clickOnGotoCartBttn() {
		waitsFor.visiblityOfElement(goToCartBttn);
		Keyword.clickOn(goToCartBttn);
	}
	public  int getQtyOfProductBefore() {
		String singlePrdctQty= Keyword.getText(getOnePrdctQty);
		return Keyword.getIntValueFromStringFormat(singlePrdctQty);
	}
	
	
	public  int QtyOfPrdctAfterAction() {
		waitsFor.visiblityOfElement(afterAddingPrdct);
		String incrseqtyPrdct= Keyword.getText(afterAddingPrdct);
		return Keyword.getIntValueFromStringFormat(incrseqtyPrdct);
	}
	public int getQntyofSubtotal() {
		waitsFor.visiblityOfElement(itemSubtotal);
		String subtotalQtyPrdct= Keyword.getText(itemSubtotal);
		return Keyword.getIntValueFromStringFormat(subtotalQtyPrdct);
	}
	
	
}
