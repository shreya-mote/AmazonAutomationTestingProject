package com.testingShastra.Base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.testingShastra.utils.PropertiesFile;

public class TestBase  {
	@BeforeClass
	public void setup() {
		Keyword.openBrowser(PropertiesFile.getBrowser());
		Keyword.launchUrl(PropertiesFile.getUrl("qa"));
		Keyword.driver.manage().window().maximize();
	}
	/*@AfterMethod
	public void tearDown() {
		Keyword.driver.quit();
	}*/

}
