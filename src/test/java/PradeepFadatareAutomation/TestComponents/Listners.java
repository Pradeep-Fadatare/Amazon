package PradeepFadatareAutomation.TestComponents;

import PradeepFadatareAutomation.pageObjects.Resources.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extentReports=ExtentReportNG.config();
    ThreadLocal<ExtentTest> local=new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        test=extentReports.createTest(result.getMethod().getMethodName());
        local.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        local.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        local.get().fail(result.getThrowable());
        local.get().log(Status.FAIL,"Test Failed");
        String filepath= null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            filepath = getScreenShot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        local.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        local.get().log(Status.SKIP,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        local.get().log(Status.FAIL,"Failed due to timeout");
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }
}
