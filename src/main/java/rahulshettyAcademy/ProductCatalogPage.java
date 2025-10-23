//159 Page object should not hold any data , it should focus only on Elements and Actions
//158-@FindBy

package rahulshettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogPage {
    WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
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


}
