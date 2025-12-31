package TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG176;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    String filePath;
    ExtentTest test;
ExtentReports extent= ExtentReporterNG176.config();
    @Override
    public void onTestStart(ITestResult result){
       test=  extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
test.log(Status.PASS," Test is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){ 
        //Take Screenshot
        test.log(Status.FAIL,"Test is Failed:---log below");
        test.fail(result.getThrowable());

        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
           e1.printStackTrace();
        }
        try {
           filePath=  getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromBase64String(filePath,result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result){

    }
   @Override
    public void onTestFinish(ITestResult result){
        extent.flush();
}


}
