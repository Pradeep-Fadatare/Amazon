package PradeepFadatareAutomation.Test;

import PradeepFadatareAutomation.TestComponents.BaseTest;
import PradeepFadatareAutomation.pageObjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class StandAloneTest extends BaseTest {


    @Test
    public void submitOrder() {
        String productName = "ZARA COAT 3";
        ProductCatalogPage pcp = landingPage.login("padyafadatare@gmail.com", "12345678");
        List<WebElement> products = pcp.productList();
        pcp.getproduct(productName);
        pcp.addproductToCart(productName);
        pcp.addproductToCart(productName);
        CheckOutPage cp = pcp.goToCart();
        Boolean match = cp.verifyProductDisplayed(productName);
        Assert.assertTrue(match);
        ConfirmationPage confirm = cp.checkout();
        confirm.selectContry("india");
        FinalPage fp = confirm.submitOrder();
        String msg = fp.confirmMsg();
        Assert.assertEquals("THANKYOU FOR THE ORDER.", msg);
    }
}
