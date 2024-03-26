import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyFifthTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        ArrayList<String> nameCountriesList = new ArrayList<>();
        ArrayList<String> nameCountriesListSort = new ArrayList<>();

        ArrayList<String> nameZonesList = new ArrayList<>();
        ArrayList<String> nameZonesListSort = new ArrayList<>();

        for (int i = 0; i < driver.findElements(By.cssSelector("table .row")).size(); i++) {
            WebElement country = driver.findElements(By.cssSelector("table .row")).get(i);
            String nameCountry = country.findElement(By.cssSelector("a")).getAttribute("textContent");
            String zones = country.findElements(By.cssSelector("td")).get(5).getAttribute("textContent");

            nameCountriesList.add(nameCountry);
            nameCountriesListSort.add(nameCountry);

            if (!zones.equals("0")) {
                country.findElement(By.cssSelector("a")).click();

                WebElement tableZones = driver.findElement(By.cssSelector(".dataTable"));
                List<WebElement> rowsTableZones = tableZones.findElements(By.cssSelector("tr:not(.header)"));

                for (int k = 0; k < rowsTableZones.size()-1; k++) {

                    String nameZone = rowsTableZones.get(k).findElements(By.cssSelector("td")).get(2).getAttribute("innerText");

                    nameZonesList.add(nameZone);
                    nameZonesListSort.add(nameZone);
                }

                Collections.sort(nameZonesListSort);

                String message = "Зоны для страны " + nameCountry + " расположены не по алфавиту. Список зон следующий:" + nameZonesList;
                assertEquals(message, nameZonesListSort, nameZonesList);

                nameZonesList.clear();
                nameZonesListSort.clear();

                driver.findElement(By.cssSelector("div ul li.selected")).click();
            }
        }

        Collections.sort(nameCountriesListSort);

        String message = "Страны расположены не по алфавиту. Список стран следующий:" + nameCountriesList;
        assertEquals(message, nameCountriesListSort, nameCountriesList);
    }
}
