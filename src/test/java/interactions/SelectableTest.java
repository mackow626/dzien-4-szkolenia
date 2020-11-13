package interactions;

import basic.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectableTest extends TestBase {

    @BeforeMethod
    public void setUpSelectable() {
        getDriver().get("https://seleniumui.moderntester.pl/selectable.php");
    }

    @Test
    public void shouldSelectItem() {
        List<WebElement> items = getDriver().findElements(By.className("ui-widget-content"));
        items.get(3).click();

        Assert.assertEquals(getDriver().findElement(By.id("select-result")).getText(), "#4");
    }

    @Test
    public void shouldSelectItems() {
        List<WebElement> items = getDriver().findElements(By.className("ui-widget-content"));
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(items.get(3))
                .click(items.get(0))
                .click(items.get(5))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        Assert.assertEquals(getDriver().findElement(By.id("select-result")).getText(), "#1 #4 #6");

    }
}