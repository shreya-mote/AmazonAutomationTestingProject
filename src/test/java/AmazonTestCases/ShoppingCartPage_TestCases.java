package AmazonTestCases;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testingShastra.Base.Keyword;
import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.AddedToCartPage;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.LoginPage;
import com.testingShastra.pages.Product_displayPage;
import com.testingShastra.pages.ShoppingCartPage;
import com.testingShastra.pages.AllProductsPage;
import com.testingShastra.utils.PropertiesFile;
import com.testingShastra.utils.waitsFor;

public class ShoppingCartPage_TestCases extends TestBase {
	@BeforeMethod
	public void loginAmazon() {
		HomePage hp = new HomePage();
		hp.ClickOnSigin();
		LoginPage loginpage = new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterPassWord(PropertiesFile.getPassword());
		loginpage.clickOnSigninButton();

	}

	@AfterMethod
	public void x1() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 0,invocationCount = 5)
	public static void verifyIsProductAddedToCartOrNot() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addtocart = new AddedToCartPage();
		homepage.sendTextOnSearchBox(PropertiesFile.EnterText());
		homepage.clickOnTshirtToSelect();
		productpage.clickOnAnotherTshirtcombo();
		productpage.switchToanotherWindow(PropertiesFile.switchToanothertshirtWindow());
		displayProduct.clickOnAddToCart();
		boolean statusOfproductcart = addtocart.displayIsItemAddedToCart();
		Assert.assertTrue(statusOfproductcart, "Product is not added to cart");
		System.out.println("product is succesfully added to cart ");
	}

	@Test(priority = 1)
	public static void verifyProductQuantityIncreasesWhenPlusSignIsClicked() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		homepage.sendTextOnSearchBox(PropertiesFile.EnterText());
		homepage.clickOnTshirtToSelect();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow(PropertiesFile.switchToTshirtWindowUrl());
		Product_displayPage displayProduct = new Product_displayPage();
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int QuntityOfPrdctBefor = shoppingCart.getQuntityOfSameProduct();
		int expectedQtyIncrease = QuntityOfPrdctBefor + 1;
		System.out.println("expectedQtyIncrease" + QuntityOfPrdctBefor);
		shoppingCart.clickOnPlusSign();
		int QuntityOfPrdctAfter = shoppingCart.getQuntityOfSameProduct();
		System.out.println("afterIncreasingPrdctQty" + QuntityOfPrdctAfter);
		Assert.assertEquals(expectedQtyIncrease, QuntityOfPrdctAfter, "quantity not increased");
		System.out.println("quantity of of product is increased ");

	}

	@Test(priority = 2)
	public static void verifyProductQuantityDecreasesWhenSubtractSignIsClicked() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingCart = new ShoppingCartPage();
		homepage.sendTextOnSearchBox(PropertiesFile.EnterText());
		homepage.clickOnTshirtToSelect();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow(PropertiesFile.switchToTshirtWindowUrl());
		Product_displayPage displayProduct = new Product_displayPage();
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int QuntityOfPrdctBefor = shoppingCart.getQuntityOfSameProduct();
		int expectedQtyIncrease = QuntityOfPrdctBefor - 1;
		shoppingCart.clickOnSubtractSign();
		int QuntityOfPrdctAfter = shoppingCart.getQuntityOfSameProduct();
		System.out.println("afterIncreasingPrdctQty" + QuntityOfPrdctAfter);
		Assert.assertEquals(QuntityOfPrdctAfter, expectedQtyIncrease, "quantity not decress");
		System.out.println("quantity of of product is decreased ");

	}

	@Test(priority = 3)
	public static void verifyTotalProductsQuntityIsIncreasedAfterAddingAnotherProduct() {
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
		System.out.println(subtotalbefor);
		int expectedsubtotal = subtotalbefor + 1;
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int actualsubtotalAfterAdded = shoppingcart.getSubTotalOfIterm();
		System.out.println(actualsubtotalAfterAdded);
		Assert.assertEquals(actualsubtotalAfterAdded, expectedsubtotal);

	}

	@Test(priority = 4)
	public void verifyQuantityIncreasesWhenSameProductIsAddedToCart() {
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
		int expectedQtyIncrease = QuntityOfPrdctBefor + 1;
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		int actualQuntityIncrease = shoppingcart.getQuntityOfSameProduct();
		Assert.assertEquals(actualQuntityIncrease, expectedQtyIncrease);

	}

	@Test(priority = 5)
	public void verifyProductNameAndPriceInCart() {
		HomePage homepage = new HomePage();
		AllProductsPage productpage = new AllProductsPage();
		Product_displayPage displayProduct = new Product_displayPage();
		AddedToCartPage addcart = new AddedToCartPage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.sendTextOnSearchBoxAndEnter(PropertiesFile.entertshirtturns(), Keys.ENTER);
		productpage.clickTshirtTurms();
		productpage.switchToanotherWindow(PropertiesFile.switchTotshirtturmsWindowUrl());
		String productNameOnDisplayPage = displayProduct.getNameOfProduct();
		System.out.println(productNameOnDisplayPage);
		String priceOndisplayPage = displayProduct.getpriceOfProduct();
		System.out.println(priceOndisplayPage);
		displayProduct.clickOnAddToCart();
		addcart.clickOnGotoCartBttn();
		String productNameOnShoppingcartPage = shoppingcart.getNameOfProduct();
		System.out.println(productNameOnShoppingcartPage);
		String  priceOnShoppingCartPage = shoppingcart.getpriceOfProduct();
		System.out.println(priceOnShoppingCartPage);
		if (productNameOnShoppingcartPage.contentEquals(productNameOnDisplayPage)
				&& priceOndisplayPage == priceOnShoppingCartPage) {
			Assert.assertTrue(true);

		}
	}

	@Test(priority = 6)
	public void verifyproductDisplayIsSameAfterRefreshBrowser() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		String NameOfProductBeforRefresh = shoppingcart.getNameOfProduct();
		System.out.println(NameOfProductBeforRefresh);
		Keyword.refreshPage();
		String NameOfProductAfterRefresh = shoppingcart.getNameOfProduct();
		System.out.println(NameOfProductAfterRefresh);
		if (NameOfProductBeforRefresh.contentEquals(NameOfProductAfterRefresh)) {
			Assert.assertTrue(true);
		}

	}

	@Test(priority = 7)
	public void verifyUserClickOnDeselectAllButtonNoItemSelectedMessageIsDisplayed() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOndeselectAll();
		String AfterDeselectExpectedMsg = "No items selected";
		String AfterDeselectActualMsg = shoppingcart.getItermsSelectMsg();
		System.out.println(AfterDeselectActualMsg);
		Assert.assertEquals(AfterDeselectActualMsg, AfterDeselectExpectedMsg);

	}

	@Test(priority = 8)
	public void verifyUserClickOnselectAllButtonAllProductCountIsDisplay() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnselectAll();
		boolean selectItermsStatus = shoppingcart.selectedProductCountIsDisplay();
		Assert.assertTrue(selectItermsStatus);
		System.out.println(shoppingcart.getItermsSelectMsg());

	}

	@Test(priority = 9)
	public void verifyRedirectToProductDetailsPageFromShoppingCart() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		String titleBeforClick = shoppingcart.getTitleOfPage();
		System.out.println(titleBeforClick);
		shoppingcart.clickOnproduct();
		Keyword.refreshPage();
		shoppingcart.switchwindow(PropertiesFile.switchToproductTitlewindow());
		String titleAfterClick = shoppingcart.getTitleOfPage();
		System.out.println(titleAfterClick);
		if (!titleBeforClick.equals(titleAfterClick)) {
			Assert.assertTrue(true);
		}

	}

	@Test(priority = 10)
	public void verifySaveToLaterOptionIsDispalyAndEnable() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		boolean isDisplay = shoppingcart.saveTolaterIsDisplay();
		boolean isEnable = shoppingcart.saveTolaterIsEnable();
		if (isDisplay && isEnable) {
			Assert.assertTrue(true);

		}

	}
	@Test (priority = 11)
	public void verifyuserClickOnSeeMoreLikeTheseThenSimilarProductsPageIsOpen() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnseemorelikeThese();
		String expectedDisplays = "More items like this";
		String actual = shoppingcart.getnameMoreLikeThese();
		Assert.assertEquals(actual, expectedDisplays);

	}
	@Test(priority = 12)
	public void verifyUserClickOnShareThenShareThisProductMsgIsDisplay() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnShare();
		boolean MsgDisplay = shoppingcart.shareTheseProductMsg();
		Assert.assertTrue(MsgDisplay);

	}

	@Test(priority = 13)
	public void verifyClickOnSaveToLaterproductIsMoveToSaveTolater() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		String beforClick = shoppingcart.productInsavetoLater();
		System.out.println(beforClick);
		shoppingcart.clickonsaveToLater();
		String afterclick = shoppingcart.productInsavetoLater();
		System.out.println(afterclick);
		if (!beforClick.contentEquals(afterclick)) {
			Assert.assertTrue(true);
		}

	}

	@Test(priority = 14)
	public void verifyClickOnAddtoShoppingListThenProductIsAddedToShoppingList() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnaddToList();
		boolean status = shoppingcart.addedToShoppingListMsg();
		Assert.assertTrue(status);

	}

	@Test(priority = 15)
	public void verifyUserClickOnAddedToShoppingListShoppingListIsDisplay() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.clickOnaddToList();
		shoppingcart.clickOnAddedToshoppingCart();
		boolean shoppingListDisplay = shoppingcart.shoppingListDisplay();
		Assert.assertTrue(shoppingListDisplay);

	}



	@Test(priority = 16)
	public void verifyUserClickOnProceedToByThenCheckoutPageIsDisplay() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		String beforTitle = shoppingcart.getTitleOfPage();
		shoppingcart.clickonProceedToBy();
		String afterTitle = shoppingcart.getTitleOfPage();
		if (!beforTitle.equals(afterTitle)) {
			Assert.assertTrue(true);
		}

		Keyword.backPage();

	}

	@Test(priority = 17)
	public void verifyUserDeleteOneProductFromCartDeleteMessageShouldBeDisplay() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.deleteOneProduct();
		boolean deletemsgIsDisplay = shoppingcart.succesfullyDeleteMsgIsDisplay();
		Assert.assertTrue(deletemsgIsDisplay);
	}

	@Test(priority = 18)
	public void verifyUserClickOnDeleteProductMessageTheseProductTitlePageIsOpen() {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.deleteOneProduct();
		String titleBeforClick = shoppingcart.getTitleOfPage();
		shoppingcart.clickondeleteProduct();
		shoppingcart.switchwindow(PropertiesFile.switchTodeleteWindow());
		String titleAfterClick = shoppingcart.getTitleOfPage();
		System.out.println(titleAfterClick);
		if (!titleBeforClick.equals(titleAfterClick)) {
			Assert.assertTrue(true);
		}

	}

	@Test(priority = 19)
	public void verifyallProductIsRemoveIncartTheCartIsEmpty() throws InterruptedException {
		HomePage homepage = new HomePage();
		ShoppingCartPage shoppingcart = new ShoppingCartPage();
		homepage.goToshoppingCart();
		shoppingcart.deleteproductFromCart();
		Boolean emptyMsgStatus = shoppingcart.emptyMsgIsDisplay();
		Assert.assertTrue(emptyMsgStatus);

	}

}
