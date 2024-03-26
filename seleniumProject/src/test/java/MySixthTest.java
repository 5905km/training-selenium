import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MySixthTest extends TestBase {

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        ArrayList<String> nameZonesList = new ArrayList<>();
        ArrayList<String> nameZonesListSort = new ArrayList<>();

        for (int i = 0; i < driver.findElements(By.cssSelector("table tr.row")).size(); i++) {
            driver.findElements(By.cssSelector("table tr.row")).get(i).findElement(By.cssSelector("td a")).click();

            WebElement tableZones = driver.findElement(By.cssSelector(".dataTable"));
            List<WebElement> rowsTableZones = tableZones.findElements(By.cssSelector("tr:not(.header)"));

                for (int k = 0; k < rowsTableZones.size()-1; k++) {

                    String nameZone = rowsTableZones.get(k).findElements(By.cssSelector("td")).get(2).findElement(By.cssSelector("select [selected=selected]")).getAttribute("textContent");

                    nameZonesList.add(nameZone);
                    nameZonesListSort.add(nameZone);
                }

                Collections.sort(nameZonesListSort);

                String message = "Зоны для страны расположены не по алфавиту. Список зон следующий:" + nameZonesList;
                assertEquals(message, nameZonesListSort, nameZonesList);

                nameZonesList.clear();
                nameZonesListSort.clear();

                driver.findElement(By.cssSelector("div ul li.selected")).click();
        }
    }
}
