package org.example;

import TestComponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import rahulshettyAcademy.CartPage;
import rahulshettyAcademy.ProductCatalogPage;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {
    @Test
    public void submitErrorOrder(){
        String productName="ADIDAS ORIGINAL";

       landingPage.loginApplication("asuman@gmail.com","aSuman21");//enter usrname, password and click login
            Assert.assertEquals("Incorrect email  password.",landingPage.getErrorMessage());
    }

    @Test
    public void submitorderWrongProd() throws IOException, InterruptedException {
        String productName="ADIDAS ORIGINAL";
        // LandingPage landingPage=launchApplication();   used  @BeforeTest in parent class i.e BaseTest


        ProductCatalogPage productCatalogPage= landingPage.loginApplication("asuman@gmail.com","aSuman@1");//enter usrname, password and click login

        List<WebElement> products=productCatalogPage.getProductList();
        productCatalogPage.addProductToCart(productName);

        CartPage cartPage= productCatalogPage.gotoCartPage();

        Boolean match=cartPage.VerifyProductDisplay("Nike");
        Assert.assertFalse(match);

    }

    @Override
    public void onTestFinish(ITestResult result) {

    }
}
