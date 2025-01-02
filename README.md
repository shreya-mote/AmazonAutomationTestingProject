# AmazonAutomationTestingProject
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
