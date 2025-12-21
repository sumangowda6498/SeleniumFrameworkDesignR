package TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG176;

public class Listeners implements ITestListener {
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
    }
    @Override
    public void onTestSkipped(ITestResult result){

    }


}
