# AmazonAutomationTestingProject
Detailed Explanation of Each Class and Its Purpose in the Project
Let’s break down the purpose and functionality of each class in the project and how data flows through them.

1. TestBase.java (Base Class for Test Setup and Browser Configuration)
Purpose:
This class is responsible for setting up the test environment and initializing the WebDriver for different browsers (Chrome, Firefox, Edge).
It includes configurations like timeouts, browser initialization, and clean-up after tests.
The class ensures that WebDriver is launched and closed properly for each test.
Usage:
Other test classes or page classes (like LoginPage) will extend TestBase to inherit its setup functionality.
Example in use:

java
Copy code
public class TestBase {
   public static WebDriver driver;
   
   @BeforeClass
   public static void setUp() {
      // Browser selection logic
      driver = new ChromeDriver();
      driver.get("https://www.amazon.com");
      // Set implicit wait
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   @AfterClass
   public static void tearDown() {
      driver.quit();
   }
}
2. Page Object Model (POM) - Page Classes
These classes represent different pages in the Amazon website and encapsulate page elements and actions specific to that page. Each page has locators and methods to perform operations on that page.

LoginPage.java
Purpose:
This class handles all elements related to the login page (e.g., username field, password field, login button).
It includes methods to interact with the login page, like entering credentials and submitting the form.
Example in use:

java
Copy code
public class LoginPage {
   private WebDriver driver;

   @FindBy(id = "username") private WebElement usernameField;
   @FindBy(id = "password") private WebElement passwordField;
   @FindBy(id = "signInButton") private WebElement signInButton;

   public LoginPage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this); // Initialize elements using PageFactory
   }

   public void enterCredentials(String username, String password) {
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
   }

   public void clickSignIn() {
      signInButton.click();
   }
}
Other Page Classes (e.g., HomePage.java, ShoppingCartPage.java, etc.)
Purpose:
Each page class represents a separate page in the Amazon website (HomePage, Cart, ProductPage).
These classes will contain methods specific to the operations users can perform on these pages.
Example in use (for HomePage.java):

java
Copy code
public class HomePage {
   private WebDriver driver;

   @FindBy(id = "cartIcon") private WebElement cartIcon;

   public HomePage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   public void clickCart() {
      cartIcon.click();
   }
}
3. Step Definition Classes (BDD Integration)
These classes are part of the BDD (Behavior-Driven Development) framework and map the Gherkin language (used in .feature files) to executable code. They interpret the steps written in a more natural language (e.g., "Given I open the Amazon homepage") and link them to the corresponding methods from page objects.

BddAmazonTestCases.java
Purpose:
This class holds the step definitions for the test case written in Gherkin syntax.
It translates the steps (like "Given", "When", "Then") into actions that will be executed by interacting with the page objects.
This is where the BDD scenarios are linked with actual code.
Example in use:

java
Copy code
public class BddAmazonTestCases {
   private WebDriver driver;
   private LoginPage loginPage;
   private HomePage homePage;

   @Given("^I open the Amazon homepage$")
   public void openHomePage() {
      driver.get("https://www.amazon.com");
   }

   @When("^I enter valid credentials and click Sign In$")
   public void login() {
      loginPage.enterCredentials("testuser", "password123");
      loginPage.clickSignIn();
   }

   @Then("^I should be logged in$")
   public void verifyLogin() {
      // Assertion logic
      Assert.assertTrue(homePage.isUserLoggedIn());
   }
}
Hooks.java
Purpose:
This class is used to set up preconditions (like starting the browser) and postconditions (like quitting the browser).
It is part of the Cucumber Hooks in BDD.
Common setup and teardown logic is defined here.
Example in use:

java
Copy code
public class Hooks {
   private WebDriver driver;

   @Before
   public void beforeTest() {
      driver = new ChromeDriver();
      driver.get("https://www.amazon.com");
   }

   @After
   public void afterTest() {
      driver.quit();
   }
}
4. Utility Classes
These classes provide helper functions that are reusable across different tests, such as managing waits, switching windows, or reading properties files.

