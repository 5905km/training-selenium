import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MySeventhTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/");
        List<WebElement> productsCampaigns = driver.findElements(By.cssSelector("#box-campaigns .content li"));
        WebElement firstProductCampaigns = productsCampaigns.get(0);

        String nameHomePage = firstProductCampaigns.findElement(By.className("name")).getAttribute("textContent");
        String regularPriceHomePage = firstProductCampaigns.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceHomePage = firstProductCampaigns.findElement(By.className("campaign-price")).getAttribute("textContent");
        String regularPriceColorHomePage = firstProductCampaigns.findElement(By.className("regular-price")).getCssValue("color");
        String campaignPriceColorHomePage = firstProductCampaigns.findElement(By.className("campaign-price")).getCssValue("color");
        int regularPriceHeightHomePage = firstProductCampaigns.findElement(By.className("regular-price")).getSize().height;
        int campaignPriceHeightHomePage = firstProductCampaigns.findElement(By.className("campaign-price")).getSize().height;
        int regularPriceWidthHomePage = firstProductCampaigns.findElement(By.className("regular-price")).getSize().width;
        int campaignPriceWidthHomePage = firstProductCampaigns.findElement(By.className("campaign-price")).getSize().width;

        firstProductCampaigns.click();

        String nameProductPage = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
        String regularPriceProductPage = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceProductPage = driver.findElement(By.className("campaign-price")).getAttribute("textContent");
        String regularPriceColorProductPage = driver.findElement(By.className("regular-price")).getCssValue("color");
        String campaignPriceColorProductPage = driver.findElement(By.className("campaign-price")).getCssValue("color");
        int regularPriceHeightProductPage = driver.findElement(By.className("regular-price")).getSize().height;
        int campaignPriceHeightProductPage = driver.findElement(By.className("campaign-price")).getSize().height;
        int regularPriceWidthProductPage = driver.findElement(By.className("regular-price")).getSize().width;
        int campaignPriceWidthProductPage = driver.findElement(By.className("campaign-price")).getSize().width;

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает текст названия товара",
                nameHomePage, nameProductPage);

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает обычная цена",
                campaignPriceHomePage, campaignPriceProductPage);

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает акционная цена",
                regularPriceHomePage, regularPriceProductPage);

        assertEquals("Проверяю цвет обычной цены на главной странице",
                "rgba(119, 119, 119, 1)", regularPriceColorHomePage);

        assertEquals("Проверяю цвет акционная цены на главной странице",
                "rgba(204, 0, 0, 1)", campaignPriceColorHomePage);

        assertEquals("Проверяю цвет обычной цены на странице товара",
                "rgba(102, 102, 102, 1)", regularPriceColorProductPage);

        assertEquals("Проверяю цвет акционной цены на странице товара",
                "rgba(204, 0, 0, 1)", campaignPriceColorProductPage);

        assertTrue("Проверяю, что высота акционной цены больше высоты обычной цены на главной странице",
                campaignPriceHeightHomePage > regularPriceHeightHomePage);

        assertTrue("Проверяю, что ширина акционной цены больше ширины обычной цены на главной странице",
                campaignPriceWidthHomePage > regularPriceWidthHomePage);

        assertTrue("Проверяю, что высота акционной цены больше высоты обычной цены на странице товара",
                campaignPriceHeightProductPage > regularPriceHeightProductPage);

        assertTrue("Проверяю, что ширина акционной цены больше ширины обычной цены на странице товара",
                campaignPriceWidthProductPage > regularPriceWidthProductPage);
    }
}
