package com.testingShastra.pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.SwitchWindowfor;
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

	@FindBy(css="div[class=\"a-row\"]>span:nth-child(1)")
	private static WebElement noResultForMsg;
	
	@FindBy(id = "twotabsearchtextbox")
	private static WebElement searchBox;
	
	@FindBy(css="span.a-price-whole")
	private static List<WebElement> productPrices;
	
	@FindBy(css="div.a-section.s-range-input-container.s-upper-bound")
	private static WebElement priceSlider;
	
	@FindBy(css="button#a-autoid-2-announce")
	private static WebElement addToCartPrdctPageButtn;
	
	@FindBy(css="div.a-checkbox.a-checkbox-fancy.s-navigation-checkbox.aok-float-left>label")
	private static List<WebElement> brandFilters;
	
	@FindBy(css="h2[aria-label=\"Classmate Pulse 6 Subject Spiral Notebook - Pack of 1 | Single Line | 300 Pages | A4 - 29.7cm x 21.0cm | Attractive Cover Designs | Soft Cover | Notebooks for College Students\"]")
	private static WebElement classmateNotebookToSelect;
	
	@FindBy(css="span#productTitle")
	private static WebElement classmateNotebookName;
	
	@FindBy(css="span.a-size-medium.a-color-success")
	private static WebElement inStockMsg;
	
	@FindBy(css="div.a-row>h2")
	private static WebElement customerReview;
	@FindBy(css="div.a-section.a-spacing-none.a-spacing-top-small.s-title-instructions-style")
	private static List<WebElement> listOfNotebookProduct;
	
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
	public String getNoResultMsg() {
		waitsFor.visiblityOfElement(noResultForMsg);
		return Keyword.getText(noResultForMsg);
	}
	public void clearSearchBox(Keys key) {
		Keyword.cleanTextBox(searchBox,Keys.ENTER);
	}
	public void getPricesList() {
		waitsFor.visibilityOfAllElemntMethod(productPrices);
		List<String> listOfPrices=Keyword.getList(productPrices);
		
		for (String priceofSingleprdct : listOfPrices) {
			System.out.println(priceofSingleprdct);
		}
		
	}
	public void slideThePriceBar() {
		waitsFor.elementToBeClickableMethod(priceSlider);
		try {
			Keyword.clickOn(priceSlider);
			Keyword.dragAndDrop(priceSlider);
		} catch (Exception e) {
			waitsFor.waitForStaneless(priceSlider);
			Keyword.clickOn(priceSlider);
			Keyword.dragAndDrop(priceSlider);
		}
	}
		
	public boolean isAddToCartDisplayOnPrdctPage() {
		waitsFor.visiblityOfElement(addToCartPrdctPageButtn);
		return Keyword.isDisplayed(addToCartPrdctPageButtn);
	}
	public boolean isAddToCartEnableOnPrdctPage() {
		waitsFor.visiblityOfElement(addToCartPrdctPageButtn);
		return Keyword.isEnable(addToCartPrdctPageButtn);
	}
	
	public void applyBrandFilter(String brandName) {
        for (WebElement brandFilter : brandFilters) {
            if (brandFilter.getText().equalsIgnoreCase(brandName)) {
                waitsFor.visiblityOfElement(brandFilter);
                brandFilter.click();
                break;
            }
        }
        // Wait for the filtered results to load
        waitsFor.visibilityOfAllElemntMethod(brandFilters);
    }
	public void clickOnClassmateNotebook() {
		waitsFor.visiblityOfElement(classmateNotebookToSelect);
		Keyword.scrollwindow(classmateNotebookToSelect);
		Keyword.clickOn(classmateNotebookToSelect);
	}
	
	public void switchToProductWindow(String url) {
		SwitchWindowfor.switchingWindow(url);
		
	}
	public String getNameOfClassmateNotebook() {
		waitsFor.visiblityOfElement(classmateNotebookName);
		return Keyword.getText(classmateNotebookName);
	}
	public String getInStockMsg() {
		
		waitsFor.visiblityOfElement(inStockMsg);
		return Keyword.getText(inStockMsg);
	}
	public boolean isCustomerReviewDisplay() {
		waitsFor.visiblityOfElement(customerReview);
		return Keyword.isDisplayed(customerReview);
	}
	
	public List<String> getNotebookProductList() {
		waitsFor.visibilityOfAllElemntMethod(listOfNotebookProduct);
		List<String> listOfNotebookProducts=Keyword.getList(listOfNotebookProduct);
		return listOfNotebookProducts;
		
		
	}
	public String getProductDetails() {
		waitsFor.visiblityOfElement(classmateNotebookName);
		return Keyword.getText(classmateNotebookName);
	}
	
	

	
		
	
}
