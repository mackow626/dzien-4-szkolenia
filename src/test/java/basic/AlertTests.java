package basic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    private void openAlertPage() {
        getDriver().get("http://seleniumui.moderntester.pl/alerts.php");
    }
    //  Zadanie:
    //  kliknij simple allert
    //  w alercie kliknij OK
    //  sprawdz wyświetlony msg

    @Test
    public void simpleAlert() {
        getDriver().findElement(By.id("simple-alert")).click();
        // switchTo().alert() pozwala na obsługę interakcji z alertem
        getDriver().switchTo().alert().accept();
        String validationMessage = getDriver().findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(validationMessage, "OK button pressed");
    }

    //  Zadanie:
    //  kliknij prompt allert
    //  w alercie wpisz imie i kliknij ok
    //  sprawdz wyświetlony msg
    @Test
    public void promptAlert() {
        getDriver().findElement(By.id("prompt-alert")).click();
        getDriver().switchTo().alert().sendKeys("Lord Vader");
        getDriver().switchTo().alert().accept();
        Assert.assertEquals(getDriver().findElement(By.id("prompt-label"))
                .getText(), "Hello Lord Vader! How are you today?");
    }
    // Zadanie:
    // kliknij confirm allert
    // w alercie kliknij OK
    // sprawdz wyświetlony msg
    //
    // kliknij confirm allert
    // w alercie kliknij Cancel
    // sprawdz wyświetlony msg

    @Test
    public void confirmAlert() {
        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().accept();
        Assert.assertEquals(getDriver().findElement(By.id("confirm-label")).getText(), "You pressed OK!");

        getDriver().findElement(By.id("confirm-alert")).click();
        getDriver().switchTo().alert().dismiss();
        Assert.assertEquals(getDriver().findElement(By.id("confirm-label")).getText(), "You pressed Cancel!");
    }
}
