package widgets;

import basic.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    // Zadanie:
    // Przesun slider do wartości 50 -> 30 -> 80

    @Test
    public void shouldMoveSliderToExpectedValue() {
        getDriver().get("http://seleniumui.moderntester.pl/slider.php");

        Integer expectedValue = 50;
        Integer expectedValue2 = 30;
        Integer expectedValue3 = 80;

        while (!getDriver().findElement(By.id("custom-handle")).getText().equals(expectedValue.toString())) {
            getDriver().findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
        }

        while (!getDriver().findElement(By.id("custom-handle")).getText().equals(expectedValue2.toString())) {
            getDriver().findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_LEFT);
        }

        while (!getDriver().findElement(By.id("custom-handle")).getText().equals(expectedValue3.toString())) {
            getDriver().findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
