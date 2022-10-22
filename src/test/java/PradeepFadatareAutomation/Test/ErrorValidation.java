package PradeepFadatareAutomation.Test;

import PradeepFadatareAutomation.TestComponents.BaseTest;
import PradeepFadatareAutomation.TestComponents.Retry;
import PradeepFadatareAutomation.pageObjects.CheckOutPage;
import PradeepFadatareAutomation.pageObjects.ProductCatalogPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"Smoke"},retryAnalyzer = Retry.class)
    public void loginValidation() {
        ProductCatalogPage pcp = landingPage.login("padyafadatare@gmail.com", "15678");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMsg());
    }

    @Test
    public void productErrorValidation() {
        String productName = "ZARA COAT 3";
        ProductCatalogPage pcp = landingPage.login("padyafadatare@gmail.com", "12345678");
        List<WebElement> products = pcp.productList();
        pcp.getproduct(productName);
        pcp.addproductToCart(productName);
        pcp.addproductToCart(productName);
        CheckOutPage cp = pcp.goToCart();
        Boolean match = cp.verifyProductDisplayed(productName);
        Assert.assertTrue(match);
        System.out.println(cp.verifyProductDisplayed(productName));
    }
}
