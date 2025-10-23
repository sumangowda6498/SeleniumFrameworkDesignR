//159 Page object should not hold any data , it should focus only on Elements and Actions
//158-@FindBy

package rahulshettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        //initialization
        this.driver=driver;

        PageFactory.initElements(driver,this);
    }

   // WebElement userEmail=driver.findElement(By.id("userEmail"));
    //or
    // PageFactory

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassowrdEle;

    @FindBy(id="login")
    WebElement login;

//Action method 159
    public void loginApplication(String email,String password){
        userEmail.sendKeys(email);
        userPassowrdEle.sendKeys(password);
        login.click();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
