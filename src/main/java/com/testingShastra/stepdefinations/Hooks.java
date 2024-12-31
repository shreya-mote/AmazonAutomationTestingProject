package com.testingShastra.stepdefinations;



import org.apache.log4j.Logger;

import com.testingShastra.Base.Keyword;
import com.testingShastra.utils.PropertiesFile;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	private static final Logger log = Logger.getLogger(Hooks.class);

	@Before
	public void setup() {
		Keyword.openBrowser(PropertiesFile.getBrowser());
		Keyword.launchUrl(PropertiesFile.getUrl("qa"));
		Keyword.driver.manage().window().maximize();
		log.info("Browser is Launch and Url is Open");
		
	}
	@After
	public void tearDown() {
		Keyword.driver.quit();
		log.info("close browser");
	}

}
