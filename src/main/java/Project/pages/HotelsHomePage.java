package Project.pages;

import Project.StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHomePage extends  Base{

    By txtDestination = By.xpath("//input[@id='qf-0q-destination']");
    By btnSearch = By.xpath("//button[@type='submit']");

    By roomDropDown = By.xpath("//select[@id='qf-0q-rooms']");

    By roomRows = By.xpath("//div[@class='widget-query-people']");

    public int getRoomRows()
    {
        return SharedSD.getDriver().findElements(roomRows).size();
    }

    public void selectRoomcount(String rooms)
    {
        selectFromDropdown(roomDropDown,rooms);
    }
    public void setTxtDestination(String destination)
    {

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+destination+"')",
                SharedSD.getDriver().findElement(txtDestination));
    }

    public void clickSearch()
    {
        clickOn(btnSearch);
    }
}
