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
	private static WebElement signIn;

	@FindBy(css = "span#nav-link-accountList-nav-line-1")
	private static WebElement signInTextMsg;

	@FindBy(id = "twotabsearchtextbox")
	private static WebElement searchBox;

	@FindBy(xpath = "//div[@class=\"s-suggestion s-suggestion-ellipsis-direction\"]")
	private static List<WebElement> tshirtToSelect;

	public void ClickOnSigin() {
		Keyword.clickOn(signIn);
	}

	public boolean isSigninMsgDisplayed() {
		waitsFor.VisibilityOfElemntMethod(signInTextMsg);
		return Keyword.isDisplayed(signInTextMsg);
	}

	public void sendTextOnSearchBox(String text_tosend) {
		Keyword.sendKeys(searchBox, text_tosend);
	}

	public void sendTextOnSearchBoxAndEnter(String text_tosend, Keys enter) {
		Keyword.sendKeys(searchBox, text_tosend, Keys.ENTER);
	}

	public void cleanTextOnSearchBar() {
		Keyword.cleanTextBox(searchBox);
	}

	public static void clickOnTshirtToSelect() {
		waitsFor.visibilityOfAllElemntMethod(tshirtToSelect);
		Keyword.getElementFromList(tshirtToSelect, "tshirts for men combo");
	}

}
