package StepDefination_195;

import TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import rahulshettyAcademy.*;

import java.io.IOException;
import java.util.List;

public class StepDefinationImpl extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalogPage productCatalogPage;
    public ConfirmationPage confirmationPage;

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

     @When("^Checkout (.+) and submit the order$")
     public void checkout_and_submit_the_order(String productName) throws InterruptedException {
         CartPage cartPage= productCatalogPage.gotoCartPage();

         Boolean match=cartPage.VerifyProductDisplay(productName);
         Assert.assertTrue(match);
         CheckoutPage checkoutPage=cartPage.goToCheckout();

         checkoutPage.setSelectCountry("india");
          confirmationPage =checkoutPage.submitOrder();
     }

     @Then("{string} message is displayed on ConfirmationPage")
     public void message_displayed_confirmationPage(String string){
         String confirmMsg=confirmationPage.getConformationMesssage();
         System.out.println(confirmMsg);
         Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));




     }





    @Override
    public void onTestFinish(ITestResult result) {

    }
}