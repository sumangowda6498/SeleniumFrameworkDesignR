package rahulshettyAcademy.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstarctComponent {
    WebDriver driver;
    public AbstarctComponent(WebDriver driver) {
        this.driver=driver;
    }

    public void waitForElementToAprar(By findBy){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));//Explicite wait
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
    }

}
