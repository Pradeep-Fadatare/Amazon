package PradeepFadatareAutomation.pageObjects;

import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogPage extends AbstractClass {

    public static WebDriver driver;

    public ProductCatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='container']/div[2]/div")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By prod=By.xpath("//div[@class='container']/div[2]/div");
    By addToCart=By.cssSelector("button.btn.w-10.rounded");
    By addedtxt=By.cssSelector("#toast-container");

    public List<WebElement> productList(){
        waitForElementToLocate(prod);
        return products;
    }

    public WebElement getproduct(String name){
         WebElement reqProduct=productList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText()
        .equalsIgnoreCase(name)).findFirst().orElse(null);
         return reqProduct;

    }

    public void addproductToCart(String name){
        getproduct(name).findElement(addToCart).click();
        waitForElementToLocate(addedtxt);
        waitForWebElementToDisapper(spinner);

    }



}
