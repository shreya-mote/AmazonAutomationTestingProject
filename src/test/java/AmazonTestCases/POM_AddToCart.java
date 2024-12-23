package AmazonTestCases;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.AddToCart;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.ProductPage;
import com.testingShastra.utils.waitsFor;

public class POM_AddToCart extends TestBase{
	@Test(priority = 0)
	public static void testCase_VerifyIsProductAddedToCartOrNot() {
	HomePage homepage=new HomePage();
	homepage.sendTextOnSearchBox("TShirts");
	homepage.clickOnTshirtToSelect();
	ProductPage productpage=new ProductPage();
	productpage.clickTshirtComboProductToSelect();
	productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
	AddToCart addtocart=new AddToCart();
	addtocart.clickOnAddToCartButton();
	boolean statusOfproductcart=addtocart.displayIsItemAddedToCart();
	Assert.assertTrue(statusOfproductcart,"Product is not added to cart");
	System.out.println("product is succesfully added to cart ");
}
	@Test(priority = 1)
	public static void shoppingCartButtnIsDisplayOrNot() {
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBox("TShirts");
		homepage.clickOnTshirtToSelect();
		ProductPage productpage=new ProductPage();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
		AddToCart addtocart=new AddToCart();
		boolean statusOfAddTocartBttn=addtocart.isButtnAddToCartDisplay();
		Assert.assertTrue(statusOfAddTocartBttn,"add to cart button is not displayed");
		System.out.println("Add to cart button is displayed on product page ");
		homepage.cleanTextOnSearchBar();
	}
	@Test(priority = 2)
	public static void isQntityIsIncreasedAfterAddingPrdct() {
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBox("TShirts");
		homepage.clickOnTshirtToSelect();
		ProductPage productpage=new ProductPage();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
		AddToCart addtocart=new AddToCart();
		addtocart.clickOnAddToCartButton();
		addtocart.clickOnGotoCartBttn();
		int qtyOfPrdct=addtocart.getQtyOfProductBefore();
		int expectedQtyIncrease= qtyOfPrdct+1;
		System.out.println("expectedQtyIncrease"+expectedQtyIncrease);
		addtocart.clickOnIncreaseQtyOfPrdct();
		int afterIncreasingPrdctQty=addtocart.QtyOfPrdctAfterAction();
		System.out.println("afterIncreasingPrdctQty"+afterIncreasingPrdctQty);
		Assert.assertEquals(expectedQtyIncrease, afterIncreasingPrdctQty,"quantity not increased");
		System.out.println("quantity of of product is increased ");
		
	}
	@Test(priority = 3)
	public static void verifyisQntityIsDecreasedAfterRemovingPrdct() {
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBox("TShirts");
		homepage.clickOnTshirtToSelect();
		ProductPage productpage=new ProductPage();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
		AddToCart addtocart=new AddToCart();
		addtocart.clickOnAddToCartButton();
		addtocart.clickOnGotoCartBttn();
		int qtyOfPrdct=addtocart.getQtyOfProductBefore();
		int expectedQtyDecrease= qtyOfPrdct-1;
		System.out.println("expectedQtyDecrease"+expectedQtyDecrease);
		addtocart.clickOnDecreaseQtyOfPrdct();
		int afterDecreasingPrdctQty=addtocart.QtyOfPrdctAfterAction();
		System.out.println("afterDecreasingPrdctQty"+ afterDecreasingPrdctQty);
		Assert.assertEquals(expectedQtyDecrease, afterDecreasingPrdctQty,"quantity not decreased");
		System.out.println("quantity of of product is decreased ");
		
	}
	@Test(priority = 4)
	public static void verifyQntyIsIncreasedAfterAddingAnotherProduct() {
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBox("TShirts");
		homepage.clickOnTshirtToSelect();
		ProductPage productpage=new ProductPage();
		productpage.clickTshirtComboProductToSelect();
		productpage.switchToanotherWindow("BULLMER-Trendy-Printed-Cotton-Sleeve/dp/B0DJYLZVMD/ref=sr_1_11?");
		AddToCart addtocart=new AddToCart();
		addtocart.clickOnAddToCartButton();
		addtocart.clickOnGotoCartBttn();
		int subtotalBeforeAdding=addtocart.getQntyofSubtotal();
		int subtotal=subtotalBeforeAdding+1;
		System.out.println("subtotal"+ subtotal);
		
		homepage.sendTextOnSearchBoxAndEnter("TShirts turms",Keys.ENTER);
		productpage.clickSecondItemTshirtProductToSelect();
		productpage.switchToanotherWindow("TURMS-Repellent-Stretchable-Regular-Breathable/dp/B0CNTNF15M/ref=sr_1_1_sspa?");
		addtocart.clickOnAddToCartButton();
		addtocart.clickOnGotoCartBttn();
		int subtotalAfterAdding=addtocart.getQntyofSubtotal();
		System.out.println("subtotalAfterAdding"+ subtotalAfterAdding);
		Assert.assertEquals(subtotal, subtotalAfterAdding,"subTotal is not correct");
		System.out.println("subtotal working correctly");
	}
	
}
