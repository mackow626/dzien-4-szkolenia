import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest {

    @Test
    public void shouldSendForm(){
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver webDriver = new ChromeDriver(options);

        webDriver.get("https://seleniumui.moderntester.pl/form.php");


        // znajdz input odpowiedzialny za imie i wypełnij
        WebElement firstName = webDriver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        // znajdz input odpowiedzialny za nazwisko i wypełnij
        WebElement lastName = webDriver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        // znajdz input odpowiedzialny za email i wypełnij
        WebElement email = webDriver.findElement(By.id("inputEmail3"));
        email.sendKeys("jank@wp.pl");

        // znajdz input odpowiedzialny za wiek i wypełnij
        WebElement age = webDriver.findElement(By.id("inputAge3"));
        age.sendKeys("52");

        // znajdz radio button men i w niego kliknij
        WebElement menRbt = webDriver.findElement(By.id("gridRadiosMale"));
        menRbt.click();

        // znajdz liste radio buttonów odpowiadających za wiek
        List<WebElement> yearsOfExperienceList = webDriver.findElements(By.name("gridRadiosExperience"));

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
        webDriver.findElement(By.id("gridCheckAutomationTester")).click();

        // znajdz input uploadu pliku i wyślij do niego sciezke absolutną do pliku file.txt
        WebElement fileUpload = webDriver.findElement(By.id("chooseFile"));
        File file = new File("src\\main\\resources\\file.txt");
        fileUpload.sendKeys(file.getAbsolutePath());

        // stowrzenie obiektu klasy Select i użycie go do wybrania odpowiedniego elementu z listy rozwijanej
        WebElement countriesElement = webDriver.findElement(By.id("selectContinents"));
        Select countriesSelect = new Select(countriesElement);
        countriesSelect.selectByValue("europe");
        // wybieranie europy moze być przez:
        //        countriesSelect.selectByIndex(2);
        //        countriesSelect.selectByValue("europe");
        //        countriesSelect.selectByVisibleText("Europe");


        //  stowrzenie obiektu klasy Select i użycie go do wybrania odpowiedniego elementu z listy
        WebElement seleniumElement = webDriver.findElement(By.id("selectSeleniumCommands"));
        Select seleniumSelect = new Select(seleniumElement);
        seleniumSelect.selectByIndex(2);

        // kliknięcie przycisku send
        webDriver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

        // pobranie wiadomości wyświetlonej po wysłaniu formularza
        WebElement msg = webDriver.findElement(By.id("validator-message"));

        // asercja sprawdzająca czy wyświetliła się poprawna wiadomość
        String expectedMsg = "Form send with success";
        Assert.assertEquals(msg.getText(), expectedMsg);

        webDriver.quit();



    }


}
