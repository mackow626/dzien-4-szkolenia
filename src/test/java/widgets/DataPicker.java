package widgets;

import basic.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataPicker extends TestBase {

    private List<String> allMonthNames =
            Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");


    @Test
    public void shouldSetDate2022October27() {
        getDriver().get("http://seleniumui.moderntester.pl/datepicker.php");
        getDriver().findElement(By.id("datepicker")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText()) == 2022) {

//            goToMonth();
            if (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) > 10) {
                while (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != 10) {
                    getDriver().findElement(By.className("ui-datepicker-prev")).click();
                }
            } else if (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) < 10) {
                while (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != 10) {
                    getDriver().findElement(By.className("ui-datepicker-next")).click();
                }
            }
        } else {
            if (Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText()) > 2022) {
                while (Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText()) != 2022) {
                    getDriver().findElement(By.className("ui-datepicker-prev")).click();
                }
            } else if (Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText()) < 2022) {
                while (Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText()) != 2022) {
                    getDriver().findElement(By.className("ui-datepicker-next")).click();
                }
            }


            if (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) > 10) {
                while (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != 10) {
                    getDriver().findElement(By.className("ui-datepicker-prev")).click();
                }
            } else if (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) < 10) {
                while (allMonthNames.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != 10) {
                    getDriver().findElement(By.className("ui-datepicker-next")).click();
                }
            }
        }

        List<WebElement> days = getDriver().findElements(By.cssSelector("td[data-handler='selectDay']:not(.ui-datepicker-other-month) a "));

        for (WebElement day : days) {
            if (day.getText().equals("27")) {
                day.click();
                break;
            }
        }

        Assert.assertEquals(getDriver().findElement(By.id("datepicker")).getAttribute("value"),"11/27/2022");


    }


}
