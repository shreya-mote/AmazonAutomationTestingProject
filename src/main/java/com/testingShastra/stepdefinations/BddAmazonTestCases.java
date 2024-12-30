package com.testingShastra.stepdefinations;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testingShastra.Base.Keyword;
import com.testingShastra.pages.AddToCart;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.LoginPage;
import com.testingShastra.pages.ProductPage;
import com.testingShastra.utils.PropertiesFile;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BddAmazonTestCases {
	@Before
	@Given("Browser is opened and app url is launched")
	public void browserIsOpenedAndAppUrlIsLaunched() {
		Keyword.openBrowser(PropertiesFile.getBrowser());
		Keyword.launchUrl(PropertiesFile.getUrl("qa"));
		Keyword.driver.manage().window().maximize();

	}
	
	@When("User click on signin link")
	public void clickOnSignInButton() {
		HomePage homepage = new HomePage();
		homepage.ClickOnSigin();
	}
	@And("Wait for Enter your email or mobile phone number error message to appear")
	public void blankUsernameErrorMsg() {
		LoginPage loginpage = new LoginPage();
		loginpage.getBlankUsernameErrorMsg();
	}
	@Then("Verify error message is as expected or not")
	public void verifyErrorMsgAsExpected() {
		LoginPage loginpage = new LoginPage();
		String expectedBlankUsernameErrorMsg="Enter your email or mobile phone number";
		System.out.println("Expected Blank Username error msg ->> "+expectedBlankUsernameErrorMsg);
		String actualBlankUsernameErrorMsg=loginpage.getBlankUsernameErrorMsg();
		System.out.println("Actual Blank Username error msg ->> "+ actualBlankUsernameErrorMsg);
		Assert.assertEquals(expectedBlankUsernameErrorMsg,actualBlankUsernameErrorMsg);
	}

	@And("Enter valid phone number in username textbox")
	public void enterValidPhoneNo() {
		LoginPage loginpage = new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
	}

	@And("Click on continue button")
	public void clickOnContinueButton() {
		LoginPage loginpage = new LoginPage();
		loginpage.clickOnContinue();
	}

	@And("Enter valid password in password textbox")
	public void enterValidPassword() {
		LoginPage loginpage = new LoginPage();
		loginpage.enterPassword(PropertiesFile.getPassword());
	}

	@And("Click on signin button")
	public void clickOnSigninButtn() {
		LoginPage loginpage = new LoginPage();
		loginpage.clickOnSigninButton();
	}

	@Then("Verify that user logedin successfully or not")
	public void verifyUserSuccessfullyLogedIn() {
		HomePage homepage = new HomePage();
		boolean signInMsgStatus = homepage.isSigninMsgDisplayed();
		Assert.assertTrue(signInMsgStatus);
	}
	
	@And("Enter invalid phone number in username textbox")
	public void enterInavlidPhoneNumber() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterInvalidPhoneNumber();
	}
	
	@Then("Verify user get invalid phone number error message")
	public void verifyUserGettingInvalidPhoneNoErrorMsg() {
		LoginPage loginpage=new LoginPage();
		boolean invalidPhoneNoMsgStatus=loginpage.invalidPhoneNoerrormsg();
		Assert.assertTrue(invalidPhoneNoMsgStatus);
		System.out.println("Invalid username login error msg ->> "+loginpage.getErrorMsg());
	}
	//4
	@And("Enter invalid password in password textbox")
	public void enterInvalidPassword() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterInvalidPassword();
	}
	@Then("Verify user get invalid password error message")
	public void verifyInvalidPasswordErrorMsg() {
		LoginPage loginpage=new LoginPage();
		String expectedInvalidPasswordErrorMsg="Your password is incorrect";
		String ActualInvalidPasswordErrorMsg=loginpage.getErrorMsgInvalidPassword();
		Assert.assertEquals(expectedInvalidPasswordErrorMsg, ActualInvalidPasswordErrorMsg);
		System.out.println("Invalid password error msg ->> "+loginpage.getErrorMsgInvalidPassword());
	}
	//5
	@Then("Verify user get blank password error message")
	public void verifyBlankPasswordErrorMsg() {
		LoginPage loginpage=new LoginPage();
		String expectedBlankPasswordErrorMsg="Enter your password";
		System.out.println("Expected Blank Password error msg ->> "+expectedBlankPasswordErrorMsg);
        String actualBlankPasswordErrorMsg=loginpage.getBlankPasswordErrorMsg();
        System.out.println("Actual Blank Password error msg ->> "+actualBlankPasswordErrorMsg);
        Assert.assertEquals(expectedBlankPasswordErrorMsg, actualBlankPasswordErrorMsg);
	}
	//6
	@And("Enter valid Password in uppercase")
	public void enterValidPasswordInUppercase() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterValidPasswordInUppercase();
		
	}
	//7
	@And("Enter valid Password in lowercase")
	public void enterValidPasswordInLowercase() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterValidPasswordInLowercase();
	}
	//8
	@And("Click on forget password link")
	public void clickOnForgetPasswordLink() {
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnForgetPasswordLink();
	}
	@Then("Verify user is redirected to password assistance page")
	public void verifyUserRedirectedToPasswordAssistancePage() {
		LoginPage loginpage=new LoginPage();
		String expectedUrl="https://www.amazon.in/ap/forgotpassword?";
		String expectedWindowTitle="Amazon Password Assistance";
		String ActualUrl= loginpage.getCurrentUrlOfWindow();
		String ActualWindowTitle=loginpage.getCurrentTitleOfWindow();
		Assert.assertTrue(ActualUrl.contains(expectedUrl),"Redirection to Password Assistance Page failed!");
		Assert.assertEquals(expectedWindowTitle, ActualWindowTitle,"Password Assistance Page title mismatch!");
	}
	//9
	@Then("Verify cursor focus is on username textbox")
	public void verifyCursorFocusIsOnUsernameTextbox() {
		LoginPage loginpage=new LoginPage();
		WebElement ExpectedphoneTextbox=loginpage.returnUsernameTextboxWebelement();
		WebElement ActualactiveElement= Keyword.driver.switchTo().activeElement();
		Assert.assertEquals(ExpectedphoneTextbox, ActualactiveElement);
	}
	//10
	@Then("Verify password masking is performed")
	public void verifyPasswordMaskingFunction() {
		LoginPage loginpage=new LoginPage();
		String expectedAttribute="password";
		String actualAttribute=loginpage.getAttributeOfWebelement();
		Assert.assertEquals(expectedAttribute, actualAttribute);
	}
	//11
	@And("Enter phone number less than ten digit")
	public void enterValidPasswordInLowerCase() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumberLess10Digit();
	}
	@Then("Verify user get error message as Incorrect phone number")
	public void verifyInvalidPhoneNoErrorMsg() {
		LoginPage loginpage=new LoginPage();
		String expectedErrorMsg="Incorrect phone number";
		String actualErrorMsg=loginpage.getErrorMsgInvalidPhoneNo();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	//12
	@And("Enter non numeric phone number in username textbox")
	public void enterNonNumericPhoneNumber() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterNonNumericPhoneNumber();
	}
	@Then("Verify user get error message as Wrong or Invalid email address or mobile phone number. Please correct and try again.")
	public void verifyUserGettingUsernameErrorMsg() {
		LoginPage loginpage=new LoginPage();
		String expectedErrorMsg="Wrong or Invalid email address or mobile phone number. Please correct and try again.";
	    String actualErrorMsg=loginpage.getInvalidEmailPhoneNoErrorMsg();
	    Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	//13
	@Then("Verify is amazon logo is present on login page or not")
	public void verifyAmzonLogoIsPresentOrNot() {
		LoginPage loginpage=new LoginPage();
		boolean isLogoPresent=loginpage.isDisplayingAmazonLogo();
		Assert.assertTrue(isLogoPresent,"Logo is not present");
	}
	//14
	@And("Paste the password in password text box")
	public void pastePasswordInPasswordBox() {
		LoginPage loginpage=new LoginPage();
		String password=PropertiesFile.getPassword();
		loginpage.pastePasswordInPasswordBox(password);
	}
	@Then("Verify is paste functionality working or not")
	public void verifyPasteFunctionality() {
		LoginPage loginpage=new LoginPage();
		String password=PropertiesFile.getPassword();
		String enterdPassword=loginpage.getPasswordTextBox().getAttribute("value");
		Assert.assertEquals(enterdPassword, password);
	}
	//15
	@And("Hit enter key on continue")
	public void pressEnterKey() {
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnContinueByEnterKey();
	}
	@And("Hit enter key on sigin")
	public void pressEnterKeyOnSignin() {
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnSigninByEnterKey();
	}
	//16
	@And("Enter invalid email format")
	public void enterInvalidEmailFormat() {
		LoginPage loginpage=new LoginPage();
		loginpage.enterInvalidEmailFormat();
		
	}
	//17
	@Then("Verify login page title is as expected")
	public void verifyLoginPageTitle() {
		LoginPage loginpage=new LoginPage();
		String expectedTitle="Amazon Sign In";
		String actualTitle=loginpage.getTitleofPage();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	//18
	@And("Click on create account button")
	public void clickOnCreateAccountButton() {
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnCreateAccountBttn();
	}
	@Then("Verify is user redirect on create account page or not")
	public void verifyUserNavigateCreateAccountPage() {
		LoginPage loginpage=new LoginPage();
		String expectedTitle="Amazon Registration";
		String actualTitle=loginpage.getCurrentTitleOfWindow();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	//19
	@And("Click on amazon logo")
	public void clickOnAmazonLogo() {
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnAmazonLogo();
	}
	@Then("Verify is user navigate to amazon home page or not")
	public void verifyUserNavigateHomePage() {
		LoginPage loginpage=new LoginPage();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle=loginpage.getTitleofPage();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	//20
	@Then("Verify is it giving error message or not")
	public void verifyIsItShowingErrorMessage() {
		LoginPage loginpage=new LoginPage();
		boolean errorMsg=loginpage.isErrorMsgDisplayed();
		Assert.assertTrue(errorMsg);
	}

}
