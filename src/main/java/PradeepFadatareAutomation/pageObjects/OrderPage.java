package PradeepFadatareAutomation.pageObjects;

import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractClass {

    WebDriver driver;
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> placedOrder;

    By nameprod=By.xpath("//td[2]");

    public Boolean conirmProduct(String name){
        Boolean match=placedOrder.stream().anyMatch(prod-> prod.findElement(nameprod).getText().equalsIgnoreCase(name));
        return match;
    }

}
