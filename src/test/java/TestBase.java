import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    // metoda wykonywana przed każdym testem
    @BeforeMethod
    public void setUp() {
        // wskazanie ścieżki do chromedriver.exe
        System.setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");

        // inicjalizacja opcji chrome drivera
        ChromeOptions options = new ChromeOptions();
        // dodawanie opcji która uruchamia zmaksymalizowana przegląrarkę
        options.addArguments("start-maximized");

        // stworzenie obiektu drivera dla przeglądarki chrome
        driver = new ChromeDriver(options);
    }

    //metoda wykonywana po kazdym teście
    @AfterMethod
    public void cleanUp() {
        // zaknięcie przeglądarki oraz procesu chromedrivera
        driver.quit();
    }
}
