package TestComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import rahulshettyAcademy.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        //Properties class
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//GlobalData.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");
        System.out.println(browserName);

if (browserName.equalsIgnoreCase("edge")) {
    System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
    WebDriver driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
}
else {
    System.out.println("browser details not available");
}
        return null;
    }

    public LandingPage launchApplication() throws IOException{
        driver= initializeDriver();
        LandingPage landingPage=new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }
}
