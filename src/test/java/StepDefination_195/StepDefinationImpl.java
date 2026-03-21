package StepDefination_195;

import TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import rahulshettyAcademy.LandingPage;
import rahulshettyAcademy.ProductCatalogPage;

import java.io.IOException;
import java.util.List;

public class StepDefinationImpl extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalogPage productCatalogPage;

    @Given("I landedon Ecommerce Page")
    public void I_landedon_Ecommerce_Page() throws IOException {
        landingPage= launchApplication();


    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_username_and_password(String username, String password){
        productCatalogPage= landingPage.loginApplication(username,password);//enter usrname, password and click login


    }

     @When("^I add product (.+)  from Cart$")
     public void i_add_product_to_cart(String productName) throws InterruptedException {
         List<WebElement> products= productCatalogPage.getProductList();
         productCatalogPage.addProductToCart(productName);

     }



    @Override
    public void onTestFinish(ITestResult result) {

    }
}