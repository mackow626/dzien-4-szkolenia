package widgets;

import basic.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    // Zadanie:
    // Przesun slider do wartości 50 -> 30 -> 30 -> 80

    @Test
    public void shouldMoveSliderToExpectedValue() {
        getDriver().get("http://seleniumui.moderntester.pl/slider.php");

        moveTo(50);
        Assert.assertEquals(getSliderValue(),50);
        moveTo(30);
        Assert.assertEquals(getSliderValue(),30);
        moveTo(30);
        Assert.assertEquals(getSliderValue(),30);
        moveTo(80);
        Assert.assertEquals(getSliderValue(),80);
    }

    // metoda spradzająca w którą stronę ma się przesunąć slider, a następnie zaczynająca go przesuwać
    private void moveTo(int expectedSliderValue) {
        int actualSliderValue = getSliderValue();

        if (actualSliderValue > expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_LEFT);
        } else if (actualSliderValue < expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_RIGHT);
        }
    }

    // wysyłanie do slidera strzałkę w lewo / prawo aby go przesunąć
    // tak długo aż wartość na sliderze będzie równa wartości oczekiwanej
    private void moveSlider(int expectedSliderValue, Keys key) {
        while (getSliderValue() != expectedSliderValue) {
            getDriver().findElement(By.id("custom-handle")).sendKeys(key);
        }
    }

    // pobieranie textu wyświetlanego w sliderze (jako tekst) i parsowanie go do inta (liczby)
    private int getSliderValue() {
        String sliderValueAsText = getDriver().findElement(By.id("custom-handle")).getText();
        return Integer.parseInt(sliderValueAsText); // "50" -> 50
    }
}
