package rahulshettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyAcademy.AbstractComponent.AbstarctComponent;

public class CheckoutPage extends AbstarctComponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath="//button[contains(@class,'ta-item')][2]")
    WebElement selectCountry;

    @FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
    WebElement submit;

    By results=By.cssSelector(".ta-results");


    public  void  setSelectCountry(String CountryName) throws InterruptedException {
        Actions a=new Actions(driver);
        a.sendKeys(country,CountryName).click().build().perform();
       // waitForElementToAprar(By.cssSelector(results));
        Thread.sleep(2000);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder(){
        submit.click();
      return  new ConfirmationPage(driver);
    }

}
