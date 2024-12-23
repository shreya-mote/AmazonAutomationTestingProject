package AmazonTestCases;

import java.awt.Window;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddProductToCartTC  {
	@Test
	public void productAddToCart() throws InterruptedException {
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement searchBar=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		searchBar.sendKeys("titan watch");
		List<WebElement> searchListResult=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")));
			for (WebElement i : searchListResult) {
				String listText=null;
				try {
				 listText= i.getText();
				}
				catch (Exception e) {
					wait.until(ExpectedConditions.stalenessOf(i));
				} 
				System.out.println(listText);
				if (listText.equalsIgnoreCase("titan watch for woman")) {
					i.click();
					break;
				} else {
					continue;}
			}
			
		//Actions act=new Actions(driver);
		//driver.executeScript("Window.scrollBy(0,300)", null);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 WebElement watchToSelect=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Edge White Dial Analog Stainless Steel Strap Watch for Women-NS2654WM01\"]")));
		 js.executeScript("arguments[0].scrollIntoView(true);", watchToSelect);
		 //Thread.sleep(1000);
		 js.executeScript("arguments[0].click();", watchToSelect);
		// act.click(watchToSelect);
			
			
		}
	}
	
	


