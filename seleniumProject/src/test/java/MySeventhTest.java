import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        List<Integer> regularPriceColorHomePageRGBA = getNumbersFromString(regularPriceColorHomePage);
        List<Integer> campaignPriceColorHomePageRGBA = getNumbersFromString(campaignPriceColorHomePage);
        String regularPriceFontSizeHomePage = firstProductCampaigns.findElement(By.className("regular-price")).getCssValue("font-size");
        String campaignPriceFontSizeHomePage = firstProductCampaigns.findElement(By.className("campaign-price")).getCssValue("font-size");
        Double regularPriceFontSizeHomePageHp = getNumbersFloatingFromString(regularPriceFontSizeHomePage);
        Double campaignPriceFontSizeHomePageHp = getNumbersFloatingFromString(campaignPriceFontSizeHomePage);
        firstProductCampaigns.click();

        String nameProductPage = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
        String regularPriceProductPage = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String campaignPriceProductPage = driver.findElement(By.className("campaign-price")).getAttribute("textContent");
        String regularPriceColorProductPage = driver.findElement(By.className("regular-price")).getCssValue("color");
        String campaignPriceColorProductPage = driver.findElement(By.className("campaign-price")).getCssValue("color");
        List<Integer> regularPriceColorProductPageRGBA = getNumbersFromString(regularPriceColorProductPage);
        List<Integer> campaignPriceColorProductPageRGBA = getNumbersFromString(campaignPriceColorProductPage);
        String regularPriceFontSizeProductPage = driver.findElement(By.className("regular-price")).getCssValue("font-size");
        String campaignPriceFontSizeProductPage = driver.findElement(By.className("campaign-price")).getCssValue("font-size");
        Double regularPriceFontSizeProductPageHp = getNumbersFloatingFromString(regularPriceFontSizeProductPage);
        Double campaignPriceFontSizeProductPageHp = getNumbersFloatingFromString(campaignPriceFontSizeProductPage);

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает текст названия товара",
                nameHomePage, nameProductPage);

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает обычная цена",
                campaignPriceHomePage, campaignPriceProductPage);

        assertEquals("Проверяю, что на главной странице и на странице товара совпадает акционная цена",
                regularPriceHomePage, regularPriceProductPage);

        assertTrue("Проверяю цвет обычной цены на главной странице",
                regularPriceColorHomePageRGBA.get(0).equals(regularPriceColorHomePageRGBA.get(1)) && regularPriceColorHomePageRGBA.get(0).equals(regularPriceColorHomePageRGBA.get(2)));

        assertTrue("Проверяю цвет обычной цены на странице товара",
                regularPriceColorProductPageRGBA.get(0).equals(regularPriceColorProductPageRGBA.get(1)) && regularPriceColorProductPageRGBA.get(0).equals(regularPriceColorProductPageRGBA.get(2)));

        assertAll("Проверяю цвет акционной цены на главной странице",
                () -> assertTrue(0 == campaignPriceColorHomePageRGBA.get(1)),
                () -> assertTrue(0 == campaignPriceColorHomePageRGBA.get(2))
                );

        assertAll("Проверяю цвет акционной цены на странице товара",
                () -> assertTrue(0 == campaignPriceColorProductPageRGBA.get(1)),
                () -> assertTrue(0 == campaignPriceColorProductPageRGBA.get(2))
        );

        assertTrue("Проверяю, что размер шрифта больше у акционной цены на главной странице",
                campaignPriceFontSizeHomePageHp > regularPriceFontSizeHomePageHp);

        assertTrue("Проверяю, что размер шрифта больше у акционной цены на странице товара",
                campaignPriceFontSizeProductPageHp > regularPriceFontSizeProductPageHp);
    }

    public Double getNumbersFloatingFromString(String size) {
        String sizeWithoutUnitMeasurement = size.replaceAll("px", "");

        return Double.parseDouble(sizeWithoutUnitMeasurement);
    }

    public ArrayList<Integer> getNumbersFromString(String color) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(color);

        while (matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }

        return numbers;
    }
}
