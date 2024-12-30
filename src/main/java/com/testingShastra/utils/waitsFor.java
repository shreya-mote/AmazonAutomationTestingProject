package com.testingShastra.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingShastra.Base.Keyword;

public class waitsFor {
	public static WebDriverWait wait = null;

	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(200));
		wait.ignoring(NoSuchElementException.class);
	}

	public static void elementToBeClickableMethod(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	

	public static void visibilityOfAllElemntMethod(List<WebElement> element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void waitForStaneless(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));

	}

	public static void visiblityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}
