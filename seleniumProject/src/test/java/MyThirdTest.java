import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class MyThirdTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        for (int i = 0; i < driver.findElements(By.id("app-")).size(); i++) {
            driver.findElements(By.id("app-")).get(i).click();

            if (isElementPresent(By.className("docs"))) {
                for (int k = 0; k < driver.findElement(By.className("docs")).findElements(By.cssSelector("li")).size(); k++) {
                    driver.findElement(By.className("docs")).findElements(By.cssSelector("li")).get(k).click();
                    assertTrue(isElementPresent(By.cssSelector("h1")));
                }
            } else {
                assertTrue(isElementPresent(By.cssSelector("h1")));
            }
        }
    }

    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
