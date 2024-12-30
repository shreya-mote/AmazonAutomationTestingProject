package com.testingShastra.pages;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.SwitchWindowfor;
import com.testingShastra.utils.waitsFor;

public class ShoppingCartPage {
	public ShoppingCartPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "span.a-icon.a-icon-small-add")
	private static WebElement PlusSign;

	@FindBy(css = "span[data-a-selector=\"decrement-icon\"]")
	private static WebElement subtractSign;

	@FindBy(css = "span#sc-subtotal-label-activecart")
	private static WebElement subTotalofItorms;

	@FindBy(css = "span[data-a-selector=\"value\"]")
	private static WebElement quntityOfSameProduct;

	@FindBy(css = "span.a-truncate-cut")
	private static WebElement deavishWomenDressName;

	@FindBy(css = "div.sc-item-price-block span.aok-align-center.a-text-bold span[aria-hidden=\"true\"]>span.a-price-whole")
	private static WebElement deavishWomenDressprice;

	@FindBy(css = "input[value=\"Delete\"]")
	private static List<WebElement> deleteProduct;

	@FindBy(css = "input[value=\"Delete\"]")
	private static WebElement deleteSingleProduct;

	@FindBy(css = "h2.a-size-extra-large.a-spacing-mini.a-spacing-top-base")
	private static WebElement cartEmptyMsg;

	@FindBy(css = "a#deselect-all")
	private static WebElement deSelectAllIterms;

	@FindBy(css = "a#select-all")
	private static WebElement SelectAllIterms;

	@FindBy(css = "span.a-size-medium.sc-number-of-items")
	private static WebElement selectItermsMsg;

	@FindBy(css = "input[aria-label=\"Save for later TURMS Anti Stain Anti Odor Polo T Shirt for Men | Water Repellent | Stretchable T Shirt for Boys | Regular fit |Breathable Cotton | Half Sleeve | Casual Sports Wear for Men Pink\"]")
	private static WebElement saveToLater;

	@FindBy(css = "div#sc-saved-cart-list-caption-text")
	private static WebElement addedInsaveToLater;

	@FindBy(css = "input[aria-label=\"See more like this TURMS Anti Stain Anti Odor Polo T Shirt for Men | Water Repellent | Stretchable T Shirt for Boys | Regular fit |Breathable Cotton | Half Sleeve | Casual Sports Wear for Men Pink\"]")
	private static WebElement seemorelikeThese;

	@FindBy(css = "h1.a-size-large")
	private static WebElement moreLikeThese;

	@FindBy(css = "input[value=\"Add to list\"]")
	private static WebElement addToList;

	@FindBy(css = "span#profile-list-name")
	private static WebElement shoppingList;

	@FindBy(css = "span#cldd-list-name-19323299IBIUW")
	private static WebElement clickonshoppingList;

	@FindBy(css = "span[class=\"add-to-list-success-label\"]")
	private static WebElement addedtoshoppingListMsg;

	@FindBy(css = "a[title=\"Share\"]")
	private static WebElement share;

	@FindBy(css = "h3.a-spacing-large")
	private static WebElement shareThisProduct;

	@FindBy(css = "input[name=\"proceedToRetailCheckout\"]")
	private static WebElement proceedToBy;

	@FindBy(css = "div[data-feature-id=\"delete-success-message\"]")
	private static WebElement deleteSuccesMsg;

	@FindBy(css = "button[aria-label=\"Close\"]")
	private static WebElement crossbutton;

	public void clickOnShare() {
		waitsFor.visiblityOfElement(share);
		Keyword.moveToElement(share);
		Keyword.clickOn(share);
	}

	public void clickonProceedToBy() {
		waitsFor.visiblityOfElement(proceedToBy);
		Keyword.clickOn(proceedToBy);
	}

	public void deleteOneProduct() {
		waitsFor.visiblityOfElement(deleteSingleProduct);
		Keyword.clickOn(deleteSingleProduct);
	}

	public void clickondeleteProduct() {
		waitsFor.visiblityOfElement(deleteSuccesMsg);
		Keyword.clickOn(deleteSuccesMsg);
	}

	public boolean shareTheseProductMsg() {
		waitsFor.visiblityOfElement(shareThisProduct);
		boolean share = Keyword.isMessageDisplayed(shareThisProduct);
		Keyword.clickOn(crossbutton);
		return share;

	}

	public boolean succesfullyDeleteMsgIsDisplay() {
		waitsFor.visiblityOfElement(deleteSuccesMsg);
		return Keyword.isMessageDisplayed(deleteSuccesMsg);

	}

	public String getnameMoreLikeThese() {
		waitsFor.visiblityOfElement(moreLikeThese);
		String more = Keyword.getText(moreLikeThese);
		Keyword.clickOn(crossbutton);
		return more;
	}

	public boolean addedToShoppingListMsg() {
		waitsFor.visiblityOfElement(addedtoshoppingListMsg);
		return Keyword.isMessageDisplayed(addedtoshoppingListMsg);

	}

	public boolean shoppingListDisplay() {
		waitsFor.visiblityOfElement(shoppingList);
		return Keyword.isMessageDisplayed(shoppingList);

	}

	public void clickOnAddedToshoppingCart() {
		waitsFor.elementToBeClickableMethod(addedtoshoppingListMsg);
		Keyword.clickOn(addedtoshoppingListMsg);

	}

	public static void clickOnaddToList() {
		waitsFor.elementToBeClickableMethod(addToList);
		Keyword.clickOn(addToList);
		waitsFor.visiblityOfElement(clickonshoppingList);
		Keyword.clickOn(clickonshoppingList);
	}

	public static void clickOnseemorelikeThese() {
		waitsFor.elementToBeClickableMethod(seemorelikeThese);
		Keyword.clickOn(seemorelikeThese);
	}

	public static void clickOnPlusSign() {
		waitsFor.elementToBeClickableMethod(PlusSign);
		Keyword.clickOn(PlusSign);
	}

	public static void clickOnSubtractSign() {
		waitsFor.elementToBeClickableMethod(subtractSign);
		Keyword.clickOn(subtractSign);
	}

	public int getSubTotalOfIterm() {
		waitsFor.visiblityOfElement(subTotalofItorms);
		String subTotal = Keyword.getText(subTotalofItorms);
		return Keyword.getIntValueFromStringFormat(subTotal);
	}

	public int getQuntityOfSameProduct() {
		waitsFor.visiblityOfElement(quntityOfSameProduct);
		String quntity = Keyword.getText(quntityOfSameProduct);
		return Keyword.getIntValueFromStringFormat(quntity);
	}

	public String getNameOfProduct() {
		waitsFor.visiblityOfElement(deavishWomenDressName);
		return Keyword.getText(deavishWomenDressName);
	}

	public String getpriceOfProduct() {
		waitsFor.visiblityOfElement(deavishWomenDressprice);
		String price = Keyword.getText(deavishWomenDressprice);
		System.out.println(price);
		return price;
	}

	public void deleteproductFromCart() throws InterruptedException {
		waitsFor.visibilityOfAllElemntMethod(deleteProduct);
		System.out.println(deleteProduct.size());
		int availableproduct = deleteProduct.size();
		while (availableproduct > 0) {

			for (int i = 0; i < deleteProduct.size(); i++) {
				try {
					Keyword.refreshPage();
					WebElement delete = deleteProduct.get(i);
					waitsFor.visiblityOfElement(delete);
					delete.click();
					availableproduct--;

				} catch (StaleElementReferenceException e) {
					System.out.println("Caught StaleElementReferenceException, retrying...");
					break;
				}
			}
		}
		System.out.println(deleteProduct.size());

	}

	public boolean emptyMsgIsDisplay() {
		waitsFor.visiblityOfElement(cartEmptyMsg);
		return Keyword.isMessageDisplayed(cartEmptyMsg);

	}

	public String getItermsSelectMsg() {
		Keyword.refreshPage();
		waitsFor.visiblityOfElement(selectItermsMsg);
		return Keyword.getText(selectItermsMsg);

	}

	public void clickOndeselectAll() {
		Keyword.refreshPage();
		waitsFor.elementToBeClickableMethod(deSelectAllIterms);
		Keyword.clickOn(deSelectAllIterms);

	}

	public void clickOnselectAll() {
		Keyword.moveToElement(SelectAllIterms);
		waitsFor.elementToBeClickableMethod(SelectAllIterms);
		Keyword.clickOn(SelectAllIterms);
		Keyword.refreshPage();

	}

	public boolean selectedProductCountIsDisplay() {
		Keyword.refreshPage();
		waitsFor.visiblityOfElement(selectItermsMsg);
		return Keyword.isMessageDisplayed(selectItermsMsg);

	}

	public void clickOnproduct() {
		waitsFor.elementToBeClickableMethod(deavishWomenDressName);
		Keyword.clickOn(deavishWomenDressName);

	}

	public String getTitleOfPage() {
		return Keyword.driver.getTitle();

	}

	public void switchwindow(String url) {
		SwitchWindowfor.switchingWindow(url);

	}

	public boolean saveTolaterIsEnable() {
		waitsFor.visiblityOfElement(saveToLater);
		return Keyword.isEnable(saveToLater);

	}

	public boolean saveTolaterIsDisplay() {
		waitsFor.visiblityOfElement(saveToLater);
		return Keyword.isMessageDisplayed(saveToLater);

	}

	public void clickonsaveToLater() {
		waitsFor.elementToBeClickableMethod(saveToLater);
		Keyword.clickOn(saveToLater);

	}

	public String productInsavetoLater() {
		waitsFor.visiblityOfElement(addedInsaveToLater);
		return Keyword.getText(addedInsaveToLater);
	}

}
