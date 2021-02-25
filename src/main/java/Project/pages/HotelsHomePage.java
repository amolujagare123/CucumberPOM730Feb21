package Project.pages;

import Project.StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHomePage extends  Base{

    By txtDestination = By.xpath("//input[@id='qf-0q-destination']");
    By btnSearch = By.xpath("//button[@type='submit']");


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
