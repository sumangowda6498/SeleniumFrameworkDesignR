package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import rahulshettyAcademy.LandingPage;
import rahulshettyAcademy.ProductCatalogPage;

import java.time.Duration;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver=new EdgeDriver();
        String productName="ADIDAS ORIGINAL";

        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       // driver.get("https://rahulshettyacademy.com/client");//landingPage.goTo();
          LandingPage landingPage=new LandingPage(driver);
          landingPage.goTo();//launchURL
          landingPage.loginApplication("asuman@gmail.com","aSuman@1");//enter usrname, password and click login
//        driver.findElement(By.id("userEmail")).sendKeys("asuman@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("aSuman@1");
//        driver.findElement(By.id("login")).click();

//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));//Explicite wait
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
//        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        ProductCatalogPage productCatalogPage=new ProductCatalogPage(driver);
        List<WebElement>products=productCatalogPage.getProductList();

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


        driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();

        String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmMsg);
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

}