package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class StandAlonetest {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("sumana@gamil.com");
        driver.findElement(By.id("userPassword")).sendKeys("Suman@1");
        driver.findElement(By.id("login")).click();
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-0"));

        int n  = driver.findElements(By.cssSelector(".mb-0")).size();
        System.out.println("Number "+n);
    }

}