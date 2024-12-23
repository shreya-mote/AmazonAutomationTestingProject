package AmazonTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingShastra.Base.Keyword;
import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.HomePage;
import com.testingShastra.pages.LoginPage;

import Locators.Locators_amazon;

public class ProductTc_login extends TestBase  {
	@Test
public static void blankemail() {	
		ChromeDriver driver=new ChromeDriver();
		driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
		String email=driver.findElement(By.xpath("//input[@type='email']")).getText();
		driver.findElement(By.xpath("//span[@id='continue']")).click();
		System.out.println(email.length());
		if(email.length()==0) {
			String msg=driver.findElement(By.xpath("(//div[@class='a-alert-content'])[3]")).getText();
			String expectedMsg="Enter your email or mobile phone number";
			/*if(msg.equalsIgnoreCase("Enter your email or mobile phone number")) {
				System.out.println("Pass");
			}
			else
				System.out.println("Fail");*/
			Assert.assertEquals(msg, expectedMsg);
		}
	}
	@Test
	public void loginBlankmail() {
		HomePage homepage=new HomePage();
		homepage.ClickOnSigin();
		LoginPage loginpage=new LoginPage();
		loginpage.clickOnContinue();
		boolean msgStatus=loginpage.errormsg();
		String expectedMsg="Enter your email or mobile phone number";
		Assert.assertTrue(msgStatus, expectedMsg);
		
	}
	
}
