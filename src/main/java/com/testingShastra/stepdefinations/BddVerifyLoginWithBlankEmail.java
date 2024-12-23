package com.testingShastra.stepdefinations;

import org.testng.Assert;

import com.testingShastra.Base.Keyword;
import com.testingShastra.pages.AddToCart;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.ProductPage;
import com.testingShastra.utils.PropertiesFile;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BddVerifyLoginWithBlankEmail {
	@Before
	@Given("Browser is opened and app url is launched")
	public void browserIsOpenedAndAppUrlIsLaunched() {
		Keyword.openBrowser(PropertiesFile.getBrowser());
		Keyword.launchUrl(PropertiesFile.getUrl("qa"));
		Keyword.driver.manage().window().maximize();
		
		
	}
	@When("User search for product on searchbar")
	public void searchForProduct() {
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBox("titan watch");
}
	@And("Select product from suggested list")
	public void clickOnSuggestedList() {
		HomePage homepage=new HomePage();
		homepage.clickOnTshirtToSelect();
	}
	@And("click on desired product")
	public void clickOnDesiredProduct() {
		ProductPage productpage=new ProductPage();
		productpage.clickTshirtComboProductToSelect();
		}
	@And("User should navigate to add to cart page,click on add to cart button")
	public void addToCartButton() {
		ProductPage productpage=new ProductPage();
		productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
		AddToCart addtocart=new AddToCart();
		addtocart.clickOnAddToCartButton();
		
	}
	@Then("Verify that product is added into cart or not.")
	public void productIsAddedToCartOrNot() {
		AddToCart addtocart=new AddToCart();
		boolean statusOfproductcart=addtocart.displayIsItemAddedToCart();
		Assert.assertTrue(statusOfproductcart,"Product is not added to cart");
		System.out.println("product is succesfully added to cart");
	}
}
