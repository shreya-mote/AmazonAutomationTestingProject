package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.PropertiesFile;
import com.testingShastra.utils.waitsFor;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "input#ap_email")
	private static WebElement phoneNumberTextBox;

	@FindBy(css = "input#ap_password")
	private static WebElement passwordTextBox;

	@FindBy(css = "input#signInSubmit")
	private static WebElement signinButton;


	@FindBy(css = "input#continue")
	private static WebElement continueButton;


	@FindBy(css = "input#ap_password")
	private static WebElement password;

	@FindBy(css = "input#signInSubmit")
	private static WebElement signinbutton;

	@FindBy(xpath = "(//div[@class=\"a-alert-content\"])[3]")
	private static WebElement errorMsg;

	
	@FindBy(css = "div.a-box-inner.a-alert-container ul span")
	private static WebElement invalidPasswordErrorMsg;

	@FindBy(css = "div#auth-error-message-box h4.a-alert-heading")
	private static WebElement invalidPhoneNoErrorMsg;

	@FindBy(css = "div#auth-email-missing-alert>div.a-box-inner.a-alert-container>div.a-alert-content")
	private static WebElement blankUserNameErrorMsg;

	//@FindBy(css = "div#auth-password-missing-alert div.a-alert-content")
	//private static WebElement blankPasswordErrorMsg;

	@FindBy(css = "div.a-alert-content li>span")
	private static WebElement incorrectPasswordErrorMsg;

	@FindBy(css = "a#auth-fpp-link-bottom")
	private static WebElement forgetPasswordLink;

	@FindBy(css = "div#auth-email-invalid-claim-alert div.a-alert-content")
	private static WebElement invalidEmailPhoneNoErrorMsg;

	@FindBy(css = "i.a-icon.a-icon-logo")
	private static WebElement amazonLogo;
	
	@FindBy(css="a[href=\"/gp/help/customer/display.html/ref=ap_signin_notification_privacy_notice?ie=UTF8&nodeId=468496\"]")
	private static WebElement conditionOfUseLink;
	
	@FindBy(css="a#createAccountSubmit")
	private static WebElement createAccountButton;
	
	@FindBy(css="div#auth-password-missing-alert>div.a-box-inner.a-alert-container>i+div")
	private static WebElement blankPasswordErrorMsg;
	

	public void clickOnContinue() {
		Keyword.clickOn(continueButton);

	}


	public void enterPassWord(String pass) {
		Keyword.sendKeys(password, pass);

	}

	
	public void clickOnCreateAccountBttn() {
		Keyword.clickOn(createAccountButton);
	}
	public void clickOnAmazonLogo() {
		Keyword.clickOn(amazonLogo);
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public void clickOnSigninButton() {
		Keyword.clickOn(signinButton);


	}

	public boolean errormsg() {
		return Keyword.isDisplayed(errorMsg);
	}

	public boolean isDisplayingAmazonLogo() {
		waitsFor.visiblityOfElement(amazonLogo);
		return Keyword.isDisplayed(amazonLogo);
	}

	public String getErrorMsgInvalidPassword() {
		return Keyword.getText(invalidPasswordErrorMsg);

	}

	public boolean invalidPhoneNoerrormsg() {
		return Keyword.isDisplayed(invalidPhoneNoErrorMsg);
	}

	public String getErrorMsgInvalidPhoneNo() {
		return Keyword.getText(invalidPhoneNoErrorMsg);

	}

	public void enterPhoneNumber(String text) {
		Keyword.sendKeys(phoneNumberTextBox, text);
	}

	public void enterPassword(String text) {
		waitsFor.elementToBeClickableMethod(passwordTextBox);
		Keyword.sendKeys(passwordTextBox, text);
	}

	public String getErrorMsg() {
		return Keyword.getText(invalidPhoneNoErrorMsg);

	}

	public WebElement returnUsernameTextboxWebelement() {
		return phoneNumberTextBox;

	}

	public String getAttributeOfWebelement() {
		return passwordTextBox.getAttribute("type");

	}

	public String getBlankUsernameErrorMsg() {
		return Keyword.getText(blankUserNameErrorMsg);
	}

	public String getBlankPasswordErrorMsg() {
		return Keyword.getText(blankPasswordErrorMsg);
	}

	public String getIncorrectPasswordErrorMsg() {
		return Keyword.getText(incorrectPasswordErrorMsg);
	}

	public String getInvalidEmailPhoneNoErrorMsg() {
		return Keyword.getText(invalidEmailPhoneNoErrorMsg);
	}

	public void clickOnForgetPasswordLink() {
		Keyword.clickOn(forgetPasswordLink);
	}

	public String getCurrentUrlOfWindow() {
		return Keyword.getCurrentUrl();

	}

	public String getCurrentTitleOfWindow() {
		return Keyword.getTitle();

	}

	public void enterInvalidPhoneNumber() {
		Keyword.sendKeys(phoneNumberTextBox, "12345678");
	}

	public void enterInvalidPassword() {
		Keyword.sendKeys(passwordTextBox, "abcde");
	}

	public void enterValidPasswordInUppercase() {
		Keyword.sendKeys(passwordTextBox, "RUPA@11");
	}

	public void enterValidPasswordInLowercase() {
		Keyword.sendKeys(passwordTextBox, "rupa@11");
	}

	public void enterPhoneNumberLess10Digit() {
		Keyword.sendKeys(phoneNumberTextBox, "942169085");
	}

	public void enterNonNumericPhoneNumber() {
		Keyword.sendKeys(phoneNumberTextBox, "123abc##");
	}
	public void enterInvalidEmailFormat() {
		Keyword.sendKeys(phoneNumberTextBox,"shreya14mote@@gmail.com" );
	}

	public void pastePasswordInPasswordBox(String password) {
		Keyword.pasteTextUsingActions(passwordTextBox, password);
	}
	public void clickOnContinueByEnterKey() {
		Keyword.pressKey(continueButton);
	}
	public void clickOnSigninByEnterKey() {
		Keyword.pressKey(signinButton);
	}
	public String getTitleofPage() {
		return Keyword.getTitle();
	}
	public void clickOnConditionOfUseLink() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		Keyword.clickOn(conditionOfUseLink);
	}
	public boolean isErrorMsgDisplayed() {
		return Keyword.isDisplayed(blankPasswordErrorMsg);
		
	}

}
