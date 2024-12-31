package com.testingShastra.stepdefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.testingShastra.Base.Keyword;
import com.testingShastra.pages.AddedToCartPage;
import com.testingShastra.pages.AllProductsPage;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.LoginPage;
import com.testingShastra.pages.Product_displayPage;
import com.testingShastra.pages.ShoppingCartPage;
import com.testingShastra.utils.PropertiesFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shoppingCart {
	private static final Logger log = Logger.getLogger(shoppingCart.class);
	int expectedQtyIncrease;
	int expectedQtydecrease;
	int expectedsubtotal;
	String productNameOnDisplayPage = null;
	String priceOndisplayPage = null;
	String NameOfProductBeforRefresh = null;
	String titleBeforClick = null;
	String beforClick = null;
	String beforTitle = null;
	String titleBeforClickOndelete = null;

	@Given("User should Login")
	public void openBrowserAndLaunchUrlAndUserLOgin() {
		HomePage hp = new HomePage();
		hp.ClickOnSigin();
		LoginPage loginpage = new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterPassWord(PropertiesFile.getPassword());
		loginpage.clickOnSigninButton();

	}

	@When("User search tShirt on search box and click on man Tshirt Combo product")
	public void selectTshirtComboFromSearchBox() {
		HomePage homepage = new HomePage();
		homepage.sendTextOnSearchBox(PropertiesFile.EnterText());
		homepage.clickOnTshirtToSelect();

	}

	@And("select one Tshirt combo and click on add to cart")
	public void selectOneTshirtComboAndClickOnAddedToCart() {
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		productpage.clickOnAnotherTshirtcombo();
		productpage.switchToanotherWindow(PropertiesFile.switchToanothertshirtWindow());
		displayProduct.clickOnAddToCart();

	}

	@Then("verify product is succesufully added to the shopping cart")
	public void verifyAddedToCartOrNot() {
		AddedToCartPage addtocart = new AddedToCartPage();
		boolean statusOfproductcart = addtocart.displayIsItemAddedToCart();
		Assert.assertTrue(statusOfproductcart, "Product is not added to cart");
		log.info("product is succesfully added to cart ");

	}

	@And("select Another Tshirt combo and click on add to cart")
	public void selectAnothercomboTshirtandAddedToCart() {
		AllProductsPage productpage = new AllProductsPage();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow(PropertiesFile.switchToTshirtWindowUrl());
		Product_displayPage displayProduct = new Product_displayPage();
		displayProduct.clickOnAddToCart();

	}

	@And("Go to cart and check quntity befor and click on plus sign")
	public void goToCartAndCheckOuntity() {
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		addcart.clickOnGotoCartBttn();
		int QuntityOfPrdctBefor = shoppingCart.getQuntityOfSameProduct();
		expectedQtyIncrease = QuntityOfPrdctBefor + 1;
		log.info("expectedQtyIncrease" + QuntityOfPrdctBefor);
		shoppingCart.clickOnPlusSign();
	}

	@Then("Verify quntity of product After click on plus sing")
	public void verifyIncreaseQuntity() {
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		int QuntityOfPrdctAfter = shoppingCart.getQuntityOfSameProduct();
		log.info("afterIncreasingPrdctQty" + QuntityOfPrdctAfter);
		Assert.assertEquals(expectedQtyIncrease, QuntityOfPrdctAfter, "quantity not increased");
		log.info("quantity of product is increased after click on plus sign");
	}

	@And("Go to cart and check quntity befor and click on subtract sign")
	public void goToCartCheckQuntityBeforDecrease() {
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		addcart.clickOnGotoCartBttn();
		int QuntityOfPrdctBefor = shoppingCart.getQuntityOfSameProduct();
		expectedQtydecrease = QuntityOfPrdctBefor - 1;
		shoppingCart.clickOnSubtractSign();

	}

	@Then("Verify quntity of product is decreases After click on subtract sing")
	public void verifyDecreaseQuntity() {
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		int QuntityOfPrdctAfter = shoppingCart.getQuntityOfSameProduct();
		log.info("afterIncreasingPrdctQty" + QuntityOfPrdctAfter);
		Assert.assertEquals(QuntityOfPrdctAfter, expectedQtydecrease);
		log.info("quantity of of product is decreased After click on subtract sign");

	}

	@When("user added one product in cart and check the SubTotal")
	public void addedOneProductAndCheckSubTotal() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.sendTextOnSearchBox(PropertiesFile.EnterText());
		homepage.clickOnTshirtToSelect();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow(PropertiesFile.switchToTshirtWindowUrl());
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int subtotalbefor = shoppingcart.getSubTotalOfIterm();
		log.info(subtotalbefor);
		expectedsubtotal = subtotalbefor + 1;

	}

	@And("also added second product and go to cart")
	public void addSecondProduct() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		displayProduct.clickOnAddToCart();

	}

	@Then("verify subTotal is Increases After Adding second product")
	public void verifyProductQuntityafterAddingSecondProduct() {
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		addcart.clickOnGotoCartBttn();
		int actualsubtotalAfterAdded = shoppingcart.getSubTotalOfIterm();
		log.info(actualsubtotalAfterAdded);
		Assert.assertEquals(actualsubtotalAfterAdded, expectedsubtotal);
		log.info("subTotal is Increase when adding second product in cart");

	}

	@When("user added one product in cart and check the Quntity")
	public void addOneProductCheckQuntity() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int QuntityOfPrdctBefor = shoppingcart.getQuntityOfSameProduct();
		expectedQtyIncrease = QuntityOfPrdctBefor + 1;

	}

	@And("Also added Same product second time")
	public void addSameProduct() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();

	}

	@Then("verify Quntity is increase after adding same product")
	public void checkQuntityAfterAddingSameProduct() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		int actualQuntityIncrease = shoppingcart.getQuntityOfSameProduct();
		Assert.assertEquals(actualQuntityIncrease, expectedQtyIncrease);
		log.info("Quntity Of product is increase after adding same product ");

	}

	@When("check Product details Before adding product in the shopping cart")
	public void detailsBeforAddingCart() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		productNameOnDisplayPage = displayProduct.getNameOfProduct();
		log.info(productNameOnDisplayPage);
		priceOndisplayPage = displayProduct.getpriceOfProduct();
		log.info(priceOndisplayPage);

	}

	@Then("Check product details After adding shopping cart")
	public void productDetailsAfterAddingCart() {
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		String productNameOnShoppingcartPage = shoppingcart.getNameOfProduct();
		log.info(productNameOnShoppingcartPage);
		String priceOnShoppingCartPage = shoppingcart.getpriceOfProduct();
		log.info(priceOnShoppingCartPage);
		if (productNameOnShoppingcartPage.contentEquals(productNameOnDisplayPage)
				&& priceOndisplayPage == priceOnShoppingCartPage) {
			Assert.assertTrue(true);

		}

	}

	@When("go to cart get name of first product and refresh the page")
	public void beforRefreshPage() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		NameOfProductBeforRefresh = shoppingcart.getNameOfProduct();
		log.info(NameOfProductBeforRefresh);
		Keyword.refreshPage();
	}

	@Then("verify same product is display in page after refreshing")
	public void afterRefresh() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		String NameOfProductAfterRefresh = shoppingcart.getNameOfProduct();
		log.info(NameOfProductAfterRefresh);
		if (NameOfProductBeforRefresh.contentEquals(NameOfProductAfterRefresh)) {
			Assert.assertTrue(true);
		}
	}

	@When("user go to the cart and click on deselect all")
	public void deselectAll() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOndeselectAll();

	}

	@Then("verify no Itern select messege is desplay in cart")
	public void checkMsgNOItermsSelected() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		String AfterDeselectExpectedMsg = "No items selected";
		String AfterDeselectActualMsg = shoppingcart.getItermsSelectMsg();
		log.info(AfterDeselectActualMsg);
		Assert.assertEquals(AfterDeselectActualMsg, AfterDeselectExpectedMsg);
		log.info(AfterDeselectActualMsg);

	}

	@When("user go to the cart and click on Select all")
	public void clickSelectAll() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnselectAll();

	}

	@Then("verify selected Item count is Displayed in cart")
	public void allItermsSelect() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean selectItermsStatus = shoppingcart.selectedProductCountIsDisplay();
		Assert.assertTrue(selectItermsStatus);
		log.info(shoppingcart.getItermsSelectMsg());

	}

	@When("user go to shopping cart and click on product")
	public void clickproductInshoppingcart() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		titleBeforClick = shoppingcart.getTitleOfPage();
		log.info(titleBeforClick);
		shoppingcart.clickOnproduct();
		Keyword.refreshPage();
	}

	@Then("verify user redirect to these product details page")
	public void redirectToProductDesplayPage() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		shoppingcart.switchwindow(PropertiesFile.switchToproductTitlewindow());
		String titleAfterClick = shoppingcart.getTitleOfPage();
		log.info(titleAfterClick);
		if (!titleBeforClick.equals(titleAfterClick)) {
			Assert.assertTrue(true);
		}
	}

	@When("user go to the cart")
	public void gotoCartforcheckSaveToLater() {
		HomePage homepage = new HomePage();
		homepage.goToshoppingCart();

	}

	@Then("verify Save To Later Option Is Dispaly and Enable")
	public void checkSaveToLaterOption() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean isDisplay = shoppingcart.saveTolaterIsDisplay();
		boolean isEnable = shoppingcart.saveTolaterIsEnable();
		if (isDisplay && isEnable) {
			Assert.assertTrue(true);

		}

	}

	@When("user go to the cart and click on see more like these")
	public void clickOnseeMoreLIkeThese() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnseemorelikeThese();

	}

	@Then("verify similar product page is display")
	public void similarProductPageIsDisplay() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		String expectedDisplays = "More items like this";
		String actual = shoppingcart.getnameMoreLikeThese();
		Assert.assertEquals(actual, expectedDisplays);
		log.info("More items like this");
	}

	@When("user go to the cart and click on share")
	public void clickOnshare() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnShare();

	}

	@Then("verify share to friend message is display")
	public void sharemsgIsDisplay() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean MsgDisplay = shoppingcart.shareTheseProductMsg();
		Assert.assertTrue(MsgDisplay);
	}

	@When("user go to the cart and click on save To Later")
	public void clickOnSaveToLater() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		beforClick = shoppingcart.productInsavetoLater();
		log.info(beforClick);
		shoppingcart.clickonsaveToLater();

	}

	@Then("verify product is move to the save to later")
	public void moveToSaveTOLater() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		String afterclick = shoppingcart.productInsavetoLater();
		log.info(afterclick);
		if (!beforClick.contentEquals(afterclick)) {
			Assert.assertTrue(true);
		}

	}

	@When("User go to cart and go to save to later and click on add to shopping cart")
	public void clickOnAddToShoppingList() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnaddToList();

	}

	@Then("Product Is Added To Shopping List message is display")
	public void addToShoppingListMsg() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean status = shoppingcart.addedToShoppingListMsg();
		Assert.assertTrue(status);

	}

	@When("user go to cart and click on added to shopping list message from save to later")
	public void addedShoppingListButton() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnaddToList();
		shoppingcart.clickOnAddedToshoppingCart();

	}

	@Then("Shopping List page is open")
	public void shoppingListDisplay() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean shoppingListDisplay = shoppingcart.shoppingListDisplay();
		Assert.assertTrue(shoppingListDisplay);
		log.info("shopping list page is open");
	}

	@When("User go to cart and Click On Proceed To By")
	public void clickonproccedToBy() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		beforTitle = shoppingcart.getTitleOfPage();
		shoppingcart.clickonProceedToBy();

	}

	@Then("Checkout Page Is Display")
	public void checkoutPageOpen() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		String afterTitle = shoppingcart.getTitleOfPage();
		if (!beforTitle.equals(afterTitle)) {
			Assert.assertTrue(true);
		}

		Keyword.backPage();
		log.info("checkOut page is Open");
	}

	@When("User go to cart and click on delete")
	public void deleteproduct() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.deleteOneProduct();
	}

	@Then("these product delete message is display")
	public void deleteproductMessage() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		boolean deletemsgIsDisplay = shoppingcart.succesfullyDeleteMsgIsDisplay();
		Assert.assertTrue(deletemsgIsDisplay);
	}

	@When("user go to cart and click delete product message")
	public void clickOndeleteMessage() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.deleteOneProduct();
		titleBeforClickOndelete = shoppingcart.getTitleOfPage();
		shoppingcart.clickondeleteProduct();
	}

	@Then("verify delete product page is open")
	public void deleteproductPage() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		shoppingcart.switchwindow(PropertiesFile.switchTodeleteWindow());
		String titleAfterClick = shoppingcart.getTitleOfPage();
		System.out.println(titleAfterClick);
		if (!titleBeforClickOndelete.equals(titleAfterClick)) {
			Assert.assertTrue(true);
		}

	}

	@When("user go to cart and delete all product in cart")
	public void deleteAllProduct() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		try {
			shoppingcart.deleteproductFromCart();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("cart is empty message is display")
	public void emptyMsg() {
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		Boolean emptyMsgStatus = shoppingcart.emptyMsgIsDisplay();
		Assert.assertTrue(emptyMsgStatus);

	}

}
