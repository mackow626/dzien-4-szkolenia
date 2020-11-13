package interactions;

import basic.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase {

    @BeforeMethod
    private void openDroppablePage() {
        getDriver().get("http://seleniumui.moderntester.pl/droppable.php#");
    }

    @Test
    public void dragAndDropTest() {
        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(drag, drop)
                .perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void holdAndDropTest() {
        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(drag)
                .release(drop)
                .perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void holdMoveAndDropTest() {
        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));
        Actions actions = new Actions(getDriver());

        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @Test
    public void dragAndDropByTest() {
        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));
        Actions actions = new Actions(getDriver());

        int x1 = drag.getLocation().getX();
        int y1 = drag.getLocation().getY();

        int x2 = drop.getLocation().getX();
        int y2 = drop.getLocation().getY();

        actions.dragAndDropBy(drag, x2 - x1, y2 - y1)
                .perform();
        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}
