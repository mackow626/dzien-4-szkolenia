package basic;

import models.Mountain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableTest extends TestBase {


    @BeforeMethod
    public void setUpTableTest() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    public void shouldShowMountainsHigherThan4200() {

        List<WebElement> mountainRows = getDriver().findElements(By.cssSelector("tbody >tr"));
        List<Mountain> mountains = new ArrayList<>();
        List<String> mountainsHigherThan4200Names = new ArrayList<>();

        for (WebElement row : mountainRows) {
            mountains.add(new Mountain(row));
        }

        for (Mountain m : mountains) {
            if (m.getHeight() > 4200) {
                mountainsHigherThan4200Names.add(m.getName());
            }
        }

        Assert.assertEquals(mountainsHigherThan4200Names,
                new ArrayList<>(Arrays.asList("Mont Blanc", "Dufourspitze", "Dom", "Weisshorn", "Matterhorn", "Finsteaarhorn")));
    }

    @Test
    public void shouldShowMountainsFromItaly() {


    }
}
