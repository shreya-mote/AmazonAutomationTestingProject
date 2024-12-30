package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.SwitchWindowfor;
import com.testingShastra.utils.waitsFor;

public class AllProductsPage {
	public AllProductsPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Trendy Printed Cotton Blend Crew Neck/Round Neck Half Sleeve Tshirt for Men - Pack of 3\"]")
	private static WebElement tshirtComboToselect;

	@FindBy(css = "h2[aria-label=\"Anti Stain Anti Odor Crew Neck Tshirt for Men | Solid Regular Fit Round Neck Half Sleeves Tshirt (Availbale in Plus Sizes) (XXX-Large, Green)\"]")
	private static WebElement tshirtTurms;

	@FindBy(css = "h2[aria-label=\"Half Sleeve Oversized Printed T-Shirt for Men, Round Neck Longline Drop Shoulder | Colorful Printed Combo T-Shirt (Pack of 3)\"")
	private static WebElement anotherTshirtcombo;

	@FindBy(css = "h2[aria-label=\"Sponsored Ad - Women's Mini Dress | One Piece Dress for Women | Dresses for Women | Trendy Dress for Women\"")
	private static WebElement womenDress;

	public void clickOnAnotherTshirtcombo() {
		waitsFor.visiblityOfElement(anotherTshirtcombo);
		Keyword.scrollwindow(anotherTshirtcombo);
		Keyword.clickOn(anotherTshirtcombo);

	}

	public void clickTshirtComboProductToSelect() {
		waitsFor.visiblityOfElement(tshirtComboToselect);
		Keyword.scrollwindow(tshirtComboToselect);
		Keyword.clickUsingjavaScript(tshirtComboToselect);
	}

	public void clickonleriyadress() {
		waitsFor.visiblityOfElement(womenDress);
		Keyword.scrollwindow(womenDress);
		Keyword.clickUsingjavaScript(womenDress);
	}

	public void clickTshirtTurms() {
		waitsFor.visiblityOfElement(tshirtTurms);
		Keyword.scrollwindow(tshirtTurms);
		Keyword.clickUsingjavaScript(tshirtTurms);

	}

	public void switchToanotherWindow(String url) {
		SwitchWindowfor.switchingWindow(url);
	}

}
