package PradeepFadatareAutomation.pageObjects;


import PradeepFadatareAutomation.pageObjects.AbstractComponent.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractClass {
    WebDriver driver;


    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userEmail")
    WebElement emailtxt;

    @FindBy(id="userPassword")
    WebElement passtxt;

    @FindBy(id="login")
    WebElement lgnbtn;

    @FindBy(css="div[role='alertdialog']")
    WebElement Errormsg;


    public ProductCatalogPage login(String email,String pass){
        emailtxt.sendKeys(email);
        passtxt.sendKeys(pass);
        lgnbtn.click();
        ProductCatalogPage pcp=new ProductCatalogPage(driver);
        return pcp;
    }

    public void gotologin(){
        driver.get("https://rahulshettyacademy.com/client");

    }

    public String getErrorMsg(){
        VisibilityOfWebElement(Errormsg);
        return Errormsg.getText();

    }
}




