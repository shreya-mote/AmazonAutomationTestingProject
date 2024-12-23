package AmazonTestCases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TshirtAddToCart {
	WebDriver driver;

	@BeforeMethod
	public void setUpMethod() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@Test
	public void AmazonSearch() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	        search.click();
	        search.sendKeys("titan watch");
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")));
	        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
	        System.out.println("Number of suggestions found: " + listOfElements.size());
	       for (int i = 0; i < listOfElements.size(); i++) {
	            WebElement element = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']")).get(i);
	            String name = element.getText();
	            System.out.println(name);
	            if (name.contains("titan watch for woman")) {
	                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	                break;
	            }
	        }
	        
	        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//span[text()=\"Edge White Dial Analog Stainless Steel Strap Watch for Women-NS2654WM01\"]")
	        ));
	        js.executeScript("arguments[0].scrollIntoView(true);", product);
	        js.executeScript("arguments[0].click();", product);
	    
	        String currentWindowId = driver.getWindowHandle();
	        Set<String> allWindowIds = driver.getWindowHandles();
	        for (String windowId : allWindowIds) {
	            if (!windowId.equals(currentWindowId)) {
	                driver.switchTo().window(windowId);
	                break;
	            }
	        }
	        
	        System.out.println("Switched to new window: " + driver.getTitle());
	        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
	        js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	        js.executeScript("arguments[0].click();", addToCartButton);
	        boolean isAdded = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"))).isDisplayed();
	        Assert.assertTrue(isAdded, "Add to cart confirmation is not displayed!");
	        String AddToCartMsg=driver.findElement(By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
		    System.out.println("AddToCart Msg " +AddToCartMsg);
	        System.out.println("Item successfully added to the cart!");

	  
	}


}
