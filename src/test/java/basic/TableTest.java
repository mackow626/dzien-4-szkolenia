package basic;

import models.Mountain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase{


    @BeforeMethod
    public void setUpTableTest() {
        getDriver().get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    public void shouldSelectItem() {
        Mountain mountain = new Mountain(getDriver().findElement(By.cssSelector("tbody >tr:first-of-type")));
        System.out.println(mountain.toString());


    }
}
