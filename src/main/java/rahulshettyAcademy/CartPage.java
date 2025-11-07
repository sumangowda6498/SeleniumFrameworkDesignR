package rahulshettyAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rahulshettyAcademy.AbstractComponent.AbstarctComponent;

import java.util.List;

public class CartPage extends AbstarctComponent {
    WebDriver driver;

    @FindBy(xpath = "/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
    WebElement checkoutEle;

    @FindBy(css=".cartSection h3")
    private List<WebElement> productTitles;


    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public Boolean VerifyProductDisplay(String productName){
        Boolean match =productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);
    }

}
