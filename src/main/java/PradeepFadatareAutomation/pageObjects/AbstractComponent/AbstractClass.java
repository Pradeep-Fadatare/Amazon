package PradeepFadatareAutomation.pageObjects.AbstractComponent;

import PradeepFadatareAutomation.pageObjects.CheckOutPage;
import PradeepFadatareAutomation.pageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractClass {
public WebDriver driver;
    public AbstractClass(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForElementToLocate(By findby){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

    public void waitForWebElementToDisapper(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public void VisibilityOfWebElement(WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    @FindBy(css = "[routerlink*='/dashboard/cart']")
    WebElement cartbtn;

    public CheckOutPage goToCart(){
        cartbtn.click();
        CheckOutPage cp=new CheckOutPage(driver);
        return cp;

    }
    @FindBy(css = "[routerlink='/dashboard/myorders']")
    WebElement orderbtn;

    public OrderPage orderPage(){
        orderbtn.click();
        OrderPage orderpage=new OrderPage(driver);
        return orderpage;
    }
//    Checking for git branch from Australia
}
