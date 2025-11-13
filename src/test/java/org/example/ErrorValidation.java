package org.example;

import TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyAcademy.ProductCatalogPage;

public class ErrorValidation extends BaseTest {
    @Test
    public void submitOrder(){
        String productName="ADIDAS ORIGINAL";

       landingPage.loginApplication("asuman@gmail.com","aSuman21");//enter usrname, password and click login
            Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }

}
