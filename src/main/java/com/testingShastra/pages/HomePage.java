package com.testingShastra.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.waitsFor;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "span#nav-link-accountList-nav-line-1")
	private static WebElement signInButton;

	@FindBy(css = "input#twotabsearchtextbox")
	private static WebElement searchBox;

	@FindBy(css = "div.s-suggestion-container")
	private static List<WebElement> tshirtToSelect;
	
	@FindBy(css="span.nav-cart-icon.nav-sprite")
	private static WebElement cartOption;

	public void ClickOnSigin() {
		Keyword.clickOn(signInButton);
	}
	
	public void goToshoppingCart() {
		waitsFor.visiblityOfElement(cartOption);
		Keyword.clickOn(cartOption);
	}

	public void sendTextOnSearchBox(String text_tosend) {
		Keyword.sendKeys(searchBox, text_tosend);
	}

	public void sendTextOnSearchBoxAndEnter(String text_tosend, Keys enter) {
		Keyword.sendKeys(searchBox, text_tosend, enter);
	}

	public void cleanTextOnSearchBar() {
		Keyword.cleanTextBox(searchBox);
	}

	public static void clickOnTshirtToSelect() {
		waitsFor.visibilityOfAllElemntMethod(tshirtToSelect);
		WebElement tshirtElement = Keyword.getElementFromList(tshirtToSelect, "tshirts for men combo");
		try {
			if (!tshirtElement.equals(null)) {
				tshirtElement.click();
			}
		} catch (Exception e) {
			if (!tshirtElement.equals(null)) {
				waitsFor.waitForStaneless(tshirtElement);
				tshirtElement.click();
			}
		}

	}

}
