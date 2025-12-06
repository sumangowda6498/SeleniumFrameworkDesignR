package org.example;


import TestComponent.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyAcademy.*;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SubmitOrderTestCopy_173 extends BaseTest {
        String productName="ADIDAS ORIGINAL";




    @Test
    public void submitorder() throws IOException, InterruptedException {
//        String productName="ADIDAS ORIGINAL";
//       // LandingPage landingPage=launchApplication();   used  @BeforeTest in parent class i.e BaseTest
//
//
//        ProductCatalogPage productCatalogPage= landingPage.loginApplication("asuman@gmail.com","aSuman@1");//enter usrname, password and click login
//
//        List<WebElement> products=productCatalogPage.getProductList();
//       productCatalogPage.addProductToCart(productName);
//
//        CartPage cartPage= productCatalogPage.gotoCartPage();
//
//        Boolean match=cartPage.VerifyProductDisplay(productName);
//        Assert.assertTrue(match);
//        CheckoutPage checkoutPage=cartPage.goToCheckout();
//        checkoutPage.setSelectCountry("india");
//        ConfirmationPage confirmationPage =checkoutPage.submitOrder();
//
//
//        String confirmMsg=confirmationPage.getConformationMesssage();
//        System.out.println(confirmMsg);
//        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //----------------------------------------------------------------------------------//
        System.out.println("___________________________________________\n Book Product Test1");
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        LandingPage landingPage=new LandingPage(driver);
        landingPage.goTo();//launchURL
        ProductCatalogPage productCatalogPage= landingPage.loginApplication("asuman@gmail.com","aSuman@1");//enter usrname, password and click login

        List<WebElement> products=productCatalogPage.getProductList();
        productCatalogPage.addProductToCart(productName);

        CartPage cartPage= productCatalogPage.gotoCartPage();

        Boolean match=cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage=cartPage.goToCheckout();

        checkoutPage.setSelectCountry("india");
        ConfirmationPage confirmationPage =checkoutPage.submitOrder();

        String confirmMsg=confirmationPage.getConformationMesssage();
        System.out.println(confirmMsg);
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }
    //To Verify Adidas original Coat 3 displaying in orders page
@Test(dependsOnMethods = {"submitorder"})
    public void OredrHistoryTest(){
    System.out.println("___________________________________________\n verify product in orders Test2");

    System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
    WebDriver driver=new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    LandingPage landingPage=new LandingPage(driver);
    landingPage.goTo();//launchURL
    ProductCatalogPage productCatalogPage= landingPage.loginApplication("asuman@gmail.com","aSuman@1");    OrderPage orderPage=productCatalogPage.gotoOrdersPage();
    Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    System.out.println("___________________________________________\n verify product in orders Test2 FINISHED");

}

//#171 Agenda of implementing Parameterization into Test with TestNG DataProvider
    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{"asuman@gmail.com","aSuman@1","ADIDAS ORIGINAL"},{"asuman@gmail.com","aSuman@1","ZARA COAT 3"}};

   }


//creating copy of submitorder method just for #171 Parameterization
@Test(dataProvider = "getData", groups={"Purchase"})
public void submitorderParameter171(String email,String password,String productName) throws IOException, InterruptedException {
    System.out.println("___________________________________________171\n Book Product Test1");
    System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
    WebDriver driver=new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    LandingPage landingPage=new LandingPage(driver);
    landingPage.goTo();//launchURL
    ProductCatalogPage productCatalogPage= landingPage.loginApplication(email,password);//enter usrname, password and click login

    List<WebElement> products=productCatalogPage.getProductList();
    productCatalogPage.addProductToCart(productName);

    CartPage cartPage= productCatalogPage.gotoCartPage();

    Boolean match=cartPage.VerifyProductDisplay(productName);
    Assert.assertTrue(match);
    CheckoutPage checkoutPage=cartPage.goToCheckout();

    checkoutPage.setSelectCountry("india");
    ConfirmationPage confirmationPage =checkoutPage.submitOrder();

    String confirmMsg=confirmationPage.getConformationMesssage();
    System.out.println(confirmMsg);
    Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

}


    //#172 Agenda of implementing Parameterization into Test with TestNG DataProvider with Hash map
    @DataProvider
    public Object[][] getDatas() throws IOException {
//        HashMap<String,String> map=new HashMap<>(); 172 codes commmented
//        map.put("email", "asuman@gmail.com");
//        map.put("password","aSuman@1");
//        map.put("product","ADIDAS ORIGINAL");
//
//        HashMap<String,String> map1=new HashMap<>();
//        map1.put("email", "asuman@gmail.com");
//        map1.put("password","aSuman@1");
//        map1.put("product","ZARA COAT 3");
List<HashMap<String,String>> data =getJsonDataMap(System.getProperty("user.dir")+"//src//test//java//Data//PurchaseOrder_173.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }

    @Test(dataProvider = "getDatas", groups={"Purchase"})
    public void submitorderParameter172(HashMap<String,String> input) throws IOException, InterruptedException {
        System.out.println("___________________________________________172\n Book Product Test1");
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        LandingPage landingPage=new LandingPage(driver);
        landingPage.goTo();//launchURL
        ProductCatalogPage productCatalogPage= landingPage.loginApplication(input.get("email"),input.get("password"));//enter usrname, password and click login

        List<WebElement> products=productCatalogPage.getProductList();
        productCatalogPage.addProductToCart(input.get("product"));

        CartPage cartPage= productCatalogPage.gotoCartPage();

        Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage=cartPage.goToCheckout();

        checkoutPage.setSelectCountry("india");
        ConfirmationPage confirmationPage =checkoutPage.submitOrder();

        String confirmMsg=confirmationPage.getConformationMesssage();
        System.out.println(confirmMsg);
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

}