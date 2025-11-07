package rahulshettyAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyAcademy.AbstractComponent.AbstarctComponent;

public class ConfirmationPage extends AbstarctComponent {

    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    public String getConformationMesssage(){
        return confirmationMessage.getText();
    }

}
