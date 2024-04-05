import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyFourthTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> products = driver.findElements(By.className("product"));

        for (WebElement product : products) {
            assertEquals(1, product.findElements(By.className("sticker")).size());
        }
    }
}
