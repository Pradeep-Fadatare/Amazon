package PradeepFadatareAutomation.pageObjects;

import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmationPage extends AbstractClass {

    public WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement contrybtn;

    @FindBy(css = ".ta-item.list-group-item.ng-star-inserted")
    List<WebElement> contryName;

    @FindBy(css=".btnn.action__submit.ng-star-inserted")
    WebElement placeorderbtn;

    @FindBy(xpath = "//div[@class='payment__shipping']//button[2]")
            WebElement india;

    By result=By.cssSelector(".ta-results.list-group.ng-star-inserted");

    public void selectContry(String name){
        Actions a=new Actions(driver);
        a.sendKeys(contrybtn,name).build().perform();
        waitForElementToLocate(result);
        india.click();

    }

    public FinalPage submitOrder(){
        placeorderbtn.click();
        FinalPage fp=new FinalPage(driver);
        return fp;
    }

}
