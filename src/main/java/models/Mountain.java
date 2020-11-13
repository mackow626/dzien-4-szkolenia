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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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
