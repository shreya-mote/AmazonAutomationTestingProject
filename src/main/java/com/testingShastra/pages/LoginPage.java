package com.testingShastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingShastra.Base.Keyword;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Keyword.driver,this);
	}
	@FindBy(xpath="//input[@id=\"continue\"]")
	private static WebElement continueButton;
	
	@FindBy(xpath="(//div[@class=\"a-alert-content\"])[3]")
	private static WebElement errorMsg;
	
	public void clickOnContinue() {
		Keyword.clickOn(continueButton);
		
	}
	public void getErrorMsg() {
		
	}
	public boolean errormsg() {
		return Keyword.isMessageDisplayed(errorMsg);
	}
	

}
