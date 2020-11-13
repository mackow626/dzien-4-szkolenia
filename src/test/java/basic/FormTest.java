package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldSendForm() {

        getDriver().get("http://seleniumui.moderntester.pl/form.php");

        // znajdz input odpowiedzialny za imie i wypełnij
        WebElement firstName = getDriver().findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        // znajdz input odpowiedzialny za nazwisko i wypełnij
        WebElement lastName = getDriver().findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        // znajdz input odpowiedzialny za email i wypełnij
        WebElement email = getDriver().findElement(By.id("inputEmail3"));
        email.sendKeys("jank@wp.pl");

        // znajdz input odpowiedzialny za wiek i wypełnij
        WebElement age = getDriver().findElement(By.id("inputAge3"));
        age.sendKeys("52");

        // znajdz radio button men i w niego kliknij
        WebElement menRbt = getDriver().findElement(By.id("gridRadiosMale"));
        menRbt.click();

        // znajdz liste radio buttonów odpowiadających za wiek
        List<WebElement> yearsOfExperienceList = getDriver().findElements(By.name("gridRadiosExperience"));

        // stworzenie obiektu klasy dostarczające losowe liczby
        Random rnd = new Random();

        // losowanie numeru od 0 (włącznie) do liczby równej wielkości listy (wyłącznie)
        // w przypadku listy lat będzie do losowanie z zakresu <0,7)
        // więc możliwe do wylosowanie są liczby 0,1,2,3,4,5,6
        int randomNumber = rnd.nextInt(yearsOfExperienceList.size());
        // pobranie elementu z listy stojącego na indeksie równym wylosowanej liczbie
        WebElement randomElement = yearsOfExperienceList.get(randomNumber);
        // kliknięcie losowo wybranego elementu
        randomElement.click();

        // znajdz checkbox automation tester ] i w niego kliknij
        getDriver().findElement(By.id("gridCheckAutomationTester")).click();

        // znajdz input uploadu pliku i wyślij do niego sciezke absolutną do pliku file.txt
        WebElement fileUpload = getDriver().findElement(By.id("chooseFile"));
        File file = new File("src\\main\\resources\\file.txt");
        fileUpload.sendKeys(file.getAbsolutePath());

        // stowrzenie obiektu klasy Select i użycie go do wybrania odpowiedniego elementu z listy rozwijanej
        WebElement countriesElement = getDriver().findElement(By.id("selectContinents"));
        Select countriesSelect = new Select(countriesElement);
        countriesSelect.selectByValue("europe");
        // wybieranie europy moze być przez:
        //        countriesSelect.selectByIndex(2);
        //        countriesSelect.selectByValue("europe");
        //        countriesSelect.selectByVisibleText("Europe");


        //  stowrzenie obiektu klasy Select i użycie go do wybrania odpowiedniego elementu z listy
        WebElement seleniumElement = getDriver().findElement(By.id("selectSeleniumCommands"));
        Select seleniumSelect = new Select(seleniumElement);
        seleniumSelect.selectByIndex(2);

        // kliknięcie przycisku send
        getDriver().findElement(By.cssSelector("button[class='btn btn-primary']")).click();

        // pobranie wiadomości wyświetlonej po wysłaniu formularza
        WebElement msg = getDriver().findElement(By.id("validator-message"));

        // asercja sprawdzająca czy wyświetliła się poprawna wiadomość
        String expectedMsg = "Form send with success";
        Assert.assertEquals(msg.getText(), expectedMsg);
    }


}
