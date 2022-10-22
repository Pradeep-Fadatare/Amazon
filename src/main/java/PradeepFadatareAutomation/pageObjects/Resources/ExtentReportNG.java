package PradeepFadatareAutomation.pageObjects.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ExtentReportNG {



    @BeforeTest
    public static ExtentReports config() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Web Automation Result");
        sparkReporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Rahul Shetty");
        return extentReports;
    }


}
