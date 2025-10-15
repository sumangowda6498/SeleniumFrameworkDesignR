package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class StandAlonetest {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver=new EdgeDriver();
        String productName="ADIDAS ORIGINAL";

        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("asuman@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("aSuman@1");
        driver.findElement(By.id("login")).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));//Explicite wait
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

       // int n  = driver.findElements(By.cssSelector(".mb-3")).size();
       // System.out.println("Number "+n);

        WebElement prod=  products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
        //ng-animating
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSectin h3"));
        Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
       //Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();


        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").click().build().perform();
Thread.sleep(2000);


        driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".action_submit")).click();

        String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));


    }

}