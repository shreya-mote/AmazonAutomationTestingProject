package com.testingshashtra.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/* "src/test/resources/features/amazon.feature","src/test/resources/features/shopping_cart_Test.feature"*/
@CucumberOptions(
	    features = {"src/test/resources/features/product_page.feature"},
	    glue = "com.testingShastra.stepdefinations",
	    tags = "@today",
	    dryRun = false,
	    plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
	)
public class FeatureRunner extends AbstractTestNGCucumberTests{
	

}
