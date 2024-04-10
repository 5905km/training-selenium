import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class MyEighthTest extends TestBase {

    @Test
    public void myFirstTest() {
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String address = "Fulton Street 10";
        String postcode = "12345";
        String city = "New York City";
        String email = generateUUID() + "@gmail.com";
        String phone = "+1111111";
        String password = "PasswordTest";

        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("table tbody tr td a")).click();

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("postcode")).sendKeys(postcode);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.className("select2-selection__arrow")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States\n");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();

        driver.findElements(By.cssSelector(".left #navigation #box-account .content .list-vertical li a")).get(3).click();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        driver.findElements(By.cssSelector(".left #navigation #box-account .content .list-vertical li a")).get(3).click();
    }

    @Test
    public void mySecondTest() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElements(By.cssSelector("#content .button")).get(1).click();

        driver.findElements(By.cssSelector(".tabs li")).get(0).click();
        driver.findElements(By.name("status")).get(0).click();
        driver.findElement(By.name("name[en]")).sendKeys("name");
        driver.findElement(By.name("code")).sendKeys("code");
        driver.findElements(By.name("product_groups[]")).get(2).click();
        driver.findElement(By.name("quantity")).sendKeys("10");

        driver.findElements(By.cssSelector(".tabs li")).get(1).click();
        driver.findElement(By.name("manufacturer_id")).findElements(By.cssSelector("option")).get(1).click();
        driver.findElement(By.name("keywords")).sendKeys("keywords");
        driver.findElement(By.name("short_description[en]")).sendKeys("short_description[en]");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Description");
        driver.findElement(By.name("head_title[en]")).sendKeys("head_title[en]");
        driver.findElement(By.name("meta_description[en]")).sendKeys("meta_description[en]");

        driver.findElements(By.cssSelector(".tabs li")).get(3).click();
        driver.findElement(By.name("purchase_price")).sendKeys("10");
        driver.findElement(By.name("purchase_price_currency_code")).findElements(By.cssSelector("option")).get(1).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("10");
        driver.findElement(By.name("prices[EUR]")).sendKeys("10");

        driver.findElement(By.name("save")).click();

        WebElement newProduct = driver.findElements(By.cssSelector(".row")).get(2);
        assertEquals("name", newProduct.findElement(By.cssSelector("a")).getAttribute("textContent"));

        newProduct.findElements(By.cssSelector("a")).get(1).findElement(By.cssSelector("i")).click();
        driver.findElement(By.className("delete")).click();
    }

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString();
    }
}
