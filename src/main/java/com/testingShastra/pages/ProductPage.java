package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.SwitchWindowfor;
import com.testingShastra.utils.waitsFor;

public class ProductPage {
	public ProductPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	@FindBy(xpath="//span[text()=\"Trendy Printed Cotton Blend Crew Neck/Round Neck Half Sleeve Tshirt for Men - Pack of 3\"]")
	private static WebElement tshirtComboToselect;
	
	@FindBy(css="h2[aria-label=\"Sponsored Ad - Anti Stain Anti Odor Polo T Shirt for Men | Water Repellent | Stretchable T Shirt for Boys | Regular fit |Breathable Cotton | Half Sleeve | Casual Sports Wear for Men\"]")
	private static WebElement secondItemTshirtToSelect;
	
	public static void clickTshirtComboProductToSelect() {
		waitsFor.VisibilityOfElemntMethod(tshirtComboToselect);
		Keyword.scrollwindow(tshirtComboToselect);
	}
	public static void clickSecondItemTshirtProductToSelect() {
		waitsFor.VisibilityOfElemntMethod(secondItemTshirtToSelect);
		Keyword.scrollwindow(secondItemTshirtToSelect);
	}
	
	public static void switchToanotherWindow(String url) {
		SwitchWindowfor.switchingWindow(url);
	}

}
