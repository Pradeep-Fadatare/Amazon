package PradeepFadatareAutomation.pageObjects;

import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage extends AbstractClass {


    public WebDriver driver;

    public FinalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".hero-primary")
    WebElement confmsg;

    public String confirmMsg(){
        return confmsg.getText();
    }
}
