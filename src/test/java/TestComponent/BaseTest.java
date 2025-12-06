package TestComponent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyAcademy.LandingPage;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
public WebDriver driver;
public LandingPage landingPage=new LandingPage(driver);

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

    @BeforeMethod
    public LandingPage launchApplication(String filePath) throws IOException{
        driver= initializeDriver();
        LandingPage landingPage=new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }
    public List<HashMap<String,String>> getJsonDataMap(String s) throws IOException {
        //reading json to string
        String jsonContent= FileUtils.readFileToString(new File(s), StandardCharsets.UTF_8);

        //string to hashMap
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
