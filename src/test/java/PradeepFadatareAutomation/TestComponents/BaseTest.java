package PradeepFadatareAutomation.TestComponents;

import PradeepFadatareAutomation.pageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    public LandingPage landingPage;

    public WebDriver intializaDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\PradeepFadatareAutomation\\pageObjects\\Resources\\GlobalData.properties");
        properties.load(fis);
        String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :properties.getProperty("browser");

        if (browserName.contains("chrome")) {

            ChromeOptions chromeOptions=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless")) {
                chromeOptions.addArguments("headless");
            }

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
             driver = new FirefoxDriver();
        } else {
            System.out.println("No browser Found");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public String getScreenShot(String testName,WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"\\reports\\"+testName+".png");
        FileUtils.copyFile(src,file);
        return System.getProperty("user.dir")+"\\reports\\"+testName+".png";
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage LaunchingApp() throws IOException {
        driver=intializaDriver();
        landingPage=new LandingPage(driver);
        landingPage.gotologin();
        return landingPage;
    }
    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
//        Reading Data from Json
        String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+filepath), StandardCharsets.UTF_8);

//        String to hash Map
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}

