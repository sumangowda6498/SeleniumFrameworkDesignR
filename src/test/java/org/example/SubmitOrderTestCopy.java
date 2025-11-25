package org.example;


import TestComponent.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyAcademy.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SubmitOrderTestCopy extends BaseTest {

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
        String productName="ADIDAS ORIGINAL";

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

}