package AmazonTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AmazonLoginValidCred {
	@Test
	public void AmazonLogin() {

	FirefoxDriver driver=new FirefoxDriver();
	driver.get("https://www.amazon.in/");
	WebElement signInBtnHomePage=driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
	signInBtnHomePage.click();
	WebElement emailTextBox=driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
	emailTextBox.sendKeys("shreya02.mote@gmail.com");
	WebElement continueButton=driver.findElement(By.xpath("//input[@id=\"continue\"]"));
	continueButton.click();
	WebElement passwordTextbox=driver.findElement(By.xpath("//input[@id=\"ap_password\"]"));
	passwordTextbox.sendKeys("Admin@123");
	WebElement signInButton=driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
	signInButton.click();
	}
}
