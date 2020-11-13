package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Mountain {
    private String name;
    private String state;
    private Integer height;

    public Mountain(WebElement row) {
        List<WebElement> elementsOfRow = row.findElements(By.cssSelector("td"));
        this.name = elementsOfRow.get(0).getText();
        this.state = elementsOfRow.get(2).getText();
        this.height = new Integer(elementsOfRow.get(3).getText());
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", height=" + height +
                '}';
    }
}
