import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

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

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString();
    }
}
