import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class MyFourthTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/");

        for (int i = 0; i < driver.findElements(By.className("image-wrapper")).size(); i++) {
            assertEquals(1, driver.findElements(By.className("image-wrapper")).get(i).findElements(By.cssSelector("[class^=sticker]")).size());
        }
    }
}
