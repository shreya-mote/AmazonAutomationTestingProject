package AmazonTestCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingShastra.pages.LoginPage;
import com.testingShastra.pages.Product_displayPage;
import com.testingShastra.Base.Keyword;
import com.testingShastra.Base.TestBase;
import com.testingShastra.pages.HomePage;

public class LoginPage_TestCases extends TestBase{
	@Test
	public  void userEnterBlankEmail() {
		Product_displayPage pd=new Product_displayPage();
		HomePage homepage=new HomePage();
		homepage.sendTextOnSearchBoxAndEnter("notebook",Keys.ENTER);
		pd.applyBrandFilter("classmate");
		
		
	}
	

}
