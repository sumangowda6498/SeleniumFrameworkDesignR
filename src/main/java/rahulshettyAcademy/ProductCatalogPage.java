//159 Page object should not hold any data , it should focus only on Elements and Actions
//158-@FindBy

package rahulshettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyAcademy.AbstractComponent.AbstarctComponent;

import java.util.List;

public class ProductCatalogPage extends AbstarctComponent {
    WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement userEmail=driver.findElement(By.id("userEmail"));
    //or
    // PageFactory
//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css =".ng-animating")
    WebElement spinner;

    By productBy=By.cssSelector(".mb-3");
    By addToCart=By.cssSelector(".card-body button:last-of-type");
    By toastMessage=By.cssSelector("#toast-conatiner");

    public List<WebElement> getProductList(){
        waitForElementToAprar(productBy);
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod=  getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }


    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod= getProductByName(productName);
        prod.findElement(addToCart).click();
        Thread.sleep(3000);
//        waitForElementToAprar(toastMessage);
//        waitElementToDisappear(spinner);

    }
}
