package rahulshettyAcademy.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstarctComponent {
    WebDriver driver;
    public AbstarctComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;

    public void gotoCartPage(){
        cartHeader.click();
    }


    public void waitForElementToAprar(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));//Explicite wait
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
    }

    public void waitElementToDisappear(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));//Explicite wait

        wait.until(ExpectedConditions.invisibilityOf(ele));

    }

}
