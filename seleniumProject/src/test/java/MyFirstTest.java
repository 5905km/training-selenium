import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver\n");
    }
}
