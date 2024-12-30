package com.testingShastra.Base;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import Exception.InvalidDriverException;

public abstract class Keyword {
	public static RemoteWebDriver driver;
	static JavascriptExecutor js;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new InvalidDriverException(browserName);
		}
	}

	public static void launchUrl(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
	}

	public static void clickOn(WebElement element) {
		element.click();
	}

	public static boolean isMessageDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static boolean isEnable(WebElement element) {
		return element.isEnabled();
	}

	public String emailInput(String email) {
		String text = driver.findElement(By.xpath(email)).getText();
		return text;
	}

	public static String getText(WebElement element) {
		String textMsg = element.getText();
		return textMsg;
	}

	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);

	}

	public static void sendKeys(WebElement element, String text, Keys enter) {
		element.sendKeys(text, enter);

	}

	public static void scrollwindow(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void clickUsingjavaScript(WebElement element) {
		js.executeScript("arguments[0].click();", element);

	}

	public static void handleDropDown(WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(2);
	}

	public static int getIntValueFromStringFormat(String element) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(element);
		int expectedCount = 0;
		while (m.find()) {
			expectedCount = Integer.parseInt(m.group());
		}
		return expectedCount;
	}

	public static WebElement getElementFromList(List<WebElement> elements, String textToCompare) {
		for (WebElement i : elements) {
			String listCurrentelement = i.getText();
			if (listCurrentelement.contains(textToCompare)) {
				return i;
			}

		}
		return null;
	}

	public static void cleanTextBox(WebElement element) {
		element.clear();
	}

	public static void refreshPage() {
		driver.navigate().refresh();

	}

	public static void backPage() {
		driver.navigate().back();

	}
	
	public static void moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);

	}

}
