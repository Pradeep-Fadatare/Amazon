package PradeepFadatareAutomation.pageObjects;

import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends AbstractClass {
    public WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']/ul/li/button")
    WebElement chckoutbtn;

    @FindBy(css = ".cartSection h3")
    List<WebElement> addedproducts;

    public Boolean verifyProductDisplayed(String name){
        Boolean match=addedproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(name));
        return match;
    }

    public ConfirmationPage checkout(){
        chckoutbtn.click();
        ConfirmationPage confirm=new ConfirmationPage(driver);
        return confirm;
    }
}
