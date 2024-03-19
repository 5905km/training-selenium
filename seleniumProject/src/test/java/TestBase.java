import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
