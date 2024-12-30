package AmazonTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingShastra.pages.LoginPage;
import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.HomePage;

public class LoginPage_TestCases extends TestBase{
	@Test
	public  void userEnterBlankEmail() {
		HomePage hp=new HomePage();
		hp.ClickOnSigin();
		LoginPage lp=new LoginPage();
		lp.clickOnContinue();
		boolean MessageStatus=lp.errormsg();
		Assert.assertTrue(MessageStatus);
		System.out.println("Enter emailID");
		
	}

}
