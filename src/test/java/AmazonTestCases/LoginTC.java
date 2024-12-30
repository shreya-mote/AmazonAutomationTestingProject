package AmazonTestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingShastra.Base.Keyword;
import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.LoginPage;
import com.testingShastra.utils.PropertiesFile;
import com.testingShastra.utils.waitsFor;

public class LoginTC extends TestBase{
	@Test //1
	public void verifyUserCanLoginWithValidCredentials() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterPassword(PropertiesFile.getPassword());
		loginpage.clickOnSigninButton();
		boolean signInMsgStatus=homepage.isSigninMsgDisplayed();
		Assert.assertTrue(signInMsgStatus);

	}
	@Test  //2
	public void verifyUserLoginWithInvalidPhoneNumber() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterInvalidPhoneNumber();
		loginpage.clickOnContinue();
		boolean invalidPhoneNoMsgStatus=loginpage.invalidPhoneNoerrormsg();
		Assert.assertTrue(invalidPhoneNoMsgStatus);
		System.out.println("Invalid username login error msg ->> "+loginpage.getErrorMsg());
		
	}
	@Test //3
	public void verifyUserLoginValidPhoneNoInvalidPassword() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterInvalidPassword();
		loginpage.clickOnSigninButton();
		String expectedInvalidPasswordErrorMsg="Your password is incorrect";
		String ActualInvalidPasswordErrorMsg=loginpage.getErrorMsgInvalidPassword();
		Assert.assertEquals(expectedInvalidPasswordErrorMsg, ActualInvalidPasswordErrorMsg);
		System.out.println("Invalid password error msg ->> "+loginpage.getErrorMsgInvalidPassword());
	}
	@Test //4
	public void verifyUserLoginWithBlankUserName() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnContinue();
		loginpage.getBlankUsernameErrorMsg();
		String expectedBlankUsernameErrorMsg="Enter your email or mobile phone number";
		System.out.println("Expected Blank Username error msg ->> "+expectedBlankUsernameErrorMsg);
		String actualBlankUsernameErrorMsg=loginpage.getBlankUsernameErrorMsg();
		System.out.println("Actual Blank Username error msg ->> "+ actualBlankUsernameErrorMsg);
		Assert.assertEquals(expectedBlankUsernameErrorMsg,actualBlankUsernameErrorMsg);
	}
	@Test //5
	public void verifyUserLoginWithBlankPassword() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.clickOnSigninButton();
		String expectedBlankPasswordErrorMsg="Enter your password";
		System.out.println("Expected Blank Password error msg ->> "+expectedBlankPasswordErrorMsg);
        String actualBlankPasswordErrorMsg=loginpage.getBlankPasswordErrorMsg();
        System.out.println("Actual Blank Password error msg ->> "+actualBlankPasswordErrorMsg);
        Assert.assertEquals(expectedBlankPasswordErrorMsg, actualBlankPasswordErrorMsg);
	}
	@Test //6
	public void verifyUserLoginVaidPhoneNoValidPasswordUppercase() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterValidPasswordInUppercase();
		loginpage.clickOnSigninButton();
		String expectedValidUppercasePasswordErrorMsg="Your password is incorrect";
		String ActualValidUppercasePasswordErrorMsg=loginpage.getIncorrectPasswordErrorMsg();
		Assert.assertEquals(expectedValidUppercasePasswordErrorMsg, ActualValidUppercasePasswordErrorMsg);
		System.out.println("Invalid password error msg ->> "+loginpage.getIncorrectPasswordErrorMsg());
	
	}
	@Test //7
	public void verifyUserLoginVaidPhoneNoValidPasswordLowercase() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterValidPasswordInLowercase();
		loginpage.clickOnSigninButton();
		String expectedValidLowercasePasswordErrorMsg="Your password is incorrect";
		String ActualValidLowercasePasswordErrorMsg=loginpage.getIncorrectPasswordErrorMsg();
		Assert.assertEquals(expectedValidLowercasePasswordErrorMsg, expectedValidLowercasePasswordErrorMsg);
		System.out.println("Invalid password error msg ->> "+loginpage.getIncorrectPasswordErrorMsg());
	}
	@Test //8
	public void verifyUserRedirectedPasswordAssistancePage() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.clickOnForgetPasswordLink();
		String expectedUrl="https://www.amazon.in/ap/forgotpassword?";
		String expectedWindowTitle="Amazon Password Assistance";
		String ActualUrl= loginpage.getCurrentUrlOfWindow();
		String ActualWindowTitle=loginpage.getCurrentTitleOfWindow();
		Assert.assertTrue(ActualUrl.contains(expectedUrl),"Redirection to Password Assistance Page failed!");
		Assert.assertEquals(expectedWindowTitle, ActualWindowTitle,"Password Assistance Page title mismatch!");
	}
	
	@Test //9
	public void verifyDefaultCursorOnPhoneNoTextBox() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		WebElement ExpectedphoneTextbox=loginpage.returnUsernameTextboxWebelement();
		WebElement ActualactiveElement= Keyword.driver.switchTo().activeElement();
		Assert.assertEquals(ExpectedphoneTextbox, ActualactiveElement);
		
	}
	@Test //10
	public void verifyPasswordMasking() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.enterPassword(PropertiesFile.getPassword());
		String expectedAttribute="password";
		String actualAttribute=loginpage.getAttributeOfWebelement();
		Assert.assertEquals(expectedAttribute, actualAttribute);
		
	}
	@Test //11
	public void verifyUserLoginLessThan10DigitPhoneNo() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumberLess10Digit();
		loginpage.clickOnContinue();
		String expectedErrorMsg="Incorrect phone number";
		String actualErrorMsg=loginpage.getErrorMsgInvalidPhoneNo();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	@Test //12
	public void verifyUserLoginNonNumericPhoneNo() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterNonNumericPhoneNumber();
		loginpage.clickOnContinue();
		String expectedErrorMsg="Wrong or Invalid email address or mobile phone number. Please correct and try again.";
	    String actualErrorMsg=loginpage.getInvalidEmailPhoneNoErrorMsg();
	    Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	@Test //13
	public void verifyIsAmzonLogoIsPresent() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		boolean isLogoPresent=loginpage.isDisplayingAmazonLogo();
		Assert.assertTrue(isLogoPresent,"Logo is not present");
	}
	@Test //14
	public void verifyCopyPasteFunctiionalityPasswordTextBox() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		String password=PropertiesFile.getPassword();
		loginpage.pastePasswordInPasswordBox(password);
		String enterdPassword=loginpage.getPasswordTextBox().getAttribute("value");
		Assert.assertEquals(enterdPassword, password);
		
	}
	@Test //15
	public void verifyUserLoginWithValidCredenByPressingEnter() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinueByEnterKey();
		loginpage.enterPassword(PropertiesFile.getPassword());
		loginpage.clickOnSigninByEnterKey();
		boolean signInMsgStatus=homepage.isSigninMsgDisplayed();
		Assert.assertTrue(signInMsgStatus);
		
	}
	@Test //16
	public void verifyUserLoginByInvalidEmailFormat() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterInvalidEmailFormat();
		loginpage.clickOnContinue();
		String expectedErrorMsg="Wrong or Invalid email address or mobile phone number. Please correct and try again.";
		String actualerrorMsg=loginpage.getInvalidEmailPhoneNoErrorMsg();
		Assert.assertEquals(expectedErrorMsg, actualerrorMsg);
	}
	@Test //17
	public void verifyLoginPageTitle() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		String expectedTitle="Amazon Sign In";
		String actualTitle=loginpage.getTitleofPage();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test //18
	public void verifyConditionOfUseLinkWorkingProperly() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnConditionOfUseLink();
		String expectedTitle="Conditions of Use - Amazon Customer Service";
		String actualTitle=loginpage.getTitleofPage();
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	@Test //19
	public void verifyUserClickOnCreateAccountButton() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnCreateAccountBttn();
		String expectedTitle="Amazon Registration";
		String actualTitle=loginpage.getCurrentTitleOfWindow();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test //20
	public void verifyClickingOnLogoRedirectingHomePage() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnAmazonLogo();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle=loginpage.getTitleofPage();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test //21
	public void verifyValidPhoneNoBlankPassword() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.enterPhoneNumber(PropertiesFile.getUserName());
		loginpage.clickOnContinue();
		loginpage.clickOnSigninButton();
		boolean errorMsg=loginpage.isErrorMsgDisplayed();
		Assert.assertTrue(errorMsg);
		
	}
	
	
	
	
	

}
