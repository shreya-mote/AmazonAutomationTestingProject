package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testingShastra.Base.Keyword;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "input#ap_email")
	private static WebElement UserNameBox;

	@FindBy(css = "input#continue")
	private static WebElement continueButton;

	@FindBy(css = "input#ap_password")
	private static WebElement password;

	@FindBy(css = "input#signInSubmit")
	private static WebElement signinbutton;

	@FindBy(xpath = "(//div[@class=\"a-alert-content\"])[3]")
	private static WebElement errorMsg;

	public void EnterUserName(String text) {
		Keyword.sendKeys(UserNameBox, text);
	}

	public void clickOnContinue() {
		Keyword.clickOn(continueButton);

	}

	public void enterPassWord(String pass) {
		Keyword.sendKeys(password, pass);

	}

	public void clickOnSigninButton() {
		Keyword.clickOn(signinbutton);

	}

	public boolean errormsg() {
		return Keyword.isMessageDisplayed(errorMsg);
	}

}
