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

        selectDate(2019, "January", 11);
        selectDate(2021, "December", 30);
        selectDate(2019, "June", 1);
        selectDate(2020, "March", 4);
    }

    private void selectDate(Integer expectedYear, String expectedMonth, Integer expectedDay) {
        getDriver().findElement(By.id("datepicker")).click();
        waitForDatePicker();

        if (getDisplayedYear() == expectedYear) {
            goToTheMonth(expectedMonth);
        } else {
            goToTheYear(expectedYear);
            goToTheMonth(expectedMonth);
        }

        gotoTheDay(expectedDay);

        Assert.assertEquals(getDriver().findElement(By.id("datepicker")).getAttribute("value"),
                ((getIndexOfMonth(expectedMonth) + 1) > 9 ? (getIndexOfMonth(expectedMonth) + 1) : "0" + (getIndexOfMonth(expectedMonth) + 1)) + "/"
                        + (expectedDay > 9 ? expectedDay.toString() : "0" + expectedDay) + "/"
                        + expectedYear.toString());
    }

    private int getIndexOfMonth(String expectedMonth) {
        return allMonthNames.indexOf(expectedMonth);
    }

    private void gotoTheDay(Integer day) {
        List<WebElement> days = getDriver().findElements(By.cssSelector("td[data-handler='selectDay']:not(.ui-datepicker-other-month) a "));

        for (WebElement singleDay : days) {
            if (singleDay.getText().equals(day.toString())) {
                singleDay.click();
                break;
            }
        }
    }

    private void goToTheYear(int expectedYear) {
        if (getDisplayedYear() > expectedYear) {
            while (getDisplayedYear() != expectedYear) {
                getDriver().findElement(By.className("ui-datepicker-prev")).click();
            }
        } else if (getDisplayedYear() < expectedYear) {
            while (getDisplayedYear() != expectedYear) {
                getDriver().findElement(By.className("ui-datepicker-next")).click();
            }
        }
    }

    private void goToTheMonth(String month) {
        if (getIndexOfMonth(getDriver().findElement(By.className("ui-datepicker-month")).getText()) > getIndexOfMonth(month)) {
            while (getIndexOfMonth(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != getIndexOfMonth(month)) {
                getDriver().findElement(By.className("ui-datepicker-prev")).click();
            }
        } else if (getIndexOfMonth(getDriver().findElement(By.className("ui-datepicker-month")).getText()) < getIndexOfMonth(month)) {
            while (getIndexOfMonth(getDriver().findElement(By.className("ui-datepicker-month")).getText()) != getIndexOfMonth(month)) {
                getDriver().findElement(By.className("ui-datepicker-next")).click();
            }
        }
    }

    private int getDisplayedYear() {
        return Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText());
    }

    private void waitForDatePicker() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
