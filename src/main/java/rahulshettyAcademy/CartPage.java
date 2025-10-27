package rahulshettyAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rahulshettyAcademy.AbstractComponent.AbstarctComponent;

import java.util.List;

public class CartPage extends AbstarctComponent {
    WebDriver driver;

    @FindBy(css = ".tatalRow button")
    WebElement checkoutEle;

    @FindBy(css=".cartSection h3")
    private List<WebElement> productTitles;


    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver
    }
}
