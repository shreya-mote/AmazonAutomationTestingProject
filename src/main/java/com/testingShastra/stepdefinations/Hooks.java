package com.testingShastra.stepdefinations;

import org.testng.annotations.AfterMethod;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.PropertiesFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void setup() {
		Keyword.openBrowser(PropertiesFile.getBrowser());
		Keyword.launchUrl(PropertiesFile.getUrl("qa"));
		Keyword.driver.manage().window().maximize();
	}
	@After
	public void tearDown() {
		Keyword.driver.quit();
	}

}