PropertiesFile.java
Purpose:
This class is used to read configuration values (like URLs, test data) from properties files.
It allows for externalizing data to make the tests more flexible and maintainable.
Example in use:

java
Copy code
public class PropertiesFile {
   public static String getPropertyValue(String key) {
      FileInputStream file = new FileInputStream("config/data.properties");
      Properties properties = new Properties();
      properties.load(file);
      return properties.getProperty(key);
   }
}
WaitsFor.java
Purpose:
This utility class helps manage waits in Selenium to ensure elements are available before interacting with them.
It can manage implicit, explicit, or fluent waits.
Example in use:

java
Copy code
public class WaitsFor {
   public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable(element));
   }
}
5. Test Runner (FeatureRunner.java)
Purpose:
This class acts as the test runner for the Cucumber feature files. It specifies which feature files to run and which step definition classes to associate with them.
It also includes configuration for the test environment, such as setting the report output locations.
Example in use:

java
Copy code
@RunWith(Cucumber.class)
@CucumberOptions(
   features = "src/test/resources/features",
   glue = {"com.testingshashtra.stepdefinitions"},
   plugin = {"pretty", "html:target/cucumber-reports"}
)
public class FeatureRunner {
}
6. Exception Handling Classes
These classes are used for handling specific exceptions that may arise during the execution of the tests, such as invalid driver selection or unknown errors.

InvalidDriverException.java
Purpose:
This class customizes the exception handling related to WebDriver initialization errors, providing a more descriptive error message when the wrong driver is selected.
Example in use:

java
Copy code
public class InvalidDriverException extends Exception {
   public InvalidDriverException(String message) {
      super(message);
   }
}
7. Test Data and Configuration Files
Purpose:
The data.properties and log4j.properties files contain test data and logging configurations, respectively.
data.properties holds things like test URLs, credentials, or test configuration values.
log4j.properties defines logging levels, file paths, and log formats.
Example of data.properties:

properties
Copy code
url=https://www.amazon.com
username=testuser
password=password123
Flow of Data:
Test Execution Flow:

The test starts with TestBase, which sets up the browser.
The BDD tests (via BddAmazonTestCases) define the steps for interacting with Amazon.
Each step interacts with the page objects (e.g., LoginPage for login).
Utilities (like WaitsFor and PropertiesFile) help manage waits and external data.
At the end of the test, the Hooks class ensures the browser is properly closed.
Communication:

Page Object Model classes (like LoginPage or HomePage) provide methods to interact with the web elements.
BDD uses these methods in a step definition class to describe actions in a human-readable format.
Data and test configurations come from properties files, and exception handling ensures smooth execution.
This is the detailed breakdown of how each class works in your project and how data flows between them. The combination of TestBase, POM, BDD, Step Definitions, and utility classes ensures your tests are modular, reusable, and easy to maintain.







src
├── main
│   └── java
│       └── com.testingShastra
│           ├── Base
│           │   ├── Keyword.java
│           │   └── TestBase.java
│           │
│           ├── Pages
│           │   ├── AddedToCartPage.java
│           │   ├── AllProductsPage.java
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   ├── Product_displayPage.java
│           │   └── ShoppingCartPage.java
│           │
│           ├── StepDefinitions
│           │   ├── BddAmazonTestCases.java
│           │   ├── BddProductPage.java
│           │   ├── Hooks.java
│           │   └── ShoppingCart.java
│           │
│           ├── Utils
│           │   ├── PropertiesFile.java
│           │   ├── PropUtils.java
│           │   ├── SwitchWindowfor.java
│           │   └── WaitsFor.java
│           │
│           ├── Exception
│           │   └── InvalidDriverException.java
│           │
│           └── Runner
│               └── FeatureRunner.java
│
├── test
│   └── java
│       └── com.testingshastra
│           └── runner
│               └── FeatureRunner.java
│
└── resources
    ├── config
    │   ├── data.properties
    │   └── log4j.properties
    │
    └── features
        ├── login.feature
        ├── product_page.feature
        └── shopping_cart_test.feature
