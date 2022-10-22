package PradeepFadatareAutomation.Test;

import PradeepFadatareAutomation.TestComponents.BaseTest;
import PradeepFadatareAutomation.pageObjects.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {


    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input)  {

        ProductCatalogPage pcp = landingPage.login(input.get("email"), input.get("password"));
        List<WebElement> products = pcp.productList();
        pcp.getproduct(input.get("product"));
        pcp.addproductToCart(input.get("product"));
        pcp.addproductToCart(input.get("product"));
        CheckOutPage cp = pcp.goToCart();
        Boolean match = cp.verifyProductDisplayed(input.get("product"));
        Assert.assertTrue(match);
        ConfirmationPage confirm = cp.checkout();
        confirm.selectContry("india");
        FinalPage fp = confirm.submitOrder();
        String msg = fp.confirmMsg();
        Assert.assertEquals("THANKYOU FOR THE ORDER.", msg);
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryCheck(){
        String productName = "ZARA COAT 3";
        ProductCatalogPage pcp = landingPage.login("padyafadatare@gmail.com", "12345678");
        OrderPage orderPage=pcp.orderPage();
//        Assert.assertTrue(orderPage.conirmProduct(productName));
    }



    @DataProvider
    public Object[][] getData() throws IOException {

//        HashMap<String,String> map= new HashMap<String,String>();
//        map.put("email","padyafadatare@gmail.com");
//        map.put("password","12345678");
//        map.put("product","ZARA COAT 3");
//
//        HashMap<String,String> map1= new HashMap<String,String>();
//        map1.put("email","padyafadatare@gmail.com");
//        map1.put("password","12345678");
//        map1.put("product","ADIDAS ORIGINAL");

        List<HashMap<String,String>> data=getJsonDataToMap("\\src\\test\\java\\radeepFadatareAutomation\\Data\\PurchaseOrder.json");
       return new Object[][] {{data.get(0)},{data.get(1)}};
    }


}
